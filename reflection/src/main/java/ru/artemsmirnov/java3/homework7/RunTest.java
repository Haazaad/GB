package ru.artemsmirnov.java3.homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RunTest {
    private Method before;
    private Method after;
    private Map<Integer, List<Method>> testMethods;

    public RunTest() {
        testMethods = new HashMap<>();
    }

    public void start(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        if (checkCountBeforeAfter(methods)) {
            prepareParameters(methods);
        }
        try {
            Object test = testClass.getDeclaredConstructor().newInstance();
            before.invoke(test);
            for (int i = 1; i <= 10; i++) {
                if (testMethods.containsKey(i)) {
                    List<Method> list = testMethods.get(i);
                    for (Method m: list) {
                        m.invoke(test);
                    }
                }
            }
            after.invoke(test);
        } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private void prepareParameters(Method[] methods) {
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) before = m;
            if (m.isAnnotationPresent(AfterSuite.class)) after = m;
            if (m.isAnnotationPresent(Test.class)) {
                if (testMethods.containsKey(m.getAnnotation(Test.class).priority())) {
                    testMethods.get(m.getAnnotation(Test.class).priority()).add(m);
                } else {
                    List<Method> list = new ArrayList<>();
                    list.add(m);
                    testMethods.put(m.getAnnotation(Test.class).priority(), list);
                }
            }
        }
    }

    private boolean checkCountBeforeAfter(Method[] methods) {
        int countBefore = 0;
        int countAfter = 0;
        for (int i = 0; i < methods.length; i++) {
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
