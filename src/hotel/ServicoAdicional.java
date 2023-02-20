package hotel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public enum ServicoAdicional {
	
	GUIA_TURISTICO("Guia Turístico", new BigDecimal("100.00")),
	PASSEIO_NAS_DUNAS("Passeio nas Dunas", new BigDecimal("150.00")),
	TRATAMENTO_SPA("Tratamento Spa", new BigDecimal("150.00")),
	AUTITORIO_DE_EVENTOS("Auditório de Eventos", new BigDecimal("300.00")),
	ESPACO_KIDS("Espaço Kids", new BigDecimal("200.00"));

	private String nomeServico;
	private BigDecimal valorServico;

	private ServicoAdicional(String nomeServico, BigDecimal valorServico) {
		this.nomeServico = nomeServico;
		this.valorServico = valorServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public BigDecimal getValorServico() {
		return valorServico;
	}

	public static BigDecimal somaServicos(List<ServicoAdicional> servicos) {
		BigDecimal resultado = BigDecimal.ZERO;
		for (ServicoAdicional servico : servicos) {
			resultado = resultado.add(servico.getValorServico());
		}
		return resultado;
	}
	
	public static BigDecimal calculaValorServico(Set<ServicoAdicional> servicos) {
		BigDecimal totalServico = BigDecimal.ZERO;
		
		for (ServicoAdicional servico : servicos) {
			totalServico = totalServico.add(servico.getValorServico());
		}
		return totalServico;
	}
	
	public static List<ServicoAdicional> gerarListaDeServicos() {
		List<ServicoAdicional> lista = new ArrayList<>();
		lista.add(GUIA_TURISTICO);
		lista.add(PASSEIO_NAS_DUNAS);
		lista.add(TRATAMENTO_SPA);
		lista.add(AUTITORIO_DE_EVENTOS);
		lista.add(ESPACO_KIDS);
		return lista;
	}
			
	@Override
	public String toString() {
		
		return this.nomeServico + "\n" + "Valor - R$" + this.valorServico + "\n";
	}

}
