package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotels.tex.model.Admin;
import com.hotels.tex.model.Cargo;
import com.hotels.tex.model.Contato;
import com.hotels.tex.model.DadosHotel;
import com.hotels.tex.model.Endereco;
import com.hotels.tex.model.Funcionario;
import com.hotels.tex.model.Hotel;
import com.hotels.tex.utils.ConnectionFactory;



public class AdminDAO {

		    private final String ERRO_CONEXAO = "Erro na conex�o com o banco de dados. Verifique e tente novamente.";

		    public void insere(Admin admin) {
				


				String sql = "INSERT INTO administrador (nome_admin, senha_admin,"
                        + "id_contato, id_endereco, id_hotel) VALUES (?,?,?,?,?)";

				try (Connection conn = ConnectionFactory.criaConexao();
						PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
					st.setString(1, admin.getNome());
					st.setString(2, admin.getSenha());
					st.setInt(3, admin.getIdContato().getIdContato());
					st.setInt(4, admin.getIdEndereco().getIdEndereco());
					st.setInt(5, admin.getHotel().getIdHotel());
					int rowsAffected = st.executeUpdate();

					if (rowsAffected > 0) {

						ResultSet rs = st.getGeneratedKeys();
						if (rs.next()) {
							int idGerado = rs.getInt(1);
							admin.setIdAdmin(idGerado);

						}
					}

				} catch (SQLException e) {
					System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
				}

			}

					
//		    public void update(Admin admin) {
//
//		    	String sql = "UPDATE administrador SET senha_admin = ?, id_contato = ?, id_endereco = ? WHERE " +
//					    "id_administrador = ?";
//
//		        try (Connection conn = ConnectionFactory.criaConexao();
//		             PreparedStatement st = conn.prepareStatement(sql)) {
//		            st.setString(1, admin.getEmail());
//		            st.setString(2, admin.getSenha());
//		            st.setInt(3, admin.getIdContato().getIdContato());
//		            st.setInt(4, admin.getIdEndereco().getIdEndereco());
//		            st.setInt(6, admin.getIdAdmin());
//		            st.execute();
//		            System.out.println("Dados alterados com sucesso!");
//
//		        } catch (SQLException e) {
//		            throw new RuntimeException("Erro ao atualizar o administrador, tente novamente ap�s verificar a causa. " +
//		                    "Causa:"
//		                    + e.getMessage());
//		        }
//		    }

		    public Admin buscaPor(int id) throws SQLException {
		        Admin admin = null;

		        String sql = "SELECT * FROM administrador WHERE id_administrador = ?";

		        try (Connection conn = ConnectionFactory.criaConexao();
		             PreparedStatement st = conn.prepareStatement(sql)) {
		            st.setInt(1, id);
		            ResultSet rs = st.executeQuery();

		            if (rs.next()) {
		                admin = new Admin(
		                		rs.getInt("id_administrador"),
		                		rs.getString("nome_admin")
		                        
		                );

		            }

		        } catch (SQLException e) {
		            throw new RuntimeException("Erro ao localizar o administrador, tente novamente ap�s verificar a causa. \nCausa:"
		                    + e.getMessage());
		        }
		        return admin;

		    }
		    	    
		    public void delete(Integer idAdmin) {
		        String sql = "SELECT * FROM administrador WHERE id_administrador = ?";

		        String sql2 = "DELETE FROM administrador WHERE id_administrador = ?";

		        try (Connection conn = ConnectionFactory.criaConexao();
		             PreparedStatement st1 = conn.prepareStatement(sql);
		             PreparedStatement st2 = conn.prepareStatement(sql2)) {

		            st1.setInt(1, idAdmin);
		            ResultSet rs = st1.executeQuery();

		            if (!rs.next()) {
		                throw new SQLException("N�o existe nenhum administrador cadastrado no id " + idAdmin);
		            }

		            System.out.println("Administrador de id " + idAdmin + " deletado com suceso!");

		            st2.setInt(1, idAdmin);
		            st2.executeUpdate();


		        } catch (SQLException e) {
		            throw new RuntimeException("Erro ao verificar se existe um administrador com o id " + idAdmin + ": " + e.getMessage());
		        }
		    }
		}
		
