package exceptions;

public class InvalidConstantException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidConstantException() {
		super("Error al establecer tipo de encabezado en reporte");
	}
}
