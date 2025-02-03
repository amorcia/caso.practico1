package servicios;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz {

	@Override
	public byte menuPrincipal() {
		System.out.println("---MENÚ---");
		System.out.println("0.Cerrar menú");
		System.out.println("1.Version Cliente");
		System.out.println("2.Version Empleado");
		System.out.println("---------");
		System.out.println("Seleccione la opción deseada");
		byte opcionUsuario = Inicio.scanner.nextByte();
		return opcionUsuario;
	}

	public byte menuCliente() {
		System.out.println("1.Registro Cliente");
		System.out.println("2.Acceso Cliente");
		System.out.println("3.Volver al menú inicial");
		byte opcionUsuario = Inicio.scanner.nextByte();
		return opcionUsuario;
	}

	@Override
	public byte menuEmpleado() {
		System.out.println("1.Validar Cliente");
		System.out.println("2.Borrar Cliente");
		System.out.println("3.Mostrar Cliente");
		System.out.println("4.Volver al menú inicial");
		byte opcionUsuario = Inicio.scanner.nextByte();
		return opcionUsuario;
	}

}
