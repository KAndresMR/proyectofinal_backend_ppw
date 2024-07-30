package ec.edu.ups.ppw64.proyecto.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "Books")
public class Libro {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = "NUMBER(4)")
    private int id;

    @Column(name = "book_title", length = 30)
    private String titulo;

    @Column(name = "book_author", length = 30)
    private String autor;

    @Column(name = "book_comprobar", length = 30)
    private String comprobar;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getComprobar() {
        return autor;
    }
    public void setComprobar(String comprobar) {
        this.comprobar = comprobar;
    }

    
}
