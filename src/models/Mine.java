package models;

import models.utils.RandomizeGenerator;

public class Mine {
	private String name;
	private int meter;
	private OreType oreType; //EDIT
	private int kilogramPrice; //EDIT
	private int id;
	private MineType mineType; //EDIT
	private int budgetMine; //EDIT(POSIBLE)
	private Transaction transaction;
	private int gain;
	
	public Mine(String name, int meter, OreType oreType, int kilogramPrice, int id, MineType mineType, int budgetMine) {
		this.name = name;
		this.meter = meter;
		this.oreType = oreType;
		this.kilogramPrice = kilogramPrice;
		this.id = id;
		this.mineType = mineType;
		this.budgetMine = budgetMine;
		generateDate();
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
	
	public void sellOre(int kilos) {
		transaction = new Sell();
		gain += transaction.transaction(budgetMine, kilos*kilogramPrice);
		budgetMine = transaction.transaction(budgetMine, kilos*kilogramPrice);
	}
	
	public void buyInsumes(int value) {
		transaction = new Buy();
		gain-= budgetMine - transaction.transaction(budgetMine, value);
		budgetMine = transaction.transaction(budgetMine, value);
	}
	
	public void generateDate() {
		gain = RandomizeGenerator.generateRandomInt(-20,80);
	}
	
	public int getGain() {
		return gain;
	}

}
