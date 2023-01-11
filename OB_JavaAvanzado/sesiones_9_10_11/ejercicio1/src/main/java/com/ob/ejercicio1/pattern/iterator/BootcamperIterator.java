package com.ob.ejercicio1.pattern.iterator;

import com.ob.ejercicio1.model.Bootcamper;

/*
Utilizaré el patrón Iterator para iterar sobre
la lista de Bootcampers
 */
public interface BootcamperIterator {

    Bootcamper next();
    boolean hasNext();
    void reset();
}
