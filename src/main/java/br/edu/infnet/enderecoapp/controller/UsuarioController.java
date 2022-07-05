package br.edu.infnet.enderecoapp.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.edu.infnet.enderecoapp.model.domain.Role;
import br.edu.infnet.enderecoapp.model.domain.Usuario;
import br.edu.infnet.enderecoapp.model.service.RoleService;
import br.edu.infnet.enderecoapp.model.service.UsuarioService;

@SessionAttributes("user")
@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RoleService roleService;

	@GetMapping(value = "/usuario")
	public String telaUsuario(Model model) {
		model.addAttribute("roles", roleService.obterLista());
		return "usuario/cadastro";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluirUsuario(Model model, Usuario usuario, @RequestParam Integer acesso) {
		usuario.setRoles(Arrays.asList(new Role(acesso)));
		usuarioService.incluir(usuario);
		return "redirect:/";
	}

}
