package br.edu.infnet.enderecoapp.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TEndereco", uniqueConstraints = @UniqueConstraint(columnNames = { "cep" }))
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String cep;

	private String logradouro;

	private String complemento;

	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String localidade;

	@Column(nullable = false)
	private String uf;

	public Endereco() {
	}

	public Endereco(String cep) {
		this.cep = cep;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EnderecoDTO toDTO() {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setBairro(bairro);
		enderecoDTO.setCep(cep);
		enderecoDTO.setComplemento(complemento);
		enderecoDTO.setLocalidade(localidade);
		enderecoDTO.setLogradouro(logradouro);
		enderecoDTO.setUf(uf);
		return enderecoDTO;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
	}

}
