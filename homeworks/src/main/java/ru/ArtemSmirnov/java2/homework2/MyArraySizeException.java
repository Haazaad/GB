package ru.ArtemSmirnov.java2.homework2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{
    String description;

    public MyArraySizeException(String description) {
        this.description = description;
    }

    public String toString() {
        return MyArraySizeException.class + " " + description;
    }
}
