package org.example;

import java.io.*;

public class StreamEncryptor {

    // a. Метод (клас), який реалізує шифрування
    static class EncryptingOutputStream extends FilterOutputStream {
        private int key;

        public EncryptingOutputStream(OutputStream out, int key) {
            super(out);
            this.key = key;
        }

        @Override
        public void write(int b) throws IOException {
            // Замінюємо символ на такий, код якого більший на значення ключа
            super.write(b + key);
        }
    }

    // b. Метод (клас), який реалізує дешифрування
    static class DecryptingInputStream extends FilterInputStream {
        private int key;

        public DecryptingInputStream(InputStream in, int key) {
            super(in);
            this.key = key;
        }

        @Override
        public int read() throws IOException {
            int b = super.read();
            if (b == -1) return -1; // Кінець потоку

            // Повертаємо оригінальний символ, віднімаючи ключ
            return b - key;
        }
    }

    public static void main(String[] args) {
        String fileName = "encrypted.txt";
        int encryptionKey = 5; // Ключове значення
        String originalText = "This is a secret message. Це секретне повідомлення.";

        // c. Використання потоків FilterOutputStream для шифрування
        try (EncryptingOutputStream eos = new EncryptingOutputStream(new FileOutputStream(fileName), encryptionKey)) {
            // Записуємо байти у файл (вони будуть зашифровані на льоту)
            eos.write(originalText.getBytes());
            System.out.println("Текст успішно зашифровано та збережено у файл " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка шифрування: " + e.getMessage());
        }

        // c. Використання потоків FilterInputStream для дешифрування
        try (DecryptingInputStream dis = new DecryptingInputStream(new FileInputStream(fileName), encryptionKey)) {
            System.out.print("Дешифрований текст: ");
            int data;
            // Читаємо байти з файлу (вони будуть дешифровані на льоту)
            while ((data = dis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Помилка дешифрування: " + e.getMessage());
        }
    }
}
