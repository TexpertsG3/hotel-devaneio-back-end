package hotel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ServicoAdicional {
	private String nomeServico;
	private BigDecimal valorServico;

	public ServicoAdicional(String nomeServico, BigDecimal valorServico) {
		this.nomeServico = nomeServico;
		this.valorServico = valorServico;
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
		return this.nomeServico + "\n" + "Valor - R$" + this.valorServico + "\n";
	}

}
