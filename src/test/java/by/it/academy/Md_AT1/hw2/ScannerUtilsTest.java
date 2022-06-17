package by.it.academy.Md_AT1.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ScannerUtilsTest {
    ScannerUtils utils = new ScannerUtils();

    @ParameterizedTest
    @DisplayName("Checking, that inputAndCheckNumber method receives a number")
    @ValueSource(strings = {"2", "-18", "0,25", "12359874623"})
    void checkThatMethodReceivesNumbers(String value) {
        StringWriter stringWriter = new StringWriter();
        assertInstanceOf(Double.class, utils.inputAndCheckNumber(new Scanner(value),new PrintWriter(stringWriter)), "Method should accepts numbers");
    }

    @Test
    @DisplayName("Checking, that inputAndCheckNumber method outputs a message until it receives a number")  //Проверка, что метод ввода числа выдает сообщение, пока не получит число
    void whileEnterNotNumberShouldGetMessage() {
        StringWriter output = new StringWriter();
        String input2 = "3o p i i 6";
        utils.inputAndCheckNumber(new Scanner(input2), new PrintWriter(output));
        System.out.println(output.toString());
        assertTrue(output.toString().contains("Enter the correct parameter"), "Should be message 'Enter the correct parameter' on the screen");
    }

    @ParameterizedTest
    @DisplayName("Checking, that chooseAndCheckOperation method receives symbols +-*/") //Проверка, что метод выбора математической операции принимает символы
    @ValueSource(strings = {"+", "-", "*", "/"})
    void checkThatMethodReceivesSymbols(String value) {
        assertEquals(value, utils.chooseAndCheckOperation(new Scanner(value), new PrintWriter(System.out)), "Method should accepts only a specific symbol");
    }

    @Test
    @DisplayName("Checking, that chooseAndCheckOperation method outputs a message until it receives the required symbol")
    void whileEnterNotSymbolShouldGetMessage() {
        StringWriter output = new StringWriter();
        String input = "[\n" + "8\n" + "--\n" + "+\n";
        utils.chooseAndCheckOperation(new Scanner(input), new PrintWriter(output));
        System.out.println(output.toString());
        assertTrue(output.toString().contains("Enter the correct operation"), "Should be message 'Enter the correct operation' on the screen");
    }

    @ParameterizedTest
    @DisplayName("Checking, that performCalculation method performs selected math operation")
    @MethodSource("performThisCalculation")
    void performCalculation(double numberOne, double numberTwo, String operation, double expectedResult) {
        assertEquals(expectedResult, utils.performCalculation(numberOne, numberTwo, operation), "Math operation should be in accordance with selected symbol");
    }

    public static Stream<Arguments> performThisCalculation() {
        return Stream.of(
                arguments(2, 3, "+", 5),
                arguments(-6, 14, "-", -20),
                arguments(15, 3, "*", 45),
                arguments(10, 2.5, "/", 4)
        );
    }
}