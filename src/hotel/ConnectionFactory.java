package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection criaConexao() throws SQLException {
	    return DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_devaneio","root","root");
	}    

}
