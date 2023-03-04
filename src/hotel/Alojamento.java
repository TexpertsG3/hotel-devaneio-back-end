package hotel;

import java.math.BigDecimal;

public class Alojamento {

	private Integer idAlojamento;
	private String nomeAlojamento;
	private BigDecimal valor;
	private Integer idHotel;

	public Alojamento(String nomeAlojamento, BigDecimal valor, Integer idHotel) {
		this.idHotel = idHotel;
		this.nomeAlojamento = nomeAlojamento;
		this.valor = valor;
	}

	public Integer getIdAlojamento() {
		return idAlojamento;
	}

	public void setIdAlojamento(Integer idAlojamento) {
		this.idAlojamento = idAlojamento;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public String getNomeAlojamento() {
		return nomeAlojamento;
	}

	public void setNomeAlojamento(String nomeAlojamento) {
		this.nomeAlojamento = nomeAlojamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {

		return "Alojamento - " + this.nomeAlojamento + "\n" + "Valor da diária - R$" + this.valor;
	}

}
