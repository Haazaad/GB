package ru.ArtemSmirnov.java2.homework1.persons;

import ru.ArtemSmirnov.java2.homework1.obstacle.Obstacle;
import ru.ArtemSmirnov.java2.homework1.obstacle.RunningTrack;
import ru.ArtemSmirnov.java2.homework1.obstacle.Wall;

public class Human implements Actionable{
    private String name;
    private int limitRunDistance;
    private int limitJumpHeight;
    private Obstacle obstacle;

    public Human(String name, int limitRunDistance, int limitJumpHeight) {
        this.name = name;
        this.limitRunDistance = limitRunDistance;
        this.limitJumpHeight = limitJumpHeight;
        obstacle = null;
    }

    @Override
    public void overcoming(Obstacle obstacle) {
        if (obstacle instanceof RunningTrack) {
            run(obstacle);
        } else if (obstacle instanceof Wall) {
            jump(obstacle);
        }
    }

    @Override
    public void run(Obstacle obstacle) {
        if (this.obstacle == null) {
            this.obstacle = obstacle;
            if (limitRunDistance >= this.obstacle.getObstacleSize()) {
                System.out.printf("%s успешно пробежал.\n", name);
                passObstacle();
            } else {
                System.out.printf("%s не удалось пробежать.\n", name);
            }
        }
    }

    public void passObstacle() {
        obstacle = null;
    }

    @Override
    public void jump(Obstacle obstacle) {
        if (this.obstacle == null) {
            this.obstacle = obstacle;
            if (limitJumpHeight >= this.obstacle.getObstacleSize()) {
                System.out.printf("%s успешно перепрыгнул.\n", name);
                passObstacle();
            } else {
                System.out.printf("%s не удалось перепрыгнуть.\n", name);
            }
        }
    }
}
