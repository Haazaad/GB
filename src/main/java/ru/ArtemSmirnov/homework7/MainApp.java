package ru.ArtemSmirnov.homework7;

public class MainApp {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = {
                new Cat("Барсик", 10),
                new Cat("Мурзик", 23),
                new Cat("Чешир", 50),
                new Cat("Марсель", 25),
                new Cat("Черныш", 12)
        };
        plate.info();
        for (Cat cat: cats) {
            cat.eat(plate);
        }
        plate.info();
        for (Cat cat: cats) {
            cat.isHungry();
        }
    }
}
