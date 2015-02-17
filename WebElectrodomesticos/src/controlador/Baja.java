package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Baja
 */
public class Baja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Baja() {
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
		
		String query ="DELETE FROM electrodomestico WHERE id="+ID+"";
		Statement sta;
		try {
	        
			sta = (Statement) Conexion.GetConnection().createStatement();
			sta.executeUpdate(query);
			sta.close();
			Conexion.CloseConnection();	
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		request.getRequestDispatcher("/Baja.jsp").forward(request, response);
	}

}
