package org.example;

import java.io.IOException;
import java.util.Scanner;

public class ShapeController {
    private Shape[] model;
    private ShapeView view;
    private ShapeService service;
    private ShapeFileService fileService;

    public ShapeController(Shape[] model, ShapeView view, ShapeService service, ShapeFileService fileService) {
        this.model = model;
        this.view = view;
        this.service = service;
        this.fileService = fileService;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            view.printMessage("\n=== МЕНЮ ===");
            view.printMessage("1. Показати всі фігури");
            view.printMessage("2. Зберегти набір об'єктів у файл");
            view.printMessage("3. Завантажити набір об'єктів з файлу");
            view.printMessage("0. Вийти");
            view.printMessage("Оберіть дію: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        view.printMessage("=== Поточний набір даних ===");
                        view.printShapes(model);
                        break;
                    case "2":
                        view.printMessage("Введіть шлях та ім'я файлу для збереження (наприклад, data.ser): ");
                        String savePath = scanner.nextLine();
                        fileService.saveShapes(model, savePath);
                        view.printMessage("Дані успішно збережено у файл " + savePath);
                        break;
                    case "3":
                        view.printMessage("Введіть шлях та ім'я файлу для завантаження: ");
                        String loadPath = scanner.nextLine();
                        model = fileService.loadShapes(loadPath);
                        view.printMessage("Дані успішно завантажено з файлу " + loadPath);
                        break;
                    case "0":
                        running = false;
                        view.printMessage("Вихід з програми...");
                        break;
                    default:
                        view.printMessage("Некоректний вибір. Спробуйте ще раз.");
                }
            } catch (IOException e) {
                view.printMessage("Помилка роботи з файлом: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                view.printMessage("Помилка зчитування даних. Невідомий клас об'єкта.");
            } catch (Exception e) {
                view.printMessage("Виникла непередбачена помилка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}