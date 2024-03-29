package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotels.tex.model.Contato;
import com.hotels.tex.utils.ConnectionFactory;

public class ContatoDAO {
	
	private final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

	public void insere(Contato contato) {

		String sql = "insert into contato (email, telefone, celular) values(?, ?, ?)";

		try (Connection conn = ConnectionFactory.criaConexao();
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, contato.getEmail());
			st.setString(2, contato.getTelefone());
			st.setString(3, contato.getCelular());
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				
			    ResultSet rs = st.getGeneratedKeys();
			    if (rs.next()) {
			        int idGerado = rs.getInt(1);
			        contato.setIdContato(idGerado);
			        
			    }
			}    
			
		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
		}
	}
	
	public void delete(Integer idContato) {
		String sql = "SELECT * FROM contato WHERE id_contato = ?";
		
		String sql2 = "DELETE FROM contato WHERE id_contato = ?";
		
		try (Connection conn = ConnectionFactory.criaConexao();
		    	 PreparedStatement st1 = conn.prepareStatement(sql);
		    	 PreparedStatement st2 = conn.prepareStatement(sql2)) {

				st1.setInt(1, idContato);
		        ResultSet rs = st1.executeQuery();
		             
		        if (!rs.next()) {
		            throw new SQLException("Não existe nenhum contato com o id " + idContato);
		        }
		        
		        st2.setInt(1, idContato);
		        st2.executeUpdate();
		        
		
		} catch (SQLException e) {
	        throw new RuntimeException("Erro ao verificar se existe um contato com o id " + idContato + ": " + e.getMessage());
	    }
	}
}
