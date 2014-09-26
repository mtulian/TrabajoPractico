
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexionDB {
    
	static Connection conexion=null;
	
    @SuppressWarnings("finally")
	public static Connection GetConnection()
    {     
        try
        {
        	  //Cargar el driver --> com.mysql.jdbc.Driver (Nombre correspondiente a BD MySQL.)
        	  Class.forName("com.mysql.jdbc.Driver");
              String servidor = "jdbc:mysql://localhost/TrabajoPractico/src/datos/tp_java.sql";   //Dirección de la BD.
              String usuarioDB="root";									    				      //Usuario de la BD.
              conexion= DriverManager.getConnection(servidor,usuarioDB,"");  //El 3er parametro corresponde a la contraseña.
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
    }
    
}