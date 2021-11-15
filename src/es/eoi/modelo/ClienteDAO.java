package es.eoi.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.eoi.servicios.Conexion;

public class ClienteDAO {

	// crear las variables para mayor facilidad y no crearlas mas
	private Connection con;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;

	// obtener el usuario cliente a partir del identificador idClientes

	public Cliente getCliente(int idclientes) throws SQLException {

		con = Conexion.getInstance().getConnection();
		String sql = "SELECT * FROM clientes WHERE idclientes = ?";

		pst = con.prepareStatement(sql);
		pst.setInt(1, idclientes);

		rs = pst.executeQuery();

		Cliente clie = null;

		if (rs.next()) {
			clie = new Cliente();
			clie.setIdclientes(rs.getInt(1));
			clie.setNombre(rs.getString(2));
			clie.setApellidos(rs.getString(3));
			clie.setDni(rs.getString(4));
			clie.setTel(rs.getInt(5));
			clie.setEmail(rs.getString(6));
			clie.setRol(rs.getString(7));
			clie.setPass(rs.getString(8));
		}

		return clie;
	}

	// obtener todos los clientes con una lista, por ello no hay parámetros de entrada

	public List<Cliente> getClientes() throws SQLException {
		
		con = Conexion.getInstance().getConnection();
		String sql = "SELECT * FROM clientes";

		st = con.createStatement();  //st porque no depende de parámetros
		rs = st.executeQuery(sql);

		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente clie = null;

		while (rs.next()) {
			clie = new Cliente();
			clie.setIdclientes(rs.getInt(1));
			clie.setNombre(rs.getString(2));
			clie.setApellidos(rs.getString(3));
			clie.setDni(rs.getString(4));
			clie.setTel(rs.getInt(5));
			clie.setEmail(rs.getString(6));
			clie.setRol(rs.getString(7));
			clie.setPass(rs.getString(8));
			lista.add(clie);
		}
		
		return lista;
	}

	// insertar en la BBDD un usuario a partir de cliente

	public int addCliente(Cliente clie) throws SQLException {

		con = Conexion.getInstance().getConnection();
		String sql = "INSERT INTO clientes(nombre,apellidos,dni,tel,email,rol,pass) VALUES (?,?,?,?,?,?,?)";

		pst = con.prepareStatement(sql);
		pst.setString(1, clie.getNombre());
		pst.setString(2, clie.getApellidos());
		pst.setString(3, clie.getDni());
		pst.setInt(4, clie.getTel());
		pst.setString(5, clie.getEmail());
		pst.setString(6, clie.getRol());
		pst.setString(7, clie.getPass());

		return pst.executeUpdate();
	}
	// borramos de la BBDD un cliente a partir del id

	public int delCliente(int idclientes) throws SQLException {
		
		con = Conexion.getInstance().getConnection();
		String sql = "DELETE FROM clientes WHERE idclientes = ? ";

		pst = con.prepareStatement(sql);
		pst.setInt(1, idclientes);

		return pst.executeUpdate();
	}

	// actualizar en la BBDD un cliente a partir del objeto cliente

	public int updateClie(Cliente clie) throws SQLException {

		con = Conexion.getInstance().getConnection();
		String sql = "UPDATE clientes SET nombre=?,apellidos=?,dni=?,tel=?,email=?,rol=?,pass=? WHERE idclientes = ? ";

		pst = con.prepareStatement(sql);
		pst.setString(1, clie.getNombre());
		pst.setString(2, clie.getApellidos());
		pst.setString(3, clie.getDni());
		pst.setInt(4, clie.getTel());
		pst.setString(5, clie.getEmail());
		pst.setString(6, clie.getRol());
		pst.setString(7, clie.getPass());
		pst.setInt(8, clie.getIdclientes());

		return pst.executeUpdate();

	}
	
	// devuelve al cliente logado si existe en la BBDD a partir del email y del pass

	public Cliente login(String email, String pass) throws SQLException {
		
		con = Conexion.getInstance().getConnection();

		String sql = "SELECT * FROM clientes WHERE email=? AND pass=?";

		pst = con.prepareStatement(sql);
		pst.setString(1, email);
		pst.setString(2, pass);

		rs = pst.executeQuery();

		Cliente clie = null;  

		if (rs.next()) {

			clie = new Cliente();
			clie.setIdclientes(rs.getInt(1));
			clie.setNombre(rs.getString(2));
			clie.setApellidos(rs.getString(3));
			clie.setDni(rs.getString(4));
			clie.setTel(rs.getInt(5));
			clie.setEmail(rs.getString(6));
			clie.setRol(rs.getString(7));
			clie.setPass(rs.getString(8));

		}
		return clie;
	}
}
