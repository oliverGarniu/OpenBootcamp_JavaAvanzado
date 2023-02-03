package com.ob.ejercicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class Ejercicio1Application {

    public static void main(String[] args) {
//        SpringApplication.run(Ejercicio1Application.class, args);

        Coches coches = new Coches();

        Coche coche1 = new Coche(1, TipoMotor.COMBUSTION, 250, 240, "gris");
        Coche coche2 = new Coche(2, TipoMotor.ELECTRICO, 270, 250, "blanco");
        Coche coche3 = new Coche(3, TipoMotor.COMBUSTION, 200, 190, "negro");
        Coche coche4 = new Coche(4, TipoMotor.HIBRIDO, 180, 180, "azul");

        coches.agregarCoche(coche1);
        coches.agregarCoche(coche2);
        coches.agregarCoche(coche3);
        coches.agregarCoche(coche4);

        System.out.println(coches.obtenerCoche(2));
    }
}
