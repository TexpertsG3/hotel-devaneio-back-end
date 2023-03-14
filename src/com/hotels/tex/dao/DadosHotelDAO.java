package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotels.tex.model.DadosHotel;
import com.hotels.tex.utils.ConnectionFactory;

public class DadosHotelDAO {
	
	private final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

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
			System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
		}
	}
	
	public void update(DadosHotel dadosHotel) {
		String sql = "update dados_hotel set nome=?, cnpj=?, id_contato=?, id_endereco=? where id =? ";
		try (Connection conn = ConnectionFactory.criaConexao();
				PreparedStatement st = conn.prepareStatement(sql)) {
			 	st.setString(1, dadosHotel.getNome());
			 	st.setString(2,  dadosHotel.getCnpj());
			 	st.setInt(3, dadosHotel.getContato().getIdContato());
			 	st.setInt(4, dadosHotel.getEndereco().getIdEndereco());
			 	st.setInt(5, dadosHotel.getIdDadosHotel());
			 	st.execute();
		
		
		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + e.getMessage());
		}
	}
	
	
	public void delete(Integer idDadosHotel) {
		String sql = "SELECT * FROM dados_hotel WHERE id_dados_hotel = ?";
		
		String sql2 = "DELETE FROM dados_hotel WHERE id_dados_hotel = ?";
		
		try (Connection conn = ConnectionFactory.criaConexao();
		    	 PreparedStatement st1 = conn.prepareStatement(sql);
		    	 PreparedStatement st2 = conn.prepareStatement(sql2)) {

				st1.setInt(1, idDadosHotel);
		        ResultSet rs = st1.executeQuery();
		             
		        if (!rs.next()) {
		            throw new SQLException("Não existe nenhum dado com o id " + idDadosHotel);
		        }
		        
		        st2.setInt(1, idDadosHotel);
		        st2.executeUpdate();
		        
		
		} catch (SQLException e) {
	        throw new RuntimeException("Erro ao verificar se existe um dado com o id " + idDadosHotel + ": " + e.getMessage());
	    }
	}
	
}
