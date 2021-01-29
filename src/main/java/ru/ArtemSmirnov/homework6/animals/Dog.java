package ru.ArtemSmirnov.homework6.animals;

public class Dog extends Animal {

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void run(int x) {
        if (x > 0) {
            if (x >= 500) {
                x = 500;
            }
        }
        System.out.println(this.name + " пробежал " + x + " м.");
    }

    @Override
    public void swim(int x) {
        if (x > 0) {
            if (x >= 10) {
                x = 10;
            }
        }
        System.out.println(this.name + " проплыл " + x + " м.");
    }
}
