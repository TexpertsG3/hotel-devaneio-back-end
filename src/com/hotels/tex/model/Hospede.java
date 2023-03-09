package com.hotels.tex.model;

import java.util.Objects;

public class Hospede {

	private Integer idHospede;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String email;
	private String senha;
	private Hotel hotel;
	
	public Hospede(Integer idHospede) {
		this.idHospede = idHospede;
	}

	public Hospede(String nome, String sobrenome, String cpf, String email, String senha, Hotel hotel) {
		this.hotel = hotel;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public Integer getIdHospede() {
		return idHospede;
	}

	public void setIdHospede(Integer idHospede) {
		this.idHospede = idHospede;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospede other = (Hospede) obj;
		return Objects.equals(email, other.email) && Objects.equals(senha, other.senha);
	}

}
