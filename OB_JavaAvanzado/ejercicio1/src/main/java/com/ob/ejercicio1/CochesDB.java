package com.ob.ejercicio1;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CochesDB {

    public String ficheroDatos = "coches.txt";

    public ArrayList<Coche> convertirFicheroEnArrayList() {

        ArrayList<Coche> listadoCoches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(ficheroDatos);

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

            for (Coche cocheExistente : convertirFicheroEnArrayList()) {
                printStream.println(separarCochePorComas(coche));
            }
            printStream.println(separarCochePorComas(coche));
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
}
