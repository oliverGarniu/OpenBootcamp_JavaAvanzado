package org.ob.recursion;

public class FactorialRecursivo {

    public static int factorialRecursivo(int valor) {

        if (valor == 0) {
            return 1;
        }

        // Recursividad por cola --> lo último que hacemos es llamar a la función.
        return valor * factorialRecursivo(valor - 1);
    }
}
