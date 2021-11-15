package es.eoi.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.eoi.servicios.Conexion;

public class HabitacionDAO {

	private Connection con;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;

	// obtener una habitacion a partir del num de habitacion
	public Habitacion getHabitacion(int n_habitacion) throws SQLException {
		
		con = Conexion.getInstance().getConnection();
		String sql = "SELECT * FROM habitacion WHERE n_habitacion = ?";

		pst = con.prepareStatement(sql);
		pst.setInt(1, n_habitacion);

		rs = pst.executeQuery();
		
		Habitacion hab = null;
		
		if (rs.next()) {   //Si entro aquí es que hay datos
			hab = new Habitacion();
			hab.setN_habitacion(rs.getInt(1));
			hab.setTipo(rs.getString(2));
			hab.setDisponibilidad(rs.getString(3));

		}
		return hab;
	}
	// obtenemos todos las habitaciones disponibles

	public List<Habitacion> getHabitaciones() throws SQLException {
		
		con = Conexion.getInstance().getConnection();
		String sql = "SELECT * FROM habitacion WHERE disponiblidad = 'disponible' ";

		st = con.createStatement();
		rs = st.executeQuery(sql);

		List<Habitacion> lista = new ArrayList<Habitacion>();
		Habitacion hab = null;

		while (rs.next()) {

			hab = new Habitacion();
			hab.setN_habitacion(rs.getInt(1));
			hab.setTipo(rs.getString(2));
			hab.setDisponibilidad(rs.getString(3));
			lista.add(hab);
		}
		return lista;
	}

	// obtener las habitaciones disponibles y que no estén reservadas por el cliente
	public List<Habitacion> getHabitaciones(int cliente_id) throws SQLException {

		con = Conexion.getInstance().getConnection();
		String sql = "SELECT *FROM habitacion WHERE disponiblidad = 'disponible' AND n_habitacion not in(SELECT habitacion_n FROM reserva WHERE cliente_id = ?)";

		pst = con.prepareStatement(sql);
		pst.setInt(1, cliente_id);

		rs = pst.executeQuery();

		List<Habitacion> lista = new ArrayList<Habitacion>();
		Habitacion hab = null;

		while (rs.next()) {
			hab = new Habitacion();
			hab.setN_habitacion(rs.getInt(1));
			hab.setTipo(rs.getString(2));
			hab.setDisponibilidad(rs.getString(3));
			lista.add(hab);
		}
		return lista;
	}

	//insertamos en BBDD una habitacion a partir del objeto Hab
	public int addHabitacion(Habitacion hab) throws SQLException {
		con = Conexion.getInstance().getConnection();
		String sql = "INSERT INTO habitacion(tipo,disponibilidad) VALUES (?,?)";

		pst = con.prepareStatement(sql);
		pst.setString(1, hab.getTipo());
		pst.setString(2, hab.getDisponibilidad());

		return pst.executeUpdate();
	}

	// borramos de la BBDD una habitacion a partir de su num hab
	public int delHabitacion(int n_habitacion) throws SQLException {
		con = Conexion.getInstance().getConnection();
		String sql = "DELETE FROM habitacion WHERE n_habitacion=?";

		pst = con.prepareStatement(sql);
		pst.setInt(1, n_habitacion);

		return pst.executeUpdate();
	}

	// actualizamos en BBDD una habitacion a partir del obj hab

	public int updatehab(Habitacion hab) throws SQLException {

		con = Conexion.getInstance().getConnection();
		String sql = "UPDATE habitacion SET tipo=?, disponibilidad=? WHERE n_habitacion=?";

		pst = con.prepareStatement(sql);
		pst.setString(1, hab.getTipo());
		pst.setString(2, hab.getDisponibilidad());
		pst.setInt(3, hab.getN_habitacion());

		return pst.executeUpdate();
	}

	// obtener las reservas realizadas por un cliente

	public List<Habitacion> getHabitacionesOfCliente(int cliente_id) throws SQLException {

		con = Conexion.getInstance().getConnection();
		String sql = "SELECT * FROM presentamos WHERE cliente_id = ?";

		pst = con.prepareStatement(sql);
		pst.setInt(1, cliente_id);
		rs = pst.executeQuery();

		List<Habitacion> lista = new ArrayList<Habitacion>();
		Habitacion hab = null;

		while (rs.next()) {
//			HabitacionDAO hadao = new HabitacionDAO();
			hab = getHabitacion(rs.getInt("habitacion_n"));
			lista.add(hab);
		}
		return lista;

	}

}
