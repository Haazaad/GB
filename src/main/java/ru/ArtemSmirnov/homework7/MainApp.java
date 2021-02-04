package ru.ArtemSmirnov.homework7;

public class MainApp {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = {
                new Cat("Barsik", 23),
                new Cat("Murzik", 15),
                new Cat("Black", 50),
                new Cat("White", 30)
        };
        plate.info();
        for (Cat cat: cats) {
            cat.eat(plate);
        }
        plate.info();
        for (Cat cat: cats) {
            cat.info();
        }
    }
}
