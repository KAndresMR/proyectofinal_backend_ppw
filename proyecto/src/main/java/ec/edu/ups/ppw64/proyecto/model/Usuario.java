package ec.edu.ups.ppw64.proyecto.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "Users")
public class Usuario {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "NUMBER(4)")
    private int id;

    @Column(name = "user_user", length = 30)
    private String user;

    @Column(name = "user_password", length = 30)
    private String password;

    @Column(name = "user_name", length = 30)
    private String nombre;
    
    @Column(name = "user_lastname", length = 30)
    private String apellido;
    
    @Column(name = "user_email", length = 30)
    private String correo;
    
    @Column(name = "user_phone", length = 30)
    private String celular;
    
    @Column(name = "user_location", length = 30)
    private String ubicacion;
    
    @Column(name = "user_photo", length = 30)
    private String foto;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSocialUrl() {
		return socialUrl;
	}

	public void setSocialUrl(String socialUrl) {
		this.socialUrl = socialUrl;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Column(name = "user_url", length = 30)
    private String socialUrl;
    
    @Column(name = "user_isAdmin", length = 30)
    private Boolean isAdmin;

}
