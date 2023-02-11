package com.ob;

public class Ejercicio3App {

    public static void main(String[] args) {

        /*
         * Comprobamos como efectivamente es posible sustituir las subclases CocheCombustion, CocheElectrico y
         * CocheHibrido por la superclase Coches.
         */
        Coches coches = new Coches();
//        Coches coches = new CocheCombustion();
//        Coches coches = new CocheElectrico();
//        Coches coches = new CocheHibrido();

        coches.agregarCoche(new Coche(1, TipoMotor.COMBUSTION, 250, 240, "gris"));
        coches.agregarCoche(new Coche(2, TipoMotor.ELECTRICO, 270, 250, "blanco"));
        coches.agregarCoche(new Coche(3, TipoMotor.COMBUSTION, 200, 190, "negro"));
        coches.agregarCoche(new Coche(4, TipoMotor.HIBRIDO, 180, 180, "azul"));
        coches.agregarCoche(new Coche(5, TipoMotor.HIBRIDO, 150, 160, "amarillo"));
        coches.agregarCoche(new Coche(6, TipoMotor.COMBUSTION, 180, 190, "plata"));
        coches.agregarCoche(new Coche(7, TipoMotor.COMBUSTION, 280, 280, "naranja"));
        coches.agregarCoche(new Coche(8, TipoMotor.ELECTRICO, 100, 180, "azul"));

        coches.listarCoches();

        int cocheSolicitado = 3;
        System.out.println("\nEl coche solicitado es: " + "\n" + coches.obtenerCoche(cocheSolicitado));

        coches.agregarCoche(new Coche(2, TipoMotor.HIBRIDO, 170, 150, "amarillo"));

        coches.eliminarCoche(5);
        coches.eliminarCoche(10);
        System.out.println("\nListado de coches actualizado: " + "\n" + coches.listadoCoches);
    }
}
