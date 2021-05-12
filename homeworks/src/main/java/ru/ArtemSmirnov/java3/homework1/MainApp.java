package ru.ArtemSmirnov.java3.homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        String[] arr1 = {"1", "2", "3", "4", "5", "6"};
        replaceElementArray(arr1, 2, 4);
        System.out.println(Arrays.toString(arr1));
        System.out.println(modifyToArrayList(arr1).getClass());

        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        for (int i = 0; i < 10; i++) {
            box1.addFruit(new Apple());
            box2.addFruit(new Orange());
        }
        System.out.println(box1.compare(box2));
        Fruit orange = new Orange(10.0f);
        System.out.println(box1.compare(orange));
        Box<Apple> box3 = new Box<>();
        box1.shiftFruit(box3, 4);
        System.out.printf("Первая коробка весит %f, вторая весит %f\n", box1.getWeight(), box3.getWeight());
        box1.shiftFruit(box3,10);
    }

    // Task № 1
    public static void replaceElementArray(Object[] array, int initialIndex, int replaceIndex) {
        Object buff = array[replaceIndex];
        array[replaceIndex] = array[initialIndex];
        array[initialIndex] = buff;
    }

    // Task № 2
    public static <T extends Object, Number> ArrayList<T> modifyToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
