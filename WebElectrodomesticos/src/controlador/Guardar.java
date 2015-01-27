package controlador;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import entidades.Electrodomestico;
import entidades.Lavarropas;
import entidades.Television;

/**
 * Servlet implementation class Guardar
 */
public class Guardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guardar() {
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
		
		String precioBase = request.getParameter("precioBase");
		String color = request.getParameter("color");
		String consumoEnergetico = request.getParameter("consumoEnergetico");
		String peso = request.getParameter("peso");
		
		String query ="insert into electrodomesticos(precioBase,color,consumoEnergetico,peso,resolucion,sintonizador,carga) values (precioBase,?,?,?,?,?,?)";
		Statement s;
		try {
			s = (Statement) Conexion.GetConnection().createStatement();
			ResultSet rs=(ResultSet) s.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		try {
			

			sentencia.setString(2, color);
			sentencia.setString(3, consumoEnergetico);
			sentencia.setFloat(4,Float.parseFloat(peso));

		//Validamos si se trata de un televisor o un lavarropa	
			
		if(request.getParameter("carga") == null || request.getParameter("carga") == "")
		{
			String resolucion = request.getParameter("resolucion");
			String sintonizador = request.getParameter("sintonizador");	
			
			sentencia.setFloat(5, Float.parseFloat(resolucion));
			sentencia.setBoolean(6,Boolean.parseBoolean(sintonizador));
			sentencia.setFloat(7, 0);
		}		
		else
		{
			String carga = request.getParameter("carga");
			
			sentencia.setFloat(5, 0);
			sentencia.setBoolean(6, false);
			sentencia.setFloat(7, Float.parseFloat(carga));
		}
						

		
		} 
		catch (SQLException e) {e.printStackTrace();}
		finally{}
		*/

	}
	


}
