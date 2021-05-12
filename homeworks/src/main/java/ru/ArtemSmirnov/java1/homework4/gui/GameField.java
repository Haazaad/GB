package ru.ArtemSmirnov.java1.homework4.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameField extends JFrame {
    private MapField map;

    public GameField(MapField map) {
        this.map = map;
        this.map.startNewGame();
        setTitle("Крестики-нолики");
        setBounds(100,100,16 + (this.map.getCELL_SIZE() * this.map.getMapSize()),62 + (this.map.getCELL_SIZE() * this.map.getMapSize()));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        add(this.map);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton newGame = new JButton("Начать игру");
        JButton exitGame = new JButton("Закончить игру");
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(newGame);
        buttonPanel.add(exitGame);
        newGame.addActionListener(actionEvent -> {
            setVisible(false);
            GameSettings gameSettings = new GameSettings();
        });
        exitGame.addActionListener(actionEvent -> System.exit(0));

        setVisible(true);
    }

}
