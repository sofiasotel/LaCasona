package es.eoi.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.eoi.modelo.Cliente;
import es.eoi.modelo.ClienteDAO;

/**
 * Servlet implementation class MiPerfil
 */
@WebServlet("/miperfil")
public class MiPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		HttpSession sesion = request.getSession();
		Cliente clie = (Cliente)sesion.getAttribute("cliente");
		String pagina = "miperfil.jsp";
		String msgerr = "";
		ClienteDAO cdao = new ClienteDAO();
		if (opcion != null) {
			switch(opcion) {
				case "b":
					try {
						cdao.delCliente(clie.getIdclientes());
						pagina = "index.jsp";
						msgerr = "Cliente dado de baja correctamente";
						request.setAttribute("msgerr", msgerr);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String dni = request.getParameter("dni");
		
		String email = request.getParameter("email");
		String rol = request.getParameter("rol");
		String pass = request.getParameter("pass");
		
		
		
	}

	private Object getParameter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}

		
		
		
		
	