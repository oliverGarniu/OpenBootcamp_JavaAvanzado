package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CochesDB {

    public String ficheroDatos;
    ArrayList<Coche> listadoCoches = new ArrayList<>();

    public CochesDB() {
        this.ficheroDatos = "coches.txt";
    }

    public ArrayList<Coche> convertirFicheroEnArrayList() {

        try {
            Scanner scanner = new Scanner(new File(ficheroDatos));

            while (scanner.hasNext()) {
                String cocheActual = scanner.next();
                String[] partes = cocheActual.split(",");

                Coche coche = new Coche();
                coche.setId(Integer.parseInt(partes[0]));
                coche.setTipoMotor(TipoMotor.valueOf(partes[1]));
                coche.setPotencia(Integer.parseInt(partes[2]));
                coche.setVelocidadMax(Integer.parseInt(partes[3]));
                coche.setColor(partes[4]);

                listadoCoches.add(coche);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listadoCoches;
    }

    public void insertarCoche(Coche coche) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatos, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separarCochePorComas(coche));
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String separarCochePorComas(Coche coche) {
        return coche.getId() + ","
                + coche.getTipoMotor() + ","
                + coche.getPotencia() + ","
                + coche.getVelocidadMax() + ","
                + coche.getColor();
    }

    public boolean borrarCoche(Coche coche) {
        boolean found = true;
        Coche cocheAEliminar = listadoCoches.stream()
                .filter(c -> c.getId() == coche.getId())
                .findFirst().orElse(null);

        System.out.println("\nId del coche que se desea borrar: " + coche.getId());
        if (cocheAEliminar == null) {
            found = false;
            System.out.println("No existe ningún coche con id: " + coche.getId());
        } else {
            listadoCoches.remove(cocheAEliminar);
            System.out.println("Se ha eliminado el coche del listado correctamente");
        }

        try {
            PrintStream printStream = new PrintStream(ficheroDatos);

            for (Coche cocheActual : listadoCoches) {
                String cocheComas = separarCochePorComas(cocheActual);
                printStream.println(cocheComas);
            }
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return found;
    }
}
