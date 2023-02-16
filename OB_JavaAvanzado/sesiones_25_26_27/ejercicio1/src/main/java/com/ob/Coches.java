package com.ob;

public class Coches {

    CochesDB cochesDB;

    protected Coches() {
    }

    public Coches(CochesDB cochesDB) {
        this.cochesDB = cochesDB;
    }

    public void listarCoches() {
        cochesDB.listarCoches();
    }

    public Coche obtenerCoche(int id) {
        return cochesDB.obtenerCoche(id);
    }

    public void agregarCoche(Coche coche) {
        if (cochesDB.obtenerCoche(coche.getId()) != null) {
            return;
        }
        cochesDB.agregarCoche(coche);
    }

    public void eliminarCoche(int id) {
        Coche coche = new Coche();
        coche.setId(id);
        cochesDB.borrarCoche(coche);
    }
}
