package ru.ArtemSmirnov.java1.homework4.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapField extends JPanel {
    private final int CELL_SIZE = 100;

    private int mapSize;
    private int dotToWin;

    private byte[][] mapField;
    private byte aiDot;
    private byte humanDot;

    private boolean humanFirstTurn = false;

    private int aiLevel;

    private Ai ai = new Ai(this);

    public boolean isStarted;

    public MapField() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (isStarted) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        int cellX = e.getX() / CELL_SIZE;
                        int cellY = e.getY() / CELL_SIZE;
                        if (isValidOrEmpty(cellX, cellY)) {
                            setDot(cellX, cellY, humanDot);
                            checkMap();
                            ai.turn();
                            repaint();
                        }
                    }
                }
            }
        });
    }

    public void setHumanFirstTurn(boolean humanFirstTurn) {
        this.humanFirstTurn = humanFirstTurn;
        if (humanFirstTurn) {
            humanDot = 1;
            aiDot = 2;
        } else {
            humanDot = 2;
            aiDot = 1;
        }
    }

    public void setAiLevel(int aiLevel) {
        this.aiLevel = aiLevel;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
        if (mapSize == 3) {
            dotToWin = mapSize;
        } else {
            dotToWin = mapSize - 1;
        }
    }

    public int getAiLevel() {
        return aiLevel;
    }

    public byte getAiDot() {
        return aiDot;
    }

    public byte getDot(int cellX, int cellY) {
        return mapField[cellX][cellY];
    }

    public byte getHumanDot() {
        return humanDot;
    }

    public void checkMap() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (mapField[i][j] == 0) {
                    return;
                }
            }
        }
        isStarted = false;
        repaint();
    }

    public boolean isValidOrEmpty(int cellX, int cellY) {
        if (cellX < 0 || cellY < 0 || cellX >= mapSize || cellY >= mapSize) {
            return false;
        }
        return mapField[cellX][cellY] == 0;
    }

    public void setDot(int cellX, int cellY, byte dot) {
        mapField[cellX][cellY] = dot;
        repaint();
    }

    public void startNewGame() {
        mapField = new byte[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                mapField[i][j] = 0;
            }
        }
        isStarted = true;
        repaint();
    }

    public boolean checkWin(byte dot) {
        for (int i = 0; i <= mapSize - dotToWin; i++) {
            for (int j = 0; j <= mapSize - dotToWin; j++) {
                if (checkDiagonal(dot, i, j) || checkColsAndRows(dot, i, j)) return true;
            }
        }
        return false;
    }

    public boolean checkDiagonal(byte dot, int shiftX, int shiftY) {
        boolean fromLeftToRight, fromRightToLeft;
        fromLeftToRight = true;
        fromRightToLeft = true;
        for (int i = 0; i < dotToWin; i++) {
            fromLeftToRight = (fromLeftToRight && mapField[i + shiftX][i + shiftY] == dot);
            fromRightToLeft = (fromRightToLeft && mapField[(dotToWin + shiftX) - 1 - i][i + shiftY] == dot);
        }
        return fromLeftToRight || fromRightToLeft;
    }

    public boolean checkColsAndRows(byte dot, int shiftX, int shiftY) {
        boolean rows, cols;
        for (int i = shiftX; i < dotToWin + shiftX; i++) {
            cols = true;
            rows = true;
            for (int j = shiftY; j < dotToWin + shiftY; j++) {
                cols = (cols && mapField[i][j] == dot);
                rows = (rows && mapField[j][i] == dot);
            }
            if (cols || rows) return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, mapSize * CELL_SIZE, mapSize * CELL_SIZE);
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                ((Graphics2D) g).setStroke(new BasicStroke(3));
                g.setColor(Color.BLACK);
                g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                if (mapField[i][j] == 2) {
                    ((Graphics2D) g).setStroke(new BasicStroke(6));
                    g.setColor(Color.RED);
                    g.drawOval(i * CELL_SIZE + 10, j * CELL_SIZE + 10, CELL_SIZE - 20, CELL_SIZE - 20);
                }
                if (mapField[i][j] == 1) {
                    ((Graphics2D) g).setStroke(new BasicStroke(6));
                    g.setColor(Color.GREEN);
                    g.drawLine(i * CELL_SIZE + 20, j * CELL_SIZE + 20, (i + 1) * CELL_SIZE - 20, (j + 1) * CELL_SIZE - 20);
                    g.drawLine(i * CELL_SIZE + 20, (j + 1) * CELL_SIZE - 20, (i + 1) * CELL_SIZE - 20, j * CELL_SIZE + 20);
                }
            }
        }
    }

    public int getCELL_SIZE() {
        return CELL_SIZE;
    }

    public int getMapSize() {
        return mapSize;
    }
}
