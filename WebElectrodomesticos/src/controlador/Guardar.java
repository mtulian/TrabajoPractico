package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
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
		//Validamos si se trata de un televisor o un lavarropa
		
		Electrodomestico elec= new Electrodomestico();
		
		elec.setPrecioBase(Float.parseFloat(precioBase));
		elec.setColor(color);
		elec.setConsumoEnergetico(consumoEnergetico);
		elec.setPeso(Float.parseFloat(peso));
		
		if(request.getParameter("carga") == null || request.getParameter("carga") == "")
		{
			String resolucion = request.getParameter("resolucion");
			String sintonizador = request.getParameter("sintonizador");
			elec = new Television();
			((Television) elec).setResolucion(Float.parseFloat(resolucion));
			((Television) elec).setSintonizadorTDT(Boolean.parseBoolean(sintonizador));			
		}		
		else
		{
			String carga = request.getParameter("carga");
			elec = new Lavarropas();
			((Lavarropas) elec).setCarga(Float.parseFloat(carga));
		}
				
		String query ="insert into electrodomesticos(precioBase,color,consumoEnergetico,peso,resolucion,sintonizador,carga) values (?,?,?,?,?,?,?)";
		PreparedStatement sentencia=null;
		try {
			
			Connection conex =null;
			Statement sql = null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conex = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos");
				sql = (Statement) conex.createStatement();
			}catch(Exception e){
			}
			
			sentencia= (PreparedStatement) conex.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			//sentencia.setInt(1, elec.getId());
			sentencia= (PreparedStatement) conex.prepareStatement(query);
			sentencia.setFloat(1, elec.getPrecioBase());
			sentencia.setString(2, elec.getColor());
			sentencia.setString(3, elec.getConsumoEnergético());
			sentencia.setFloat(4, elec.getPeso());
			if (elec instanceof Lavarropas) {
				sentencia.setFloat(5, 0);
				sentencia.setBoolean(6, false);
				sentencia.setFloat(7, ((Lavarropas) elec).getCarga());
			}
			else {
				sentencia.setFloat(5, ((Television) elec).getResolucion());
				sentencia.setBoolean(6,((Television) elec).isSintonizadorTDT());
				sentencia.setFloat(7, 0);
			}
			
			sentencia.executeUpdate(query);
		} 
		catch (SQLException e) {e.printStackTrace();}
		finally{}
		
	}
	


}
