package ru.ArtemSmirnov.java2.homework1.persons;

import ru.ArtemSmirnov.java2.homework1.obstacle.Obstacle;
import ru.ArtemSmirnov.java2.homework1.obstacle.RunningTrack;
import ru.ArtemSmirnov.java2.homework1.obstacle.Wall;

public class Robot implements Actionable {
    private String name;
    private int limitRunDistance;
    private Obstacle obstacle;

    public Robot(String name, int limitRunDistance) {
        this.name = name;
        this.limitRunDistance = limitRunDistance;
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
            System.out.println("К сожалению роботы не умеют прыгать");
        }
    }
}
