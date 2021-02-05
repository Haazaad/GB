package ru.ArtemSmirnov.java1.homework3;

import java.util.Scanner;

public class HomeWork_3 {
    static Scanner scanner = new Scanner(System.in);
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        // загадываем слово из массива
        String hiddenWord = words[(int) (Math.random() * words.length)];

        System.out.println("Попробуйте угадать слово.");

        while (true) {
            System.out.print("Введите загаданное слово: ");
            // считываем введенное слово, с преобразованием в lowerCase
            String userInput = scanner.nextLine().toLowerCase();
            if (hiddenWord.equals(userInput)) {
                System.out.println("Вы угадали!!! ");
                break;
            }
            System.out.println("Вы не угадали((( \nПопробуйте еще раз");
            System.out.println("Совпадающие буквы: " + checkWords(hiddenWord, userInput));
        }

    }

    // сравниваем загаданное слово и введенное
    public static String checkWords(String hiddenWord, String userInput) {
        StringBuilder outString = new StringBuilder();
        // если загаданное слово большей длины
        if (hiddenWord.length() > userInput.length()) {
            for (int i = 0; i < userInput.length(); i++) {
                outString.append(checkChar(hiddenWord.charAt(i), userInput.charAt(i)));
            }
            // если загаданное слово меньшей длины
        } else {
            for (int i = 0; i < hiddenWord.length(); i++) {
                outString.append(checkChar(hiddenWord.charAt(i), userInput.charAt(i)));
            }
        }
        // дополняем строку до 15 символов с добавлением #
        if (outString.length() == 15) {
            return outString.toString();
        }
        while (outString.length() < 15) {
            outString.append('#');
        }
        return outString.toString();
    }

    // сравнение символов слов
    public static char checkChar(char firstChar, char secondChar){
        if (firstChar == secondChar) {
            return secondChar;
        }
        return '#';
    }

}
