package com.example;

public class Main {
    public static void main(String[] args) {
        String data = "To jest test danych";

        DataSource fileData = new FileDataSource("plik.txt");
        DataSource encrypted = new EncryptionDecorator(fileData);
        DataSource compressed = new CompressionDecorator(encrypted);

        compressed.writeData(data);

        System.out.println("Odczytane dane:");
        System.out.println(compressed.readData());
    }
}