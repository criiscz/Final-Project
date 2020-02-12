package models;

/**
 * Se encarga de hacer una compra.
 * 
 * @author Criis
 * @author Felipe
 */
public class Buy extends Transaction {

	@Override
	protected int transaction(int budget, int deposit) {
		return budget -= deposit;
	}

}
