package models;

public abstract class Transaction {
	private int ganancias = 0;
	
	protected abstract int transaction(int Budget, int mont);
	
	public int getGanancias() {
		return ganancias;
	}

	public void setGanancias(int ganancias) {
		this.ganancias = ganancias;
	}
	
}
