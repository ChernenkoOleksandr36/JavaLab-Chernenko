package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagCounter {
    public static void main(String[] args) {
        String urlString = "https://example.com";
        Map<String, Integer> tagFrequencies = new HashMap<>();

        System.out.println("Читання сторінки: " + urlString + "...\n");

        try {
            URL url = URI.create(urlString).toURL();
            Pattern pattern = Pattern.compile("<([a-zA-Z][a-zA-Z0-9]*)(?=[\\s/>])");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        String tag = matcher.group(1).toLowerCase();
                        tagFrequencies.put(tag, tagFrequencies.getOrDefault(tag, 0) + 1);
                    }
                }
            }

            if (tagFrequencies.isEmpty()) {
                System.out.println("Тегів на сторінці не знайдено.");
                return;
            }

            // a. В порядку зростання для тегів в лексикографічному порядку
            System.out.println("=== Теги в лексикографічному порядку ===");
            Map<String, Integer> sortedLexicographically = new TreeMap<>(tagFrequencies);
            for (Map.Entry<String, Integer> entry : sortedLexicographically.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // b. В порядку зростання по частоті появи тегів
            System.out.println("\n=== Теги в порядку зростання частоти появи ===");
            var sortedByFrequency = new ArrayList<>(tagFrequencies.entrySet());
            sortedByFrequency.sort(
                    Map.Entry.<String, Integer>comparingByValue()
                            .thenComparing(Map.Entry.comparingByKey())
            );

            for (Map.Entry<String, Integer> entry : sortedByFrequency) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (Exception e) {
            System.out.println("Виникла помилка під час зчитування URL: " + e.getMessage());
        }
    }
}