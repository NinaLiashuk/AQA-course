package by.it.academy.Md_AT1.hw2;

import java.util.Scanner;

public class Calculator implements ICalculator {

    @Override
    public double add(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    @Override
    public double subtract(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    @Override
    public double multiply(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    @Override
    public double divide(double numberOne, double numberTwo) {
        Scanner scanner = new Scanner(System.in);
        if (numberTwo == 0) {
            while (numberTwo == 0) {
                System.out.println("Cannot be divided by zero. Enter another number");
                numberTwo = scanner.nextDouble();
            }
        } else if (numberTwo != 0) {
            return numberOne / numberTwo;
        }
        return numberOne / numberTwo;
    }
}