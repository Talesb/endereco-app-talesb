package br.edu.infnet.enderecoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.enderecoapp.model.domain.Endereco;
import br.edu.infnet.enderecoapp.model.domain.EstadoDTO;
import br.edu.infnet.enderecoapp.model.domain.MunicipioDTO;
import br.edu.infnet.enderecoapp.model.service.EnderecoService;

@Controller
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@GetMapping(value = "/enderecos")
	public String telaLista(Model model) {
		model.addAttribute("lista", enderecoService.obterLista());
		return "endereco/lista";
	}

	@GetMapping(value = "/estados")
	public String telaListaEstados(Model model) {
		List<EstadoDTO> estados = enderecoService.obterEstados();
		model.addAttribute("listaestados", estados);
		return "estado/lista";
	}

	@GetMapping(value = "/municipios")
	public String telaListaMunicipios(Model model) {
	 Integer estadoId =	(Integer) model.getAttribute("estadoid");
		 List<MunicipioDTO> municipios =  this.enderecoService.obterMunicipioPorEstados(estadoId);
		model.addAttribute("listamunicipios", enderecoService.obterLista());
		return "municipio/lista";
	}
	
	@GetMapping(value = "/endereco")
	public String telaCadastro() {
		return "endereco/cadastro";
	}

	@PostMapping(value = "/endereco")
	public String buscar(Model model, @RequestParam String cep) {
		Endereco endereco = enderecoService.obterPorCep(cep);
		model.addAttribute("endereco", endereco);
		return "endereco/cadastro";
	}

	@PostMapping(value = "/endereco/incluir")
	public String incluir(Model model, Endereco endereco) {
		this.enderecoService.incluir(endereco);
		return "redirect:/enderecos";
	}

	@GetMapping(value = "/endereco/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id) {
		this.enderecoService.excluir(id);
		return "redirect:/enderecos";
	}
	
	@GetMapping(value = "/estado/{id}/municipios")
	public String obterMunicipiosPorEstado(Model model, @PathVariable Integer estadoId) {
		model.addAttribute("estadoid", estadoId);
		return "redirect:/municipios";
	}

}
