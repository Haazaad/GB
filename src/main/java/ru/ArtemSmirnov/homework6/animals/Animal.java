package ru.ArtemSmirnov.homework6.animals;

public abstract class Animal {
    String type;
    String name;
    int maxRunDistance;
    int maxSwimDistance;

    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.printf("%s пробежал %d метров\n", type, distance);
        } else {
            System.out.printf("%s не смог пробежать\n", type);
        }
    }

    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            System.out.printf("%s не умеет плавать\n", type);
        }
        if (distance <= maxSwimDistance) {
            System.out.printf("%s пробежал %d метров\n", type, distance);
        } else {
            System.out.printf("%s не смог пробежать\n", type);
        }
    }
}
