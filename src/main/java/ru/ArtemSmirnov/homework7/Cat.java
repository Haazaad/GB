package ru.ArtemSmirnov.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public void eat(Plate p) {
        if (p.isDecrease(appetite)) {
            hungry = false;
        }
    }

    public void isHungry() {
        System.out.printf("%s голоден? - %s\n", name, hungry);
    }
}
