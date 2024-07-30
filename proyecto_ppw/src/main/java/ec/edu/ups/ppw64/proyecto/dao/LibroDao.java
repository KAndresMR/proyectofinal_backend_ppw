package com.programacion.ppw.dao;

import java.util.List;
import com.programacion.ppw.model.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LibroDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    public void agregarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Libro> obtenerLibros() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        } finally {
            em.close();
        }
    }

    public Libro obtenerLibroPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public void actualizarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void eliminarLibro(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Libro libro = em.find(Libro.class, id);
            if (libro != null) {
                em.remove(libro);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}