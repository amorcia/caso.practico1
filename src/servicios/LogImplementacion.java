package servicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controladores.Inicio;
import dtos.ClienteDto;

public class LogImplementacion implements LogInterfaz {

	
	// Método para generar y escribir logs en el archivo
	@Override
    public void generarLog(String err, String titulo) {
		boolean sesionIniciada = false;
		String rutaArchivo = "aaaaa";
		
		for(Long idCliente : Inicio.clientes.keySet()) {
			ClienteDto cliente = Inicio.clientes.get(idCliente);
		if(cliente.isSesion() == true) {
			sesionIniciada = true;
			rutaArchivo = "logs/log".concat(cliente.getNombre()).concat(".txt");
		}
		}
		
		if(sesionIniciada == false) {
			rutaArchivo = "logs/logGeneral.txt";
		}
		
        String fechaYHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        // Agregar la fecha y hora al mensaje
        String mensajeAMostrar = fechaYHora.concat("\n").concat(titulo).concat("\n").concat(err).concat("\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            // Escribir el mensaje en el archivo
            writer.append(mensajeAMostrar);
        } catch (IOException e) {
        	//Control error Input Output
            System.err.println("Error al intentar escribir el log en el archivo: " + e.getMessage());
        }
    }
	
	public String obtenerTrazaError(Exception e) {
		StringBuilder sb = new StringBuilder();
        for (StackTraceElement elemento : e.getStackTrace()) {
            sb.append(elemento.toString()).append("\n");
        }
        return sb.toString();
	}
}

