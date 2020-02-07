package exceptions;

/**
 * Excepcion lanzada al no encontrar un objeto de tipo Mine.
 * 
 * @author Criis
 * @author Felipe
 */

public class MineNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public MineNotFoundException() {
		super("la mina no fue encontrada.");
	}
}
