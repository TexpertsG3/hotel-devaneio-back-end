package com.hotels.tex;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.hotels.tex.dao.FuncionarioDAO;
import com.hotels.tex.model.Cargo;
import com.hotels.tex.model.Contato;
import com.hotels.tex.model.Endereco;
import com.hotels.tex.model.Funcionario;
import com.hotels.tex.model.Hotel;

public class TesteRapido {
	
	public static void main(String[] args) throws SQLException {
		
		
		//(Integer idFuncionario, String nome, String sobrenome, BigDecimal salario, String cpf, 
		//Cargo cargo, Endereco endereco, Contato contato, Hotel hotel) 
		
//		Cargo cargo = new Cargo(1);
//		Endereco endereco = new Endereco(1);
//		Contato contato = new Contato(1);
//		Hotel hotel = new Hotel(1);
//		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
//		Funcionario funcionario = new Funcionario("Funcionario3","Sobrenome3",
//				new BigDecimal("800.00"),"111.000.000-00",cargo,endereco,contato,hotel);
		//funcionarioDAO.insere(funcionario);
		
		
		Funcionario funcionario = new Funcionario(1);
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionarioTeste = funcionarioDAO.buscaPor(1);
		funcionarioTeste.setNome("João da Silva");
		System.out.println("Funcionário de id: " + funcionarioTeste);
		funcionarioDAO.update(funcionarioTeste);		
		Funcionario novoFuncionario = funcionarioDAO.buscaPor(1);
		funcionarioDAO.update(novoFuncionario);
		System.out.println("Funcionário atualizado com sucesso");
		
		
		
		
		
		
		
		
//
//		HotelDAO hotelDAO = new HotelDAO();
//
//		System.out.println(hotelDAO.procurarHotelPorId(1));
//
//		hotelDAO.delete(1);

//		ContatoDAO contatoDAO = new ContatoDAO();
//		Contato contato = contatoDAO.buscaPor(2);
//		contato.setTelefone("(99) 9999-9999");
//		contatoDAO.update(contato);
//		Contato contatoAlterado = contatoDAO.buscaPor(4);
//		System.out.println(contatoAlterado);

//		CargosDAO cargosDAO = new CargosDAO();
//		Cargo cargo = new Cargo("Gerente Comercial");
//		cargosDAO.insere(cargo);
//		Cargo cargo = new Cargo("Gerente de TI", 2);
//		cargosDAO.insere(cargo);
//		Cargo cargo = cargosDAO.buscaPor(5);
//		cargo.setNome("Gerente comercial");
//		cargosDAO.update(cargo);
	}

}
