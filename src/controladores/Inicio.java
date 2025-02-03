package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import dtos.ClienteDto;
import servicios.ClienteImplementacion;
import servicios.ClienteInterfaz;
import servicios.EmpleadoImplementacion;
import servicios.EmpleadoInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;

public class Inicio {

	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<ClienteDto> clientes = new ArrayList<ClienteDto>();
	
	public static void main(String[] args) {
		MenuInterfaz menu = new MenuImplementacion();
		ClienteInterfaz cliente = new ClienteImplementacion();
		EmpleadoInterfaz empleado = new EmpleadoImplementacion();
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
					cliente.nuevoCliente();
					
					break;
				case 2:
					cliente.accederCliente();
					
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
					empleado.validarCliente();
					break;
				case 2:
					empleado.borrarCliente();
					break;
				case 3:
					empleado.mostrarClientes();
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
