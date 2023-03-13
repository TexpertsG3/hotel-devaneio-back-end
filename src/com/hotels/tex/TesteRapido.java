package com.hotels.tex;

import com.hotels.tex.dao.CargosDAO;
import com.hotels.tex.dao.ContatoDAO;
import com.hotels.tex.dao.HotelDAO;
import com.hotels.tex.model.Cargo;
import com.hotels.tex.model.Contato;

import java.sql.SQLException;

public class TesteRapido {
	
	public static void main(String[] args) throws SQLException {
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

		CargosDAO cargosDAO = new CargosDAO();
//		Cargo cargo = new Cargo("Gerente Comercial");
//		cargosDAO.insere(cargo);
//		Cargo cargo = new Cargo("Gerente de TI", 2);
//		cargosDAO.insere(cargo);
		Cargo cargo = cargosDAO.buscaPor(5);
		cargo.setNome("Gerente comercial");
		cargosDAO.update(cargo);
	}

}
