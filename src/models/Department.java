package models;

import java.util.List;

import exceptions.MineNotFoundException;

public class Department {
	private String name;
	private List<Mine> listMine;
	private int budgetDepartment;
	
	public Department() {
		
	}
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
	public Mine searchMine(String name) throws MineNotFoundException {
		for (int i = 0; i < listMine.size(); i++) {
			if (listMine.get(i).getName().equals(name)) {
				return listMine.get(i);
			}
		}
		throw new MineNotFoundException();
	}
	public int searchPositionMine(String name)throws MineNotFoundException{
		for (int i = 0; i < listMine.size(); i++) {
			Mine minee = listMine.get(i);
			if (minee.getName().equals(name)) {
				return i;
			}
		}
		throw new MineNotFoundException();
	}
	
	public void removeMineByName(String name)throws MineNotFoundException {
		int positionFound = searchPositionMine(name);
		listMine.remove(positionFound);
	}
	
}
