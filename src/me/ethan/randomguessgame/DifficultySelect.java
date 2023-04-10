package me.ethan.randomguessgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DifficultySelect implements ActionListener {

    static public JFrame frame = new JFrame();

    JPanel titlePanel;
    JLabel titleLabel;

    JPanel mainPanel;
    JButton easyButton;
    JButton medButton;
    JButton hardButton;
    JButton extremeButton;

    public boolean easyMode = false;
    public boolean medMode = false;
    public boolean hardMode = false;
    public boolean extremeMode = false;

    public DifficultySelect(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setTitle("Difficulty Select");
        frame.setIconImage(new ImageIcon("logo.png").getImage());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);

        easyButton = new JButton("EASY");
        easyButton.setBounds(7,20,80,50);
        easyButton.setBackground(Color.BLACK);
        easyButton.setFocusable(false);
        easyButton.addActionListener(this);

        medButton = new JButton("MEDIUM");
        medButton.setBounds(92,20,80,50);
        medButton.setBackground(Color.BLACK);
        medButton.setFocusable(false);
        medButton.addActionListener(this);

        hardButton = new JButton("HARD");
        hardButton.setBounds(177,20,80,50);
        hardButton.setBackground(Color.BLACK);
        hardButton.setFocusable(false);
        hardButton.addActionListener(this);

        extremeButton = new JButton("EXTREME");
        extremeButton.setBounds(90,72,100,15);
        extremeButton.setBackground(Color.BLACK);
        extremeButton.setFocusable(false);
        extremeButton.addActionListener(this);

        titleLabel = new JLabel();
        titleLabel.setText("Select a Difficultly!");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Roboto",Font.BOLD,25));

        titlePanel = new JPanel();
        titlePanel.setBounds(5,5,265,50);
        titlePanel.setBackground(Color.DARK_GRAY);
        titlePanel.add(titleLabel);

        mainPanel = new JPanel();
        mainPanel.setBounds(5,60,265,90);
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(null);
        mainPanel.add(easyButton);
        mainPanel.add(medButton);
        mainPanel.add(hardButton);
        mainPanel.add(extremeButton);

        frame.add(titlePanel);
        frame.add(mainPanel);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == easyButton) {
            easyMode = true;
            Random random = new Random();
            int randInt = random.nextInt(1, 11);
            System.out.println(randInt);
            new RandomGuessGame(randInt, easyMode, medMode, hardMode, extremeMode);
            frame.dispose();
        }

        if (e.getSource() == medButton  ) {
            medMode = true;
            Random random = new Random();
            int randInt = random.nextInt(1, 101);
            new RandomGuessGame(randInt, easyMode, medMode, hardMode, extremeMode);
            frame.dispose();

        }

        if (e.getSource() == hardButton) {
            hardMode = true;
            Random random = new Random();
            int randInt = random.nextInt(1, 1001);
            new RandomGuessGame(randInt, easyMode, medMode, hardMode, extremeMode);
            frame.dispose();
        }

        if (e.getSource() == extremeButton) {
            extremeMode = true;
            Random random = new Random();
            int randInt = random.nextInt(1, 1000001);
            new RandomGuessGame(randInt, easyMode, medMode, hardMode, extremeMode);
            frame.dispose();
        }
    }
}
