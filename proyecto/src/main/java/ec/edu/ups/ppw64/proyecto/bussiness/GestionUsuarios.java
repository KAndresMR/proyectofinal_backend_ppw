package ec.edu.ups.ppw64.proyecto.bussiness;

import java.util.List;
import ec.edu.ups.ppw64.proyecto.dao.UsuarioDao;
import ec.edu.ups.ppw64.proyecto.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionUsuarios {

	@Inject
    private UsuarioDao usuarioDao;

    public void guardarUsuario(Usuario usuario) {
        Usuario usr = usuarioDao.read(usuario.getId());
        if (usr != null) {
            usuarioDao.update(usuario);
        } else {
            usuarioDao.insert(usuario);
        }
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDao.getAll();
    }
    
    public Usuario buscarUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }
}
