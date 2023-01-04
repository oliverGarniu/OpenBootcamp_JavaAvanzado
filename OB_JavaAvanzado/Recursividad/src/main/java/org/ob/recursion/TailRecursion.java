package org.ob.recursion;

public class TailRecursion {

    public static void tailRecursion(int valor) {

        // Sentencia de control
        if (valor == 0) {
            return;
        }

        // Tail recursion --> lo último que hacemos es invocar a la función.
        System.out.println(valor);
        tailRecursion(valor - 1);
    }
}
