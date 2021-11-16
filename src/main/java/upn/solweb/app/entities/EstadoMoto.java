package upn.solweb.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;

import java.lang.Integer;



@Entity
@Table(name="estadomoto")
public class EstadoMoto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstado;
	
	
	private String dni;
	
	@NotEmpty(message = "La marca es obligatoria.")
	private String marca;
	
	@NotEmpty(message = "El ciclindraje es obligatorio.")
	private String cilindraje;
	
	@NotEmpty(message = "El esto es obligatorio.")
	private String estado;

	public EstadoMoto() {
		super();
	}

	public EstadoMoto(Integer idEstado,String dni, String marca, String cilindraje, String estado) {
		super();
		this.idEstado = idEstado;
		this.dni = dni;
		this.marca = marca;
		this.cilindraje = cilindraje;
		this.estado = estado;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "EstadoMoto [idEstado=" + idEstado + ", dni=" + dni + ", marca=" + marca + ", cilindraje=" + cilindraje
				+ ", estado=" + estado + "]";
	}
	
	
	
	
}
