package com.ob.ejercicio3.service;

import com.ob.ejercicio3.model.Bootcamper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;

/**
 * En BootcamperService aplicamos toda la lógica necesaria para poder
 * ejecutar las peticiones llevadas a cabo en el controller.
 */
@Service
public class BootcamperService {

    /**
     * Logger para poder introducir los mensajes que serán visibles en el log a nivel informativo.
     */
    private final Logger logger = LoggerFactory.getLogger(BootcamperService.class);
    private final List<Bootcamper> bootcamperList = new ArrayList<>();

    public List<Bootcamper> getAll() {
        return bootcamperList.isEmpty() ? null : bootcamperList;
    }

    public Bootcamper getBootcamper(String name) {
        return findBootcamper(name);
    }

    public String getAverageAge() {
        OptionalDouble result = bootcamperList.stream()
                .mapToDouble(Bootcamper::getAge).average();

        return result.isPresent() ? "La edad media de los bootcampers es: "
                + String.format("%.2f", result.getAsDouble()) : null;
    }

    public Bootcamper addBootcamper(Bootcamper bootcamper) {
        Bootcamper existBootcamper = findBootcamper(bootcamper.getName());

        if (existBootcamper == null) {
            bootcamperList.add(bootcamper);
            logger.info("Bootcamper " + bootcamper.getName().toUpperCase() + " added successfully");
            return null;
        }

        logger.info("Bootcamper " + bootcamper.getName().toUpperCase() + " already exists");
        return bootcamper;
    }

    /**
     * Se añaden 3 posibles maneras de eliminar un bootcamper
     * de la lista a partir del nombre: Usando foreach, iterator o stream.
     * <p>
     * Dejamos dos de las opciones comentadas para poder ejecutar el programa.
     */
    public String deleteBootcamper(String name) {
        Bootcamper existBootcamper = findBootcamper(name);

        if (existBootcamper != null) {
            bootcamperList.remove(existBootcamper);
            return "Bootcamper " + name.toUpperCase() + " deleted successfully";
        }
        return "Bootcamper " + name.toUpperCase() + " not found";
    }

//    // mismo método que el anterior pero utilizando iterator
//    public String deleteBootcamper(String name) {
//        // reinicio el iterador, volviendo a la posición 0.
//        Iterator<Bootcamper> iter = bootcamperList.iterator();
//
//        while (iter.hasNext()) {
//            Bootcamper bootcamper = iter.next();
//            if (bootcamper.getName().equalsIgnoreCase(name)) {
//                bootcamperList.remove(bootcamper);
//                return "Bootcamper " + name.toUpperCase() + " deleted successfully";
//            }
//        }
//        return "Bootcamper " + name.toUpperCase() + " not found";
//    }

//    // mismo método que el anterior pero utilizando stream
//    public String deleteBootcamper(String name) {
//        boolean existBootcamper = bootcamperList.stream()
//                .anyMatch(bootcamper -> bootcamper.getName().equalsIgnoreCase(name));
//
//        if (existBootcamper) {
//            bootcamperList.remove(getBootcamper(name));
//            return "Bootcamper " + name.toUpperCase() + " deleted successfully";
//        }
//        return "Bootcamper " + name.toUpperCase() + " not found";
//    }

    public void deleteAllBootcampers() {
        bootcamperList.clear();
        logger.info("Bootcamper list is empty");
    }

    public Bootcamper findBootcamper(String name) {
        return bootcamperList.stream()
                .filter(bootcamper -> bootcamper.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
}

