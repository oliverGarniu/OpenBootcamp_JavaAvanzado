package com.ob.ejercicio1.model;

public class Bootcamper {

    private String name;
    private int age;

    /*
     Creamos el constructor vacío private para que no
     pueda instanciarse desde fuera y asegurarnos que
     se hace con los parámetros name y age.
     */
    private Bootcamper() {
    }

    public Bootcamper(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bootcamper{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
