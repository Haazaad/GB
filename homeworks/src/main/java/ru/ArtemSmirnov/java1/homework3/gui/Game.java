package ru.ArtemSmirnov.java1.homework3.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    private GameLogic logic;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        logic = new GameLogic();

        setTitle("Угадай слово");
        setBounds(300,300, 300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel northPanel = new JPanel(new GridLayout(2, 1));
        add(northPanel, BorderLayout.NORTH);
        JLabel label = new JLabel("Попробуйте угадать слово:");
        northPanel.add(label);
        JTextField inputField = new JTextField();
        northPanel.add(inputField);

        JPanel mainPanel = new JPanel();
        add(mainPanel);
        JTextArea outputField = new JTextArea(12,25);

        JScrollPane scrollTextArea = new JScrollPane(outputField);
        scrollTextArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollTextArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scrollTextArea);


        JPanel southPanel = new JPanel(new GridLayout(1,2, 10, 5));
        add(southPanel, BorderLayout.SOUTH);
        JButton exitGame = new JButton("Закончить игру");
        JButton newGame = new JButton("Новая игра");
        southPanel.add(newGame);
        southPanel.add(exitGame);

        newGame.addActionListener(e -> {
            logic = new GameLogic();
            outputField.setText(null);
        });

        exitGame.addActionListener(e -> System.exit(0));

        inputField.addActionListener(e -> {
            logic.setInputWord(inputField.getText());
            logic.game();
            outputField.append(logic.getOutputString() + "\n");
            inputField.setText("");
        });

        setVisible(true);
    }
}
