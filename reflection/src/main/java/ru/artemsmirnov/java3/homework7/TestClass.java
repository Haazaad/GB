package ru.artemsmirnov.java3.homework7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestClass {
    private static final Logger logger = LogManager.getLogger(TestClass.class.getName());

    private int a;
    private int b;

    public TestClass() {}

    @BeforeSuite
    public void initialize() {
        this.a = 5;
        this.b = 6;
        logger.info("Инициализация переменных a={}, b={}", a, b);
    }

    @AfterSuite
    public void deInitialize() {
        a = 0;
        b = 0;
        logger.info("Аннулирование переменных a={}, b={}", a, b);
    }

    @Test(priority = 2)
    public void getSum(int checkedSum) {
        int sum = a + b;
        if (sum == checkedSum) {
            System.out.println(true);
        }
        System.out.println(false);
    }
}
