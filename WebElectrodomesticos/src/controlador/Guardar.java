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
		
		//hay problemas en el envio de los parametros, no toma los atributos float, arreglar eso.
		
		float precioBase =0;
		String color ="";
		String consumoEnergetico ="";
		float peso =0;
		float resolucion =0;
		int sintonizador = 0;
		float carga =0;
		
		try{
			
			  //NO FUNCIONA EL PASAJE DE FLOATS DESDE EL JSP AL SEVLET.
			  precioBase = Float.parseFloat(request.getParameter("precioBase"));
			  peso = Float.parseFloat(request.getParameter("peso"));
			  resolucion = Float.parseFloat(request.getParameter("resolucion"));
			  sintonizador =Integer.parseInt(request.getParameter("sintonizador"));			  
			  carga = Float.parseFloat(request.getParameter("carga"));	

		}catch(NumberFormatException e){
			  
			}
				
		color = request.getParameter("color");
		consumoEnergetico = request.getParameter("consumoEnergetico");
	
			String query ="INSERT INTO electrodomestico(precioBase,color,consumoEnergetico,peso,resolucion,sintonizador,carga) VALUES ('"+precioBase+"','"+color+"','"+consumoEnergetico+"','"+peso+"','"+resolucion+"','"+sintonizador+"','"+carga+"')";
			Statement st;
			try {
				st = (Statement) Conexion.GetConnection().createStatement();
				st.executeUpdate(query);
				st.close();
				//Conexion.CloseConnection();		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("/Alta.jsp").forward(request, response);

	}
	


}
