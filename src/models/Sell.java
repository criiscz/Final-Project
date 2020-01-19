package models;

public class Sell extends Transaction{

	@Override
	protected int transaction(int Budget, int mont) {
		return Budget += mont;
	}

}
