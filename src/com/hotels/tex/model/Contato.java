package com.hotels.tex.model;

public class Contato {

	private int idContato;
	private String email;
	private String telefone;
	private String celular;

	public Contato(String email, String telefone, String celular, int idContato) {
		this.idContato = idContato;
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}
	public Contato(String email, String telefone, String celular) {
		this.email = email;
		this.telefone = telefone;
		this.celular = celular;
	}

	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}