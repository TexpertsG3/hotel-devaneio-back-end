package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotels.tex.model.Alojamento;
import com.hotels.tex.model.Hotel;
import com.hotels.tex.utils.ConnectionFactory;

public class AlojamentoDAO {

	private final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

	public void insere(Alojamento alojamento) {

		String sql = "insert into quarto (nome, descricao, preco, id_hotel) "
				+ "values(?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.criaConexao(); 
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, alojamento.getNomeAlojamento());
			st.setString(2, alojamento.getDescricao());
			st.setBigDecimal(3, alojamento.getValor());
			st.setInt(4, alojamento.getHotel().getIdHotel());
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				
			    ResultSet rs = st.getGeneratedKeys();
			    if (rs.next()) {
			        int idGerado = rs.getInt(1);
			        alojamento.setIdAlojamento(idGerado);
			        
			    }
			}    

		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
		}
	}
	
	public List<Alojamento> listagem() {

		String sql = "SELECT q.id_quarto, q.nome, q.descricao, q.valor, h.id_hotel FROM quarto q INNER JOIN hotel h ON q.id_hotel = h.id_hotel";
		List<Alojamento> lista = new ArrayList<>();

		try (Connection conn = ConnectionFactory.criaConexao();
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery()) {

			while (rs.next()) {

				Hotel hotel = new Hotel(rs.getInt("id_hotel"));
				Alojamento alojamento = new Alojamento(rs.getInt("id_quarto"), rs.getString("nome"), rs.getString("descricao"), rs.getBigDecimal("valor"), hotel);
				lista.add(alojamento);
			}

		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
		}

		return lista;

	}

}
