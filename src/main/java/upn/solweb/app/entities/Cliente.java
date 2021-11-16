package upn.solweb.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.lang.Integer;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	
	@Max(value = 99999999, message = "Número de Dni invalido")

	private Integer dni;

	@NotEmpty(message = "El nombre del Cliente es obligatorio")
	private String nombre;
	
	@NotEmpty(message = "El apellido del Cliente es obligatorio")
	private String apellido;
	
	@NotEmpty(message = "El correo del Cliente es obligatorio")
	@Email
	private String correo;
	
	@Pattern (regexp = "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", message = "Error de formato de número de teléfono móvil")
	@NotEmpty(message = "El número telefónico del Cliente es obligatorio")
	private String telefono;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente,Integer dni, String nombre, String apellido, String correo, String telefono) {
		super();
		this.idCliente = idCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", telefono=" + telefono + "]";
	}

	
	
	
}
