package ec.edu.ups.ppw64.proyecto.dao;

import java.util.List;

import ec.edu.ups.ppw64.proyecto.model.Libro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class LibroDao {

	@PersistenceContext
    private EntityManager em;
	
	public void insert(Libro libro) {
        em.persist(libro);
    }

    public void update(Libro libro) {
        em.merge(libro);
    }  
    
    public Libro read(int id) {
        return em.find(Libro.class, id);
    }
    
    public List<Libro> getAll() {
        String jpql = "SELECT l FROM Libro l";
        Query q = em.createQuery(jpql, Libro.class);
        return q.getResultList();
    }
    
}
