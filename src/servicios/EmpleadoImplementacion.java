package servicios;

import controladores.Inicio;
import dtos.ClienteDto;

public class EmpleadoImplementacion implements EmpleadoInterfaz {

	@Override
	public void validarCliente() {
		for(ClienteDto cliente : Inicio.clientes) {
			if(cliente.isEsValidado() == false) {
				System.out.println(cliente.toString());
			}
		}
		System.out.println("Introduzca el dni a verificar: ");
		String dniAComprobar = Inicio.scanner.next();
		for(ClienteDto cliente : Inicio.clientes) {
			String dni = cliente.getDni();
			if(dni.equals(dniAComprobar)) {
				cliente.setEsValidado(true);
			}
		}
	}

	@Override
	public void borrarCliente() {
		ClienteImplementacion clienteImp = new ClienteImplementacion();
		ClienteDto clienteABorrar = new ClienteDto();
		boolean esInexistente = true;
		System.out.println("Introduzca el dni del cliente a borrar: ");
		String dniABorrar = Inicio.scanner.next();
		clienteImp.validarDni(dniABorrar);
		for(ClienteDto cliente : Inicio.clientes) {
			String dni = cliente.getDni();
			if(dni.equals(dniABorrar)) {
				clienteABorrar = cliente;
				esInexistente = false;
			}
		}
		if(esInexistente == false) {
			Inicio.clientes.remove(clienteABorrar);
			System.out.println("Se ha borrado con exito");
		}else {
			System.out.println("Dni no encontrado");
		}
	}

	@Override
	public void mostrarClientes() {
		for(ClienteDto cliente : Inicio.clientes) {
			if(cliente.isEsValidado() == true) {
				System.out.println(cliente.toString());
			}
		}
		
	}
	
	

}
