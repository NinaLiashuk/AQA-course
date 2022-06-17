package by.it.academy.Md_AT1.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("Number addition test")
    @CsvSource(value = {"2, 3, 5", "-6, 14, 8", "1.5, 2.3, 3.8", "1.57, -2.33, -0.76", "1.571, 2.333, 3.904"})
    void add(double numberOne, double numberTwo, double expectedResult) {
        assertEquals(expectedResult, calculator.add(numberOne, numberTwo), "Adding of two numbers should show correct sum");
    }

    @ParameterizedTest
    @DisplayName("Number subtraction test")
    @CsvSource(value = {"11, 7, 4", "-12, -7, -5", "1.3, 2.3, -1", "3.33, 1.22, 2.11", "5.555, 6.666, -1.111"})
    void subtract(double numberOne, double numberTwo, double expectedResult) {
        assertEquals(expectedResult, calculator.subtract(numberOne, numberTwo), 0.0001, "Subtracting of two numbers should show correct result");
    }

    @ParameterizedTest
    @DisplayName("Number multiplication test")
    @CsvSource(value = {"11, 7, 77", "-12, 2, -24", "1.3, 2.3, 2.99", "3.33, 1.22, 4.0626", "5.555, 6.666, 37.02963", "5.556, 0, 0"})
    void multiply(double numberOne, double numberTwo, double expectedResult) {
        assertEquals(expectedResult, calculator.multiply(numberOne, numberTwo), 0.0001, "Multiplication of two numbers should show correct result");
    }

    @ParameterizedTest
    @DisplayName("Number division test")
    @CsvSource(value = {"12, 3, 4", "-12, 2, -6", "5, 4, 1.25", "3.33, 2, 1.665", "5.555, 5.555, 1"})
    void divide(double numberOne, double numberTwo, double expectedResult) {
        assertEquals(expectedResult, calculator.divide(numberOne, numberTwo), 0.0001, "Division of two numbers should show correct result");
    }
}