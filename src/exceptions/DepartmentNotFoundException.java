package exceptions;

public class DepartmentNotFoundException extends Exception{
private static final long serialVersionUID = 1L;
	
	public DepartmentNotFoundException() {
		super("Departamento no encontrado.");
	}
}
