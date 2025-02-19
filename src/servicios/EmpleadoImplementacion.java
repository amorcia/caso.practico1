package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import controladores.Inicio;
import dtos.ClienteDto;

public class EmpleadoImplementacion implements EmpleadoInterfaz {

	@Override
	public void validarCliente() throws Exception {
		for(Long idCliente : Inicio.clientes.keySet()) {
			ClienteDto cliente = Inicio.clientes.get(idCliente);
			if(cliente.isEsValidado() == false) {
				System.out.println(cliente.toString());
			}
		}
		System.out.println("Introduzca el dni a verificar: ");
		String dniAComprobar = Inicio.scanner.next();
		for(Long idCliente : Inicio.clientes.keySet()) {
			ClienteDto cliente = Inicio.clientes.get(idCliente);
			String dni = cliente.getDni();
			if(dni.equals(dniAComprobar)) {
				cliente.setEsValidado(true);
			}
		}
	}

	@Override
	public void borrarCliente() throws Exception {
		ClienteImplementacion clienteImp = new ClienteImplementacion();
		long clienteABorrar = 0;
		boolean esInexistente = true;
		System.out.println("Introduzca el dni del cliente a borrar: ");
		String dniABorrar = Inicio.scanner.next();
		clienteImp.validarDni(dniABorrar);
		for(Long idCliente : Inicio.clientes.keySet()) {
			ClienteDto cliente = Inicio.clientes.get(idCliente);
			String dni = cliente.getDni();
			if(dni.equals(dniABorrar)) {
				clienteABorrar = idCliente;
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
	public void mostrarClientes() throws Exception {
		System.out.println("1.Orden Descendente");
		System.out.println("2.Orden Ascendente");
		System.out.println("¿De que forma quiere ver ordenados los clientes?");
		byte opcionOrden = Inicio.scanner.nextByte();
		
		if(opcionOrden == 1) {
			ordenarDesc();
		}else if(opcionOrden == 2) {
			ordenarAsc();
		}
	}

	@Override
	public void ordenarDesc() throws Exception {
		TreeSet<ClienteDto> clientesOrdenados = new TreeSet<>((cliente1, cliente2) -> 
        cliente2.getApellido1().compareTo(cliente1.getApellido1()) // Comparación descendente
    );

		for(Long idCliente : Inicio.clientes.keySet()) {
			ClienteDto cliente = Inicio.clientes.get(idCliente);
			if(cliente.isEsValidado() == true) {
				clientesOrdenados.addAll(Inicio.clientes.values());
			}
		}
		
    // Mostrar los clientes ordenados
    for (ClienteDto cliente : clientesOrdenados) {
        System.out.println(cliente.toString());
    }
		
	}

	@Override
	public void ordenarAsc() throws Exception {
	    // Convertir los clientes del HashMap en una lista
	    List<ClienteDto> listaClientes = new ArrayList<>(Inicio.clientes.values());

	    for (int i = 0; i < listaClientes.size() - 1; i++) {
	        for (int j = 0; j < listaClientes.size() - 1 - i; j++) {
	            // Comparar los apellidos de dos clientes
	            if (listaClientes.get(j).getApellido1().compareTo(listaClientes.get(j + 1).getApellido1()) > 0) {
	                // Intercambiar los elementos si están en el orden incorrecto
	                ClienteDto temp = listaClientes.get(j);
	                listaClientes.set(j, listaClientes.get(j + 1));
	                listaClientes.set(j + 1, temp);
	            }
	        }
	    }

	    // Imprimir los clientes ordenados
	    for (ClienteDto cliente : listaClientes) {
	        System.out.println(cliente.toString());
	    }
	}

	
	

}
