package ru.ArtemSmirnov.java1.homework6.animals;

public abstract class Animal {
    static int animalsCount = 0;
    String type;
    String name;
    int maxRunDistance;
    int maxSwimDistance;

    public Animal() {
        animalsCount++;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

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
