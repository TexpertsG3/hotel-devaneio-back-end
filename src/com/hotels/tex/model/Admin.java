package com.hotels.tex.model;

public class Admin {

	private Integer idAdmin;
	private String nome;
	private String email;
	private String senha;
	private Integer idHotel;

	public Admin(String nome, String email, String senha, Integer idHotel) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

}
