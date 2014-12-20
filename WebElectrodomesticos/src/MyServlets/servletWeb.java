package MyServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletWeb
 */
public class servletWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		float precioBase = Float.parseFloat(request.getParameter("precioBase"));
		String color = request.getParameter("color");
		String consumoEnergetico = request.getParameter("consumoEnergetico");
		float peso = Float.parseFloat(request.getParameter("peso"));
		float resolucion = Float.parseFloat(request.getParameter("resolucion"));
		boolean sintonizador = Boolean.parseBoolean(request.getParameter("sintonizador"));
		float carga = Float.parseFloat(request.getParameter("carga"));
	}

}
