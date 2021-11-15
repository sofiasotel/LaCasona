package es.eoi.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Conexion instancia;
	private Connection connection;

	private String url = "jdbc:mysql://localhost:3306/hotel?useSSL=false&serverTimezone=UTC";
	private String username = "root";
	private String password = "1234";

	private Conexion() throws SQLException {
		// cuando usamos apache, a veces no encuentra el driver, por ello, le especificamos donde tiene que encontrar el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username, password);  //hacemos la conexión
		} catch (ClassNotFoundException e) {
			System.out.println("Conexion a BD incorrecta : " + e.getMessage());
		}
	}

	public Connection getConnection() {
		return connection; //devuelve la conexión
	}
	//para que siempre utilice la misma conexión(para optimizar). Es static para que pueda llamarlas de otras clases.
	public static Conexion getInstance() throws SQLException {
		if (instancia == null) {  //Si es null, creamos el objeto conexión
			instancia = new Conexion();
		} else if (instancia.getConnection().isClosed()) {
			instancia = new Conexion();
		}
		return instancia;
	}
}
