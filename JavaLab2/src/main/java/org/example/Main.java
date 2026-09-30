package org.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Person originalPerson = new Person("Черненко", "Олександр", 20);

        Gson gson = new Gson();

        String jsonText = gson.toJson(originalPerson);
        System.out.println("JSON текст: " + jsonText);

        Person newPerson = gson.fromJson(jsonText, Person.class);

        System.out.println("Чи однакові дані всередині? " + originalPerson.equals(newPerson));
    }
}