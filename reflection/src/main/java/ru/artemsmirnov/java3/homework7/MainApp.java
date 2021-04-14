package ru.artemsmirnov.java3.homework7;

public class MainApp {
    public static void main(String[] args) throws NoSuchMethodException {
        RunTest run = new RunTest();
        TestClass test = new TestClass();
        run.start(test.getClass());
    }
}
