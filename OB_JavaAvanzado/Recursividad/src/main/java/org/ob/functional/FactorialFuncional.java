package org.ob.functional;

import java.util.stream.IntStream;

public class FactorialFuncional {

    public static int factorialFuncional(int valor) {

        return IntStream.rangeClosed(1, valor)
                .reduce(1, (a, b) -> a * b);
    }
}
