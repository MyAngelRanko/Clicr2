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
    button.setBounds(10,10,10,10);

    ButtonGroup buttonGroup = new ButtonGroup();
    JCheckBox jCheckBox = new JCheckBox("metres", false);
    JCheckBox jCheckBox1 = new JCheckBox("km", false );
    buttonGroup.add(jCheckBox);
    buttonGroup.add(jCheckBox1);

    TextField textField = new TextField(4);






    button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(textField.getText());
                if (jCheckBox.isSelected()){
                    label.setText(String.valueOf(x*100));
                }
                if (jCheckBox1.isSelected()){
                    label.setText(String.valueOf(x/100));
                }

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

