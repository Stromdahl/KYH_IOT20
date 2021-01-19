package com.company;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Frame extends JFrame implements FocusListener {

    public Frame(){
        super("Test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addFocusListener(this);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.dispose();
    }
}