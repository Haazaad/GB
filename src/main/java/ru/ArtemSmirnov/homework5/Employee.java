package ru.ArtemSmirnov.homework5;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    public Employee(String name, String position,  String email, String phoneNumber, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void getInfo() {
        System.out.printf("ФИО: %s\n" +
                "Должность: %s\n" +
                "Email: %s\n" +
                "Телефон: %s\n" +
                "Размер заработной платы: %s\n" +
                "Возраст: %s\n", name, position, email, phoneNumber, salary, age);
    }
}
