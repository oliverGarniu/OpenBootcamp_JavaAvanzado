package com.ob;

import java.util.ArrayList;

public class Coches {

    ArrayList<Coche> listadoCoches = new ArrayList<>();

    public void listarCoches() {
        if (listadoCoches.isEmpty()) {
            System.out.println("No aparece ningún coche en el listado");
        }

        System.out.println("\n***Listado de coches***");
        System.out.println("-----------------------");

        for (Coche c : listadoCoches) {
            System.out.println(c);
        }
    }

    public Coche obtenerCoche(int id) {
        return listadoCoches.stream()
                .filter(car -> car.getId() == id)
                .findFirst().orElse(null);
    }

    public void agregarCoche(Coche coche) {
        if (obtenerCoche(coche.getId()) != null) {
            return;
        }
        System.out.println("Se procede a añadir el coche con id: " + coche.getId());
        listadoCoches.add(coche);
    }

    public void eliminarCoche(int id) {
        boolean found = listadoCoches.removeIf(coche -> coche.getId() == id);
        System.out.println(found ? "\nSe ha eliminado el coche con id: " + id : "No existe ningún coche con id: " + id);
    }
}
