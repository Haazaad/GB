package ru.ArtemSmirnov.java1.homework4;

import ru.ArtemSmirnov.java1.homework4.players.AiPlayer;
import ru.ArtemSmirnov.java1.homework4.players.HumanPlayer;

import java.util.Scanner;

public class MainApp {
    public static Map map = new Map();
    public static HumanPlayer humanPlayer;
    public static AiPlayer aiPlayer;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        map.chooseMapSize(scanner);
        map.prepareMap();
        humanPlayer = new HumanPlayer(scanner);
        aiPlayer = new AiPlayer(humanPlayer.getDot());
        aiPlayer.chooseAiLevel(scanner);
        map.printMap();
        if (humanPlayer.getDot() == 'X') {
            humanFirstTurn();
        } else {
            aiFirstTurn();
        }
        map.printMap();
        System.out.println("Игра закончена!!!");
    }

    public static void humanFirstTurn() {
        while (true) {
            humanPlayer.turn(scanner, map);
            if (map.checkWin(humanPlayer.getDot())) {
                System.out.println("Вы выиграли!!!");
                break;
            }
            if (map.isFull()) {
                System.out.println("Ничья.");
                break;
            }
            aiPlayer.turn(map, humanPlayer.getDot());
            if (map.checkWin(aiPlayer.getDot())) {
                System.out.println("Компьютер выиграл.");
                break;
            }
            if (map.isFull()) {
                System.out.println("Ничья.");
                break;
            }
            map.printMap();
        }
    }

    public static void aiFirstTurn() {
        while (true) {
            aiPlayer.turn(map, humanPlayer.getDot());
            if (map.checkWin(aiPlayer.getDot())) {
                System.out.println("Компьютер выиграл.");
                break;
            }
            if (map.isFull()) {
                System.out.println("Ничья.");
                break;
            }
            map.printMap();
            humanPlayer.turn(scanner, map);
            if (map.checkWin(humanPlayer.getDot())) {
                System.out.println("Вы выиграли!!!");
                break;
            }
            if (map.isFull()) {
                System.out.println("Ничья.");
                break;
            }
        }
    }
}