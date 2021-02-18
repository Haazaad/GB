package ru.ArtemSmirnov.java2.homework2;

public class MyArrayDataException extends NumberFormatException {
    String description;

    public MyArrayDataException(String description) {
        this.description = description;
    }

    public String toString() {
        return MyArrayDataException.class + " " + description;
    }
}
