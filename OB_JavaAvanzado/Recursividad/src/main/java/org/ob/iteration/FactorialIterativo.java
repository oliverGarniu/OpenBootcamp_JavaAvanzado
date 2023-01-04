package org.ob.iteration;

public class FactorialIterativo {

    public static int factorialIterativo(int valor) {

        int resultado = 1;

        for (int i = 1; i <= valor; i++) {
            resultado *= i;
        }

        return resultado;
    }
}
