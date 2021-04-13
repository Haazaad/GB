package ru.ArtemSmirnov.java1.homework4.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettings extends JFrame {
    private MapField map = new MapField();

    public GameSettings() {
        setTitle("Настройки");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 340, 200);
        JPanel mainPanel = new JPanel();
        add(mainPanel, BorderLayout.CENTER);
        JLabel chooseMapSize = new JLabel("Выберите размерность игрового поля:");
        ButtonGroup mapSizeGroup = new ButtonGroup();
        JRadioButton size_3 = new JRadioButton("3", true);
        JRadioButton size_5 = new JRadioButton("5", false);
        mapSizeGroup.add(size_3);
        mapSizeGroup.add(size_5);
        mainPanel.add(chooseMapSize);
        mainPanel.add(size_3);
        mainPanel.add(size_5);

        JLabel chooseAiLevel = new JLabel("Выберите уровень сложности:");
        JSlider slideAiLevel = new JSlider(0, 2, 0);
        slideAiLevel.setMajorTickSpacing(2);
        slideAiLevel.setMinorTickSpacing(1);
        slideAiLevel.setPaintTicks(true);
        slideAiLevel.setPaintLabels(true);
        mainPanel.add(chooseAiLevel);
        mainPanel.add(slideAiLevel);

        JLabel chooseFirstTurn = new JLabel("Выберите кто ходит первым:");
        ButtonGroup firstTurnGroup = new ButtonGroup();
        JRadioButton humanFirstTrun = new JRadioButton("Игрок", true);
        JRadioButton aiFirstTrun = new JRadioButton("ИИ", false);
        firstTurnGroup.add(humanFirstTrun);
        firstTurnGroup.add(aiFirstTrun);
        mainPanel.add(chooseFirstTurn);
        mainPanel.add(humanFirstTrun);
        mainPanel.add(aiFirstTrun);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton newGame = new JButton("Начать игру");
        JButton exitGame = new JButton("Закончить игру");
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(newGame);
        buttonPanel.add(exitGame);
        newGame.addActionListener(actionEvent -> {
            if (size_3.isSelected()) {
                map.setMapSize(3);
            } else {
                map.setMapSize(5);
            }
            if (humanFirstTrun.isSelected()) {
                map.setHumanFirstTurn(true);
            }
            map.setAiLevel(slideAiLevel.getValue());
            setVisible(false);
            GameField gameField = new GameField(map);
        });
        exitGame.addActionListener(actionEvent -> System.exit(0));


        setVisible(true);
    }

    public static void main(String[] args) {
        new GameSettings();
    }
}
