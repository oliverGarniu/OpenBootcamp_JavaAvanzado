package com.ob.ejercicio1.controller;

import com.ob.ejercicio1.model.Bootcamper;
import com.ob.ejercicio1.service.BootcamperService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@Path("/api")
public class BootcamperController {

    /*
    Realizamos inyección de dependencias de la clase BootcamperService;
    La anotación @Autowired sería otra manera de hacerlo.
     */
    private final BootcamperService bootcamperService;

    public BootcamperController(BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;

        bootcamperService.add(new Bootcamper("Ona", 24));
        bootcamperService.add(new Bootcamper("Kai", 44));
        bootcamperService.add(new Bootcamper("Koa", 32));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> getAllBootcampers() {
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{name}")
    @Produces("application/json")
    public Bootcamper getBootcamper(@PathParam("name") String name) {
        return bootcamperService.getBootcamper(name);
    }

    /**
     * Obtenemos la edad media de los bootcampers
     *
     * @return
     */
    @GET
    @Path("/bootcampers/average")
    public String getAverageAge() {
        return bootcamperService.getAverageAge();
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addBootcamper(Bootcamper bootcamper) {
        bootcamperService.add(bootcamper);

        return Response.created(
                        URI.create("/bootcampers/" + bootcamper.getName()))
                .build();
    }

    @DELETE
    @Path("/bootcampers/{name}")
    public Response deleteOneBootcamper(@PathParam("name") String name) {
        return bootcamperService.deleteBootcamper(name);
    }

    @DELETE
    @Path("/bootcampers")
    public Response deleteAllBootcampers() {
        return bootcamperService.deleteAllBootcampers();
    }
}

