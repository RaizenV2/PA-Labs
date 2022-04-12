package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner1, spinner2;
    JButton button;
    int row,col;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinner1 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        button = new JButton("Create");

        add(label);
        add(spinner1);
        add(spinner2);
        add(button);
        button.addActionListener(this::setRowCol);
    }

    private void setRowCol(ActionEvent e) {
        this.row = (Integer) spinner1.getValue();
        this.col = (Integer) spinner2.getValue();
        frame.canvas.setRow(row);
        frame.canvas.setCol(col);
        frame.canvas.init(row,col);
        frame.canvas.repaint();
    }

    public int getRows() {
        return row;
    }

    public int getCols() {
        return col;
    }
}
