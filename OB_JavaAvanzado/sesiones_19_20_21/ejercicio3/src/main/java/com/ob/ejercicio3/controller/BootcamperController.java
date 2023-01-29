package com.ob.ejercicio3.controller;

import com.ob.ejercicio3.model.Bootcamper;
import com.ob.ejercicio3.service.BootcamperService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

/*
 * Controller de Bootcamper donde incluimos las peticiones.
 * Además se crean y añaden 3 bootcampers para no tener una lista vacía
 * cuando iniciamos la aplicación.
 */
@Component
@Path("/api")
public class BootcamperController {

    private final BootcamperService bootcamperService;

    public BootcamperController(BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;

        bootcamperService.addBootcamper(new Bootcamper("Ona", 24));
        bootcamperService.addBootcamper(new Bootcamper("Kai", 44));
        bootcamperService.addBootcamper(new Bootcamper("Koa", 32));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> getAllBootcampers() {
        return bootcamperService.getAll();
    }

    /**
     * Devuelve un bootcamper introduciendo su nombre como parámetro.
     *
     * @param name nombre del bootcamper
     * @return bootcamper Devuelve un bootcamper si existe
     */
    @GET
    @Path("/bootcampers/{name}")
    @Produces("application/json")
    public Bootcamper getBootcamperByName(@PathParam("name") String name) {
        return bootcamperService.getBootcamper(name);
    }

    /**
     * Obtenemos la edad media de todos los bootcampers.
     *
     * @return Average age
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
        Bootcamper bc = bootcamperService.addBootcamper(bootcamper);
        return bc == null ? Response.created(URI.create("/bootcampers/" + bootcamper.getName()))
                .build() : Response.noContent().build();
    }

    /**
     * Buscamos y eliminamos un bootcamper de la lista introduciendo
     * el nombre como parámetro.
     *
     * @param name nombre del bootcamper a eliminar
     * @return devuelve un String indicando si ha encontrado y eliminado
     * al bootcamper, o bien que no existe ningún bootcamper con ese nombre
     * en la lista.
     */
    @DELETE
    @Path("/bootcampers/{name}")
    public void deleteOneBootcamper(@PathParam("name") String name) {
        bootcamperService.deleteBootcamper(name);
    }

    @DELETE
    @Path("/bootcampers")
    public void deleteAllBootcampers() {
        bootcamperService.deleteAllBootcampers();
    }
}
