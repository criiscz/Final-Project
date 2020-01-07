package models;

public class Buy extends Transaction{

	@Override
	protected int transaction(int budget, int deposit) {
		setGanancias(getGanancias() + deposit);
		return budget+=deposit;
	}

}
