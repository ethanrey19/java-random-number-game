package me.ethan.randomguessgame;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class WinnerScreen extends JFrame {

    JLabel background;
    JLabel won;
    JLabel guessesLabel;

    public WinnerScreen(int guesses){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("win.jpg").getImage());
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        won = new JLabel("YOU WON!");
        won.setFont(new Font("Roboto",Font.BOLD,55));
        won.setBounds(570,200,500,100);

        guessesLabel = new JLabel("It took you " + guesses + " trys!");
        guessesLabel.setFont(new Font("Roboto",Font.BOLD,35));
        guessesLabel.setBounds(570,320,500,100);

        background = new JLabel(new ImageIcon("win.jpg"));
        this.setContentPane(background);

        this.add(won);
        this.add(guessesLabel);
        this.setVisible(true);

    }

}
