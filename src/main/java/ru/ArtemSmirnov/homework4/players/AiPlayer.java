package ru.ArtemSmirnov.homework4.players;

import ru.ArtemSmirnov.homework4.Map;

import java.util.Random;
import java.util.Scanner;

public class AiPlayer extends Player{
    private int aiLevel;

    private Random random = new Random();

    public AiPlayer(char dot) {
        if (dot == 'X') {
            this.dot = 'O';
        } else {
            this.dot = 'X';
        }
    }

    public void chooseAiLevel(Scanner scanner) {
        int level;
        do {
            System.out.println("Выберите сложность игры 0 или 1");
            level = scanner.nextInt();
        } while (level != 0 && level != 1);
        this.aiLevel = level;
    }

    public void turn(Map map, char humanDot) {
        int x, y;
        x = 0;
        y = 0;
        boolean isHumanWin = false;
        // повышенный уровень сложности с блокировкой хода игрока
        // не особо работает для длины поля 5
        // как вариант добавить дополнительно проверку ИИ на выигрыш
        if (aiLevel == 1) {
            for (int i = 0; i < map.getMapSize(); i++) {
                char buffer;
                for (int j = 0; j < map.getMapSize(); j++) {
                    if (map.isValidOrEmpty(i, j)) {
                        buffer = map.getDot(i, j);
                        map.setDot(i, j, humanDot);
                        if (map.checkWin(humanDot)) {
                            x = j;
                            y = i;
                            isHumanWin = true;
                        }
                        map.setDot(i, j, buffer);
                    }
                }

            }
        }
        // обычный ход ИИ
        if (!isHumanWin) {
            do {
                x = random.nextInt(map.getMapSize());
                y = random.nextInt(map.getMapSize());
            } while (!map.isValidOrEmpty(x, y));
        }
        map.setDot(y, x, this.dot);
        System.out.printf("Ход компьютера по координатам %s %s\n", x + 1, y + 1);
    }
}
