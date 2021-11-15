package es.eoi.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.eoi.modelo.Cliente;
import es.eoi.modelo.OperacionesDAO;
import es.eoi.modelo.Reserva;

/**
 * Servlet implementation class Reservas
 */
@WebServlet("/Reservas")
public class Reservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recupera una sesion existente
		HttpSession sesion = request.getSession();
		
		String fecha_reserva = request.getParameter("fecha_reserva");
		String fecha_entrada = request.getParameter("fecha_entrada");
		String fecha_salida = request.getParameter("fecha_salida");
		int num_personas = Integer.parseInt(request.getParameter("num_personas"));
		String tipoHab = request.getParameter("tipoHab");		
		
		String extra = request.getParameter("extra");
		
		//Recuperamos la sesion de cliente
		Cliente cliente = (Cliente)sesion.getAttribute("cliente");
		int idCliente = cliente.getIdclientes(); 
		
		
		Reserva r = new Reserva();
		r.setFecha_reserva(fecha_reserva);
		r.setFecha_entrada(fecha_entrada);
		r.setFecha_salida(fecha_salida);
		r.setNum_personas(num_personas);
		r.setCliente_id(idCliente);
		r.setExtra(extra);
		
		try {
			OperacionesDAO.reserva(fecha_reserva, fecha_entrada, fecha_salida, num_personas, idCliente, tipoHab);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
