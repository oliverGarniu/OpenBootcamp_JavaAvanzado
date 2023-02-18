package com.ob.ejercicio4.repository;

import com.ob.ejercicio4.entity.Coche;

import java.util.ArrayList;

public class CochesDBNullable implements CochesDB {

    @Override
    public ArrayList<Coche> listarCoches() {
        return null;
    }

    @Override
    public Coche obtenerCoche(int id) {
        return null;
    }

    @Override
    public void agregarCoche(Coche coche) {
    }

    @Override
    public Boolean borrarCoche(Coche coche) {
        return null;
    }
}



