package com.ob.ejercicio4.repository;

public class CochesDBFactory {

    private String tipoDB;

    public CochesDBFactory(String tipoDB) {
        this.tipoDB = tipoDB;
    }

    public CochesDB getDBInstance() {
        if (tipoDB.equalsIgnoreCase("memoria")) {
            return new CochesDBMemoria();
        } else if (tipoDB.equalsIgnoreCase("fichero")) {
            return new CochesDBFichero();
        }

        return new CochesDBNullable();
    }
}
