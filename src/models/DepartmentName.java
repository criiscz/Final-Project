package models;

public enum DepartmentName {

	BOYACA("Boyaca"),CUNDINAMARCA("Cundinamarca");
	
	String name;
	
	private DepartmentName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
