package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotels.tex.model.Contato;
import com.hotels.tex.model.Endereco;
import com.hotels.tex.utils.ConnectionFactory;

public class EnderecoDAO {
	
	private final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

	public void insere(Endereco endereco) {

		String sql = "INSERT INTO endereco (rua, bairro, numero, cep, cidade, uf, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.criaConexao(); 
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			st.setString(1, endereco.getRua());
			st.setString(2, endereco.getBairro());
			st.setInt(3, endereco.getNumero());
			st.setString(4, endereco.getCep());
			st.setString(5, endereco.getCidade());
			st.setString(6, endereco.getUf());
			st.setString(7, endereco.getComplemento());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
			    ResultSet rs = st.getGeneratedKeys();
			    if (rs.next()) {
			        int idGerado = rs.getInt(1);
			        endereco.setIdEndereco(idGerado);
			    }
			}    
			
		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
		}
	}
	
	public void delete(Integer idEndereco) {
		String sql = "SELECT * FROM endereco WHERE id_endereco = ?";
		
		String sql2 = "DELETE FROM endereco WHERE id_endereco = ?";
		
		try (Connection conn = ConnectionFactory.criaConexao();
		    	 PreparedStatement st1 = conn.prepareStatement(sql);
		    	 PreparedStatement st2 = conn.prepareStatement(sql2)) {

				st1.setInt(1, idEndereco);
		        ResultSet rs = st1.executeQuery();
		             
		        if (!rs.next()) {
		            throw new SQLException("Não existe nenhum endereco com o id " + idEndereco);
		        }
		        
		        st2.setInt(1, idEndereco);
		        st2.executeUpdate();
		        
		
		} catch (SQLException e) {
	        throw new RuntimeException("Erro ao verificar se existe um endereco com o id " + idEndereco + ": " + e.getMessage());
	    }
	}

	public Endereco buscaPor(Integer id) throws SQLException {
		Endereco endereco = null;

		String sql = "SELECT * FROM endereco WHERE id_endereco = ?";

		try (Connection conn = ConnectionFactory.criaConexao();
		     PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();


			if (rs.next()) {
				endereco = new Endereco(
						rs.getInt("id_endereco"),
						rs.getString("rua"),
						rs.getString("bairro"),
						rs.getInt("numero"),
						rs.getString("cep"),
						rs.getString("cidade"),
						rs.getString("uf"),
						rs.getString("complemento")
				);

			}

		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar o endereço, tente novamente após verificar a causa. Causa:"
					+ e.getMessage());
		}
		return endereco;

	}
}
