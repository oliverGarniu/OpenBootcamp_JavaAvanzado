package org.ob.recursion;

public class SumaRecursiva {

    public static int sumaRecursiva(int valor) {

        // Sentencia de control
        if (valor == 1) {
            return 1;
        }

        return valor + sumaRecursiva(valor - 1);
    }
}
