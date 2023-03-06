package com.hotels.tex.model;

public class Endereco {

	private Integer idEndereco;
	private String rua;
	private String bairro;
	private Integer numero;
	private String cep;
	private String cidade;
	private String uf;
	private String complemento;

	public Endereco(String rua, String bairro, Integer numero, String cep, String cidade, String uf,
			String complemento) {
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
