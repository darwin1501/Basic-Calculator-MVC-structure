package com.darwin.view;

import javax.swing.*;

public class CalculatorFrame {

    private JFrame frame;

    public CalculatorFrame(){
//        build frame
        frame = new JFrame("Basic Calculator");
        frame.setSize(435,393);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JFrame getFrame(){
        return frame;
    }
}
