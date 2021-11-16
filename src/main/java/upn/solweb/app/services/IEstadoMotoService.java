package upn.solweb.app.services;

import java.util.List;

import upn.solweb.app.entities.EstadoMoto;

public interface IEstadoMotoService {

	public EstadoMoto registrar(EstadoMoto estadomoto);
	
	public List<EstadoMoto> obtenerEstadoMoto();
	
	public EstadoMoto obtenerEstadoMotoId(Integer id);
	
	public void eliminar(Integer id);
	
	public EstadoMoto buscarEstadoMoto(Integer dni);
	
	public List<EstadoMoto> findByDni(String dni);
	
}
