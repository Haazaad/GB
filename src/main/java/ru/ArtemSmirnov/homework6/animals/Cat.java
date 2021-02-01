package ru.ArtemSmirnov.homework6.animals;

public class Cat extends Animal {
    public Cat(String name) {
        this.type = "Кот";
        this.name = name;
        this.maxRunDistance = 200;
        this.maxSwimDistance = 0;
    }

    @Override
    public void swim(int x) {
        System.out.println("Кошки не умеют плавать\n");
    }
}