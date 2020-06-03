package com.company;

import com.sun.security.auth.module.JndiLoginModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Xzx {
    public static void main(String[] args) {
        JFrame frame  = new JFrame("New practic");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(300, 100, 1000,720);
        frame.setVisible(true);



    JPanel panel = new JPanel();
    JLabel label = new JLabel("df");
    JButton button = new JButton("преобразовать");

    ButtonGroup buttonGroup = new ButtonGroup();
    JCheckBox jCheckBox = new JCheckBox("metres", false);
    JCheckBox jCheckBox1 = new JCheckBox("km", false );
    buttonGroup.add(jCheckBox);
    buttonGroup.add(jCheckBox1);
    Integer.parseInt("1");
    TextField textField = new TextField();
    

    int x = 1000;




    button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(String.valueOf(x));

            }
        });




    panel.add(jCheckBox);
    panel.add(jCheckBox1);
    panel.add(button);
    panel.add(label);
    panel.add(textField);
    frame.setContentPane(panel);
    frame.setVisible(true);


    }
}

