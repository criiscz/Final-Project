package models;

public class Buy extends Transaction{

	@Override
	protected int transaction(int budget, int deposit) {
		return budget-=deposit;
	}

}
