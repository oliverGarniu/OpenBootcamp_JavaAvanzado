package org.ob;

import static org.ob.iteration.FactorialIterativo.factorialIterativo;
import static org.ob.iteration.SumaIterativa.sumaIterativa;
import static org.ob.functional.FactorialFuncional.factorialFuncional;
import static org.ob.recursion.FactorialRecursivo.factorialRecursivo;
import static org.ob.recursion.HeadRecursion.headRecursion;
import static org.ob.functional.SumaFuncional.sumaFuncional;
import static org.ob.recursion.SumaRecursiva.sumaRecursiva;
import static org.ob.recursion.TailRecursion.tailRecursion;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nSuma Iterativa: " + sumaIterativa(5));
        System.out.println("Suma Recursiva: " + sumaRecursiva(5));
        System.out.println("Suma Funcional: " + sumaFuncional(5));

        System.out.println("\nFactorial Iterativo: " + factorialIterativo(5));
        System.out.println("Factorial Recursivo: " + factorialRecursivo(5));
        System.out.println("Factorial Funcional: " + factorialFuncional(5));

        System.out.println("\nTail Recursion");
        tailRecursion(5);

        System.out.println("\nHead Recursion");
        headRecursion(5);
    }
}