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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import upn.solweb.app.entities.EstadoMoto;
import upn.solweb.app.services.IEstadoMotoService;

@Controller
@RequestMapping("/views/estado")
public class EstadoMotoController<RegisterRequestModel> {
		
	@Autowired
	private IEstadoMotoService estadoMotoService;
	
	
	@GetMapping("/")
	public String listarMotos(Model model) {
		
		List<EstadoMoto> listaestados = estadoMotoService.obtenerEstadoMoto();
		
		model.addAttribute("titulo", "Lista de estados de Motos");
		
		model.addAttribute("estadosmotos", listaestados);
		
		return "/views/estado/estmotos";
	}
	
	@GetMapping("/crearestado")
	public String crearEstados(Model model, @ModelAttribute EstadoMoto estmoto) {
		
		 estmoto = new EstadoMoto();
		
		model.addAttribute("titulo", "Formulario: Nuevo E");
		model.addAttribute("estmoto",estmoto);
		
		return "/views/estado/crearestadomotos";
	}
	
	@PostMapping("/saves")
	public String guardar(@Valid @ModelAttribute EstadoMoto estadosmotos,BindingResult result, Model model, RedirectAttributes attribute) {
		
		if(result.hasErrors()) {
			return "/views/estado/crearestadomotos";
		}
		
		estadoMotoService.registrar(estadosmotos);
		System.out.println("Estado guardado con exito");
		return "redirect:/views/estado/";
		
	}
	
	@GetMapping("/edit/{idEstado}")
	public String editarEstados(@PathVariable("idEstado") Integer idEstado, Model model,@ModelAttribute RegisterRequestModel registerRequestModel) {
		
		EstadoMoto estadoMoto = estadoMotoService.obtenerEstadoMotoId(idEstado);
		
		model.addAttribute("titulo", "Formulario: Editar Estado");
		model.addAttribute("estmoto",estadoMoto);
		
		return "/views/estado/crearestadomotos";
	}

	@GetMapping("/delete/{idEstado}")
	public String eliminarEstados(@PathVariable("idEstado") Integer idEstado) {
		
		estadoMotoService.eliminar(idEstado);
		System.out.println("Estado eliminado con exito");
		
		return "redirect:/views/estado/";
	}
	
	@GetMapping("/buscar")
	public String buscarporDni(@RequestParam String dni, Model model, @ModelAttribute ("estadosmotos") EstadoMoto listaestados) {
		
		
		model.addAttribute("estadosdni", estadoMotoService.findByDni(dni));
		
		
		return "/views/estado/buscar";
	}
	
}
