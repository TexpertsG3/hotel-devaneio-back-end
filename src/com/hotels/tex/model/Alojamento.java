package com.hotels.tex.model;

import java.math.BigDecimal;

public class Alojamento {

	private Integer idAlojamento;
	private String nomeAlojamento;
	private String descricao;
	private BigDecimal valor;
	private Hotel hotel;
	
	public Alojamento(Integer idAlojamento) {
		this.idAlojamento = idAlojamento;
	}
	
	public Alojamento(Integer idAlojamento, String nomeAlojamento) {
		this.idAlojamento = idAlojamento;
		this.nomeAlojamento = nomeAlojamento;
	}

	public Alojamento(String nomeAlojamento, String descricao, BigDecimal valor, Hotel hotel) {
		this.hotel = hotel;
		this.nomeAlojamento = nomeAlojamento;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Alojamento(Integer idAlojamento, String nomeAlojamento, String descricao, BigDecimal valor, Hotel hotel) {
		this.idAlojamento = idAlojamento;
		this.hotel = hotel;
		this.nomeAlojamento = nomeAlojamento;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Integer getIdAlojamento() {
		return idAlojamento;
	}

	public void setIdAlojamento(Integer idAlojamento) {
		this.idAlojamento = idAlojamento;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getNomeAlojamento() {
		return nomeAlojamento;
	}

	public void setNomeAlojamento(String nomeAlojamento) {
		this.nomeAlojamento = nomeAlojamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {

		return "\nRegistro do Hotel: " + hotel.getIdHotel() + "    " + "Nome: " + hotel.getDadosHotel().getNome()
				+ "\nAlojamento - " + this.nomeAlojamento + "\n" + "Valor da diária - R$" + this.valor;
	}

}
