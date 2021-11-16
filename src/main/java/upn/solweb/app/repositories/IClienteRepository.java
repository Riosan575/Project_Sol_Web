package upn.solweb.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import upn.solweb.app.entities.Cliente;


@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query("SELECT c FROM Cliente c WHERE c.nombre=?1")
	Cliente buscarCliente(String nombre);
	
}
