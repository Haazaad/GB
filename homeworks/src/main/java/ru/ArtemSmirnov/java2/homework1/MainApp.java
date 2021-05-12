package ru.ArtemSmirnov.java2.homework1;

import ru.ArtemSmirnov.java2.homework1.obstacle.*;
import ru.ArtemSmirnov.java2.homework1.persons.*;

public class MainApp {
    public static void main(String[] args) {
        Actionable[] persons = {
                new Human("Bob", 100, 2),
                new Cat("Barsik", 300, 5),
                new Robot("R2D2", 1000)
        };
        Obstacle[] obstacles = {
                new RunningTrack(50),
                new RunningTrack(200),
                new Wall(3),
                new RunningTrack(500),
        };
        for (Actionable person: persons) {
            for (Obstacle obstacle: obstacles) {
                person.overcoming(obstacle);
            }
        }
    }
}
