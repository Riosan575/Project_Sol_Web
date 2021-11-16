package upn.solweb.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import upn.solweb.app.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByUsername(String username);
	
}
