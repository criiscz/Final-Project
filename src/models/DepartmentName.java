package models;

public enum DepartmentName {

	BOYACA("Boyaca"),CUNDINAMARCA("Cundinamarca"),ANTIOQUIA("Antioquia"),NORTE_DE_SANTANDER("Norte de Santander"),SANTANDER("Santander"),IBAGUE("Ibague");
	
	String name;
	
	private DepartmentName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
