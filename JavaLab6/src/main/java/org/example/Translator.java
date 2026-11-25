package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Translator {
    private final HashMap<String, String> dictionary;

    public Translator() {
        this.dictionary = new HashMap<>();
    }

    // Метод для додавання пари слів до словника
    public void addWord(String englishWord, String ukrainianWord) {
        if (englishWord == null || ukrainianWord == null) {
            return;
        }
        String key = englishWord.trim().toLowerCase();
        String value = ukrainianWord.trim().toLowerCase();

        if (!key.isEmpty() && !value.isEmpty()) {
            dictionary.put(key, value);
        }
    }

    // Метод для перекладу фрази з англійської на українську
    public String translatePhrase(String phrase) {
        if (phrase == null || phrase.trim().isEmpty()) {
            return "";
        }

        String[] tokens = phrase.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            // Відокремлюємо розділові знаки на початку та в кінці слова
            String leadingPunct = token.replaceAll("^([^a-zA-Z']*).*", "$1");
            String trailingPunct = token.replaceAll(".*?([^a-zA-Z']*)$", "$1");
            String coreWord = token.substring(leadingPunct.length(), token.length() - trailingPunct.length());

            if (coreWord.isEmpty()) {
                result.append(token);
            } else {
                String translation = dictionary.get(coreWord.toLowerCase());
                if (translation != null) {
                    // Зберігаємо велику літеру, якщо оригінал починався з великої
                    if (Character.isUpperCase(coreWord.charAt(0))) {
                        translation = Character.toUpperCase(translation.charAt(0)) + translation.substring(1);
                    }
                    result.append(leadingPunct).append(translation).append(trailingPunct);
                } else {
                    // Якщо слова немає в словнику — залишаємо як є (у квадратних дужках)
                    result.append(leadingPunct).append("[").append(coreWord).append("]").append(trailingPunct);
                }
            }

            if (i < tokens.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public Map<String, String> getDictionary() {
        return Collections.unmodifiableMap(dictionary);
    }
}
