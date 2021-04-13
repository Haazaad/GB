package ru.ArtemSmirnov.java3.homework5;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{
    private static int CARS_COUNT;
    private static boolean winner;
    private CyclicBarrier barrier;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник № " + CARS_COUNT;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            barrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            winner(this);
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static synchronized void winner(Car c) {
        if (!c.winner) {
            System.out.println(c.name + " - WIN!!!");
            c.winner = true;
        }
    }

}
