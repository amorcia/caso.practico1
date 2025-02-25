package servicios;

import controladores.Inicio;
import dtos.ClienteDto;

public class ClienteImplementacion implements ClienteInterfaz {

	public static final char[] LETRA = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
			'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	public static byte intentos = 0;
	public static long id = 0;
	
	@Override
	public void nuevoCliente() throws Exception {
	    intentos++;
	    ClienteDto cliente = new ClienteDto();
	    System.out.println("Introduzca su DNI con la letra en mayúscula: ");
	    String dni = Inicio.scanner.next();

	    // Validamos que el DNI no esté ya en uso
	    while (comprobarDniUsado(dni)) {
	        System.out.println("Introduzca un nuevo DNI (el anterior ya está registrado): ");
	        dni = Inicio.scanner.next();
	    }
	    
	    cliente.setDni(dni);

	    System.out.println("Introduzca su nombre completo: ");
	    Inicio.scanner.nextLine(); // Limpiar el buffer
	    String nombreCompleto = Inicio.scanner.nextLine();
	    cliente.setNombreCompleto(nombreCompleto);
	    System.out.println("Introduzca su email: ");
	    cliente.setEmail(Inicio.scanner.next());
	    System.out.println("Introduzca su contraseña: ");
	    cliente.setContraseña(Inicio.scanner.next());

	    // Lista para partir el nombre completo
	    String[] listaString = nombreCompleto.split(" ");
	    String nombre = listaString[0];
	    String apellido1 = listaString[1];

	    if (listaString.length == 3) {
	        String apellido2 = listaString[2];
	        cliente.setApellido2(apellido2);
	    } else {
	        cliente.setApellido2("");
	    }

	    cliente.setNombre(nombre);
	    cliente.setApellido1(apellido1);
	    validarDni(cliente.getDni());

	    Inicio.clientes.put(++id, cliente);
	    System.out.println("Cliente registrado correctamente.");
	   
	}


	public static String validarDni(String dni) throws Exception {
		String dniAVerificar = dni.substring(0, 8);
		int dniSinLetra = Integer.parseInt(dniAVerificar);
		char letraComprobada = LETRA[dniSinLetra % 23];
		if (letraComprobada == dni.charAt(8)) {
			System.out.println("DNI valido");
		} else {
			System.out.println("DNI incorrecto, intentelo de nuevo\n");
			System.out.println("Introduzca el DNI: ");
			dni = Inicio.scanner.next();
			validarDni(dni);
		}
		return dni;
	}
	
	private boolean comprobarDniUsado(String dniAComprobar) throws Exception {
	    for(Long idCliente : Inicio.clientes.keySet()) {
	        ClienteDto cliente = Inicio.clientes.get(idCliente);
	        if(cliente.getDni().equals(dniAComprobar)) {
	            System.out.println("DNI ya registrado.\n");
	            return true;
	        }
	    }
	    return false;
	}


	@Override
	public void accederCliente() throws Exception {
		intentos = 0;
		do {
			System.out.println("Introduzca su email: ");
			String emailAComprobar = Inicio.scanner.next();
			System.out.println("Introduzca su contraseña: ");
			String contraseñaAComprobar = Inicio.scanner.next();
			for(Long idCliente : Inicio.clientes.keySet()) {
				ClienteDto cliente = Inicio.clientes.get(idCliente);
				String email = cliente.getEmail();
				String contraseña = cliente.getContraseña();
				intentos++;
				if (email.equals(emailAComprobar) && contraseña.equals(contraseñaAComprobar)
						&& cliente.isEsValidado() == true) {
					System.out.println("INICIO DE SESIÓN CORRECTO");
					cliente.setSesion(true);
					return;
				} else {
					System.out.println("Sesión incorrecta, intentelo de nuevo\n");
				}
			}

		} while (intentos < 3);

	}


	@Override
	public void cerrarSesion() throws Exception {
		System.out.println("¿Está seguro que quiere cerrar la sesion de su cuenta?(Si/No): ");
		String mensaje = Inicio.scanner.next();
		if(mensaje.substring(0,2) == "Si" || mensaje.substring(0,2) == "SI" || mensaje.substring(0,2) == "si") {
			System.out.println("Introduzca el nombre de su sesión");
			String nombreAVerificar = Inicio.scanner.next();
			for(Long idCliente : Inicio.clientes.keySet()) {
				ClienteDto cliente = Inicio.clientes.get(idCliente);
				String nombre = cliente.getNombre();
				if(nombre.equals(nombreAVerificar)) {
					cliente.setSesion(false);
				}
			}
		}else {
			System.out.println("Volviendo al menú principal");
		}
		
	}
	
	
}
