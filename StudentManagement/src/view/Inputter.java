package view;

import java.util.Scanner;

public class Inputter {

    public static Scanner scanner = new Scanner(System.in);


    public static String inputStr(String msg) {
        System.out.print(msg);
        String data = scanner.nextLine().trim();
        return data;
    }

    public static String inputNonBlankStr(String msg) {
        String data = null;
        do {
            System.out.print(msg);
            data = scanner.nextLine().trim();
        } while (data.length() == 0 || data == null);
        return data;
    }

    public static double inputDouble(String msg, double min, double max) {
        if (min > max) {
            double temp = min;
            min = max;
            max = temp;
        }
        double data;
        do {
            System.out.print(msg);
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a double.");
                scanner.next();
            }
            data = scanner.nextDouble();
        } while (data < min || data > max);
        scanner.nextLine();
        return data;
    }
}
