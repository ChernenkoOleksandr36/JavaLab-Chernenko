package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    /**
     * Варіант 4
     * Знаходить слова, символи в яких йдуть у строгому порядку зростання кодів.
     * @param text Вхідний рядок
     * @return Масив слів, що задовольняють умову
     */
    public static String[] findWordsWithAscendingChars(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[0];
        }

        String[] words = text.trim().split("[\\s,.:;!?]+");

        List<String> resultList = new ArrayList<>();

        for (String word : words) {
            if (isAscending(word)) {
                resultList.add(word);
            }
        }

        return resultList.toArray(new String[0]);
    }

    private static boolean isAscending(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) >= word.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abc test demo 1389 flor це абв білий";

        String[] result = findWordsWithAscendingChars(input);

        System.out.println("Вхідний рядок: " + input);
        System.out.println("Знайдені слова: " + Arrays.toString(result));
    }
}