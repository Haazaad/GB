package ru.ArtemSmirnov.java3.homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TestAppTest {
    static TestApp testApp;

    @BeforeEach
    void init() {
        testApp = new TestApp();
    }


    @MethodSource("prepareArrays")
    @ParameterizedTest
    public void test1(int num, int[] ints) {
        if (num == 1) Assertions.assertArrayEquals(new int[] {5, 6}, testApp.getNewArray(ints));
        if (num == 2) Assertions.assertThrows(RuntimeException.class, () -> testApp.getNewArray(ints));
        if (num == 3) Assertions.assertArrayEquals(new int[] {1}, testApp.getNewArray(ints));
        if (num == 4) Assertions.assertArrayEquals(new int[] {5, 6}, testApp.getNewArray(ints));
        if (num == 5) Assertions.assertArrayEquals(new int[] {}, testApp.getNewArray(ints));
    }

    @Test
    public void test2() {
        int[] array = {1, 4, 1, 1, 1, 4};
        Assertions.assertTrue(testApp.searchNumbersInArray(array));
    }

    @Test
    public void test3() {
        int[] array = {3, 3, 1, 4 ,3, 1};
        Assertions.assertFalse(testApp.searchNumbersInArray(array));
    }

    @MethodSource("prepareArray")
    @ParameterizedTest
    public void test4(int num, int[] array) {
        if (num == 1) Assertions.assertTrue(testApp.searchNumbersInArray(array));
        if (num == 2) Assertions.assertFalse(testApp.searchNumbersInArray(array));
    }

    static Stream<Arguments> prepareArray() {
        return Stream.of(
                Arguments.arguments(1, new int[]{1, 1, 1, 1, 4}),
                Arguments.arguments(2, new int[]{4, 4, 4, 4, 4, 4})
        );
    }

    static Stream<Arguments> prepareArrays() {
        return Stream.of(
                Arguments.arguments(1, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.arguments(2, new int[]{1, 1, 1, 1, 1}),
                Arguments.arguments(3, new int[]{4, 2, 3, 1, 4, 1}),
                Arguments.arguments(4, new int[]{4, 4, 4, 4, 4, 5, 6}),
                Arguments.arguments(5, new int[]{1, 2, 3, 5, 4})
        );
    }
}