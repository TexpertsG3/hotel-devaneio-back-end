package hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Reserva {

	private Alojamento quarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Hospede usuario;
	private Integer quantidadeAdultos;
	private Integer quantidadeCriancas;
	private Set<ServicoAdicional> servicoAdicional = new HashSet<>();

	public Reserva(Alojamento quarto, LocalDate checkIn, LocalDate checkOut, Hospede usuario,
			Integer quantidadeAdultos, Integer quantidadeCriancas, Set<ServicoAdicional> servicoAdicional) {
		this.quarto = quarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.usuario = usuario;
		this.quantidadeAdultos = quantidadeAdultos;
		this.quantidadeCriancas = quantidadeCriancas;
		this.servicoAdicional = servicoAdicional;
	}

	public Alojamento getQuarto() {
		return quarto;
	}
	
	public void setQuarto(Alojamento quarto) {
		this.quarto = quarto;
	}
	
	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Hospede getUsuario() {
		return usuario;
	}

	public void setUsuario(Hospede usuario) {
		this.usuario = usuario;
	}

	public Integer getQuantidadeAdultos() {
		return quantidadeAdultos;
	}

	public void setQuantidadeAdultos(Integer quantidadeAdultos) {
		this.quantidadeAdultos = quantidadeAdultos;
	}

	public Integer getQuantidadeCriancas() {
		return quantidadeCriancas;
	}

	public void setQuantidadeCriancas(Integer quantidadeCriancas) {
		this.quantidadeCriancas = quantidadeCriancas;
	}

	public Set<ServicoAdicional> getServicoAdicional() {
		return servicoAdicional;
	}

	public void setServicoAdicional(Set<ServicoAdicional> servicoAdicional) {
		this.servicoAdicional = servicoAdicional;
	}
			
	public BigDecimal calculaValorDiaria(Reserva reserva) {
		BigDecimal totalDiaria = BigDecimal.ZERO;
		
		if (quantidadeAdultos > 2) {
			BigDecimal temp = new BigDecimal(quantidadeAdultos-2).multiply(BigDecimal.valueOf(10.00));
			totalDiaria = totalDiaria.add(temp);
		}
		
		Integer dias = Integer.valueOf(checkOut.getDayOfYear() - checkIn.getDayOfYear());
		
		totalDiaria = totalDiaria.add(quarto.getValor());
		totalDiaria = totalDiaria.multiply(new BigDecimal(dias));
		
		return totalDiaria;
	}
	
	public BigDecimal calculaTotalReserva(Set<ServicoAdicional> servicoAdicional, Reserva reserva) {
		BigDecimal diaria = calculaValorDiaria(reserva);
		BigDecimal servico = ServicoAdicional.calculaValorServico(servicoAdicional);
		
		BigDecimal total = BigDecimal.ZERO;
		total = total.add(diaria).add(servico);
		
		return total;
	}

	@Override
	public String toString() {
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva efetuada com sucesso para o cliente: " + usuario.getNome());
		sb.append("\n\nDados da reserva:");
		sb.append("\nQuarto: " + quarto.getNomeAlojamento());
		sb.append("\nData do CheckIn: " + checkIn.format(dataFormatada));
		sb.append("\nData do Checkout: " + checkOut.format(dataFormatada));
		sb.append("\nQuantidade de adultos: " + quantidadeAdultos);
		sb.append("\nQuantidade de crianças: " + quantidadeCriancas);
		sb.append("\nServiços adicionais selecionados:\n");
		for (ServicoAdicional servico : servicoAdicional) {
			sb.append(servico.getNomeServico()).append(" - ");
		}
		return sb.toString();
	}
	
}
