package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotels.tex.model.ServicoAdicional;
import com.hotels.tex.utils.ConnectionFactory;

public class ServicoAdicionalDAO {
	
	private static final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

	HotelDAO hotelDao = new HotelDAO();

	public void insere(ServicoAdicional servicoAdicional) {

		String sql = "insert into servico_adicional (nome, preco, id_hotel) values(?,?,?)";

		try (Connection conn = ConnectionFactory.criaConexao(); 
				PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, servicoAdicional.getNomeServico());
			st.setBigDecimal(2, servicoAdicional.getValorServico());
			st.setInt(3, servicoAdicional.getIdHotel());

			hotelDao.procurarHotelPorId(servicoAdicional.getIdHotel());

			st.execute();
			System.out.println("Serviço " + servicoAdicional.getNomeServico() + " adicionado com sucesso.");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public List<ServicoAdicional> listagem() {

		String sql = "select nome, preco, id_hotel from servico_adicional";
		List<ServicoAdicional> lista = new ArrayList<>();

		try (Connection conn = ConnectionFactory.criaConexao();
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery()) {

			while (rs.next()) {

				ServicoAdicional servico = new ServicoAdicional(rs.getString(1), rs.getBigDecimal(2), rs.getInt(3));
				lista.add(servico);
			}

		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + e.getMessage());
		}

		return lista;

	}

}
