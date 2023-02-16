package com.ob.ejercicio3.repository;

import com.ob.ejercicio3.entity.Coche;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class CochesDBMemoria implements CochesDB, CochesDBEstadisticas {

    private final Logger logger = LoggerFactory.getLogger(CochesDBMemoria.class);
    private int totalInserciones = 0;
    private int totalEliminaciones = 0;

    ArrayList<Coche> listadoCoches = new ArrayList<>();

    @Override
    public ArrayList<Coche> listarCoches() {
//        listarCochesMejorado();
        return listadoCoches;
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
        logger.info("Se ha añadido el coche al listado.");
        totalInserciones++;
    }

    @Override
    public void borrarCoche(Coche coche) {
        for (int i = 0; i < listadoCoches.size(); i++) {
            if (listadoCoches.get(i).getId() == coche.getId()) {
                listadoCoches.remove(i);
                logger.info("Se ha eliminado el coche del listado.");
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

