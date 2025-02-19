package controladores;

import java.util.HashMap;
import java.util.Scanner;

import dtos.ClienteDto;
import servicios.ClienteImplementacion;
import servicios.ClienteInterfaz;
import servicios.EmpleadoImplementacion;
import servicios.EmpleadoInterfaz;
import servicios.LogImplementacion;
import servicios.LogInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;

public class Inicio {

	public static Scanner scanner = new Scanner(System.in);
	public static HashMap<Long,ClienteDto> clientes = new HashMap<Long,ClienteDto>();
	
	public static void main(String[] args) {
		MenuInterfaz menu = new MenuImplementacion();
		ClienteInterfaz cliente = new ClienteImplementacion();
		EmpleadoInterfaz empleado = new EmpleadoImplementacion();
		LogInterfaz log = new LogImplementacion();
		boolean esCerrado = false;
		
		do {
			byte opcionUsuario = menu.menuPrincipal();
			switch (opcionUsuario) {
			case 0:
				esCerrado = true;
				break;
			case 1:
				opcionUsuario = menu.menuCliente();
				switch (opcionUsuario) {
				case 1:
					try {
					cliente.nuevoCliente();
					}catch (Exception e) {
						String titulo = "[ERROR - servicios.Cliente.nuevoCliente()] \nMétodo alta del cliente";
						String err = "ERROR: ".concat(e.getMessage()).concat("\n").concat(log.obtenerTrazaError(e));
						log.generarLog(err, titulo);
						System.err.println("Error en el case " + opcionUsuario + " para mas información consulte el archivo log.txt");
					}
					
					break;
				case 2:
					try {
					cliente.accederCliente();
					}catch (Exception e) {
						String titulo = "[ERROR - servicios.Cliente.accederCliente()] \nMétodo acceso cliente";
						String err = "ERROR: ".concat(e.getMessage()).concat("\n").concat(log.obtenerTrazaError(e));
						log.generarLog(err, titulo);
						System.err.println("Error en el case " + opcionUsuario + " para mas información consulte el archivo log.txt");
					}
					
					break;
				case 3:
					
					break;

				default:
					System.out.println("Opción inexistente");
					break;
				}
				break;
			case 2:
				opcionUsuario = menu.menuEmpleado();
				switch (opcionUsuario) {
				case 1:
					try {
					empleado.validarCliente();
					}catch (Exception e) {
						String titulo = "[ERROR - servicios.Empleado.validarCliente()] \nMétodo validación del cliente";
						String err = "ERROR: ".concat(e.getMessage()).concat("\n").concat(log.obtenerTrazaError(e));
						log.generarLog(err, titulo);
						System.err.println("Error en el case " + opcionUsuario + " para mas información consulte el archivo log.txt");
					}
					break;
				case 2:
					try {
					empleado.borrarCliente();
					}catch (Exception e) {
						String titulo = "[ERROR - servicios.Empleado.borrarCliente()] \nMétodo borrar cliente";
						String err = "ERROR: ".concat(e.getMessage()).concat("\n").concat(log.obtenerTrazaError(e));
						log.generarLog(err, titulo);
						System.err.println("Error en el case " + opcionUsuario + " para mas información consulte el archivo log.txt");
					}
					break;
				case 3:
					try {
					empleado.mostrarClientes();
					}catch (Exception e) {
						String titulo = "[ERROR - servicios.Empleado.mostrarCliente()] \nMétodo mostrar cliente";
						String err = "ERROR: ".concat(e.getMessage()).concat("\n").concat(log.obtenerTrazaError(e));
						log.generarLog(err, titulo);
						System.err.println("Error en el case " + opcionUsuario + " para mas información consulte el archivo log.txt");
					}
					break;
				case 4:
					
					break;

				default:
					System.out.println("Opción inexistente");
					break;
				}
				break;

			default:
				System.out.println("Opción inexistente");
				break;
			}
			
		} while (!esCerrado);

	}

}
