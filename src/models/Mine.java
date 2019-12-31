package models;

public class Mine {
	private String name;
	private int meter;
	private OreType oreType; //EDIT
	private int kilogramPrice; //EDIT
	private int id;
	private MineType mineType; //EDIT
	private int budgetMine; //EDIT(POSIBLE)
	private Transaction transaction;
	
	public Mine(String name, int meter, OreType oreType, int kilogramPrice, int id, MineType mineType, int budgetMine) {
		this.name = name;
		this.meter = meter;
		this.oreType = oreType;
		this.kilogramPrice = kilogramPrice;
		this.id = id;
		this.mineType = mineType;
		this.budgetMine = budgetMine;
	}

	public String getName() {
		return name;
	}

	public int getMeter() {
		return meter;
	}

	public OreType getOreType() {
		return oreType;
	}

	public int getKilogramPrice() {
		return kilogramPrice;
	}

	public int getId() {
		return id;
	}

	public MineType getMineType() {
		return mineType;
	}

	public int getBudgetMine() {
		return budgetMine;
	}
	
	public Object[] toObjectVector() {
		return new Object[] {id,name,meter,oreType.getOreType(),kilogramPrice,mineType.getMineType(),budgetMine};
	}

	public void setOreType(OreType oreType) {
		this.oreType = oreType;
	}

	public void setKilogramPrice(int kilogramPrice) {
		this.kilogramPrice = kilogramPrice;
	}

	public void setMineType(MineType mineType) {
		this.mineType = mineType;
	}
	
	public void SellOre(int kilos) {
		transaction = new Sell();
		budgetMine = transaction.transaction(budgetMine, kilos*kilogramPrice);
	}
	
	public void buyInsumes(int value) {
		transaction = new Buy();
		budgetMine = transaction.transaction(budgetMine, value);
	}

}
