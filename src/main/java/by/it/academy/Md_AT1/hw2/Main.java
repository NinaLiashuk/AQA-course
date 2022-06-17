package by.it.academy.Md_AT1.hw2;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double numberOne, numberTwo;
        String operation;
        Scanner scanner = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out, true);
        ScannerUtils utils = new ScannerUtils();

        numberOne = utils.inputAndCheckNumber(scanner, output);
        numberTwo = utils.inputAndCheckNumber(scanner, output);
        operation = utils.chooseAndCheckOperation(scanner, output);
        utils.performCalculation(numberOne, numberTwo, operation);
    }
}
