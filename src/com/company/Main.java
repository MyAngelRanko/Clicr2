package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame frame  = new JFrame("Clicker");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(300, 100, 1000,720);

        JPanel panel = new JPanel();
        JButton button = new JButton("Click");
        JLabel label = new JLabel("");
        JLabel label1 = new JLabel("");
        JButton button1 = new JButton("x2");

        button.addActionListener(new ActionListener() {
            int x = 0;
            int b = 1;
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label1.setText(String.valueOf(2));
                        b++;
                    }
                });
                x++;
                label.setText(String.valueOf(x*b));
            }
        });

        panel.add(label);
        panel.add(label1);
        panel.add(button);
        panel.add(button1);
        frame.setContentPane(panel);
        frame.setVisible(true);

    }
}