package upn.solweb.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import upn.solweb.app.entities.Cliente;

import upn.solweb.app.services.IClienteService;

@Controller
@RequestMapping("/views/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteservice;
	
	@GetMapping("/")
	public String listarClientes(Model model) {
		
		List<Cliente> listaClientes = clienteservice.obtenerClientes();
		
		model.addAttribute("titulo", "Lista de Clientes");
		
		model.addAttribute("clientes", listaClientes);
		
		return "/views/cliente/mostrar";
	}
	
	@GetMapping("/crear")
	public String crearCliente(Model model) {
		
		Cliente cliente = new Cliente();
		
		model.addAttribute("titulo", "Formulario: Nuevo Cliente");
		model.addAttribute("cliente",cliente);
		
		return "/views/cliente/crear";
	}
	
	@PostMapping("/save")
	public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result,Model model, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			return "/views/cliente/crear";
		}else {
		
		clienteservice.registrar(cliente);
		System.out.println("Cliente guardado con exito");
		return "redirect:/views/cliente/";
		}
	}
	
	@GetMapping("/edit/{idCliente}")
	public String editarCliente(@PathVariable("idCliente") int idClient, Model model) {
		
		Cliente cliente = clienteservice.obtenerClienteId(idClient);
		
		model.addAttribute("titulo", "Formulario: Editar Cliente");
		model.addAttribute("cliente",cliente);
		
		return "/views/cliente/crear";
	}

	@GetMapping("/delete/{idCliente}")
	public String eliminarClientes(@PathVariable("idCliente") int idCliente) {
		
		clienteservice.eliminar(idCliente);
		System.out.println("Cliente eliminado con exito");
		
		return "redirect:/views/cliente/";
	}
}
