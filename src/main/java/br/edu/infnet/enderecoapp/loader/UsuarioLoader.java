package br.edu.infnet.enderecoapp.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.enderecoapp.model.service.RoleService;
import br.edu.infnet.enderecoapp.model.service.UsuarioService;

@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private RoleService roleService;    
	
	@Autowired
	private UsuarioService usuarioService;    
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//		roleService.incluir(new Role("ROLE_ADMIN"));
//		roleService.incluir(new Role("ROLE_USER"));
//		
//			
//		Endereco endereco = new Endereco();
//		endereco.setBairro("Bairro Tales");
//		endereco.setCep("26589582");
//		endereco.setComplemento("complemento Tales");
//		endereco.setLocalidade("Localidade Tales");
//		endereco.setLogradouro("Logradouro Tales");
//		endereco.setUf("UF Tales");
//		
//		Usuario tales = new Usuario();
//		tales.setEmail("talesloader@email.com");
//		tales.setSenha("1234");
//		tales.setNome("Tales");
//		tales.setRoles(Arrays.asList(new Role(1)));;
//		tales.setEndereco(endereco);
//		
//		Endereco enderecoElberth = new Endereco();
//		enderecoElberth.setBairro("Bairro Elberth");
//		enderecoElberth.setCep("2658958222");
//		enderecoElberth.setComplemento("complemento Elberth");
//		enderecoElberth.setLocalidade("Localidade Elberth");
//		enderecoElberth.setLogradouro("Logradouro Elberth");
//		enderecoElberth.setUf("UF Elberth");
//		
//		Usuario elberth = new Usuario();
//		elberth.setEmail("elberthloader@email.com");
//		elberth.setSenha("1234");
//		elberth.setNome("Elbert");
//		elberth.setRoles(Arrays.asList(new Role(2)));;
//		elberth.setEndereco(enderecoElberth);
//		
//		usuarioService.incluir(tales);
//		usuarioService.incluir(elberth);
		
	}

}
