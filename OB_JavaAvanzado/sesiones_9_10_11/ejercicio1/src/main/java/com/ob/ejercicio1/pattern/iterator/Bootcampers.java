package com.ob.ejercicio1.pattern.iterator;

import com.ob.ejercicio1.model.Bootcamper;

import java.util.ArrayList;

public class Bootcampers implements BootcamperIterator {

    private final ArrayList<Bootcamper> bootcampersList = new ArrayList<>();
    private int index = 0;

    public void crear(Bootcamper bootcamper) {
        bootcampersList.add(bootcamper);
    }

    public ArrayList<Bootcamper> listarBootcampers() {
        return bootcampersList;
    }

    public void eliminar(Bootcamper bootcamper) {
        bootcampersList.remove(bootcamper);
    }

    public void eliminarTodos() {
        bootcampersList.clear();
    }

    public boolean isEmpty() {
        return bootcampersList.isEmpty();
    }

    @Override
    public Bootcamper next() {
        Bootcamper bootcamper = bootcampersList.get(index);
        index++;
        return bootcamper;
    }

    @Override
    public boolean hasNext() {
        /*
         Si el index es menor a el tamaño de la lista retorna true,
         si no lo es retornará false.
         */
        return index < bootcampersList.size();
    }

    @Override
    public void reset() {
        index = 0;
    }
}
