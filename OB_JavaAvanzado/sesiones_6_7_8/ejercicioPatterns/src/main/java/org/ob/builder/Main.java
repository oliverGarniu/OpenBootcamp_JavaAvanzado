package org.ob.builder;

public class Main {
    public static void main(String[] args) {

        /*
        Esta sería la manera "convecional" de crear
        un objeto vehicle y asignarle parámetros.
        Demasido largo cuando es una clase con
        muchos parámetros.
         */
//        Vehicle vehicle = new Vehicle();
//        vehicle.setManufacturer("Honda");
//        vehicle.setModel("Civic VTi");
//        vehicle.setEngine("Diesel");
//        vehicle.setHorsepower(150);

        // Ahora haremos lo mismo utilizando el patrón builder
        Vehicle car = new CarBuilder("Mazda")
                .setModel("CX7")
                .setEngine("Hybrid")
                .setHorsepower(180)
                .build();

        System.out.println("Manufacturer: " + car.getManufacturer());
        System.out.println("Model: " + car.getModel());
        System.out.println("Engine: " + car.getEngine());
        System.out.println("Horsepower: " + car.getHorsepower());
    }
}
