package com.programacion.ppw.test;

import com.programacion.ppw.dao.LibroDAO;
import com.programacion.ppw.model.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersistenceTest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
    private static EntityManager em = emf.createEntityManager();
    private static LibroDAO libroDAO = new LibroDAO();
    
    
    public static void main(String[] args) {
        try {
            em.getTransaction().begin();

            // Crear
            Libro nuevoLibro = new Libro();
            nuevoLibro.setTitulo("Nuevo Libro");
            nuevoLibro.setAutor("Autor Desconocido");
            libroDAO.agregarLibro(nuevoLibro);

            // Leer
            Libro libroLeido = libroDAO.obtenerLibroPorId(nuevoLibro.getId());
            System.out.println("Libro leído: " + libroLeido);

            // Actualizar
            libroLeido.setTitulo("Libro Actualizado");
            libroDAO.actualizarLibro(libroLeido);

            // Leer todos
            List<Libro> libros = libroDAO.obtenerLibros();
            libros.forEach(libro -> System.out.println("Libro: " + libro));

            // Eliminar
            libroDAO.eliminarLibro(libroLeido.getId());

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }
}
