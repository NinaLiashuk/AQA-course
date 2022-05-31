package by.it.academy.Md_AT1.hw1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double a, b;
        a = checkCorrect();
        b = checkCorrect();
        System.out.println("Выберите операцию");
        char c = scanner.next().charAt(0);

        switch (c) {
            case '+':
                System.out.println(calculator.add(a, b));
                break;
            case '-':
                System.out.println(calculator.subtract(a, b));
                break;
            case '*':
                System.out.println(calculator.multiply(a, b));
                break;
            case '/':
                if (b == 0) {
                    while (b == 0) {
                        System.out.println("Нельзя делить на ноль. Введите другое число");
                        b = scanner.nextInt();
                    }
                }
                if (b != 0) {
                    System.out.println(calculator.divide(a, b));
                }
                break;
        }
    }

    /**
     * Метод проверяет корректность вводимых данных
     * @return натуральное число
     */
    public static double checkCorrect(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        double result;
        while (!scanner.hasNextDouble()){
            System.out.println("Введите корректный параметр");
            scanner.next();
        }
        result = scanner.nextDouble();
        return result;
    }
}
