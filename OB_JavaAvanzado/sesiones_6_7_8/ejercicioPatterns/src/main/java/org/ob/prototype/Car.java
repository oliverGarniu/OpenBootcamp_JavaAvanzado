package org.ob.prototype;

public class Car implements Cloneable {

    public String manufacturer;
    public String model;
    public String year;
    public String color;

    public Car() {
    }

    // para utilizar el patrón prototype
    public Car clonar() {
        Car clon = new Car();

        clon.manufacturer = manufacturer;
        clon.model = model;
        clon.year = year;
        clon.color = color;

        return clon;
    }

    // utilizando la interfaz que nos da java (Cloneable)
    public Car clonar2() throws CloneNotSupportedException {
        return (Car) this.clone();
    }
}
