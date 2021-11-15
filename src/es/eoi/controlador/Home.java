package es.eoi.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.eoi.modelo.Cliente;
import es.eoi.modelo.Habitacion;
import es.eoi.modelo.HabitacionDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		Cliente clie = (Cliente)sesion.getAttribute("cliente");
		
		HabitacionDAO hadao = new HabitacionDAO();
		List<Habitacion> habitaciones;
		String pagina = "home.jsp";
		try {
			habitaciones = hadao.getHabitaciones(clie.getIdclientes());
			request.setAttribute("habitaciones", habitaciones);
		} catch (SQLException e) {
			e.printStackTrace();  
		}
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
