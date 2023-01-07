package org.ob.prototype;

public class Main {
    public static void main(String[] args) {

        // Manera "convencional"
        System.out.println("\n==Manera convecional==");
        Car car = new Car();

        car.manufacturer = "Honda";
        car.model = "Civic";
        car.year = "2009";
        car.color = "Blue";

        System.out.println(car.manufacturer + " " +
                car.model + " " + car.year + " " + car.color);

        // Utilizando patrón prototype; clonando el objeto inicial.
        System.out.println("\n==Patrón prototype==");

        Car clonado = car.clonar();
        clonado.year = "2011";

        System.out.println(clonado.manufacturer + " " +
                clonado.model + " " + clonado.year +
                " " + clonado.color);

        /*
        También podemos implementar el patrón prototype,
        utilizando una intaerfaz (Cloneable) que nos da java.
         */
        System.out.println("\n==Utilizando la interfaz Cloneable==");

        try {
            Car clonado2 = car.clonar2();
            clonado.year = "2016";

            System.out.println(clonado.manufacturer + " " +
                    clonado.model + " " + clonado.year +
                    " " + clonado.color);
        } catch (CloneNotSupportedException e) {
            System.out.println("No se puede clonar: " + e.getMessage());
        }
    }
}
