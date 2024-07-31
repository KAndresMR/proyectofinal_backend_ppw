package ec.edu.ups.ppw64.proyecto.bussiness;



import java.util.List;

import ec.edu.ups.ppw64.proyecto.dao.LibroDao;
import ec.edu.ups.ppw64.proyecto.model.Libro;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionLibros {

	@Inject
    private LibroDao libroDao;
	
    public void guardarLibro(Libro libro) {
        Libro lib = libroDao.read(libro.getId());
        if(lib != null) {
            libroDao.update(libro);
        } else {
            libroDao.insert(libro); 
        }
    }
    
	public List<Libro> listarLibros() {
		return libroDao.getAll();
	}
    
}
