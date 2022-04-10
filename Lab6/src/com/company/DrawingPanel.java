package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.*;
import java.util.List;

import static java.lang.Math.abs;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    public BufferedImage image;
    Graphics2D offscreen;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    ArrayList<Integer> nodes = new ArrayList<>();
    int stoneSize = 20;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth,canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE);
        offscreen.fillRect(0,0,canvasWidth,canvasHeight);
    }

    final void init(int rows, int cols) {
        createOffscreenImage();
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        paintGrid();
        paintSticks();
        this.addMouseListener(new MouseAdapter() {
            private int turn=0;

            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY(),turn);
                repaint();
                turn = abs(turn-1);
            }
        });
    }

    private void drawStone(int x, int y, int turn) {
        if(turn == 0) {
            for (int i = 0; i < nodes.size(); i++) {
                if (x >= nodes.get(i) - stoneSize / 2 && x <= nodes.get(i) + stoneSize/2) {
                    offscreen.setColor(Color.RED);
                    offscreen.fillOval(nodes.get(i) - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                    nodes.remove(i);
                    break;
                }
            }
        }else {
            for (int i = 0; i < nodes.size(); i++) {
                if (x >= nodes.get(i) - stoneSize / 2 && x <= nodes.get(i) + stoneSize/2) {
                    offscreen.setColor(Color.BLUE);
                    offscreen.fillOval(nodes.get(i) - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                    nodes.remove(i);
                    break;
                }
            }
        }
    }

    private void paintSticks() {
        offscreen.setColor(Color.BLACK);
        offscreen.setStroke(new BasicStroke(3));
        Random rand = new Random();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(rand.nextBoolean()) {
                    int x1 = padX + col * cellWidth;
                    int y1 = padY + row * cellHeight;
                    int x2 = padX + (col + 1) * cellWidth;
                    int y2 = padY + row * cellHeight;
                    if(col+1<cols) {
                        offscreen.drawLine(x1, y1, x2, y2);
                        nodes.add(x2);
                    }
                }else{
                    int x1 = padX + col * cellWidth;
                    int y1 = padY + row * cellHeight;
                    int x2 = padX + col * cellWidth;
                    int y2 = padY + (row + 1) * cellHeight;
                    if(row+1<rows) {
                        offscreen.drawLine(x1, y1, x2, y2);
                        nodes.add(y2);
                    }
                }

            }
        }
    }

    protected void paintGrid() {
        offscreen.setColor(Color.LIGHT_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            offscreen.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    public MainFrame getFrame() {
        return frame;
    }

    public void setRow(int row) {
        rows = row;
    }

    public void setCol(int col) {
        cols = col;
    }

    public void loadImage(BufferedImage img) {
        offscreen.drawImage(img,0,0,null);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image,0,0,this);
    }

}
