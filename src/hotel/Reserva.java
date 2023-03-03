package hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Reserva {

	private Hotel hotel;
	private Alojamento quarto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Hospede usuario;
	private Integer quantidadeAdultos;
	private Integer quantidadeCriancas;
	private Set<ServicoAdicional> servicoAdicional = new HashSet<>();

	public Reserva(Hotel hotel, Alojamento quarto, LocalDate checkIn, LocalDate checkOut, Hospede usuario,
			Integer quantidadeAdultos, Integer quantidadeCriancas, Set<ServicoAdicional> servicoAdicional) {
		this.hotel = hotel;
		this.quarto = quarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.usuario = usuario;
		this.quantidadeAdultos = quantidadeAdultos;
		this.quantidadeCriancas = quantidadeCriancas;
		this.servicoAdicional = servicoAdicional;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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

	@Override
	public String toString() {
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("Reserva efetuada com sucesso para o cliente: " + usuario.getNome());
		sb.append("\n\nDados da reserva:");
		sb.append("\nHotel: " + hotel.getDadosHotel().getNome());
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
