package org.example;

import java.io.Serializable;

// Додано інтерфейс Serializable
public abstract class Shape implements Drawable, Serializable {
    private static final long serialVersionUID = 1L;

    private String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "Колір: " + shapeColor;
    }
}
