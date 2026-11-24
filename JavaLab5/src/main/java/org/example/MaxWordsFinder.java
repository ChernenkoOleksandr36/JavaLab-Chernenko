package org.example;

import java.io.*;

public class MaxWordsFinder {
    public static void main(String[] args) {
        String fileName = "input.txt"; // Створіть цей файл у корені проєкту для перевірки
        String maxWordsLine = "";
        int maxWordsCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Розбиваємо рядок на слова, використовуючи пробіли як роздільник
                String[] words = line.trim().split("\\s+");

                // Перевіряємо, чи рядок не порожній і чи кількість слів більша за поточний максимум
                if (!line.trim().isEmpty() && words.length > maxWordsCount) {
                    maxWordsCount = words.length;
                    maxWordsLine = line;
                }
            }

            System.out.println("Рядок з максимальною кількістю слів (" + maxWordsCount + "):");
            System.out.println(maxWordsLine);

        } catch (IOException e) {
            System.out.println("Помилка роботи з файлом: " + e.getMessage());
        }
    }
}
