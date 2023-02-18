package com.ob.ejercicio4.service;

import com.ob.ejercicio4.entity.Coche;
import com.ob.ejercicio4.entity.CocheBuilder;
import com.ob.ejercicio4.repository.CochesDB;
import com.ob.ejercicio4.repository.CochesDBFactory;
import com.ob.ejercicio4.repository.CochesDBMemoria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CocheService {

    private final Logger logger = LoggerFactory.getLogger(CochesDBMemoria.class);
    CochesDB cochesDB;
    String tipoDB = "memoria";

    private CocheService() {
        CochesDBFactory cochesDBFactory = new CochesDBFactory(tipoDB);
        this.cochesDB = cochesDBFactory.getDBInstance();
    }

    public ArrayList<Coche> listarCoches() {
        ArrayList<Coche> listadoCoches = cochesDB.listarCoches();
        if (listadoCoches.isEmpty()) {
            logger.warn("El listado de coches está vacío");
            return listadoCoches;
        }

        return listadoCoches;
    }

    public Coche obtenerCoche(int id) {
        Coche coche = cochesDB.obtenerCoche(id);
        if (coche == null) {
            logger.warn("No existe ningún coche con id: " + id);
        }

        return coche;
    }

    public void agregarCoche(Coche coche) {
        if (cochesDB.obtenerCoche(coche.getId()) != null) {
            logger.warn("Ya existe un coche con id: " + coche.getId());
            return;
        }

        Coche cocheFiltrado = crearCocheReal(coche);
        cochesDB.agregarCoche(cocheFiltrado);
        logger.info("Se ha añadido el coche con id: " + coche.getId());
    }

    public void eliminarCoche(int id) {
        Coche coche = new Coche();
        coche.setId(id);
        Boolean found = cochesDB.borrarCoche(coche);
        if (found) {
            logger.info("Se ha eliminado el coche con id: " + id);
        } else {
            logger.warn("No aparece ningún coche con id: " + id);
        }
    }

    private Coche crearCocheReal(Coche coche) {
        CocheBuilder cocheBuilder = new CocheBuilder(coche.getId());

        Coche temp = cocheBuilder
                .conTipoMotor(coche.getTipoMotor())
                .conPotencia(coche.getPotencia())
                .conVelocidadMax(coche.getVelocidadMax())
                .conColor(coche.getColor())
                .build();

        return temp;
    }
}
