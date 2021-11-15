package es.eoi.modelo;

public class Cliente {
	private int idclientes;
	private String nombre;
	private String apellidos;
	private String dni;
	private int tel;
	private String email;
	private String rol;
	private String pass;
	
	public Cliente() {
		
	}
	
	public Cliente(int idclientes, String nombre, String apellidos, String dni, int tel, String email, String rol,
			String pass) {
		super();
		this.idclientes = idclientes;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.tel = tel;
		this.email = email;
		this.rol = rol;
		this.pass = pass;
	}
	
	public int getIdclientes() {
		return idclientes;
	}
	
	public void setIdclientes(int idclientes) {
		this.idclientes = idclientes;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getTel() {
		return tel;
	}
	
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRol() {
		return rol;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

}
