package ru.ArtemSmirnov.homework6.animals;

public class Cat extends Animal {
    static int catsCount = 0;

    public Cat(String name) {
        this.type = "Кот";
        this.name = name;
        this.maxRunDistance = 200;
        this.maxSwimDistance = 0;
        catsCount++;
    }

    @Override
    public void swim(int x) {
        System.out.println("Кошки не умеют плавать\n");
    }

    public static int getCatsCount() {
        return catsCount;
    }
}