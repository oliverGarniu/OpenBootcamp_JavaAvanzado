package com.ob.ejercicio3.service;

import com.ob.ejercicio3.entity.Coche;
import com.ob.ejercicio3.repository.CochesDB;
import com.ob.ejercicio3.repository.CochesDBMemoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CocheService {

    CochesDB cochesDB = new CochesDBMemoria();

    protected CocheService() {
    }

    public CocheService(CochesDB cochesDB) {
        this.cochesDB = cochesDB;
    }

    public ArrayList<Coche> listarCoches() {
        return cochesDB.listarCoches();
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
