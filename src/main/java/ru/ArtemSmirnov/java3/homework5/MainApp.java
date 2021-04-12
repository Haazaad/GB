package ru.ArtemSmirnov.java3.homework5;

import java.util.concurrent.CyclicBarrier;

public class MainApp {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cb);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
}
