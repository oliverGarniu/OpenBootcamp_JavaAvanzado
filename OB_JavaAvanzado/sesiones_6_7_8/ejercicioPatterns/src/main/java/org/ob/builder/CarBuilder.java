package org.ob.builder;

public class CarBuilder {

    Vehicle vehicle;

    public CarBuilder(String manufacturer) {
        vehicle = new Vehicle();
        vehicle.setManufacturer(manufacturer);
    }

    /*
    Creamos un método que retorna CarBuilder,
    de esta manera podremos aplicar la programación
    fluida.
     */
    public CarBuilder setModel(String model) {
        vehicle.setModel(model);
        return this;
    }

    public CarBuilder setHorsepower(int horsepower) {
        vehicle.setHorsepower(horsepower);
        return this;
    }

    public CarBuilder setEngine(String engine) {
        vehicle.setEngine(engine);
        return this;
    }

    public Vehicle build() {
        return vehicle;
    }
}
