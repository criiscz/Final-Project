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
	
	public Mine createMine() {
		return null;
	}
	
	public void addMine() {
		
	}
	
}
