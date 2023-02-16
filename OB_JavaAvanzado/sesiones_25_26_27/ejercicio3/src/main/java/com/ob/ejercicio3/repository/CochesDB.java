package com.ob.ejercicio3.repository;

import com.ob.ejercicio3.entity.Coche;

import java.util.ArrayList;

public interface CochesDB {
    ArrayList<Coche> listarCoches();
    Coche obtenerCoche(int id);
    void agregarCoche(Coche coche);
    void borrarCoche(Coche coche);
}
