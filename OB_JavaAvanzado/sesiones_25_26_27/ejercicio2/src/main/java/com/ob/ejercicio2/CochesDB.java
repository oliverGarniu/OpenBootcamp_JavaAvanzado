package com.ob.ejercicio2;

public interface CochesDB {
    void listarCoches();
    Coche obtenerCoche(int id);
    void agregarCoche(Coche coche);
    void borrarCoche(Coche coche);
}
