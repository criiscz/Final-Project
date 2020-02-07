package exceptions;

/**
 * Excepcion lanzada al no encontrar un objeto de tipo Department.
 * @author Criis
 * @author Felipe
 */
public class DepartmentNotFoundException extends Exception{
private static final long serialVersionUID = 1L;
	
	public DepartmentNotFoundException() {
		super("Departamento no encontrado.");
	}
}
