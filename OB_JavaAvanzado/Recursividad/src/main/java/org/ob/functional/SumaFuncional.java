package org.ob.functional;

import java.util.stream.IntStream;

public class SumaFuncional {

    public static int sumaFuncional(int valor) {

        return IntStream.rangeClosed(1, valor)
                .reduce(0, (a, b) -> a + b);
    }
}
