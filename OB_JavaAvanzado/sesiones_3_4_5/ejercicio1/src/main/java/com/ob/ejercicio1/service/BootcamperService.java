package com.ob.ejercicio1.service;

import com.ob.ejercicio1.model.Bootcamper;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootcamperService {

    private final Logger logger = LoggerFactory.getLogger(BootcamperService.class);

    private final List<Bootcamper> bootcamperList = new ArrayList<>();

    public List<Bootcamper> getAll() {
        if (!bootcamperList.isEmpty()) {
            return bootcamperList;
        }
        logger.info("Bootcamper list is empty");
        return null;
    }

    public Bootcamper getBootcamper(String name) {
        for (Bootcamper bootcamper : bootcamperList) {
            if (bootcamper.getName().equalsIgnoreCase(name)) {
                logger.info("Bootcamper found successfully");
                return bootcamper;
            }
        }
        logger.info("Bootcamper " + name + " not found");
        return null;
    }

    public String getAverageAge() {

        double averageAge = 0;

        if (bootcamperList.isEmpty()) {
            logger.info("Bootcamper list is empty");
        }
        for (Bootcamper bootcamper : bootcamperList) {
            int age = bootcamper.getAge();
            averageAge += age;
        }
        double result = averageAge / bootcamperList.size();
        return "La edad media de los bootcampers es: " + String.format("%.2f", result);
    }

    public void add(Bootcamper bootcamper) {
        bootcamperList.add(bootcamper);
        logger.info("Bootcamper " + bootcamper.getName() + " added successfully");
    }

    public Response deleteBootcamper(String name) {
        for (Bootcamper bootcamper : bootcamperList) {
            if (bootcamper.getName().equalsIgnoreCase(name)) {
                bootcamperList.remove(bootcamper);
                logger.info("Bootcamper " + name + " deleted successfully");
                return Response.noContent().build();
            } else {
                logger.info("Bootcamper " + name + " not found");
                return Response.notModified().build();
            }
        }
        return null;
    }

    public Response deleteAllBootcampers() {
        if (!bootcamperList.isEmpty()) {
            bootcamperList.clear();
            logger.info("BootcamperList cleared successfully");
            return Response.noContent().build();
        } else {
            logger.info("BootcamperList was already empty");
            return Response.notModified().build();
        }
    }
}
