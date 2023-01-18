package com.ob;

import com.ob.exception.Arithmetic;
import com.ob.exception.ArrayIndexOutOfBounds;
import com.ob.exception.FileNotFound;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\n** Arithmetic Exception **");
        try {
            System.out.println(new Arithmetic().divideByZero());
        } catch (ArithmeticException e) {
            System.out.println("Division by zero --> " + e.getClass());
        }

        System.out.println("\n** ArrayIndexOutOfBounds Exception **");
        try {
            System.out.println(new ArrayIndexOutOfBounds().getUser());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There are only 6 users on the list --> " + e.getClass());
        }

        System.out.println("\n** FileNotFound Exception **");
        try {
            System.out.println(new FileNotFound().getFile());
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found --> " + e.getClass());
        }
    }
}