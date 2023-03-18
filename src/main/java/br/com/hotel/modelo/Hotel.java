package br.com.hotel.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hotel {

	private Integer idHotel;
	private DadosHotel dadosHotel;
	private List<Alojamento> listaDeAlojamentos = new ArrayList<>();
	private Set<Funcionario> listaDeFuncionarios = new HashSet<>();
	private List<Reserva> listaDeReservas = new ArrayList<>();

	public Hotel(Integer idHotel) {
		this.idHotel = idHotel;
	}
	
	public Hotel(Integer idHotel, DadosHotel dadosHotel) {
		this.idHotel = idHotel;
		this.dadosHotel = dadosHotel;
	}

	public Hotel(DadosHotel dadosHotel) {
		this.dadosHotel = dadosHotel;
	}

	public Hotel(DadosHotel dadosHotel, List<Alojamento> listaDeAlojamentos, List<ServicoAdicional> listaDeServicos,
			Set<Funcionario> listaDeFuncionarios, List<Reserva> listaDeReservas) {

		this.dadosHotel = dadosHotel;
		this.listaDeAlojamentos = listaDeAlojamentos;
		this.listaDeFuncionarios = listaDeFuncionarios;
		this.listaDeReservas = listaDeReservas;
	}
	
	public Hotel() {
		
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public Integer getIdHotel() {
		return idHotel;
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

	public Set<Funcionario> getListaDeFuncionarios() {
		return listaDeFuncionarios;
	}

	public void setListaDeFuncionarios(Set<Funcionario> listaDeFuncionarios) {
		this.listaDeFuncionarios = listaDeFuncionarios;
	}

	public List<Reserva> getListaDeReservas() {
		return listaDeReservas;
	}

	public void setListaDeReservas(List<Reserva> listaDeReservas) {
		this.listaDeReservas = listaDeReservas;
	}

	public static BigDecimal somaServicos(List<ServicoAdicional> servicos) {
		BigDecimal resultado = BigDecimal.ZERO;
		for (ServicoAdicional servico : servicos) {
			resultado = resultado.add(servico.getValorServico());
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return "\nRegistro: " + idHotel +  "\nHotel: " + dadosHotel.getNome() + "\nCNPJ: " + dadosHotel.getCnpj() + "\nEmail: " + dadosHotel.getContato().getEmail() 
				+ "\nTelefone: " + dadosHotel.getContato().getTelefone() + " / Celular: " + dadosHotel.getContato().getCelular() 
				+ "\nEndereco: " + dadosHotel.getEndereco().getRua() + ", " + dadosHotel.getEndereco().getNumero() + " - Bairro: " + dadosHotel.getEndereco().getBairro() 
				+ "\nCidade: " + dadosHotel.getEndereco().getCidade() + " / " + dadosHotel.getEndereco().getUf() + "\nComplemento: " + dadosHotel.getEndereco().getComplemento() + "\n";
	}

}
