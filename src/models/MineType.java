package models;

/**
 * Enumerado con los tipos de mina disponibles.
 * 
 * @author Criis
 *
 */
public enum MineType {

	OPEN_PIT_MINE("Mina al aire libre"), SUBTERRANEAN_MINE("Mina subterranea");

	private String mineType;

	private MineType(String mineType) {
		this.mineType = mineType;
	}

	/**
	 * Returns the value of constant.
	 * 
	 * @return Returns the value of constant.
	 */
	public String getMineType() {
		return mineType;
	}
}
