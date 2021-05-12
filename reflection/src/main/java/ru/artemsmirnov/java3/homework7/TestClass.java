package ru.artemsmirnov.java3.homework7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestClass {
    private static final Logger logger = LogManager.getLogger(TestClass.class.getName());

    private int a;
    private int b;

    public TestClass() {
    }

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
    public void test1() {
        int sum = a + b;
        if (sum == 11) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println(a > 1);
    }

    @Test
    public void test5() {
        System.out.println(b > 10);
    }

    @Test
    public void test6() {
        System.out.println("Просто вывод в консоль");
    }

    @Test(priority = 1)
    public void test7() {
        System.out.println("Самый высокий приоритет");
    }
}
