package by.it.academy.Md_AT1.hw1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();
    double actual;
    double expected;

    @Test
    public void add() {
        actual = calculator.add(5,2.5);
        expected = 7.5;
        assertEquals(expected, actual, 0.0001);
        assertEquals(6.46,calculator.add(5.84,0.62),0.0001);
    }

    @Test
    public void subtract() {
        actual = calculator.subtract(10.5,5.4);
        expected = 5.1;
        assertEquals(expected,actual,0.0001);
        assertEquals(4,calculator.subtract(10,6),0.0001);
    }

    @Test
    public void multiply() {
        actual = calculator.multiply(5.3,2);
        expected = 10.6;
        assertEquals(expected,actual,0.0001);
        assertEquals(15.3,calculator.multiply(5.1,3),0.0001);
    }

    @Test
    public void divide() {
        actual = calculator.divide(10,2);
        expected = 5;
        assertEquals(expected,actual,0.0001);
        assertEquals(5,calculator.divide(20,4),0.0001);
    }
}