package com.hotels.tex.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.hotels.tex.model.Alojamento;
import com.hotels.tex.model.DadosHotel;
import com.hotels.tex.model.Funcionario;
import com.hotels.tex.model.Hospede;
import com.hotels.tex.model.Hotel;
import com.hotels.tex.model.Reserva;
import com.hotels.tex.model.ServicoAdicional;
import com.hotels.tex.utils.ConnectionFactory;

public class ReservaDAO {

	private final String ERRO_CONEXAO = "Erro na conexÃ£o com o banco de dados. Verifique e tente novamente.";

	public void insere(Reserva reserva) {

		String sql = "INSERT INTO reserva (check_in, check_out, qtd_adultos, qtd_criancas, "
				+ "id_quarto, id_hotel, total_servicos, total_reserva) VALUES (?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.criaConexao();
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setObject(1, reserva.getCheckIn());
			st.setObject(2, reserva.getCheckOut());
			st.setInt(3, reserva.getQuantidadeAdultos());
			st.setInt(4, reserva.getQuantidadeCriancas());
			st.setInt(5, reserva.getQuarto().getIdAlojamento());
			st.setInt(6, reserva.getHotel().getIdHotel());
			st.setBigDecimal(7, reserva.getTotalServicos());
			st.setBigDecimal(8, reserva.getTotalReserva());
			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {

				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int idGerado = rs.getInt(1);
					reserva.setIdReserva(idGerado);

				}
			}

		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
		}

	}

	public List<Reserva> listagem() {

		String sql = "SELECT d.nome, d.cnpj, q.nome, r.id_reserva, e.id_hospede, r.check_in, r.check_out, r.qtd_adultos, r.qtd_criancas, "
				+ "q.id_quarto, h.id_hotel, h.id_dados_hotel, r.total_servicos, r.total_reserva FROM reserva r "
				+ "INNER JOIN hospede e ON r.id_hospede = e.id_hospede "
				+ "INNER JOIN quarto q ON r.id_quarto = q.id_quarto "
				+ "INNER JOIN hotel h ON r.id_hotel = h.id_hotel "
				+ "INNER JOIN dados_hotel d ON h.id_dados_hotel = d.id_dados_hotel";
				
		
		List<Reserva> lista = new ArrayList<>();

		try (Connection conn = ConnectionFactory.criaConexao();
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery()) {

			while (rs.next()) {
				Hospede hospede = new Hospede(rs.getInt("id_hospede"));
				
				Alojamento alojamento = new Alojamento(rs.getInt("id_quarto"),
													   rs.getString("nome"));
				
				DadosHotel dados = new DadosHotel(rs.getString("nome"),
						  						  rs.getString("cnpj"));
				
				Hotel hotel = new Hotel(rs.getInt("id_hotel"),
										dados);
				
				Reserva reserva = new Reserva(rs.getInt("id_reserva"),
											  hospede,
											  rs.getDate("check_in").toLocalDate(), 
											  rs.getDate("check_out").toLocalDate(), 
											  rs.getInt("qtd_adultos"), 
											  rs.getInt("qtd_criancas"),
											  alojamento,
											  hotel, 
											  rs.getBigDecimal("total_servicos"), 
											  rs.getBigDecimal("total_reserva"));
				lista.add(reserva);
			}

		} catch (SQLException e) {
			System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
		}

		return lista;

	}
	
	  public void update(Reserva reserva) {
	    	
		  //check_in, check_out, qtd_adultos, qtd_criancas,id_quarto, total_servicos, total_reserva"
					
	    	String sql = "UPDATE reserva SET check_in = ?, check_out = ?, qtd_adultos = ?, qtd_criancas = ?, id_quarto = ?, id_hotel=?, total_servicos = ?, total_reserva = ?  WHERE id_reserva = ?";

	        try (Connection conn = ConnectionFactory.criaConexao();
	             PreparedStatement st = conn.prepareStatement(sql)) {
	        	st.setObject(1, reserva.getCheckIn());
				st.setObject(2, reserva.getCheckOut());
				st.setInt(3, reserva.getQuantidadeAdultos());
				st.setInt(4, reserva.getQuantidadeCriancas());
				st.setInt(5, reserva.getQuarto().getIdAlojamento());
				st.setInt(6, reserva.getHotel().getIdHotel());
				st.setBigDecimal(7, reserva.getTotalServicos());
				st.setBigDecimal(8, reserva.getTotalReserva());
				st.setInt(8, reserva.getIdReserva());
	            st.execute();
	            System.out.println("Dados alterados com sucesso! ");

	        } catch (SQLException e) {
	            throw new RuntimeException("Erro ao atualizar a reserva, tente novamente após verificar a causa. " +
	                    "Causa:"
	                    + e.getMessage());
	        }
	    }

	    public Reserva buscaPor(int id) throws SQLException {
	        Reserva reserva = null;

	        String sql = "SELECT * FROM reserva WHERE id_reserva = ?";

	        try (Connection conn = ConnectionFactory.criaConexao();
	             PreparedStatement st = conn.prepareStatement(sql)) {
	            st.setInt(1, id);
	            ResultSet rs = st.executeQuery();

	            if (rs.next()) {
	                reserva = new Reserva(
	                		rs.getInt("id_reserva")     
	                );

	            }

	        } catch (SQLException e) {
	            throw new RuntimeException("Erro ao localizar a reserva, tente novamente após verificar a causa. \nCausa:"
	                    + e.getMessage());
	        }
	        return reserva;

	    }
	    	    
	    public void delete(Integer idReserva) {
	        String sql = "SELECT * FROM reserva WHERE id_reserva = ?";

	        String sql2 = "DELETE FROM reserva WHERE id_reserva = ?";

	        try (Connection conn = ConnectionFactory.criaConexao();
	             PreparedStatement st1 = conn.prepareStatement(sql);
	             PreparedStatement st2 = conn.prepareStatement(sql2)) {

	            st1.setInt(1, idReserva);
	            ResultSet rs = st1.executeQuery();

	            if (!rs.next()) {
	                throw new SQLException("Não existe nenhuma reserva cadastrada no id " + idReserva);
	            }

	            System.out.println("Reserva de id " + idReserva + " deletado com suceso!");

	            st2.setInt(1, idReserva);
	            st2.executeUpdate();


	        } catch (SQLException e) {
	            throw new RuntimeException("Erro ao verificar se existe uma reserva com o id " + idReserva + ": " + e.getMessage());
	        }
	    }
	}
