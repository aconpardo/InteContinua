package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	public static String url ="jdbc:mysql://localhost:3306/clinica";
	public static String usuario ="root";
	public static String clave ="";
	public static String clase = "com.mysql.cj.jdbc.Driver";
	PreparedStatement ps=null;
	
	public static Connection conectar() {
		Connection conexion = null;
		try {
			Class.forName(clase);
			conexion = (Connection) DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexion Establecida");
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return conexion;
	}
	
	public ResultSet ejecutarConsulta(String sql) throws Exception{
		Statement st = null;
		st= conectar().createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	public boolean ejecutarGuardar(String sql) throws Exception{
		Statement st = null;
		st= conectar().createStatement();
		boolean rs = st.executeUpdate(sql) > 0;
		return rs;
	}
	
	public void desconectar() throws SQLException {
		conectar().close();
	}

}
