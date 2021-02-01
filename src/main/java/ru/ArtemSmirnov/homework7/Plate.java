package ru.ArtemSmirnov.homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean isDecrease(int n) {
        if (food - n >= 0) {
            decreaseFood(n);
            return true;
        } else {
            return false;
        }
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void addFood(int n) {
        food += n;
    }

    public void info() {
        System.out.println("Еды в тарелке: " + food);
    }
}
