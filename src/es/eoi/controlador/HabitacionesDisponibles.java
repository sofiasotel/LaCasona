package es.eoi.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HabitacionesDisponibles
 */
@WebServlet("/habitacionesdisponibles")
public class HabitacionesDisponibles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HabitacionesDisponibles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fecha_entrada = request.getParameter("fecha_entrada");
		String fecha_salida = request.getParameter("fecha_salida");
		
		request.setAttribute("fecha_entrada", fecha_entrada);
		request.setAttribute("fecha_salida", fecha_salida);
		request.setAttribute("habitacion_n", request.getParameter("habitacion_n"));
		request.setAttribute("preciotot", request.getParameter("preciotot"));
		
		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("reservas.jsp");
        reqDispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
