package org.example;

import java.io.*;

public class ShapeFileService {

    // Збереження масиву об'єктів у файл
    public void saveShapes(Shape[] shapes, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(shapes);
        }
    }

    // Читання масиву об'єктів з файлу
    public Shape[] loadShapes(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Shape[]) ois.readObject();
        }
    }
}
