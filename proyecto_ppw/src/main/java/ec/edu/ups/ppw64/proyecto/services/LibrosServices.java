package com.programacion.ppw.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

import com.programacion.ppw.dao.LibroDAO;
import com.programacion.ppw.model.Libro;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/biblioteca")
public class BibliotecaResource {
	
    private LibroDAO libroDAO = new LibroDAO();

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerLibros() {
		List<Libro> libros = libroDAO.obtenerLibros();
        return Response.ok(libros).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregarLibro(Libro libro ) {
    	 libroDAO.agregarLibro(libro);
         return Response.status(Response.Status.CREATED).build();
    }
	
}
