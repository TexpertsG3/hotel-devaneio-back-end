package DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ServicoAdicional;
import util.ConnectionFactory;

public class ServicoAdicionalDAO {

	public void insere(String nomeServico, BigDecimal valor, Integer idHotel) throws SQLException {
		Connection conn = ConnectionFactory.criaConexao();

		ServicoAdicional servicoAdicional = new ServicoAdicional(nomeServico, valor, idHotel);

		String sql = "insert into servico_adicional (nome, preco) values(?,?)";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.setString(1, servicoAdicional.getNomeServico());
			st.setBigDecimal(2, servicoAdicional.getValorServico());
			st.execute();
			System.out.println("Serviço " + servicoAdicional.getNomeServico() + " adicionado com sucesso");
			st.close();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			conn.close();
		}

	}

	public List<ServicoAdicional> listagem() throws SQLException {
		Connection conn = ConnectionFactory.criaConexao();

		String sql = "select nome, preco, id_hotel from servico_adicional";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		List<ServicoAdicional> lista = new ArrayList<>();

		while (rs.next()) {

			ServicoAdicional servico = new ServicoAdicional(rs.getString(1), rs.getBigDecimal(2), rs.getInt(3));
			lista.add(servico);

		}
		rs.close();
		st.close();
		conn.close();

		return lista;
	}

}
