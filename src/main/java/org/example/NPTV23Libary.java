package org.example;

import java.util.Scanner;

public class NPTV23Libary {
    public static void main(String[] args) {
        System.out.println("-------------NPTV23Libary-------------");

        // Instantiate Scanner here and pass it to the App class
        Scanner scanner = new Scanner(System.in);
        App app = new App(scanner);

        app.run();

        // Close the scanner when done
        scanner.close();
    }
}
