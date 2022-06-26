package br.edu.infnet.enderecoapp.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.enderecoapp.model.domain.EstadoDTO;
import br.edu.infnet.enderecoapp.model.domain.MunicipioDTO;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1", name = "IBGEClient")
public interface IBGEClient {

	@GetMapping(value = "/localidades/estados")
	public List<EstadoDTO> obterEstados();

	@GetMapping(value = "/localidades/estados/{estadoId}/municipios")
	public List<MunicipioDTO> obterMunicipios(@PathVariable Integer estadoId);

}
