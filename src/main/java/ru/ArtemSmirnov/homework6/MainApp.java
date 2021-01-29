package ru.ArtemSmirnov.homework6;

import ru.ArtemSmirnov.homework6.animals.*;

public class MainApp {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Barsik"),
                new Cat("Murzik"),
                new Dog("Bobik"),
                new Dog("Trezor"),
        };
        checkCount(animals);
    }

    public static void checkCount(Animal[] animals) {
        int countCat = 0;
        int countDog = 0;
        for (Animal a: animals) {
            if (a instanceof Cat) {
                countCat++;
            }
            if (a instanceof Dog) {
                countDog++;
            }
            a.run(300);
            a.swim(10);
        }
        System.out.println("Всего животных - " + animals.length);
        System.out.println("Всего собак - " + countDog);
        System.out.println("Всего котов - " + countCat);
    }
}
