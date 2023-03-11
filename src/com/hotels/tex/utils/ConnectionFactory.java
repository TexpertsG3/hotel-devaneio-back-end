package com.hotels.tex.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection criaConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_devaneio", "root", "root");
	}

	public static void fecharConexao(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			conn.close();
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Problema ao fechar as conexões com o banco de dados.");
			e.printStackTrace();
		}

	}

}
