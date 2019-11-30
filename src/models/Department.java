package models;

import java.util.List;

public class Department {
	private String name;
	private List<Mine> listMine;
	private int budgetDepartment;
	
	public Department(String name, int budgetDepartment) {
		this.name = name;
		this.budgetDepartment = budgetDepartment;
	}
	
	public Mine createMine(String name, int meter, OreType oreType, int kilogramPrice, int id, MineType mineType, int budgetMine) {
		return new Mine(name,meter,oreType, kilogramPrice,id,mineType,budgetMine);
	}
	
	public void addMine(Mine mine) {
		budgetDepartment -= mine.getBudgetMine();
		listMine.add(mine);
	}
	
}
