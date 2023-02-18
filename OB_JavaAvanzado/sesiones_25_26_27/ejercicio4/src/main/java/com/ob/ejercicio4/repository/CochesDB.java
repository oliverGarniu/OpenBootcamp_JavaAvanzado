package com.ob.ejercicio4.repository;

import com.ob.ejercicio4.entity.Coche;

import java.util.ArrayList;

public interface CochesDB {
    ArrayList<Coche> listarCoches();
    Coche obtenerCoche(int id);
    void agregarCoche(Coche coche);
    Boolean borrarCoche(Coche coche);
}
