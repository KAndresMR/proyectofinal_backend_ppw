package ec.edu.ups.ppw64.proyecto.dao;

import java.util.List;

import ec.edu.ups.ppw64.proyecto.model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UsuarioDao {
	
	
	@PersistenceContext
    private EntityManager em;
	
	public void insert(Usuario usuario) {
        em.persist(usuario);
    }

    public void update(Usuario usuario) {
        em.merge(usuario);
    }  
    
    public Usuario read(int id) {
        return em.find(Usuario.class, id);
    }
    
    public List<Usuario> getAll() {
        String jpql = "SELECT u FROM Usuario u";
        Query q = em.createQuery(jpql, Usuario.class);
        return q.getResultList();
    }
    
 // Método para encontrar usuario por nombre de usuario (ejemplo)
    public Usuario findByUsername(String username) {
        String jpql = "SELECT u FROM Usuario u WHERE u.user = :username";
        Query q = em.createQuery(jpql, Usuario.class);
        q.setParameter("username", username);
        return (Usuario) q.getSingleResult();
    }

}
