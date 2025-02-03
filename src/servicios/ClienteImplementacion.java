package servicios;

import controladores.Inicio;
import dtos.ClienteDto;

public class ClienteImplementacion implements ClienteInterfaz {

	public static final char[] LETRA = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
			'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	public static byte intentos = 0;

	@Override
	public void nuevoCliente() {
		intentos++;
		ClienteDto cliente = new ClienteDto();
		System.out.println("Introduzca su DNI con la letra en mayúscula: ");
		cliente.setDni(Inicio.scanner.next());
		String dni = cliente.getDni();
		System.out.println("Introduzca su nombre completo: ");
		Inicio.scanner.nextLine();
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

		Inicio.clientes.add(cliente);
		validarDni(dni);
		if(intentos >= 2) {
		comprobarDniUsado(dni);
		}
	}

	public static String validarDni(String dni) {
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

	private long calcularId() {
		long id;
		long idAuxiliar = 0;
		id = idAuxiliar + 1;
		idAuxiliar = id;
		return id;
	}
	
	private void comprobarDniUsado(String dniAComprobar) {
		for(ClienteDto cliente : Inicio.clientes) {
			if(cliente.getDni().equals(dniAComprobar)) {
				System.out.println("Dni ya registrado.\n");
				System.out.println("Introduzca de nuevo el Dni: ");
				cliente.setDni(Inicio.scanner.next());
			}
		}
	}

	@Override
	public void accederCliente() {
		intentos = 0;
		do {
			System.out.println("Introduzca su email: ");
			String emailAComprobar = Inicio.scanner.next();
			System.out.println("Introduzca su contraseña: ");
			String contraseñaAComprobar = Inicio.scanner.next();
			for (ClienteDto cliente : Inicio.clientes) {
				String email = cliente.getEmail();
				String contraseña = cliente.getContraseña();
				intentos++;
				if (email.equals(emailAComprobar) && contraseña.equals(contraseñaAComprobar)
						&& cliente.isEsValidado() == true) {
					System.out.println("INICIO DE SESIÓN CORRECTO");
					return;
				} else {
					System.out.println("Sesión incorrecta, intentelo de nuevo\n");
				}
			}

		} while (intentos < 3);

	}
}
