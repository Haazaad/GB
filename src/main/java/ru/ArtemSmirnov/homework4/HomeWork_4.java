package ru.ArtemSmirnov.homework4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork_4 {
    public static char[][] map;
    public static int mapSize;
    public static int dotsToWin;

    public static final char EMPTY_DOT = '•';
    public static char humanDot;
    public static char aiDot;
    public static int aiLevel;

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        chooseMapSize();
        chooseAiLevel();
        chooseFirstTurn();
        prepareMap();
        printMap();
        if (humanDot == 'X') {
            humanFirstTurn();
        } else {
            aiFirstTurn();
        }
        printMap();
        System.out.println("Игра закончена!!!");
    }

    // выбираем размерность игрового поля
    public static void chooseMapSize() {
        int size;
        do {
            System.out.println("Введите размерность игрового поля - 3 или 5.");
            size = scanner.nextInt();
        } while (size != 3 && size != 5);
        mapSize = size;
        if (mapSize == 3) {
            dotsToWin = mapSize;
        } else {
            dotsToWin = mapSize - 1;
        }
    }

    // подготавливаем игровое поле
    public static void prepareMap() {
        map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    // вывод игрового поля
    public static void printMap() {
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
    public static boolean isMapFull() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    // проверка валидности введенных координат и занятости на игровом поле
    public static boolean isValidOrEmpty(int x, int y) {
        if (x < 0 || x >= mapSize || y < 0 || y >= mapSize) return false;
        return map[y][x] == EMPTY_DOT;
    }

    // выбор кто ходит первым
    public static void chooseFirstTurn() {
        int num;
        do {
            System.out.println("Выберите кто ходит первым (1 - Вы, 2 - Компьютер)?");
            num = scanner.nextInt();
        } while (num != 1 && num !=2);
        if (num == 1) {
            humanDot = 'X';
            aiDot = 'O';
        } else {
            humanDot = 'O';
            aiDot = 'X';
        }
    }

    public static void chooseAiLevel() {
        int level;
        do {
            System.out.println("Выберите сложность игры 0 или 1");
            level = scanner.nextInt();
        } while (level != 0 && level != 1);
        aiLevel = level;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты хода в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidOrEmpty(x, y));
        map[y][x] = humanDot;
    }

    // ход ИИ
    public static void aiTurn() {
        int x, y;
        x = 0;
        y = 0;
        boolean isHumanWin = false;
        // повышенный уровень сложности с блокировкой хода игрока
        // не особо работает для длины поля 5
        // как вариант добавить дополнительно проверку ИИ на выигрыш
        if (aiLevel == 1) {
            for (int i = 0; i < mapSize; i++) {
                char buffer;
                for (int j = 0; j < mapSize; j++) {
                    if (isValidOrEmpty(i, j)) {
                        buffer = map[i][j];
                        map[i][j] = humanDot;
                        if (checkWin(humanDot)) {
                            x = j;
                            y = i;
                            isHumanWin = true;
                        }
                        map[i][j] = buffer;
                    }
                }

            }
        }
        // обычный ход ИИ
        if (!isHumanWin) {
            do {
                x = random.nextInt(mapSize);
                y = random.nextInt(mapSize);
            } while (!isValidOrEmpty(x, y));
        }
        map[y][x] = aiDot;
        System.out.printf("Ход компьютера по координатам %s %s\n", x + 1, y + 1);
    }

    public static void humanFirstTurn() {
        while (true) {
            humanTurn();
            if (checkWin(humanDot)) {
                System.out.println("Вы выиграли!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
            aiTurn();
            if (checkWin(aiDot)) {
                System.out.println("Компьютер выиграл.");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
            printMap();
        }
    }

    public static void aiFirstTurn() {
        while (true) {
            aiTurn();
            if (checkWin(aiDot)) {
                System.out.println("Компьютер выиграл.");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
            printMap();
            humanTurn();
            if (checkWin(humanDot)) {
                System.out.println("Вы выиграли!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
        }
    }

    public static boolean checkWin(char dot) {
        for (int i = 0; i <= mapSize - dotsToWin; i++) {
            for (int j = 0; j <= mapSize - dotsToWin; j++) {
                if (checkDiagonal(dot, i, j) || checkColsAndRows(dot, i, j)) return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonal(char dot, int shiftX, int shiftY) {
        boolean fromLeftToRight, fromRightToLeft;
        fromLeftToRight = true;
        fromRightToLeft = true;
        for (int i = 0; i < dotsToWin; i++) {
            fromLeftToRight = (fromLeftToRight && map[i + shiftX][i + shiftY] == dot);
            fromRightToLeft = (fromRightToLeft && map[(dotsToWin + shiftX) - 1 - i][i + shiftY] == dot);
        }
        return fromLeftToRight || fromRightToLeft;
    }

    public static boolean checkColsAndRows(char dot, int shiftX, int shiftY) {
        boolean rows, cols;
        for (int i = shiftX; i < dotsToWin + shiftX; i++) {
            cols = true;
            rows = true;
            for (int j = shiftY; j < dotsToWin + shiftY; j++) {
                cols = (cols && map[i][j] == dot);
                rows = (rows && map[j][i] == dot);
            }
            if (cols || rows) return true;
        }
        return false;
    }
}