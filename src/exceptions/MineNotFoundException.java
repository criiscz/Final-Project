package exceptions;

public class MineNotFoundException extends Exception{
private static final long serialVersionUID = 1L;
	
	public MineNotFoundException() {
		super("la mina no fue encontrada.");
	}
}
