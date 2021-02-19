package ru.ArtemSmirnov.java1.homework6.animals;

public class Dog extends Animal {
    static int dogsCount = 0;

    public Dog(String name) {
        this.type = "Собака";
        this.name = name;
        this.maxRunDistance = 500;
        this.maxSwimDistance = 10;
        dogsCount++;
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}
