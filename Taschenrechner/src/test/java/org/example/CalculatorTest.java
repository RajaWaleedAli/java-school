package org.example;

import org.junit.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator=new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5.0f, calculator.add(2.0f, 3.0f), 0.0001);
    }

    @Test
    public void testSub() {
        assertEquals(1.0f, calculator.sub(3.0f, 2.0f), 0.0001);
    }

    @Test
    public void testMul() {
        assertEquals(6.0f, calculator.mul(2.0f, 3.0f), 0.0001);
    }

    @Test
    public void testDiv() {
        assertEquals(2.0f, calculator.div(6.0f, 3.0f), 0.0001);
    }

    @Test
    public void testMod() {
        assertEquals(1.0f, calculator.mod(7.0f, 2.0f), 0.0001);
    }

    @Test
    public void testPow() {
        assertEquals(8.0f, calculator.pow(2.0f, 3.0f), 0.0001);
    }

    @Test
    public void testLn() {
        assertEquals(Math.log(2.0), calculator.ln(2.0), 0.0001);
    }

    @Test
    public void testLnThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.ln(-1));
        assertEquals("x muss größer als 0 sein", exception.getMessage());
    }

    @Test
    public void testSqrt() {
        assertEquals(Math.sqrt(25), calculator.sqrt(25.0,2.0), 0.0001);
    }
}

