package by.it.academy.Md_AT1.hw1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double numberOne, numberTwo;
        String operation;

        Calculator calculator = new Calculator();
        ScannerUtils utils = new ScannerUtils();
        Scanner scanner = new Scanner(System.in);

        numberOne = utils.inputAndCheckNumber();
        numberTwo = utils.inputAndCheckNumber();
        operation = utils.chooseAndCheckOperation();

        switch (operation) {
            case "+":
                System.out.println(calculator.add(numberOne, numberTwo));
                break;
            case "-":
                System.out.println(calculator.subtract(numberOne, numberTwo));
                break;
            case "*":
                System.out.println(calculator.multiply(numberOne, numberTwo));
                break;
            case "/":
                if (numberTwo == 0) {
                    while (numberTwo == 0) {
                        System.out.println("Нельзя делить на ноль. Введите другое число");
                        numberTwo = scanner.nextInt();
                    }
                }
                if (numberTwo != 0) {
                    System.out.println(calculator.divide(numberOne, numberTwo));
                }
                break;
        }
    }
}
