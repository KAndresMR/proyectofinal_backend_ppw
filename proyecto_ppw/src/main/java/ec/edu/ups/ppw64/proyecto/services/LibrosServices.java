package ec.edu.ups.ppw64.proyecto.services;

import java.util.List;

import ec.edu.ups.ppw64.proyecto.bussiness.GestionLibros;
import ec.edu.ups.ppw64.proyecto.model.Libro;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/biblioteca")
public class LibrosServices {
	
	@Inject
	private GestionLibros gestionLibro;
	 
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Libro libro) {
	    try {
	        gestionLibro.guardarLibro(libro);
	        return Response.ok(libro).build();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
	    }
	
	}
	
	@GET
	@Produces("application/json")
	public List<Libro> list() {
		List<Libro> libros = gestionLibro.listarLibros();
		return libros;
	}
	
	
}
