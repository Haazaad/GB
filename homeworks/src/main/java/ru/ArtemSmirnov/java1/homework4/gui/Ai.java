package ru.ArtemSmirnov.java1.homework4.gui;

public class Ai {
    private int aiLevel;
    private MapField map;

    public Ai(MapField map) {
        this.map = map;
        this.aiLevel = map.getAiLevel();
    }

    public void turn() {
        int cellX = 0;
        int cellY = 0;
        boolean isHumanWin = false;
        boolean isAiWin = false;
        byte buffer;
        if (aiLevel == 2) {
            for (int i = 0; i < map.getMapSize(); i++) {
                for (int j = 0; j < map.getMapSize(); j++) {
                    if (map.isValidOrEmpty(i,j)) {
                        buffer = map.getDot(i, j);
                        map.setDot(i, j, map.getAiDot());
                        if (map.checkWin(map.getAiDot())) {
                            cellX = i;
                            cellY = j;
                            isAiWin = true;
                        }
                        map.setDot(i, j, buffer);
                    }
                }
            }
        }
        // ход ИИ с блокировкой хода игрока
        if (aiLevel == 1) {
            for (int i = 0; i < map.getMapSize(); i++) {
                for (int j = 0; j < map.getMapSize(); j++) {
                    if (map.isValidOrEmpty(i, j)) {
                        buffer = map.getDot(i, j);
                        map.setDot(i, j, map.getHumanDot());
                        if (map.checkWin(map.getHumanDot())) {
                            cellX = i;
                            cellY = j;
                            isHumanWin = true;
                        }
                        map.setDot(i, j, buffer);
                    }
                }

            }
        }
        // обычный ход ИИ
        if (!isAiWin || !isHumanWin) {
            do {
                cellX = (int) (Math.random() * map.getMapSize());
                cellY = (int) (Math.random() * map.getMapSize());
            } while (!map.isValidOrEmpty(cellX, cellY));
        }
        map.setDot(cellX, cellY, map.getAiDot());
    }
}
