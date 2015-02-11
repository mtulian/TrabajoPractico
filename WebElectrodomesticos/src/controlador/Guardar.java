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
		
		float precioBase =0;
		String color ="";
		String consumoEnergetico ="";
		String peso ="";
		String resolucion ="";
		String sintonizador ="";	
		
		if(request.getParameter("precioBase").trim() != null)
			precioBase = Float.parseFloat(request.getParameter("precioBase").trim());
		if(request.getParameter("color") != null)
			color = request.getParameter("color");
		if(request.getParameter("consumoEnergetico") != null)
			consumoEnergetico = request.getParameter("consumoEnergetico");
		if(request.getParameter("peso").trim() != null)
			peso = request.getParameter("peso").trim();
		if(request.getParameter("resolucion").trim() != null)
			resolucion = request.getParameter("resolucion").trim();
		if(request.getParameter("sintonizador") != null)
			sintonizador =request.getParameter("sintonizador");
		//String car = request.getParameter("carga").trim();
		
		
		String query ="INSERT INTO electrodomestico(precioBase,color,consumoEnergetico,peso,resolucion,sintonizador,carga) VALUES ('"+precioBase+"','"+color+"','"+consumoEnergetico+"','"+peso+"','"+resolucion+"','"+sintonizador+"',null)";
		Statement st;
		try {
			st = (Statement) Conexion.GetConnection().createStatement();
			st.executeUpdate(query);
			st.close();
			Conexion.CloseConnection();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Alta.jsp").forward(request, response);

	}
	


}
