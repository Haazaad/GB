package ru.ArtemSmirnov.java3.homework6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TestApp {
    private static final int SEARCH_NUMBER = 4;
    private static final int SEARCH_1 = 1;
    private static final int SEARCH_2 = 4;

    private static final Logger logger = LogManager.getLogger(TestApp.class.getName());

    TestApp(){}

    public int[] getNewArray(int[] numbers) {
        logger.info("Входящий массив " + Arrays.toString(numbers));
        boolean isFind = false;
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == SEARCH_NUMBER) {
                maxIndex = i;
                isFind = true;
            }
        }
        if (isFind) {
            int[] newArray = new int[numbers.length - maxIndex - 1];
            System.arraycopy(numbers, maxIndex + 1, newArray, 0, numbers.length - maxIndex - 1);
            logger.info("Перобразованный массив " + Arrays.toString(newArray));
            return newArray;
        }
        throw new RuntimeException("Array doesn't contains searching number " + SEARCH_NUMBER);
    }

    public boolean searchNumbersInArray(int[] array) {
        int count1 = 0;
        int count2 = 0;
        for (int j : array) {
            if (j == SEARCH_1) count1++;
            if (j == SEARCH_2) count2++;
        }
        return count1 != array.length && count2 != array.length && (count1 + count2) == array.length;
    }
}
