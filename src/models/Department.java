package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.MineNotFoundException;

public class Department {
	private DepartmentName name;
	private List<Mine> listMine;
	private int budgetDepartment;
	
	public Department(DepartmentName name, int budgetDepartment) {
		this.name = name;
		this.budgetDepartment = budgetDepartment;
		listMine = new ArrayList<>();
	}
	
	public String getName() {
		return name.getName();
	}
	
	public int getBudgetDepartment() {
		return budgetDepartment;
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
