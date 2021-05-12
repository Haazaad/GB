package ru.ArtemSmirnov.java1.homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public void eat(Plate plate) {
        if (plate.getFood() - appetite >= 0) {
            plate.decreaseFood(appetite);
            hungry = false;
        } else {
            System.out.printf("%s не удалось поесть\n", name);
        }
    }

    public void info() {
        System.out.printf("%s голоден? - %s\n", name, hungry);
    }
}
