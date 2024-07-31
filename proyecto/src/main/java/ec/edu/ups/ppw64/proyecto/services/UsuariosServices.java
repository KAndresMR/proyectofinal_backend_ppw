package ec.edu.ups.ppw64.proyecto.services;

import java.util.List;
import ec.edu.ups.ppw64.proyecto.bussiness.GestionUsuarios;
import ec.edu.ups.ppw64.proyecto.model.Usuario;
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

@Path("/usuarios")
public class UsuariosServices {

	@Inject
    private GestionUsuarios gestionUsuarios;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Usuario usuario) {
        try {
            gestionUsuarios.guardarUsuario(usuario);
            return Response.ok(usuario).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(503).entity(new Respuesta(Respuesta.ERROR, "Error en BD")).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> list() {
        return gestionUsuarios.listarUsuarios();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByUsername(@QueryParam("username") String username) {
        Usuario usuario = gestionUsuarios.buscarUsuarioPorUsername(username);
        if (usuario != null) {
            return Response.ok(usuario).build();
        } else {
            return Response.status(404).entity(new Respuesta(Respuesta.ERROR, "Usuario no encontrado")).build();
        }
    }
	
}
