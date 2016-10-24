package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static String jdbc_url 	= "jdbc:mysql://localhost/labo2016P4E4";
	private static String usuario	= "root";
	private static String password 	= "1234";
	private static String driver 	= "com.mysql.jdbc.Driver";
	
	public static Connection getConnection(){
		
		try {
			/* Como vamos a usar Connector/J tenemos que hacer lo siguiente: */
			Class.forName(driver).newInstance();
			
			/* Devuelve un Objeto de tipo Connection*/
			return DriverManager.getConnection(jdbc_url, usuario, password);
			
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}
