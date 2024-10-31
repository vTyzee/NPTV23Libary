package ee.ivkhkdev.interfaces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface FileRepository<T> {
    default void save(T entity, String fileName) {
        List<T> list = this.load(fileName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(entity);
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            System.out.println("Data has been written to file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception while writing to file: " + e.getMessage());
        }
    }

    default void saveAll(List<T> entities, String fileName) {
        if (entities == null) entities = new ArrayList<>();
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
            System.out.println("Data has been written to file: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception while writing to file: " + e.getMessage());
        }
    }

    default List<T> load(String fileName) {
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (List<T>) objectInputStream.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception while reading from file: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}