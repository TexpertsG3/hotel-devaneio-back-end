package hotel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hotel {

	private DadosHotel dadosHotel;
	private List<Alojamento> listaDeAlojamentos = new ArrayList<>();
	private List<ServicoAdicional> listaDeServicos = new ArrayList<>();
	private Set<Funcionario> listaDeFuncionarios = new HashSet<>();
	private Reserva reserva;

	public Hotel() {

	}
	
	public Hotel(DadosHotel dadosHotel) {
		this.dadosHotel = dadosHotel;
	}

	public Hotel(DadosHotel dadosHotel, List<Alojamento> listaDeAlojamentos, List<ServicoAdicional> listaDeServicos,
			Set<Funcionario> listaDeFuncionarios, Reserva reserva) {

		this.dadosHotel = dadosHotel;
		this.listaDeAlojamentos = listaDeAlojamentos;
		this.listaDeServicos = listaDeServicos;
		this.listaDeFuncionarios = listaDeFuncionarios;
		this.reserva = reserva;
	}

	

	public DadosHotel getDadosHotel() {
		return dadosHotel;
	}

	public void setDadosHotel(DadosHotel dadosHotel) {
		this.dadosHotel = dadosHotel;
	}

	public List<Alojamento> getListaDeAlojamentos() {
		return listaDeAlojamentos;
	}

	public void setListaDeAlojamentos(List<Alojamento> listaDeAlojamentos) {
		this.listaDeAlojamentos = listaDeAlojamentos;
	}

	public List<ServicoAdicional> getListaDeServicos() {
		return listaDeServicos;
	}

	public void setListaDeServicos(List<ServicoAdicional> listaDeServicos) {
		this.listaDeServicos = listaDeServicos;
	}

	public Set<Funcionario> getListaDeFuncionarios() {
		return listaDeFuncionarios;
	}

	public void setListaDeFuncionarios(Set<Funcionario> listaDeFuncionarios) {
		this.listaDeFuncionarios = listaDeFuncionarios;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	public void cadastrarQuarto(String quarto, BigDecimal preco) {
		this.listaDeAlojamentos.add(new Alojamento(quarto, preco));
	}
	
	public void cadastrarServicoAdicional(ServicoAdicional servico) {
		this.listaDeServicos.add(servico);
	}

	@Override
	public String toString() {

		return "Hotel - " + this.dadosHotel.getNome() + "\n" + "Rua - " + this.dadosHotel.getEndereco().getRua() +
				"\nBairro - " + this.dadosHotel.getEndereco().getBairro() + 
				"\nCidade - " + this.dadosHotel.getEndereco().getCidade() + 
				"\nEstado - " + this.dadosHotel.getEndereco().getEstado() + 
				"\nCEP - " + this.dadosHotel.getEndereco().getCep() + 
				"\nCNPJ - " + this.dadosHotel.getCnpj();
	}

}
