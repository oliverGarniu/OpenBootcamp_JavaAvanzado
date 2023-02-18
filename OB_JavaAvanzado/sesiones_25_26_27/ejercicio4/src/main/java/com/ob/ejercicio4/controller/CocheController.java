package com.ob.ejercicio4.controller;

import com.ob.ejercicio4.entity.Coche;
import com.ob.ejercicio4.service.CocheService;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;

@Component
@Path("/api")
public class CocheController {
    private final CocheService cocheService;

    public CocheController(CocheService cocheService) {
        this.cocheService = cocheService;
    }

    @GET
    @Path("/coches")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Coche> listarCoches() {
        return cocheService.listarCoches();
    }

    @GET
    @Path("/coches/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Coche obtenerCoche(@PathParam("id") int id) {
        return cocheService.obtenerCoche(id);
    }

    @POST
    @Path("/coches")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarCoche(Coche coche) {
        cocheService.agregarCoche(coche);

        return Response.created(URI.create("/coches/" + coche.getId())).build();
    }

    @DELETE
    @Path("/coches/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response borrarCoche(@PathParam("id") int id) {
        cocheService.eliminarCoche(id);

        return Response.ok().build();
    }
}
