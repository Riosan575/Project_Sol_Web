package upn.solweb.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.app.entities.Cliente;
import upn.solweb.app.repositories.IClienteRepository;


@Service
public class ClienteService implements IClienteService{


	@Autowired
	private IClienteRepository clienteRepo;

	@Override
	public Cliente registrar(Cliente cliente) {
		return clienteRepo.save(cliente); 
	}

	@Override
	public List<Cliente> obtenerClientes() {
		return clienteRepo.findAll();
	}

	@Override
	public Cliente obtenerClienteId(Integer id) {
		return clienteRepo.getById(id);
	}

	@Override
	public void eliminar(Integer id) {
		clienteRepo.deleteById(id);
		
	}

	@Override
	public Cliente obtenerClientePorNombre(String Nombre) {
		return clienteRepo.buscarCliente(Nombre);
	}

		

}
