package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Modificacion
 */
public class Modificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modificacion() {
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
		
		
		int ID = Integer.parseInt(request.getParameter("id"));
		
		Statement sta;
		try {
	        
			sta = (Statement) Conexion.GetConnection().createStatement();
			ResultSet rs = (ResultSet) sta.executeQuery("SELECT * FROM electrodomestico WHERE id="+ID+"");
			if(rs.next())
			{
				request.getSession().setAttribute("id",rs.getInt("id"));
				request.getSession().setAttribute("precioBase",rs.getFloat("precioBase"));
				request.getSession().setAttribute("color",rs.getString("color"));
				request.getSession().setAttribute("consumoEnergetico",rs.getString("consumoEnergetico"));
				request.getSession().setAttribute("peso",rs.getFloat("peso"));
				request.getSession().setAttribute("resolucion",rs.getFloat("resolucion"));
				request.getSession().setAttribute("sintonizador",rs.getBoolean("sintonizador"));
				request.getSession().setAttribute("carga",rs.getFloat("carga"));	
			}
			else
				JOptionPane.showMessageDialog(null, "El Id ingresado es inexistente");
			sta.close();
			Conexion.CloseConnection();	
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		request.getRequestDispatcher("/Modi.jsp").forward(request, response);
	}


}
