package models;

/**
 * Clase padre Transaction que contiene metodos para generar economia en la mina.
 * @author Criis
 *
 */
public abstract class Transaction {
	
	/**
	 * Metodo encargado de realizar una transaccion que necesite dos valores numericos
	 * @param Budget
	 * Presupuesto sobre el que se esta realizando la transaccion
	 * @param mont
	 * monto el cual se le va a agregar o reducir al parametro anterior.
	 * @return
	 * Retorna el valor total despues de realizar la transaccion.
	 */
	protected abstract int transaction(int Budget, int mont);

}
