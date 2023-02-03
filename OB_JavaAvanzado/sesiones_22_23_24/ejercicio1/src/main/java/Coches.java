import java.util.ArrayList;

public class Coches {

    CochesDB cochesDB = new CochesDB();
    ArrayList<Coche> listadoCoches = cochesDB.convertirFicheroEnArrayList();

    public ArrayList<Coche> listarCoches() {
        return cochesDB.convertirFicheroEnArrayList();
    }

    public Coche obtenerCoche(int id) {
        return listadoCoches.stream()
                .filter(coche -> coche.getId() == id)
                .findFirst().orElse(null);
    }

    public void agregarCoche(Coche coche) {
        if (obtenerCoche(coche.getId()) != null) {
            return;
        }
        cochesDB.insertarCoche(coche);
    }

    public void eliminarCoche(int id) {
        Coche coche = new Coche();
        coche.setId(id);
        cochesDB.borrarCoche(coche);
    }
}
