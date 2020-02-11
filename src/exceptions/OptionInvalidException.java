package exceptions;

/**
 * Excepcion lanzada al determinar que el usuario a ingresado una opcion no
 * valida.
 * 
 * @author Criis
 * @author Felipe
 */
public class OptionInvalidException extends Exception {
	private static final long serialVersionUID = 1L;

	public OptionInvalidException() {
		super("Opcion Invalida");
	}
}
