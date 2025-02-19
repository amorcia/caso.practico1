package servicios;

public interface LogInterfaz {

	void generarLog(String err, String titulo);
	String obtenerTrazaError(Exception e);
	
}
