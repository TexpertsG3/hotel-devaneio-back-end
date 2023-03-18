package br.com.hotel.modelo;

import java.math.BigDecimal;

public class ServicoAdicional {

	private Integer idServico;
	private String nomeServico;
	private BigDecimal valorServico;
	private Integer idHotel;

	public ServicoAdicional(String nomeServico, BigDecimal valorServico, Integer idHotel) {
		this.idHotel = idHotel;
		this.nomeServico = nomeServico;
		this.valorServico = valorServico;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer hotel) {
		this.idHotel = hotel;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public void setValorServico(BigDecimal valorServico) {
		this.valorServico = valorServico;
	}

	@Override
	public String toString() {
		return "\nNome: " + this.nomeServico + "\n" + "Valor - R$" + this.valorServico + "\n";
	}

}
