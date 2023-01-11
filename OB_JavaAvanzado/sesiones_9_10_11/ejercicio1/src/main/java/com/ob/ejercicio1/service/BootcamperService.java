package com.ob.ejercicio1.service;

import com.ob.ejercicio1.model.Bootcamper;
import com.ob.ejercicio1.pattern.iterator.Bootcampers;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BootcamperService {

    private final Logger logger = LoggerFactory.getLogger(BootcamperService.class);

    Bootcampers bootcampers = new Bootcampers();

    // Utilizamos los métodos del iterator
    public List<Bootcamper> getAll() {

        if (bootcampers.isEmpty()) {
            logger.info("Bootcamper list is empty");
            return null;
        }
        return bootcampers.listarBootcampers();
    }

    // Utilizamos los métodos del iterator
    public Bootcamper getBootcamper(String name) {
        bootcampers.reset();
        while (bootcampers.hasNext()) {
            Bootcamper bootcamper = bootcampers.next();
            if (bootcamper.getName().equalsIgnoreCase(name)) {
                logger.info("Bootcamper found successfully");
                return bootcamper;
            }
        }
        logger.info("Bootcamper " + name + " not found");
        return null;
    }

    // Utilizamos los métodos del iterator
    public String getAverageAge() {

        bootcampers.reset();

        double averageAge = 0;
        int size = 0;

        if (bootcampers.isEmpty()) {
            logger.info("Bootcamper list is empty");
        }
        while (bootcampers.hasNext()) {
            Bootcamper bootcamper = bootcampers.next();
            int age = bootcamper.getAge();
            averageAge += age;
            size++;
        }
        double result = averageAge / size;
        return "La edad media de los bootcampers es: " + String.format("%.2f", result);
    }

    // Utilizamos los métodos del iterator
    public void add(Bootcamper bootcamper) {
        bootcampers.crear(bootcamper);
        logger.info("Bootcamper " + bootcamper.getName() + " added successfully");
    }

    // Utilizamos los métodos del iterator
    public Response deleteBootcamper(String name) {
        bootcampers.reset();

        if (bootcampers.isEmpty()) {
            logger.info("Bootcamper list is empty");
            return Response.notModified().build();
        }

        while (bootcampers.hasNext()) {
            Bootcamper bootcamper = bootcampers.next();
            if (bootcamper.getName().equalsIgnoreCase(name)) {
                bootcampers.eliminar(bootcamper);
                logger.info("Bootcamper " + name + " deleted successfully");
                return Response.noContent().build();
            }
        }
        logger.info("Bootcamper " + name + " not found");
        return Response.notModified().build();
    }

    public Response deleteAllBootcampers() {
        if (!bootcampers.isEmpty()) {
            bootcampers.eliminarTodos();
            logger.info("BootcamperList cleared successfully");
            return Response.noContent().build();
        }
        logger.info("BootcamperList was already empty");
        return Response.notModified().build();
    }
}
