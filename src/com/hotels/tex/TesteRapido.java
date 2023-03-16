package com.hotels.tex;

import com.hotels.tex.dao.*;
import com.hotels.tex.model.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class TesteRapido {
	
	public static void main(String[] args) throws SQLException {
//
//		HotelDAO hotelDAO = new HotelDAO();
//
//		System.out.println(hotelDAO.procurarHotelPorId(1));
//
//		hotelDAO.delete(1);

//		Cargo cargo = new Cargo("Patrão");
//		CargosDAO cargosDAO = new CargosDAO();
//		cargosDAO.insere(cargo);
//		Cargo cargo1 = cargosDAO.buscaPor(1);
//		cargo1.setNome("Boss");
//		cargosDAO.update(cargo1);
//
//		Contato contato = new Contato("tex.devaneio@tex.com", "(99) 6661-6661", "(99) 9-9999-9999");
//		ContatoDAO contatoDAO = new ContatoDAO();
//  	contatoDAO.insere(contato);
//		Contato contato = contatoDAO.buscaPor(1);
//		contato1.setCelular("(54) 9-3618-1097");
//		contato1.setEmail("devaneio.tex@tex.com");
//		contatoDAO.update(contato1);

//		EnderecoDAO enderecoDAO = new EnderecoDAO();
//		Endereco endereco = enderecoDAO.buscaPor(1);
//
//
		HotelDAO hotelDAO = new HotelDAO();
		Hotel hotel = hotelDAO.procurarHotelPorId(1);
//
//
//		Admin admin = new Admin("Albino", "1234", contato, endereco, hotel);
//		AdminDAO adminDAO = new AdminDAO();
//		adminDAO.insere(admin);




//		CargosDAO cargosDAO = new CargosDAO();
//		Cargo cargo = cargosDAO.buscaPor(1);
//
//
//		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//		Funcionario funcionario = new Funcionario("Albino", "Marques",new BigDecimal("1300.00") , "040.184.420-09",
//				cargo, endereco,contato, hotel	);
//		funcionarioDAO.insere(funcionario);


		ReservaDAO reservaDAO = new ReservaDAO();
//		(Hotel hotel, Alojamento quarto, LocalDate checkIn, LocalDate checkOut, Hospede hospede,
//				Integer quantidadeAdultos, Integer quantidadeCriancas, BigDecimal totalServicos, BigDecimal totalReserva,
//				Set<ServicoAdicional> servicoAdicional)
//		Reserva reserva = new Reserva(hotel, );



	}

}
