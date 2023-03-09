package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotels.tex.model.Contato;
import com.hotels.tex.model.DadosHotel;
import com.hotels.tex.model.Endereco;
import com.hotels.tex.model.Hotel;
import com.hotels.tex.utils.ConnectionFactory;

public class HotelDAO {
	
	private EnderecoDAO enderecoDao = new EnderecoDAO();
	private ContatoDAO contatoDAO = new ContatoDAO();
	private DadosHotelDAO dadosHotelDAO = new DadosHotelDAO();
	
	private final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

	public void insere(Hotel hotel) {
		
		String sql = "INSERT INTO hotel (id_dados_hotel) VALUES (?)";

		try (Connection conn = ConnectionFactory.criaConexao();
			 PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			st.setInt(1, hotel.getDadosHotel().getIdDadosHotel());
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				
			    ResultSet rs = st.getGeneratedKeys();
			    if (rs.next()) {
			        int idGerado = rs.getInt(1);
			        hotel.setIdHotel(idGerado);
			        
			    }
			}
			
		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
		}	

	}

	public List<Hotel> listagem() {
		List<Hotel> hotels = new ArrayList<>();
	    String sql = "SELECT * FROM hotel "
	    		+ "INNER JOIN dados_hotel ON hotel.id_dados_hotel = dados_hotel.id_dados_hotel "
	    		+ "INNER JOIN contato ON dados_hotel.id_contato = contato.id_contato "
	    		+ "INNER JOIN endereco ON dados_hotel.id_endereco = endereco.id_endereco";

	    try (Connection conn = ConnectionFactory.criaConexao();
	         PreparedStatement statement = conn.prepareStatement(sql);
	         ResultSet resultSet = statement.executeQuery()) {
	        
	        while (resultSet.next()) {
	            Contato contato = new Contato(resultSet.getString("email"),
	                                          resultSet.getString("telefone"),
	                                          resultSet.getString("celular"));
	            
	            Endereco endereco = new Endereco(resultSet.getString("rua"),
	                                             resultSet.getString("bairro"),
	                                             resultSet.getInt("numero"),
	                                             resultSet.getString("cep"),
	                                             resultSet.getString("cidade"),
	                                             resultSet.getString("uf"),
	                                             resultSet.getString("complemento"));
	            
	            DadosHotel dados = new DadosHotel(resultSet.getString("nome"),
	            								  resultSet.getString("cnpj"),
	            								  contato, endereco);
	            
	            Hotel hotel = new Hotel(resultSet.getInt("id_hotel"), dados);
	            hotel.setDadosHotel(dados);
	            hotels.add(hotel);
	        }
	    } catch (SQLException e) {
	        System.err.println(ERRO_CONEXAO + e.getMessage());
	    }

	    return hotels;
	}
	
	public void procurarHotelPorId(Integer id) {
	    String sql = "SELECT * FROM hotel WHERE id_hotel = ?";
	    try (Connection conn = ConnectionFactory.criaConexao();
	    	 PreparedStatement stmt = conn.prepareStatement(sql);){

	    	stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (!rs.next()) {
	            throw new SQLException("Não existe nenhum hotel com o id " + id);
	        }
	        
	    } catch (SQLException e) {
	        throw new RuntimeException("Erro ao verificar se existe um hotel com o id " + id + ": " + e.getMessage());
	    }
	}
	
	public void delete(Integer idHotel) {
		String sql = "SELECT * FROM hotel "
	    		+ "INNER JOIN dados_hotel ON hotel.id_dados_hotel = dados_hotel.id_dados_hotel "
	    		+ "INNER JOIN contato ON dados_hotel.id_contato = contato.id_contato "
	    		+ "INNER JOIN endereco ON dados_hotel.id_endereco = endereco.id_endereco WHERE hotel.id_hotel = ?";
		
		String sql2 = "DELETE FROM hotel WHERE id_hotel = ?";
		
		try (Connection conn = ConnectionFactory.criaConexao();
		    	 PreparedStatement st = conn.prepareStatement(sql);
				 PreparedStatement st2 = conn.prepareStatement(sql2)){

				st.setInt(1, idHotel);
		        ResultSet rs = st.executeQuery();
		        		        		        
		        if (!rs.next()) {
		            throw new SQLException("Não existe nenhum hotel com o id " + idHotel);
		        }
		        int idContato = rs.getInt("id_contato");
		        int idEndereco = rs.getInt("id_endereco");
		        int idDados = rs.getInt("id_dados_hotel");
		       
		        st2.setInt(1, idHotel);
		        st2.executeUpdate();
		        
		        dadosHotelDAO.delete(idDados);
		        contatoDAO.delete(idContato);
		        enderecoDao.delete(idEndereco);
		
		} catch (SQLException e) {
	        throw new RuntimeException("Erro ao verificar se existe um hotel com o id " + idHotel + ": " + e.getMessage());
	    }
	}

}
