package org.example;

public class Main {
    public static void main(String[] args) {
        // Створюємо масив з 10 елементів (ініціалізація заздалегідь підготовленими даними)
        Shape[] shapes = new Shape[]{
                new Rectangle("Червоний", 4, 5),
                new Circle("Синій", 3),
                new Triangle("Зелений", 4, 6),
                new Rectangle("Жовтий", 2, 8),
                new Circle("Червоний", 5),
                new Triangle("Синій", 3, 4),
                new Rectangle("Білий", 7, 3),
                new Circle("Зелений", 2),
                new Triangle("Чорний", 5, 5),
                new Rectangle("Синій", 6, 6)
        };

        ShapeView view = new ShapeView();
        ShapeService service = new ShapeService();
        ShapeController controller = new ShapeController(shapes, view, service);

        // Запуск програми
        controller.execute();
    }
}