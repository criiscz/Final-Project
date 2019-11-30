package models;

public class Mine {
	private String name;
	private int meter;
	private OreType oreType;
	private int kilogramPrice;
	private int id;
	private MineType mineType;
	private int budgetMine;
	
	public Mine(String name, int meter, OreType oreType, int kilogramPrice, int id, MineType mineType, int budgetMine) {
		this.name = name;
		this.meter = meter;
		this.oreType = oreType;
		this.kilogramPrice = kilogramPrice;
		this.id = id;
		this.mineType = mineType;
		this.budgetMine = budgetMine;
	}
}
