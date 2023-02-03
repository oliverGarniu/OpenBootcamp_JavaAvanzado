package org.example;

public class CochesDBEstadisticas extends CochesDB {
    private int totalCochesNuevos = 0;
    private int totalCochesEliminados = 0;

    @Override
    public void insertarCoche(Coche coche) {
        super.insertarCoche(coche);
        totalCochesNuevos++;
    }

    @Override
    public boolean borrarCoche(Coche coche) {
        boolean found = super.borrarCoche(coche);
        if (found) totalCochesEliminados++;

        return found;
    }

    public void totalCochesElectricos() {
        int numCochesElectricos = (int) listadoCoches.stream()
                .filter(coche -> coche.getTipoMotor().name().equalsIgnoreCase("ELECTRICO")).count();

        System.out.println("Total de coches eléctricos: " + numCochesElectricos);
    }

    public void totalCochesCombustion() {
        int numCochesCombustion = (int) listadoCoches.stream()
                .filter(coche -> coche.getTipoMotor().name().equalsIgnoreCase("COMBUSTION")).count();

        System.out.println("Total de coches combustión: " + numCochesCombustion);
    }

    public void totalCochesHibridos() {
        int numCochesHibridos = (int) listadoCoches.stream()
                .filter(coche -> coche.getTipoMotor().name().equalsIgnoreCase("HIBRIDO")).count();

        System.out.println("Total de coches híbridos: " + numCochesHibridos);
    }

    public int getTotalCochesNuevos() {
        return totalCochesNuevos;
    }

    public int getTotalCochesEliminados() {
        return totalCochesEliminados;
    }
}
