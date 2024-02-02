package org.example;

import java.io.*;
import java.util.List;

public class Storage {

    public static void saveToFile(List<Table> tables, String filename) {
    try {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(tables);

        objectOutputStream.close();
        fileOutputStream.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static List<Table> loadFromFile(List<Table> tables, String filename) {
       // List<Table> tables = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            tables = (List<Table>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tables;
    }

    public static List<Integer> loadFromFileInt(List<Integer> list, String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            list = (List<Integer>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Plik pusty");
            c.printStackTrace();
        }
        return list;
    }
    public static void saveToFileInt(List<Integer> tables, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(tables);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

