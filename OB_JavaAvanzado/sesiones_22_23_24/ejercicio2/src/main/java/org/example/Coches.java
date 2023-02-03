package org.example;

import java.util.ArrayList;

public class Coches {

    CochesDBEstadisticas cochesDB = new CochesDBEstadisticas();
    ArrayList<Coche> listadoCoches = cochesDB.convertirFicheroEnArrayList();

    public ArrayList<Coche> listarCoches() {
        return cochesDB.convertirFicheroEnArrayList();
    }

    public void listarCochesSeparado() {
        System.out.println("\n***Listado de coches***");
        for (Coche c : listadoCoches) {
            System.out.println("\nTipo de motor: " + c.getTipoMotor());
            System.out.println("---------------" + "-".repeat(c.getTipoMotor().name().length()));
            System.out.println(c);
        }
    }

    public Coche obtenerCoche(int id) {
        return listadoCoches.stream()
                .filter(coche -> coche.getId() == id)
                .findFirst().orElse(null);
    }

    public void agregarCoche(Coche coche) {
        if (obtenerCoche(coche.getId()) != null) {
            return;
        }
        cochesDB.insertarCoche(coche);
    }

    public void eliminarCoche(int id) {
        Coche coche = new Coche();
        coche.setId(id);
        cochesDB.borrarCoche(coche);
    }
}
