package models;

public enum DepartmentName {

	BOYACA("Boyaca"),
	CUNDINAMARCA("Cundinamarca"),
	ANTIOQUIA("Antioquia"),
	NORTE_DE_SANTANDER("Norte de Santander"),
	SANTANDER("Santander"),
	TOLIMA("Tolima"), 
	CAUCA("Cauca"), 
	LA_GUAJIRA("La Guajira"), 
	CESAR("Cesar"), 
	CORDOBA("Cordoba");
	
	String name;
	
	private DepartmentName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
