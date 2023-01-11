package com.ob.ejercicio1.pattern.iterator;

import com.ob.ejercicio1.model.Bootcamper;

/*
Añado este Main en el paquete iterator para visualizar el funcionamiento
de los métodos sin tener que ejecutar el Main principal del proyecto.
En BootcamperService también he añadido los métodos del iterador para
poder ejecutar el proyecto y comprobar el funcionamiento, en mi caso
usando Postman.
 */
public class Main {
    public static void main(String[] args) {

        /*
        Utilizaremos el método crear del iterador para crear
        los bootcampers iniciales, pero antes creamos un objeto de la
        clase Bootcampers para utilizar los métodos del iterator.
         */
        Bootcampers bootcampers = new Bootcampers();
        bootcampers.crear(new Bootcamper("Ona", 24));
        bootcampers.crear(new Bootcamper("Kai", 44));
        bootcampers.crear(new Bootcamper("Koa", 32));

        // Realizamos la prueba del iterator
        System.out.println("\n== Print inicial ==");
        int index = 1;
        while (bootcampers.hasNext()) {
            Bootcamper bootcamper = bootcampers.next();
            System.out.printf("Bootcamper %s --> %s%n", index, bootcamper.getName());
            index++;
        }

        bootcampers.crear(new Bootcamper("Kalatrava", 22));

        /*
        En este caso imprimirá solo el último objeto que hemos creado,
        porque el iterador se ha quedado en Koa.
         */
        System.out.println("\n== Print sin reiniciar el iterator ==");
        while (bootcampers.hasNext()) {
            Bootcamper bootcamper = bootcampers.next();
            System.out.printf("Bootcamper %s --> %s%n", index, bootcamper.getName());
            index++;
        }

        /*
        En este caso imprimirá el listado completo,
        ya que al hacer reset() el iterador vuelve
        a estar en el inicio.
         */
        System.out.println("\n== Print reiniciando el iterator ==");
        bootcampers.reset();
        while (bootcampers.hasNext()) {
            Bootcamper bootcamper = bootcampers.next();
            System.out.printf("Bootcamper %s --> %s%n", index, bootcamper.getName());
            index++;
        }
    }
}
