package models;

public enum MineType {
		
	OPEN_PIT_MINE("Mina al aire libre"), SUBTERRANEAN_MINE("Mina subterranea");
	
	private String mineType;
	
	private MineType(String mineType) {
		this.mineType = mineType;
	}
	
	public String getMineType() {
		return mineType;
	}
}
