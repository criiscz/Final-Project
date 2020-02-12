package models;

/**
 * Enumerado que almacena los distintos minerales explotados en el pais.
 * 
 * @author Criis
 * @author Felipe
 *
 */
public enum OreType {
	NIQUEL("Niquel"), PETROL("Petroléo"), GOLD("Oro"), EMERALD("Esmeralda"), IRON("Hierro"), PLATE("Plata"),
	COBRE("Cobre"), PLOMO("Plomo"), PLATINO("Platino"), TITANIO("Titanio"), MANGANESO("Manganeso"),
	AGREGADOS("Agregados"), COAL("Carbon");

	private String oreType;

	private OreType(String name) {
		oreType = name;
	}

	/**
	 * Returns content of the constant.
	 * 
	 * @return Returns content of the constant.
	 */
	public String getOreType() {
		return oreType;
	}
}
