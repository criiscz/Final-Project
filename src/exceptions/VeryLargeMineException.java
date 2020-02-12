package exceptions;

public class VeryLargeMineException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public VeryLargeMineException() {
		super("la Mina no puede exceder de 800m2 ");
	}
}
