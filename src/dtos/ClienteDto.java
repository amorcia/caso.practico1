package dtos;

public class ClienteDto implements Comparable<ClienteDto> {
	long id;
	String dni;
	String nombreCompleto;
	String nombre = "aaaaa";
	String apellido1;
	String apellido2;
	String email;
	String contraseña;
	boolean sesion = false;
	boolean esValidado = false;
	
	public long getId() {
		return id;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public boolean isEsValidado() {
		return esValidado;
	}
	
	public void setEsValidado(boolean esValidado) {
		this.esValidado = esValidado;
	}

	public boolean isSesion() {
		return sesion;
	}

	public void setSesion(boolean sesion) {
		this.sesion = sesion;
	}

	@Override
	public String toString() {
		return ("DNI: ").concat(dni).concat("\n").concat("NOMBRE: ")
				.concat(apellido1).concat(" ").concat(apellido2).concat(", ").concat(nombre)
				.concat("\n").concat("ESTADO VALIDACIÓN: ") + esValidado + 
				"\n".concat("%%%%%%%%%%");
	}
	
	@Override
	public int compareTo(ClienteDto o) {
	    if (o == null) {
	        System.err.println("No se puede comparar con un objeto nulo");
	    }
	    return o.apellido1.compareTo(this.apellido1);
	}
	
}
