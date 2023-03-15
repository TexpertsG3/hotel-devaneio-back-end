package com.hotels.tex.model;

public class Admin {

	private Integer idAdmin;
	private String nome;
	private String email;
	private String senha;
	private Contato idContato;
	private Endereco idEndereco;
	private Hotel idHotel;

	public Admin (Integer idAdmin, String nome) {
		this.idAdmin=idAdmin;
		this.nome=nome;
	}
	
	public Admin(Integer idAdmin, String nome, String email, String senha, Contato idContato, Endereco idEndereco,
			Hotel idHotel) {
		this.idAdmin = idAdmin;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idContato = idContato;
		this.idEndereco = idEndereco;
		this.idHotel = idHotel;
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Contato getIdContato() {
		return idContato;
	}

	public void setIdContato(Contato idContato) {
		this.idContato = idContato;
	}

	public Endereco getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Endereco idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Hotel getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Hotel idHotel) {
		this.idHotel = idHotel;
	}

	
	
	
}