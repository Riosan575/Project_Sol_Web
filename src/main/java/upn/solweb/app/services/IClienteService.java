package upn.solweb.app.services;

import java.util.List;

import upn.solweb.app.entities.Cliente;



public interface IClienteService {
	
	public Cliente registrar(Cliente cliente);
	
	public List<Cliente> obtenerClientes();
	
	public Cliente obtenerClienteId(Integer id);
	
	public void eliminar(Integer id);
	
	public Cliente obtenerClientePorNombre(String Nombre);
}
