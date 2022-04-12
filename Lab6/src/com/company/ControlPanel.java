package com.company;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.SQLOutput;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");
    int i = 0;

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        setLayout(new GridLayout(1, 3));
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);
        loadBtn.addActionListener(this::load);
        saveBtn.addActionListener(this::save);
        exitBtn.addActionListener(this::exitGame);
    }

    private void load(ActionEvent actionEvent) {
        try{
            BufferedReader img = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Select which file to load:");
            int i = Integer.parseInt(img.readLine());
            frame.canvas.image = ImageIO.read(new File("path" + i + ".png"));
            frame.canvas.offscreen = frame.canvas.image.createGraphics();
            frame.canvas.offscreen.drawImage(frame.canvas.image,0,0,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(ActionEvent actionEvent) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("path" + i + ".png"));
            i++;
        }catch(IOException ex){
            System.err.println(ex);
        }
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
