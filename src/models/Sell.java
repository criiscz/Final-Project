package models;

public class Sell extends Transaction{

	@Override
	protected int transaction(int Budget, int mont) {
		setGanancias(getGanancias() - mont);
		return Budget -= mont;
	}

}
