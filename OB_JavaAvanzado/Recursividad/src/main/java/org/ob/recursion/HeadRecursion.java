package org.ob.recursion;

public class HeadRecursion {

    public static void headRecursion(int valor) {

        // Sentencia de control
        if (valor == 0) {
            return;
        }

        // Head Recursion --> primero recorremos y luego imprimimos.
        headRecursion(valor - 1);
        System.out.println(valor);
    }
}
