package me.ethan.randomguessgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RandomGuessGame {

    static JFrame frame = new JFrame();

    JPanel titlePanel;
    JPanel mainPanel;

    JLabel titleLabel;
    JLabel guessLabel;
    JLabel hintLabel;
    JLabel pickLabel;

    JTextField guessTextField;

    JButton submitButton;
    JButton hintButton;

    public int guesses = 1;

    public RandomGuessGame(int randInt, boolean easyMode,boolean medMode,boolean hardMode,boolean extremeMode){

        System.out.println(randInt);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(600,560);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        hintButton = new JButton("HINT");
        hintButton.setBounds(350,300,150,75);
        hintButton.setFont(new Font("Roboto",Font.BOLD,25));
        hintButton.setBorder(null);
        hintButton.setFocusable(false);
        hintButton.addActionListener(e -> {
            if(e.getSource()==hintButton){
               if(easyMode){
                   hintLabel.setText("No hints in easy mode!");
                   hintLabel.setVisible(true);
               }else {
                   hintLabel.setVisible(true);
               }
            }
        });

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(350,50,150,75);
        submitButton.setFont(new Font("Roboto",Font.BOLD,25));
        submitButton.setBorder(null);
        submitButton.setFocusable(false);
        submitButton.addActionListener(e -> {
            String text = guessTextField.getText();
            if(e.getSource()==submitButton) {
                if (text.trim().matches(String.valueOf(randInt))) {
                    new WinnerScreen(guesses);
                    frame.dispose();
                } else {
                    guesses++;
                    guessLabel.setText("You are on try number " + guesses);
                }
            }
        });

        guessTextField = new JTextField();
        guessTextField.setFont(new Font("Roboto",Font.BOLD,25));
        guessTextField.setBackground(Color.BLACK);
        guessTextField.setBounds(100,50,200,75);
        guessTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();  // if it's not a number, ignore the event
                }
            }
        });


        hintLabel = new JLabel();
        hintLabel.setText("The first number is " + String.valueOf(Math.abs((randInt))).charAt(0));
        hintLabel.setBounds(80,300,250,75);
        hintLabel.setForeground(Color.WHITE);
        hintLabel.setFont(new Font("Roboto",Font.BOLD,20));
        hintLabel.setVisible(false);

        guessLabel = new JLabel();
        guessLabel.setText("You are on try number " + guesses);
        guessLabel.setBounds(200,200,300,75);
        guessLabel.setForeground(Color.WHITE);
        guessLabel.setFont(new Font("Roboto",Font.BOLD,25));

        pickLabel = new JLabel();
        setPick(easyMode,medMode,hardMode,extremeMode);
        pickLabel.setBounds(250,-20,300,75);
        pickLabel.setForeground(Color.WHITE);
        pickLabel.setFont(new Font("Roboto",Font.BOLD,20));

        titleLabel = new JLabel();
        titleLabel.setText("Guess A Number");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Roboto",Font.BOLD,45));

        titlePanel = new JPanel();
        titlePanel.setBounds(15,15,550,75);
        titlePanel.setBackground(Color.darkGray);
        titlePanel.add(titleLabel);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(15,95,550,400);
        mainPanel.setBackground(Color.darkGray);
        mainPanel.add(guessTextField);
        mainPanel.add(submitButton);
        mainPanel.add(guessLabel);
        mainPanel.add(hintButton);
        mainPanel.add(hintLabel);
        mainPanel.add(pickLabel);

        frame.add(titlePanel);
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void setPick(boolean easyMode,boolean medMode,boolean hardMode,boolean extremeMode) {
       if(easyMode){
           pickLabel.setText("1 - 10");
       }else if(medMode){
           pickLabel.setText("1 - 100");
       }else if(hardMode){
           pickLabel.setText("1 - 1000");
       }else if(extremeMode){
           pickLabel.setText("1 - 1000000");
       }
    }
}
