package ru.ArtemSmirnov.homework6.animals;

public class Dog extends Animal {

    public Dog(String name) {
        this.type = "Собака";
        this.name = name;
        this.maxRunDistance = 500;
        this.maxSwimDistance = 10;
    }
}
