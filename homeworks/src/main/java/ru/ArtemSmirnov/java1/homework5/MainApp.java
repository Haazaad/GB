package ru.ArtemSmirnov.java1.homework5;

public class MainApp {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Инженер", "ivanov@mail.ru", "+7987545698", 2052.45, 45);
        employees[1] = new Employee("Петров Петр Петрович", "Программист", "petrov@mail.ru", "+85698745601", 35265.12, 23);
        employees[2] = new Employee("Пупкин Василий Иванович", "Кладовщик", "pupkin@mail.ru", "+82654789354", 21451.09, 51);
        employees[3] = new Employee("Тыгыдыков Тыгыдык Тыгыдыкович", "Директор", "wasuup@mail.ru", "+123457895", 52487.23, 32);
        employees[4] = new Employee("Мухин Иван Васильевич", "Инженер-программист", "vjick@mail.ru", "+3235648792", 2457.29, 24);
        for (Employee employee: employees) {
            if (employee.getAge() > 40) {
                employee.getInfo();
                System.out.println();
            }
        }
    }
}
