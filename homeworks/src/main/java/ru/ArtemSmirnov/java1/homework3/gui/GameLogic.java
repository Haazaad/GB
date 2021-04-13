package ru.ArtemSmirnov.java1.homework3.gui;

public class GameLogic {
    private static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    private String hiddenWord;
    private String inputWord;
    private String outputString;

    public GameLogic() {
        this.hiddenWord = WORDS[(int) (Math.random() * WORDS.length)];
    }

    public void setInputWord(String inputWord) {
        this.inputWord = inputWord.toLowerCase();
    }

    public String getOutputString() {
        return outputString;
    }

    public void game() {
        if (inputWord.equals(hiddenWord)) {
            outputString = "Вы выиграли!!!";
        } else {
            outputString = "Вы не угадали, попробуйте еще раз.\nСовпадающие буквы: " + checkWords(hiddenWord, inputWord);
        }
    }

    public static String checkWords(String hiddenWord, String userInput) {
        StringBuilder outString = new StringBuilder();
        if (hiddenWord.length() > userInput.length()) {
            for (int i = 0; i < userInput.length(); i++) {
                outString.append(checkChar(hiddenWord.charAt(i), userInput.charAt(i)));
            }
        } else {
            for (int i = 0; i < hiddenWord.length(); i++) {
                outString.append(checkChar(hiddenWord.charAt(i), userInput.charAt(i)));
            }
        }
        if (outString.length() == 15) {
            return outString.toString();
        }
        while (outString.length() < 15) {
            outString.append('#');
        }
        return outString.toString();
    }

    public static char checkChar(char firstChar, char secondChar) {
        if (firstChar == secondChar) {
            return secondChar;
        }
        return '#';
    }
}
