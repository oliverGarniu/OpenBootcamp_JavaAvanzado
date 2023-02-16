package com.ob;

public class Ejercicio1App {

    public static void main(String[] args) {

        CochesDB cochesDB;
        String tipoDB = "memoria";

        if (tipoDB.equalsIgnoreCase("memoria")) {
            cochesDB = new CochesDBMemoria();
        } else {
            cochesDB = new CochesDBFichero();
        }

        Coches coches = new Coches(cochesDB);

        coches.agregarCoche(new Coche(1, TipoMotor.COMBUSTION, 250, 240, "gris"));
        coches.agregarCoche(new Coche(2, TipoMotor.ELECTRICO, 270, 250, "blanco"));
        coches.agregarCoche(new Coche(3, TipoMotor.COMBUSTION, 200, 190, "negro"));
        coches.agregarCoche(new Coche(4, TipoMotor.HIBRIDO, 180, 180, "azul"));

        Coche coche = coches.obtenerCoche(2);
        System.out.println("\nEl coche solicitado tiene un motor de tipo: " + coche.getTipoMotor());

        coches.listarCoches();
        coches.eliminarCoche(3);
        coches.listarCoches();

        imprimirEstadisticas(cochesDB);
    }

    public static void imprimirEstadisticas(CochesDB cochesDB) {
        if (cochesDB instanceof CochesDBMemoria) {
            System.out.println("\nTotal de coches añadidos: " + ((CochesDBMemoria) cochesDB).getTotalInserciones());
            System.out.println("Total de coches eliminados: " + ((CochesDBMemoria) cochesDB).getTotalEliminaciones());
        }
    }
}
