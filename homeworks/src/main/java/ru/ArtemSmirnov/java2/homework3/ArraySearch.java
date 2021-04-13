package ru.ArtemSmirnov.java2.homework3;

import java.util.*;

public class ArraySearch {
    private static final String[] STRING_ARRAY = {"new", "old", "new", "mellon", "dog", "human", "cat", "robot", "car",
            "new", "old", "new", "cat", "dog", "human", "cat", "robot", "car"};
    private static List<String> list = new ArrayList<>(Arrays.asList(STRING_ARRAY));

    public static void main(String[] args) {
        Set<String> map = new HashSet<>(list);
        for (String word : map) {
            System.out.printf("%s %d\n", word, checkCountWord(word));
        }
    }

    public static int checkCountWord(String word) {
        int count = 0;
        for (String s : list) {
            if (word.equals(s)) {
                count++;
            }
        }
        return count;
    }
}
