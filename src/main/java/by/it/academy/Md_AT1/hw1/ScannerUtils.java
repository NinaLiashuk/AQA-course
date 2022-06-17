package by.it.academy.Md_AT1.hw1;

import java.util.Scanner;

public class ScannerUtils {
    /**
     * Метод вводит данные и проверяет их корректность
     *
     * @return натуральное число
     */
    public double inputAndCheckNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        double result;
        while (!scanner.hasNextDouble()) {
            System.out.println("Введите корректный параметр");
            scanner.next();
        }
        result = scanner.nextDouble();
        return result;
    }

    /**
     * Метод вводит операцию и проверяет ее корректность
     *
     * @return строка
     */
    public String chooseAndCheckOperation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите операцию. Введите + - *  или /");
        String symbol = scanner.nextLine();
            while (!symbol.equals("+") && !symbol.equals("-") && !symbol.equals("*") && !symbol.equals("/")) {
                System.out.println("Введите корректный параметр");
                symbol = scanner.next();
            }
        return symbol;
    }
}



