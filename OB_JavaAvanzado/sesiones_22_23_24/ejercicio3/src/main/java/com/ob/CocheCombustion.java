package com.ob;

import static com.ob.TipoMotor.COMBUSTION;

public class CocheCombustion extends Coches {

    public void listarCoches() {
        if (listadoCoches.isEmpty()) {
            System.out.println("No aparece ningún coche en el listado");
        }

        System.out.println("\n***Listado de coches de combustión***");
        System.out.println("-------------------------------------");

        for (Coche c : listadoCoches) {
            if (c.getTipoMotor() == COMBUSTION) {
                System.out.println("\n" + c);
            }
        }
    }

    public Coche obtenerCoche(int id) {
        return listadoCoches.stream()
                .filter(car -> car.getId() == id)
                .findFirst().orElse(null);
    }

    public void agregarCoche(Coche coche) {
        if (obtenerCoche(coche.getId()) != null) {
            System.out.println("\nNo se ha añadido el coche, ya existe un coche con id: " + coche.getId());
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
