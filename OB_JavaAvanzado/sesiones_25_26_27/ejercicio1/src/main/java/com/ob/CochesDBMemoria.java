package com.ob;

import java.util.ArrayList;

public class CochesDBMemoria implements CochesDB, CochesDBEstadisticas {

    private int totalInserciones = 0;
    private int totalEliminaciones = 0;

    ArrayList<Coche> listadoCoches = new ArrayList<>();

    @Override
    public void listarCoches() {
        listarCochesMejorado();
    }

    public void listarCochesMejorado() {
        System.out.println("\n***Listado de coches***");
        for (Coche c : listadoCoches) {
            System.out.println("\nTipo de motor: " + c.getTipoMotor());
            System.out.println("---------------" + "-".repeat(c.getTipoMotor().name().length()));
            System.out.println(c);
        }
    }

    @Override
    public Coche obtenerCoche(int id) {
        return listadoCoches.stream()
                .filter(coche -> coche.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void agregarCoche(Coche coche) {
        for (Coche c : listadoCoches) {
            if (c.getId() == coche.getId()) {
                return;
            }
        }

        listadoCoches.add(coche);
        totalInserciones++;
    }

    @Override
    public void borrarCoche(Coche coche) {
        for (int i = 0; i < listadoCoches.size(); i++) {
            if (listadoCoches.get(i).getId() == coche.getId()) {
                listadoCoches.remove(i);
                System.out.printf("\nSe ha eliminado el coche con id %s del listado.\n", coche.getId());
                totalEliminaciones++;
            }
        }
    }

    @Override
    public int getTotalInserciones() {
        return totalInserciones;
    }

    @Override
    public int getTotalEliminaciones() {
        return totalEliminaciones;
    }
}

