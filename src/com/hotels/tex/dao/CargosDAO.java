package com.hotels.tex.dao;

import com.hotels.tex.model.Cargo;

import com.hotels.tex.utils.ConnectionFactory;

import java.sql.*;

public class CargosDAO {


    private final String ERRO_CONEXAO = "Erro na conexão com o banco de dados. Verifique e tente novamente.";

    public void insere(Cargo cargo) {

        String sql = "INSERT INTO cargo (nome_cargo) VALUES (?)";

        try (Connection conn = ConnectionFactory.criaConexao();
             PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, cargo.getNome());
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {

                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    cargo.setIdCargo(idGerado);
                }
            }
            System.out.println("O Cargo de " + cargo.getNome() + " foi cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println(ERRO_CONEXAO + "\n" + e.getMessage());
        }
    }

    public void delete(Integer idCargo) {
        String sql = "SELECT * FROM cargo WHERE id_cargo = ?";

        String sql2 = "DELETE FROM cargo WHERE id_cargo = ?";

        try (Connection conn = ConnectionFactory.criaConexao();
             PreparedStatement st1 = conn.prepareStatement(sql);
             PreparedStatement st2 = conn.prepareStatement(sql2)) {

            st1.setInt(1, idCargo);
            ResultSet rs = st1.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Não existe nenhum cargo cadastrado no id " + idCargo);
            }

            System.out.println("Cargo de id " + idCargo + " deletado com suceso!");

            st2.setInt(1, idCargo);
            st2.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar se existe um cargo com o id " + idCargo + ": " + e.getMessage());
        }
    }

    public void update(Cargo cargo) {
        String sql = "UPDATE cargo SET nome_cargo = ? WHERE id_cargo = ?";

        try (Connection conn = ConnectionFactory.criaConexao();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cargo.getNome());
            st.setInt(2, cargo.getIdCargo());
            st.execute();
            System.out.println("Dados alterados com sucesso! \nO Cargo atualizado agora é: " + cargo.getNome());

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o cargo, tente novamente após verificar a causa. " +
                    "Causa:"
                    + e.getMessage());
        }
    }

    public Cargo buscaPor(int id) throws SQLException {
        Cargo cargo = null;

        String sql = "SELECT * FROM cargo WHERE id_cargo = ?";

        try (Connection conn = ConnectionFactory.criaConexao();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                cargo = new Cargo(
                        rs.getString("nome_cargo"),
                        rs.getInt("id_cargo")
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao localizar o cargo, tente novamente após verificar a causa. \nCausa:"
                    + e.getMessage());
        }
        return cargo;

    }
}
