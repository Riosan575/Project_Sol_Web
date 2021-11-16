package upn.solweb.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.app.entities.EstadoMoto;
import upn.solweb.app.repositories.IEstadoMotoRepository;

@Service
public class EstadoMotoService implements IEstadoMotoService{

	@Autowired
	private IEstadoMotoRepository estadoMotoRepo;
	
	@Override
	public EstadoMoto registrar(EstadoMoto estadomoto) {
		return estadoMotoRepo.save(estadomoto); 
	}

	@Override
	public List<EstadoMoto> obtenerEstadoMoto() {
		return estadoMotoRepo.findAll();
	}

	@Override
	public EstadoMoto obtenerEstadoMotoId(Integer id) {
		return estadoMotoRepo.getById(id);
	}

	@Override
	public void eliminar(Integer id) {
		estadoMotoRepo.deleteById(id);
		
	}

	@Override
	public EstadoMoto buscarEstadoMoto(Integer dni) {
		return estadoMotoRepo.buscarEstadoMoto(dni);
	}

	@Override
	public List<EstadoMoto> findByDni(String dni) {
		return estadoMotoRepo.findByDni(dni);
	}

	
	
	

}
