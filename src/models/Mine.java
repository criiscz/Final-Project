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
		return new Object[] {id,name,meter,oreType,kilogramPrice,mineType.getMineType(),budgetMine};
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMeter(int meter) {
		this.meter = meter;
	}

	public void setOreType(OreType oreType) {
		this.oreType = oreType;
	}

	public void setKilogramPrice(int kilogramPrice) {
		this.kilogramPrice = kilogramPrice;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMineType(MineType mineType) {
		this.mineType = mineType;
	}

	public void setBudgetMine(int budgetMine) {
		this.budgetMine = budgetMine;
	}
}
