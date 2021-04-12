package ru.ArtemSmirnov.java2.homework3;

import java.util.*;

public class PhoneBook {
    private Map<String, List<Integer>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String secondName, int number) {
        List<Integer> numbers;
        if (phoneBook.containsKey(secondName)) {
            numbers = phoneBook.get(secondName);
        } else {
            numbers = new ArrayList<>();
        }
        numbers.add(number);
        phoneBook.put(secondName, numbers);
    }

    public void get(String secondName) {
        if (phoneBook.containsKey(secondName)) {
            System.out.println(secondName + ": " + phoneBook.get(secondName));
        }
    }

    public void printAll() {
        for (Map.Entry<String, List<Integer>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        List<String> str = new ArrayList<>(Arrays.asList("new", "old", "new", "mellon", "dog", "human", "cat", "robot", "car",
                "new", "old", "new", "cat", "dog", "human", "cat", "robot", "car"));
        for (String s : str) {
            phoneBook.add(s, (int) (Math.random() * 100));
        }
        phoneBook.get(str.get((int) (Math.random() * str.size())));

        //phoneBook.printAll();
    }
}
