package ru.ArtemSmirnov.homework7;

public class Plate {
    private int food;
    private int maxFood;

    public Plate(int food) {
        this.maxFood = food;
        this.food = this.maxFood;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int count) {
        if (food - count >= 0) {
            food -= count;
        } else {
            System.out.println("В тарелке недостаточно еды.");
        }
    }

    public void fillPlate(int count) {
        this.food += count;
    }

    public void info() {
        System.out.printf("Еды в тарелке: %d/%d\n", food, maxFood);
    }
}
