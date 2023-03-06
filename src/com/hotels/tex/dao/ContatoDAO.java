package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotels.tex.model.Contato;
import com.hotels.tex.utils.ConnectionFactory;

public class ContatoDAO {
	
	private static final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

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
			System.err.println(ERRO_CONEXAO + e.getMessage());
		}
	}
}
