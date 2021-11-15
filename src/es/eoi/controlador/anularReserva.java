package es.eoi.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.eoi.modelo.Cliente;
import es.eoi.modelo.OperacionesDAO;

/**
 * Servlet implementation class anularReserva
 */
@WebServlet("/anularReserva")
public class anularReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public anularReserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Recupera una sesion existente
		HttpSession sesion = request.getSession();
			
		// Recuperamos la sesion de cliente
		Cliente cliente = (Cliente) sesion.getAttribute("cliente");
		int idCliente = cliente.getIdclientes();

		// Recogemos número de reserva a cancelar

		int habitacion_n = Integer.parseInt(request.getParameter("habitacion_n"));

		// LLamamos al método de anulación de OperacionesDAO

		try {
			OperacionesDAO.anularReserva(idCliente, habitacion_n);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
