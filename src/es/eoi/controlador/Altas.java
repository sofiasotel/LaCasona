package es.eoi.controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import es.eoi.modelo.*;

/**
 * 
 * Servlet implementation class Altas
 * 
 */
@WebServlet("/Altas")
public class Altas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @see HttpServlet#HttpServlet()
	 * 
	 */
	public Altas() {
		super();
	}
	/**
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ClienteDAO cdao = new ClienteDAO();
		HabitacionDAO hadao = new HabitacionDAO();
		String opcion = request.getParameter("opcion");
		String pagina = "home.jsp";
		HttpSession sesion = request.getSession();
		String msginfo = "";

		try {
			List<Habitacion> habitaciones;

			switch (opcion) {
			case "h":
			case "m":
				int id = 0;
				if (opcion.equals("m")) {
					id = Integer.parseInt(request.getParameter("id"));
					int n_habitacion = (Integer.parseInt(request.getParameter("n_habitacion")));
					String tipo = request.getParameter("tipo");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String disponibilidad = request.getParameter("disponibilidad");
					Habitacion hab = new Habitacion();
					hab.setN_habitacion(n_habitacion);
					hab.setTipo(tipo);
					hab.setDisponibilidad(disponibilidad);

					if (opcion.equals("m")) {
						hab.setN_habitacion(n_habitacion);
						hadao.updatehab(hab);
						msginfo = "habitacion " + hab.getN_habitacion() + " Actualizada";

					} else {
						hadao.addHabitacion(hab);
						msginfo = "Habitacion " + hab.getN_habitacion() + " Creada";
					}

					Cliente c = (Cliente) sesion.getAttribute("cliente");
					habitaciones = hadao.getHabitaciones(c.getIdclientes());
					request.setAttribute("habitaciones", habitaciones);
					request.setAttribute("msginfo", msginfo);
					break;

					}

			case "c":

				String nombre = request.getParameter("nombre");
				String apellidos = request.getParameter("apellidos");
				String dni = request.getParameter("dni");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				String rol = request.getParameter("rol");
				String pass = request.getParameter("pass");

				Cliente clie = new Cliente();

				cdao.addCliente(clie);

				msginfo = "Alta de cliente " + clie.getNombre() + " " + clie.getApellidos() + " - " + clie.getRol()
						+ " OK";

				request.setAttribute("msginfo", msginfo);
				sesion.setAttribute("cliente", clie);
				habitaciones = hadao.getHabitaciones();
				request.setAttribute("habitaciones", habitaciones);
				break;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);

	}

}
