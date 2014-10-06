
package datos;

import java.sql.*;

import javax.swing.JOptionPane;



public class ConexionDB {
    
	static Connection conexion=null;
	
	private static String dbUrl="jdbc:mysql://localhost:3306/tp_java";
	private static String dbUser="root";
	private static String dbPassword= "";
	private static ConexionDB instancia;
	private Connection conn;
	
	public static ConexionDB getInstancia(){
		if(instancia==null){
			instancia=new ConexionDB();
		}
		return instancia;
	}
	public ConexionDB() {
		// TODO Auto-generated constructor stub
	}
	public Connection getConn(){
		try {
			if(conn==null || !conn.isValid(3)){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);	
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	public void CloseConn(){
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    
}