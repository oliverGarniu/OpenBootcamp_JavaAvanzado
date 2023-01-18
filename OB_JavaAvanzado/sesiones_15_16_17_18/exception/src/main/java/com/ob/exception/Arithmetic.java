package com.ob.exception;

public class Arithmetic extends Exception {

    int num1 = 10;
    int num2 = 0;

    public int divideByZero() {
        return num1 / num2;
    }
}
