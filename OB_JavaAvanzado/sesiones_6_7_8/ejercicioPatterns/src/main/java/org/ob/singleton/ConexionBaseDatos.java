package org.ob.singleton;

public class ConexionBaseDatos {

    private static ConexionBaseDatos conexion;

    int contador;

    /*
    Creamos el constructor private para evitar que se pueda
    crear una nueva instancia desde fuera utilizando el operador new Singleton().
    Solo podremos crear nuevas instancias con el método getInstance().
    */
    private ConexionBaseDatos() {
    }

    public static ConexionBaseDatos getInstance() {
        if (conexion == null) {
            conexion = new ConexionBaseDatos();
        }
        return conexion;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
