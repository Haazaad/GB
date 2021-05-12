package ru.ArtemSmirnov.java3.homework1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0;
        for (Fruit f: fruits) {
            weight += f.getWeight();
        }
        return weight;
    }

    public void shiftFruit(Box<T> anotherBox, int count) {
        if (count < fruits.size() && count > 0) {
            for (int i = count; i > 0; i--){
                anotherBox.addFruit(fruits.get(i));
                fruits.remove(i);
            }
        }
        System.out.println("Сейчас в коробке " + fruits.size() + " а необходимо " + count);
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(getWeight() - anotherBox.getWeight()) < 0.00001;
    }

    public boolean compare(Fruit fruit) {
        return Math.abs(getWeight() - fruit.getWeight()) < 0.00001;
    }
}
