
public class Ejercicio1Application {

    public static void main(String[] args) {

        Coches coches = new Coches();

        coches.agregarCoche(new Coche(1, TipoMotor.COMBUSTION, 250, 240, "gris"));
        coches.agregarCoche(new Coche(2, TipoMotor.ELECTRICO, 270, 250, "blanco"));
        coches.agregarCoche(new Coche(3, TipoMotor.COMBUSTION, 200, 190, "negro"));
        coches.agregarCoche(new Coche(4, TipoMotor.HIBRIDO, 180, 180, "azul"));

        int idCocheSolicitado = 2;
        System.out.println("\nEl coche solicitado es: " + coches.obtenerCoche(idCocheSolicitado));

        for (Coche c : coches.listadoCoches) {
            System.out.println("\nTipo de motor: " + c.getTipoMotor());
            System.out.println("---------------" + "-".repeat(c.getTipoMotor().name().length()));
            System.out.println(c);
        }

        int idCocheAEliminar = 3;
        coches.eliminarCoche(idCocheAEliminar);
        System.out.println("\nListado de coches actualizado: " + coches.listadoCoches);
    }
}
