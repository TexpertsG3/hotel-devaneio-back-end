package br.com.hotel.modelo;

import java.math.BigDecimal;
import java.util.Objects;

import com.hotels.tex.exception.SalarioInvalidoException;

public class Funcionario {

	private static final String MSG_SALARIO_INVALIDO = "O valor digitado é inválido. Deve ser maior que 0";

	private Integer idFuncionario;
	private String nome;
	private String sobrenome;
	private Cargo cargo;
	private BigDecimal salario;
	private Integer idHotel;

	public Funcionario(String nome, String sobrenome, Cargo cargo, BigDecimal salario, Integer idHotel) {
		this.idHotel = idHotel;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
		this.salario = salario;
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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
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
		return "\nNome: " + this.nome + "\nSobrenome: " + this.sobrenome + "\nCargo: " + this.cargo + "\nSalário: R$"
				+ this.salario;
	}

}
