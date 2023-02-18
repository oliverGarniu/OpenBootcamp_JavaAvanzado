package com.ob.ejercicio4.repository;

import com.ob.ejercicio4.entity.Coche;

import java.util.ArrayList;

public class CochesDBMemoria implements CochesDB, CochesDBEstadisticas {

    //    Obtendremos los datos de las estadísticas solo en caso de que el tipo de DB sea en memoria.
    private int totalInserciones = 0;
    private int totalEliminaciones = 0;

    ArrayList<Coche> listadoCoches = new ArrayList<>();

    @Override
    public ArrayList<Coche> listarCoches() {
        if (!listadoCoches.isEmpty()) {
            listarCochesMejorado();
        }
        return listadoCoches;
    }

    public void listarCochesMejorado() {
        System.out.println("\n***LISTADO DE COCHES EN MEMORIA***");
        for (Coche c : listadoCoches) {
            System.out.println("\nTipo de motor: " + c.getTipoMotor());
            System.out.println("---------------" + "-".repeat(c.getTipoMotor().name().length()));
            System.out.println(c);
        }
        System.out.println("\nTotal coches añadidos: " + getTotalInserciones());
        System.out.println("Total coches eliminados: " + getTotalEliminaciones());
    }

    @Override
    public Coche obtenerCoche(int id) {
        return listadoCoches.stream()
                .filter(c -> c.getId() == id)
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
    public Boolean borrarCoche(Coche coche) {
        Boolean found = false;
        for (int i = 0; i < listadoCoches.size(); i++) {
            if (listadoCoches.get(i).getId() == coche.getId()) {
                listadoCoches.remove(i);
                found = true;
                totalEliminaciones++;
            }
        }

        return found;
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

