package me.ethan.randomguessgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame implements ActionListener {

    JLabel startLabel;

    JPanel buttonPanel;
    JButton startButton;

    public StartScreen(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,205);
        this.setTitle("Random Number Game");
        this.setIconImage(new ImageIcon("logo.png").getImage());
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        startLabel = new JLabel(new ImageIcon("logo.png"));

        startButton = new JButton("START");
        startButton.setFocusable(false);
        startButton.setBackground(Color.red);
        startButton.setSize(55,50);
        startButton.addActionListener(this);

        buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.setBackground(Color.DARK_GRAY);

        this.add(startLabel);
        this.add(buttonPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==startButton){
            new DifficultySelect();
            this.dispose();
        }

    }
}
