package models;

/**
 * Enumerado con los nombres de los departamentos a utilizar
 * 
 * @author Criis
 * @author Felipe
 *
 */
public enum DepartmentName {

	BOYACA("Boyaca"), CUNDINAMARCA("Cundinamarca"), ANTIOQUIA("Antioquia"), NORTE_DE_SANTANDER("Norte de Santander"),
	SANTANDER("Santander"), TOLIMA("Tolima"), CAUCA("Cauca"), LA_GUAJIRA("La Guajira"), CESAR("Cesar"),
	CORDOBA("Cordoba");

	private String name;

	private DepartmentName(String name) {
		this.name = name;
	}

	/**
	 * Retorna el nombre del departamento.
	 * 
	 * @return Retorna el almacenado en el enumarado.
	 */
	public String getName() {
		return name;
	}
}
