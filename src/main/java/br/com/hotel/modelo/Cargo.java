package br.com.hotel.modelo;

public class Cargo {
	
	private Integer idCargo;
	private String nome;

	public Cargo(String nome) {
		this.nome = nome;

	}
	
	public Integer getIdCargo() {
		return idCargo;
	}
	
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.nome;
	}
}
