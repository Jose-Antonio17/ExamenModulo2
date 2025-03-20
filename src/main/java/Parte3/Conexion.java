package Parte3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String URL_DB_ORACLE="jdbc:oracle:thin:@localhost:1522:XE";
	private static final String USER_DB_ORACLE="jose";
	private static final String PASSWORD_DB_ORACLE="password";

	public static Connection crearConexion() {
		Connection connection = crearConexion(URL_DB_ORACLE,USER_DB_ORACLE,PASSWORD_DB_ORACLE);
		return connection;
	}

	public static Connection crearConexion(String url, String user, String password) {
		Connection connection = null;
		try  {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
		return connection;
	}
	public static void cerrarConexion(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
