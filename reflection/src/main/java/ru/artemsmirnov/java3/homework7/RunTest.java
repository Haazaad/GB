package ru.artemsmirnov.java3.homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {
    private Method before;
    private Method after;

    public RunTest(){}

    public void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        if (checkCountBeforeAfter(methods)) {
            for (Method m : methods) {
                if (m.isAnnotationPresent(BeforeSuite.class)) before = m;
                if (m.isAnnotationPresent(AfterSuite.class)) after = m;
            }
        }
        System.out.println(before + " " + after);
        try {
            before.invoke(testClass.getName());
        } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private boolean checkCountBeforeAfter(Method[] methods) {
        int countBefore = 0;
        int countAfter = 0;
        for (int i = 0; i < methods.length; i++){
            if (methods[i].isAnnotationPresent(BeforeSuite.class)) countBefore++;
            if (methods[i].isAnnotationPresent(AfterSuite.class)) countAfter++;
        }
        if (countAfter == 1 && countBefore == 1) {
            return true;
        } else {
            throw new RuntimeException("Аннотации BeforeSuite и AfterSuite должны присутсвовать в единственном экземпляре");
        }
    }
}
