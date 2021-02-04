package ru.ArtemSmirnov.homework4;

import java.util.Scanner;

public class Map {
    private final char EMPTY_DOT = '*';

    private char[][] map;
    private int mapSize;
    private int dotToWin;

    private Scanner scanner;

    // выбираем размерность игрового поля
    public void chooseMapSize(Scanner scanner) {
        this.scanner = scanner;
        int size;
        do {
            System.out.println("Введите размерность игрового поля - 3 или 5.");
            size = scanner.nextInt();
        } while (size != 3 && size != 5);
        mapSize = size;
        if (mapSize == 3) {
            dotToWin = mapSize;
        } else {
            dotToWin = mapSize - 1;
        }
    }

    public int getMapSize() {
        return mapSize;
    }

    public char getDot(int x, int y) {
        return map[x][y];
    }

    public void setDot(int x, int y, char dot) {
        map[x][y] = dot;
    }

    // подготавливаем игровое поле
    public void prepareMap() {
        map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    // вывод игрового поля
    public void printMap() {
        System.out.println();
        for (int i = 0; i <= mapSize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < mapSize; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < mapSize; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // проверка заполнено ли игровое поле полностью
    public boolean isFull() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    // проверка валидности введенных координат и занятости на игровом поле
    public boolean isValidOrEmpty(int x, int y) {
        if (x < 0 || x >= mapSize || y < 0 || y >= mapSize) return false;
        return map[y][x] == EMPTY_DOT;
    }

    public boolean checkWin(char dot) {
        for (int i = 0; i <= mapSize - dotToWin; i++) {
            for (int j = 0; j <= mapSize - dotToWin; j++) {
                if (checkDiagonal(dot, i, j) || checkColsAndRows(dot, i, j)) return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal(char dot, int shiftX, int shiftY) {
        boolean fromLeftToRight, fromRightToLeft;
        fromLeftToRight = true;
        fromRightToLeft = true;
        for (int i = 0; i < dotToWin; i++) {
            fromLeftToRight = (fromLeftToRight && map[i + shiftX][i + shiftY] == dot);
            fromRightToLeft = (fromRightToLeft && map[(dotToWin + shiftX) - 1 - i][i + shiftY] == dot);
        }
        return fromLeftToRight || fromRightToLeft;
    }

    public boolean checkColsAndRows(char dot, int shiftX, int shiftY) {
        boolean rows, cols;
        for (int i = shiftX; i < dotToWin + shiftX; i++) {
            cols = true;
            rows = true;
            for (int j = shiftY; j < dotToWin + shiftY; j++) {
                cols = (cols && map[i][j] == dot);
                rows = (rows && map[j][i] == dot);
            }
            if (cols || rows) return true;
        }
        return false;
    }

}
