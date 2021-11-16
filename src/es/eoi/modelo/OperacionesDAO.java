package es.eoi.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.eoi.servicios.Conexion;

public class OperacionesDAO {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement pst;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	private HabitacionDAO hadao;

	// realiza la op de reserva en la bbdd
	// dara el alta del registro en la tabla de reserva y actualizara el dato en
	// tabla Habitacion

	public int reserva(String fecha_reserva, String fecha_entrada,String fecha_salida, int num_personas, int cliente_id, String tipohab) throws SQLException {

		int ret = 1;
		Date fechaEntrada = null;
		Date fechaSalida = null;
		int costo;
		float preciotot = 0;
		int habitacion_n = 0;
		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaEntrada = formatoDelTexto.parse(fecha_entrada);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fechaSalida = formatoDelTexto.parse(fecha_salida);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int dias=(int) ((fechaSalida.getTime()-fechaEntrada.getTime())/86400000);
		
		con = Conexion.getInstance().getConnection();
		String sql1 = "INSERT INTO reserva(fecha_reserva,fecha_entrada,fecha_salida,num_personas,preciotot,cliente_id,habitacion_n,exta)VALUES(?,?,?,?,?,?,?,?)";
		String sql2 = "UPDATE habitacion SET disponibilidad=? WHERE n_habitacion=?";
		String sql = "SELECT * FROM habitacion WHERE disponibilidad=? AND tipo=?";
		con.setAutoCommit(false);

		// tabla habitacion tipo

		

		System.out.println("cuantos dias " + dias);
		System.out.println("que tipo de habitacion" + tipohab);

		pst = con.prepareStatement(sql);
		pst.setString(1,"disponible");
		pst.setString(2,tipohab);
		
		rs = pst.executeQuery();
		
		//Solo se mete si hay disponibilidad
		if (rs.next()) {
			habitacion_n = rs.getInt(1);
		}
		if (habitacion_n != 0) {
		if (tipohab.equals("individual")) {
			costo = 25;
			preciotot = (float) (costo * dias);
		} else if (tipohab.equals("matrimonial")) {
			costo = 50;
			preciotot = (float) (costo * dias);
						;
		} else if (tipohab.equals("doble")) {
			costo = 55;
			preciotot = (float) (costo * dias);
		} else {
			costo = 0;
		}
		

		// reservas tabla

		pst1 = con.prepareStatement(sql1);
		pst1.setString(1, fecha_reserva);
		pst1.setString(2, fecha_entrada);
		pst1.setString(3, fecha_salida);
		pst1.setInt(4, num_personas);
		pst1.setFloat(5, preciotot);
		pst1.setInt(6, cliente_id);
		

		ret = pst1.executeUpdate();

		// tabla habitacion
		if (ret == 1) {
			hadao = new HabitacionDAO();
			Habitacion hab = hadao.getHabitacion(habitacion_n);

			pst1 = con.prepareStatement(sql1);

			pst1.setString(1, "ocupada");
			pst1.setInt(2, hab.getN_habitacion());

			if (pst2.executeUpdate(sql2) == 1) {// que devuelva una fila afectada

			}

			else {
				pst2.setString(1, "disponible");
				pst2.setInt(2, hab.getN_habitacion());

			}
		}
		}
		return ret;

	}

	public boolean anularReserva(int cliente_id, int habitacion_n) throws SQLException {

		boolean anu = false;
		con = Conexion.getInstance().getConnection();

		String sql = "DELETE FROM reserva WHERE cliente_id=? AND habitacion_n=?";// borrar la reserva
		String sql1 = "UPDATE habitacion SET disponibilidad=? WHERE n_habitacion";// actualizar la bdd

		// tabla reserva borrar
		pst = con.prepareStatement(sql);
		pst.setInt(1, cliente_id);
		pst.setInt(2, habitacion_n);
		pst.executeUpdate();

		// tabla habitacion actualizando
		hadao = new HabitacionDAO();
		Habitacion hab = hadao.getHabitacion(habitacion_n);
		pst2 = con.prepareStatement(sql1);
		pst2.setString(1, hab.getDisponibilidad() + 1);
		pst2.setInt(2, habitacion_n);
		pst2.executeUpdate();

		return anu;

	}

}
