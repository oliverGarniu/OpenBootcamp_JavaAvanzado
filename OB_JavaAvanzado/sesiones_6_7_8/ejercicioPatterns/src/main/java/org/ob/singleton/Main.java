package org.ob.singleton;

public class Main {
    public static void main(String[] args) {

        /*
        Comprobamos como efectivamente no es posible
        crear objetos con el operador new ConexionBaseDatos().
        ConexionBaseDatos conexion = new ConexionBaseDatos();
         */

        /*
         * La primera vez que llamamos al método getInstance(),
         * al no existir ningún objeto se crea uno nuevo.
         * La siguiente vez al haber ya un objeto creado, la segunda "instancia"
         * en realidad sigue siendo el primer objeto con el parámetro
         * modificado.
         */
        ConexionBaseDatos conexion1 = ConexionBaseDatos.getInstance();  // new ConexionBaseDatos()
        conexion1.setContador(5);
        System.out.println(conexion1.getContador());

        ConexionBaseDatos conexion2 = ConexionBaseDatos.getInstance();  // conexion2 = conexion1
        conexion2.setContador(10);
        System.out.println(conexion2.getContador());

        /*
        Comprobamos que efectivamente ocupan el mismo espacio en memoria,
        y por lo tanto son el mismo objeto.
         */
        System.out.println("Espacio en memoria de conexion1: " + conexion1);
        System.out.println("Espacio en memoria de conexion2: " + conexion2);
    }
}