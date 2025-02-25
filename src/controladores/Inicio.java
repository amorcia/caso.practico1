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
				log.generarLog("Se ha cerrado la aplicación", "Opcion 0 seleccionada");
				break;
			case 1:
				opcionUsuario = menu.menuCliente();
				log.generarLog("Se ha seleccionado el menú cliente", "Opcion 1 seleccionada");
				switch (opcionUsuario) {
				case 1:
					try {
					cliente.nuevoCliente();
					log.generarLog("Se ha accedido al metodo de alta Cliente", "Opcion 1 seleccionada");
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
					log.generarLog("Se ha accedido al metodo de inicio de sesión de cliente", "Opcion 2 seleccionada");
					}catch (Exception e) {
						String titulo = "[ERROR - servicios.Cliente.accederCliente()] \nMétodo acceso cliente";
						String err = "ERROR: ".concat(e.getMessage()).concat("\n").concat(log.obtenerTrazaError(e));
						log.generarLog(err, titulo);
						System.err.println("Error en el case " + opcionUsuario + " para mas información consulte el archivo log.txt");
					}
					
					break;
				case 3:
					try {
						cliente.cerrarSesion();
						log.generarLog("Se ha accedido al metodo de cerrar la sesión de cliente", "Opcion 3 seleccionada");
					}catch (Exception e) {
						String titulo = "[ERROR - servicios.Cliente.cerrarSesion()] \nMétodo de cerrar la sesión del cliente";
						String err = "ERROR: ".concat(e.getMessage()).concat("\n").concat(log.obtenerTrazaError(e));
						log.generarLog(err, titulo);
						System.err.println("Error en el case " + opcionUsuario + " para mas información consulte el archivo log.txt");
					}
				case 4:
					log.generarLog("Se ha vuelto al menú principal", "Opcion 4 seleccionada");
					break;

				default:
					System.out.println("Opción inexistente");
					break;
				}
				break;
			case 2:
				opcionUsuario = menu.menuEmpleado();
				log.generarLog("Se ha seleccionado el menu empleado", "Opcion 2 seleccionada");
				switch (opcionUsuario) {
				case 1:
					try {
					empleado.validarCliente();
					log.generarLog("Se ha accedido al metodo de validación del cliente", "Opcion 1 seleccionada");
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
					log.generarLog("Se ha accedido al metodo de borrar un cliente", "Opcion 2 seleccionada");
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
					log.generarLog("Se ha accedido al metodo de mostrar los clientes", "Opcion 3 seleccionada");
					}catch (Exception e) {
						String titulo = "[ERROR - servicios.Empleado.mostrarCliente()] \nMétodo mostrar cliente";
						String err = "ERROR: ".concat(e.getMessage()).concat("\n").concat(log.obtenerTrazaError(e));
						log.generarLog(err, titulo);
						System.err.println("Error en el case " + opcionUsuario + " para mas información consulte el archivo log.txt");
					}
					break;
				case 4:
					log.generarLog("Se ha vuelto al menú principal", "Opcion 4 seleccionada");
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
