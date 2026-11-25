package org.example;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        fillDefaultDictionary(translator);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Англо-український перекладач ===");

        while (running) {
            System.out.println("\nОберіть дію:");
            System.out.println("1 - Перекласти фразу");
            System.out.println("2 - Додати пару слів до словника");
            System.out.println("3 - Показати словник");
            System.out.println("0 - Вихід");
            System.out.print("Ваш вибір: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Введіть фразу англійською: ");
                    String phrase = scanner.nextLine();
                    String translated = translator.translatePhrase(phrase);
                    System.out.println("Переклад: " + translated);
                    break;

                case "2":
                    System.out.print("Введіть слово англійською: ");
                    String eng = scanner.nextLine();
                    System.out.print("Введіть переклад українською: ");
                    String ukr = scanner.nextLine();

                    if (eng.trim().isEmpty() || ukr.trim().isEmpty()) {
                        System.out.println("Помилка: обидва слова мають бути непорожніми.");
                    } else {
                        translator.addWord(eng, ukr);
                        System.out.println("Пару слів додано: " + eng.trim() + " -> " + ukr.trim());
                    }
                    break;

                case "3":
                    System.out.println("\nПоточний словник (" + translator.getDictionary().size() + " слів):");
                    for (Map.Entry<String, String> entry : translator.getDictionary().entrySet()) {
                        System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
                    }
                    break;

                case "0":
                    running = false;
                    System.out.println("Завершення роботи.");
                    break;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }

    private static void fillDefaultDictionary(Translator translator) {
        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");
        translator.addWord("i", "я");
        translator.addWord("love", "люблю");
        translator.addWord("java", "джава");
        translator.addWord("programming", "програмування");
        translator.addWord("this", "це");
        translator.addWord("is", "є");
        translator.addWord("a", "");
        translator.addWord("good", "хороший");
        translator.addWord("day", "день");
        translator.addWord("student", "студент");
        translator.addWord("university", "університет");
        translator.addWord("code", "код");
        translator.addWord("computer", "комп'ютер");
        translator.addWord("my", "мій");
        translator.addWord("friend", "друг");
        translator.addWord("today", "сьогодні");
    }
}