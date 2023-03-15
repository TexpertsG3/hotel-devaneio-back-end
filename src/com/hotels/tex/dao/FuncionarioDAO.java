package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotels.tex.model.Cargo;
import com.hotels.tex.model.Contato;
import com.hotels.tex.model.DadosHotel;
import com.hotels.tex.model.Endereco;
import com.hotels.tex.model.Funcionario;
import com.hotels.tex.model.Hotel;
import com.hotels.tex.utils.ConnectionFactory;

public class FuncionarioDAO {

	    private final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

		public void insere(Funcionario funcionario) {
			


			String sql = "INSERT INTO funcionario (nome_funcionario, sobrenome_funcionario, cpf, salario,"
					+ "id_cargo, id_contato, id_endereco, id_hotel) VALUES (?,?,?,?,?,?,?,?)";

			try (Connection conn = ConnectionFactory.criaConexao();
					PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				st.setString(1, funcionario.getNome());
				st.setString(2, funcionario.getSobrenome());
				st.setString(3, funcionario.getCpf());
				st.setBigDecimal(4, funcionario.getSalario());
				st.setInt(5, funcionario.getCargo().getIdCargo());
				st.setInt(6, funcionario.getContato().getIdContato());
				st.setInt(7, funcionario.getEndereco().getIdEndereco());
				st.setInt(8, funcionario.getHotel().getIdHotel());
				int rowsAffected = st.executeUpdate();

				if (rowsAffected > 0) {

					ResultSet rs = st.getGeneratedKeys();
					if (rs.next()) {
						int idGerado = rs.getInt(1);
						funcionario.setIdFuncionario(idGerado);

					}
				}

			} catch (SQLException e) {
				System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
			}

		}

		public List<Funcionario> listagem() {					
			
			String sql = "SELECT c.nome, f.nome_funcionario, f.sobrenome_funcionario, f.salario, f.cpf,"
					+ "c.id_cargo, k.id_contato,h.id_hotel, e.id_endereco FROM funcionario f "
					+ "INNER JOIN cargo c ON f.id_cargo = c.id_cargo "
					+ "INNER JOIN contato k ON f.id_contato = k.id_contato "
					+ "INNER JOIN endereco e ON f.id_endereco = e.id_endereco "
					+ "INNER JOIN hotel h ON r.id_hotel = h.id_hotel ";
					
			
			List<Funcionario> lista = new ArrayList<>();

			try (Connection conn = ConnectionFactory.criaConexao();
					PreparedStatement st = conn.prepareStatement(sql);
					ResultSet rs = st.executeQuery()) {

				while (rs.next()) {
					Cargo cargo = new Cargo(rs.getInt("id_cargo"));
					
					Contato contato = new Contato(rs.getInt("id_contato"));
					
					Endereco endereco = new Endereco(rs.getInt("id_endereco"));
					
					DadosHotel dados = new DadosHotel(rs.getString("nome"),
							  						  rs.getString("cnpj"));
					
					Hotel hotel = new Hotel(rs.getInt("id_hotel"),
											dados);
					
					Funcionario funcionario = new Funcionario(
												  rs.getString("nome_funcionario"),
												  rs.getString("sobrenome_funcionario"),
												  rs.getBigDecimal("salario"),
												  rs.getString("cpf"), 
												  cargo,
												  endereco,
												  contato,
												  hotel);
											
					lista.add(funcionario);
				}

			} catch (SQLException e) {
				System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
				}
			
				return lista;
			}
		
	    public void update(Funcionario funcionario) {
	    	
	    	String sql = "UPDATE funcionario SET salario = ?, id_cargo = ?, id_contato = ?, id_endereco = ?, id_hotel = ? WHERE id_funcionario = ?";

	        try (Connection conn = ConnectionFactory.criaConexao();
	             PreparedStatement st = conn.prepareStatement(sql)) {
	            st.setBigDecimal(1, funcionario.getSalario());
	            st.setInt(2, funcionario.getCargo().getIdCargo());
	            st.setInt(3, funcionario.getContato().getIdContato());
	            st.setInt(4, funcionario.getEndereco().getIdEndereco());
	            st.setInt(5, funcionario.getHotel().getIdHotel());
	            st.setInt(6, funcionario.getIdFuncionario());
	            st.execute();
	            System.out.println("Dados alterados com sucesso! O funcionário atualizado agora é: " + funcionario.getNome() + funcionario.getSobrenome() + "\nNúmero do cpf: " + funcionario.getCpf() + "\nSalário: " + funcionario.getSalario() + "\nCom o cargo: " + funcionario.getCargo());

	        } catch (SQLException e) {
	            throw new RuntimeException("Erro ao atualizar o funcionário, tente novamente após verificar a causa. " +
	                    "Causa:"
	                    + e.getMessage());
	        }
	    }

	    public Funcionario buscaPor(int id) throws SQLException {
	        Funcionario funcionario = null;

	        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";

	        try (Connection conn = ConnectionFactory.criaConexao();
	             PreparedStatement st = conn.prepareStatement(sql)) {
	            st.setInt(1, id);
	            ResultSet rs = st.executeQuery();

	            if (rs.next()) {
	                funcionario = new Funcionario(
	                		rs.getInt("id_funcionario"),
	                		rs.getString("nome_funcionario")
	                        
	                );

	            }

	        } catch (SQLException e) {
	            throw new RuntimeException("Erro ao localizar o funcionário, tente novamente após verificar a causa. \nCausa:"
	                    + e.getMessage());
	        }
	        return funcionario;

	    }
	    	    
	    public void delete(Integer idFuncionario) {
	        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";

	        String sql2 = "DELETE FROM funcionario WHERE id_funcionario = ?";

	        try (Connection conn = ConnectionFactory.criaConexao();
	             PreparedStatement st1 = conn.prepareStatement(sql);
	             PreparedStatement st2 = conn.prepareStatement(sql2)) {

	            st1.setInt(1, idFuncionario);
	            ResultSet rs = st1.executeQuery();

	            if (!rs.next()) {
	                throw new SQLException("Não existe nenhum funcionário cadastrado no id " + idFuncionario);
	            }

	            System.out.println("Funcionário de id " + idFuncionario + " deletado com suceso!");

	            st2.setInt(1, idFuncionario);
	            st2.executeUpdate();


	        } catch (SQLException e) {
	            throw new RuntimeException("Erro ao verificar se existe um funcionário com o id " + idFuncionario + ": " + e.getMessage());
	        }
	    }
	}
	

