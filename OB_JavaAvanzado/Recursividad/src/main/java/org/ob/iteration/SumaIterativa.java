package org.ob.iteration;

public class SumaIterativa {

    public static int sumaIterativa(int valor) {

        int resultado = 0;

        for (int i = 0; i <= valor; i++) {
            resultado += i;
        }

        return resultado;
    }
}
