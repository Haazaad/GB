package ru.ArtemSmirnov.java2.homework1.obstacle;

public abstract class Obstacle {
    private int obstacleSize;

    public Obstacle(int obstacleSize) {
        this.obstacleSize = obstacleSize;
    }

    public int getObstacleSize() {
        return obstacleSize;
    }

}
