package ru.ArtemSmirnov.homework6.animals;

public class Cat extends Animal {
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(int x) {
        if (x > 0) {
            if (x >= 200) {
                x = 200;
            }
        }
        System.out.println(this.name + " пробежал " + x + " м.");
    }

    @Override
    public void swim(int x) {
        System.out.println("Кошки не умеют плавать");
    }
}