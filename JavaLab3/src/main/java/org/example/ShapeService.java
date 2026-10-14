package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeService {

    public double calcTotalArea(Shape[] shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calcArea();
        }
        return total;
    }

    // Метод приймає клас фігури (наприклад, Circle.class), щоб рахувати площу тільки для неї
    public double calcTotalAreaByType(Shape[] shapes, Class<?> shapeType) {
        double total = 0;
        for (Shape shape : shapes) {
            if (shapeType.isInstance(shape)) {
                total += shape.calcArea();
            }
        }
        return total;
    }

    public void sortByArea(Shape[] shapes) {
        // Використовуємо Comparator для сортування за зростанням площі
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::calcArea));
    }

    public void sortByColor(Shape[] shapes) {
        // Використовуємо Comparator для сортування за алфавітом кольору
        Arrays.sort(shapes, Comparator.comparing(Shape::getShapeColor));
    }
}
