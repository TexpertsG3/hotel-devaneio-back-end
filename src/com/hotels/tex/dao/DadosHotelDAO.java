package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotels.tex.model.DadosHotel;
import com.hotels.tex.utils.ConnectionFactory;

public class DadosHotelDAO {
	
	private static final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

	public void insere(DadosHotel dadosHotel) {
		
	
		String sql = "INSERT INTO dados_hotel (nome, cnpj, id_contato, id_endereco) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.criaConexao();
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, dadosHotel.getNome());
			st.setString(2, dadosHotel.getCnpj());
			st.setInt(3, dadosHotel.getContato().getIdContato());
			st.setInt(4, dadosHotel.getEndereco().getIdEndereco());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
			    ResultSet rs = st.getGeneratedKeys();
			    if (rs.next()) {
			        int idGerado = rs.getInt(1);
			        dadosHotel.setIdDadosHotel(idGerado);
			    }
			}    
		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + e.getMessage());
		}
	}
}
