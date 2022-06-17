package by.it.academy.Md_AT1.hw2;

import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerUtils {

    public double inputAndCheckNumber(Scanner scanner, PrintWriter output) {
        output.println("Enter a number");
        double result;
        while (!scanner.hasNextDouble()) {
            output.println("Enter the correct parameter");
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
    public String chooseAndCheckOperation(Scanner scanner, PrintWriter output) {
        output.println("Choose the operation. Enter + - *  or /");
        String symbol = scanner.next();
            while (!symbol.equals("+") && !symbol.equals("-") && !symbol.equals("*") && !symbol.equals("/")) {
                output.println("Enter the correct operation");
                symbol = scanner.next();
            }
        return symbol;
    }


    /**
     * Метод выполняет выбранную математическую операцию
     * @param numberOne число
     * @param numberTwo число
     * @param operation математическая операция
     */
    public double performCalculation (double numberOne, double numberTwo, String operation){
        Calculator calculator = new Calculator();
        double result = 0;
        switch (operation) {
            case "+":
                result = calculator.add(numberOne, numberTwo);
                System.out.println(result);
                break;
            case "-":
                result = calculator.subtract(numberOne, numberTwo);
                System.out.println(result);
                break;
            case "*":
                result = calculator.multiply(numberOne, numberTwo);
                System.out.println(result);
                break;
            case "/":
                result = calculator.divide(numberOne, numberTwo);
                System.out.println(result);
                break;
        }
        return result;
    }
}



