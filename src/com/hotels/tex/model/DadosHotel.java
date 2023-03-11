package com.hotels.tex.model;

public class DadosHotel {

	private Integer idDadosHotel;
	private String nome;
	private String cnpj;
	private Contato contato;
	private Endereco endereco;

	public DadosHotel(String nome, String cnpj, Contato contato, Endereco endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.contato = contato;
		this.endereco = endereco;
	}
	
	public DadosHotel(Integer idDadosHotel) {
		this.idDadosHotel = idDadosHotel;
	}

	public DadosHotel(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public Integer getIdDadosHotel() {
		return idDadosHotel;
	}

	public void setIdDadosHotel(Integer idDadosHotel) {
		this.idDadosHotel = idDadosHotel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
