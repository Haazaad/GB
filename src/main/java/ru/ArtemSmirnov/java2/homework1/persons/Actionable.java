package ru.ArtemSmirnov.java2.homework1.persons;

import ru.ArtemSmirnov.java2.homework1.obstacle.Obstacle;

public interface Actionable {
    void overcoming(Obstacle obstacle);
    void run(Obstacle obstacle);
    void jump(Obstacle obstacle);
}
