package org.example;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String shapeColor, double width, double height) {
        super(shapeColor);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Малюємо прямокутник колір: " + getShapeColor());
    }

    @Override
    public String toString() {
        return "Прямокутник [" + super.toString() + ", ширина=" + width + ", висота=" + height + ", площа=" + String.format("%.2f", calcArea()) + "]";
    }
}
