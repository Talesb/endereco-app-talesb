package br.edu.infnet.enderecoapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.enderecoapp.model.domain.Usuario;

@SessionAttributes("user")
@Controller
public class AppController {

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}

//	@PostMapping(value = "/login")
//	public String login(Model model, @RequestParam String email, @RequestParam String senha) {
// 
//		Usuario usuario = usuarioService.autenticar(email, senha);
//		if (usuario != null) {
//			model.addAttribute("user", usuario);
//			return "redirect:/";
//		}
//
//		return "redirect:/login";
//	}

	@PostMapping(value = "/login")
	public String login(Model model, @AuthenticationPrincipal Usuario usuario) {
		return "redirect:/login";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("user");
		return "redirect:/";
	}

	@GetMapping(value = "/negado")
	public String negadoAcesso() {
		return "negado";
	}

}
