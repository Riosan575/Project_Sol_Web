package upn.solweb.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import upn.solweb.app.entities.EstadoMoto;

@Repository
public interface IEstadoMotoRepository extends JpaRepository<EstadoMoto,Integer>{

	@Query("SELECT e FROM EstadoMoto e WHERE e.dni=?1")
	EstadoMoto buscarEstadoMoto(Integer dni);
	
	List<EstadoMoto> findByDni(String dni);
	
}
