package hotel;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import exception.SalarioInvalidoException;

public class Funcionario {
	
	private static final String MSG_SALARIO_INVALIDO = "O valor digitado é inválido. Deve ser maior que 0";
	
	private String nome;
	private String sobrenome;
	private Cargo cargo;
	private BigDecimal salario;
	
	public Funcionario(String nome, String sobrenome, Cargo cargo, BigDecimal salario) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
		this.salario = salario;
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

	public void modificarSalarioFuncionario (BigDecimal novoSalario) {
		if(novoSalario.compareTo(BigDecimal.ZERO) > 0) {
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
		return "\nNome: " + this.nome
				+ "\nSobrenome: " + this.sobrenome
				+ "\nCargo: " + this.cargo
				+ "\nSalário: R$" + this.salario;
	}
	
}
