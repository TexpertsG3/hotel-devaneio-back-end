package com.hotels.tex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotels.tex.model.Alojamento;
import com.hotels.tex.model.DadosHotel;
import com.hotels.tex.model.Hospede;
import com.hotels.tex.model.Hotel;
import com.hotels.tex.model.Reserva;
import com.hotels.tex.utils.ConnectionFactory;

public class ReservaDAO {

	private final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

	public void insere(Reserva reserva) {

		String sql = "INSERT INTO reserva (check_in, check_out, qtd_adultos, qtd_criancas, "
				+ "id_quarto, id_hotel, total_servicos, total_reserva) VALUES (?,?,?,?,?,?,?,?)";

		try (Connection conn = ConnectionFactory.criaConexao();
				PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			st.setObject(1, reserva.getCheckIn());
			st.setObject(2, reserva.getCheckOut());
			st.setInt(3, reserva.getQuantidadeAdultos());
			st.setInt(4, reserva.getQuantidadeCriancas());
			st.setInt(4, reserva.getQuarto().getIdAlojamento());
			st.setInt(5, reserva.getHotel().getIdHotel());
			st.setBigDecimal(6, reserva.getTotalServicos());
			st.setBigDecimal(7, reserva.getTotalReserva());
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

}
