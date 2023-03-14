package com.hotels.tex.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.hotels.tex.exception.SalarioInvalidoException;

public class Funcionario {

	private static final String MSG_SALARIO_INVALIDO = "O valor digitado é inválido. Deve ser maior que 0";

	private Integer idFuncionario;
	private String nome;
	private String sobrenome;
	private BigDecimal salario;
	private String cpf;
	private Cargo cargo;
	private Endereco endereco;
	private Contato contato;
	private Hotel hotel;

	
	public Funcionario (Integer idFuncionario, String nome) {
		this.idFuncionario=idFuncionario;
		this.nome=nome;
	}
	

	public Funcionario(Integer idFuncionario, String nome, String sobrenome, BigDecimal salario, String cpf,
			Cargo cargo, Endereco endereco, Contato contato, Hotel hotel) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.salario = salario;
		this.cpf = cpf;
		this.cargo = cargo;
		this.endereco = endereco;
		this.contato = contato;
		this.hotel = hotel;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void modificarSalarioFuncionario(BigDecimal novoSalario) {
		if (novoSalario.compareTo(BigDecimal.ZERO) > 0) {
			this.salario = novoSalario;
		} else {
			throw new SalarioInvalidoException(MSG_SALARIO_INVALIDO);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}

	@Override
	public String toString() {
		return "Funcionario: " + nome + " " + sobrenome + " /nCPF= " + cpf + " /nCargo= " + cargo + "/nSalário=" + salario;
	}	

}
