package ru.ArtemSmirnov.homework4.players;

import ru.ArtemSmirnov.homework4.Map;

import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(Scanner scanner) {
        int num;
        do {
            System.out.println("Выберите кто ходит первым (1 - Вы, 2 - Компьютер)?");
            num = scanner.nextInt();
        } while (num != 1 && num !=2);
        if (num == 1) {
            this.dot = 'X';
        } else {
            this.dot = 'O';
        }
    }

    public void turn(Scanner scanner, Map map) {
        int x, y;
        do {
            System.out.println("Введите координаты хода в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!map.isValidOrEmpty(x, y));
        map.setDot(y, x, dot);
    }
}
