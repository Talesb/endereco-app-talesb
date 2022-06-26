package br.edu.infnet.enderecoapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.enderecoapp.clients.EnderecoClient;
import br.edu.infnet.enderecoapp.clients.IBGEClient;
import br.edu.infnet.enderecoapp.clients.ViaCepClient;
import br.edu.infnet.enderecoapp.model.domain.Endereco;
import br.edu.infnet.enderecoapp.model.domain.EstadoDTO;
import br.edu.infnet.enderecoapp.model.domain.MunicipioDTO;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoClient enderecoClient;
	
	@Autowired
	private ViaCepClient cepClient;
	
	@Autowired
	private IBGEClient iBGEClient;
	

	public List<Endereco> obterLista() {
		return enderecoClient.obterLista();
	}

	public Endereco obterPorCep(String cep) {
		Endereco endereco = cepClient.obterEndereco(cep);
		if (endereco != null) {
			return endereco;
		} else {
			return new Endereco(cep);
		}
	}

	public void incluir(Endereco endereco) {
		enderecoClient.incluir(endereco.toDTO());
	}

	public void excluir(Integer enderecoId) {
		enderecoClient.excluir(enderecoId);
	}

	public List<EstadoDTO> obterEstados() {
		return this.iBGEClient.obterEstados();
	}

	public List<MunicipioDTO> obterMunicipioPorEstados(Integer estadoId) {
		return this.iBGEClient.obterMunicipios(estadoId);
		 
	}
}
