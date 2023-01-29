package com.ob.ejercicio3.service;

import com.ob.ejercicio3.model.Bootcamper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

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
        boolean found = bootcamperExists(name);

        if (found) {
            logger.info("Bootcamper " + name + " found successfully");
            return getActualBootcamper(name);
        }

        logger.info("Bootcamper " + name + " not found");
        return null;
    }

    public String getAverageAge() {
        OptionalDouble result = bootcamperList.stream()
                .mapToDouble(Bootcamper::getAge).average();

        return result.isPresent() ? "La edad media de los bootcampers es: "
                + String.format("%.2f", result.getAsDouble()) : null;
    }

    public Bootcamper addBootcamper(Bootcamper bootcamper) {
        boolean found = bootcamperExists(bootcamper.getName());

        if (found) {
            logger.info("Bootcamper " + bootcamper.getName().toUpperCase() + " already exists");
            return bootcamper;
        }

        bootcamperList.add(bootcamper);
        logger.info("Bootcamper " + bootcamper.getName().toUpperCase() + " added successfully");
        return null;
    }

    public void deleteBootcamper(String name) {
        boolean found = bootcamperExists(name);

        if (found) {
            Bootcamper bootcamper = getActualBootcamper(name);
            bootcamperList.remove(bootcamper);
            logger.info("Bootcamper " + name.toUpperCase() + " removed successfully");
        } else {
            logger.info("Bootcamper " + name.toUpperCase() + " not found");
        }
    }

    public void deleteAllBootcampers() {
        bootcamperList.clear();
        logger.info("Bootcamper list is empty");
    }

    public boolean bootcamperExists(String name) {
        return bootcamperList.stream()
                .anyMatch(bootcamper -> bootcamper.getName().equalsIgnoreCase(name));
    }

    public Bootcamper getActualBootcamper(String name) {
        return bootcamperList.stream()
                .filter(bootcamper -> bootcamper.getName().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }
}

