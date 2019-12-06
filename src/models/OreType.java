package models;

public enum OreType {
	NIQUEL("Niquel"),
	PETROL("Petroléo"),
	GOLD("Oro"),
	EMERALD("Esmeralda")
	,IRON("Hierro"),
	PLATE("Plata"),
	COBRE("Cobre"),
	PLOMO("Plomo"),
	PLATINO("Platino"),
	TITANIO("Titanio"),
	MANGANESO("Manganeso"),
	AGREGADOS("Agregados");
	
	private String oreType;
	private OreType(String name) {
		oreType = name;
	}
	
	public String getOreType() {
		return oreType;
	}
}
