package com.company.client;

//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class GUI extends JFrame{

    JButton send;
    JTextArea ta;
    JTextField tf;

    ChatClient client;

    GUI(ChatClient client) {
        this.client = client;

        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        // accepts upto 10 characters
        tf = new JTextField(10);
        send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        Clicklistener click= new Clicklistener();
        send.addActionListener(click);
        // Text Area at the Center

        ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
        frame.
    }


    public static void main(String args[]) {
        GUI gui = new GUI();
    }

    private class Clicklistener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == send)
            {
                client.write(tf.getText());
            }
        }
    }
}


