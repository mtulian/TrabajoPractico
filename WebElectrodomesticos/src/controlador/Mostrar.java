package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Mostrar
 */
public class Mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mostrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement st;
		try {
			st = (Statement) Conexion.GetConnection().createStatement();
			ResultSet rs = (ResultSet) st.executeQuery("SELECT * FROM electrodomestico"); 
			while (rs.next())
			{
			   System.out.println("ID="+rs.getObject("id")+", Precio base="+rs.getObject("precioBase")+", Color="+rs.getObject("color")+", Consumo="+rs.getObject("consumoEnergetico")+", Peso="+rs.getObject("peso")+", Resolucion="+rs.getObject("resolucion")+", Sintonizador="+rs.getObject("sintonizador")+", Carga="+rs.getObject("carga"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
