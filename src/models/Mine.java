package models;
/**
 * clase Mina, donde se le dan valores a las minas de cada Departamento.
 * @author Felipe and Cristian
 */		
public class Mine {
	private String name;
	private int meter;
	private OreType oreType; //EDIT
	private int kilogramPrice; //EDIT
	private int id;
	private MineType mineType; //EDIT
	private int budgetMine; //EDIT(POSIBLE)
	private Transaction transaction;
	private int gain;
	/**
	 * Constructor encargado de asignar los valores a cada mina.
	 * @param name
	 * Nombre de la mina.
	 * @param meter
	 * M2 de la mina.
	 * @param oreType
	 * Tipo de mineral que explota la mina.
	 * @param kilogramPrice
	 * Valor por Kg del mineral.
	 * @param id
	 * Numero de identificacion de la mina.
	 * @param mineType
	 * Tipo de mina(Al aire libre/subterranea).
	 * @param budgetMine
	 * Presupuesto de la mina.
	 */
	public Mine(String name, int meter, OreType oreType, int kilogramPrice, int id, MineType mineType, int budgetMine) {
		this.name = name;
		this.meter = meter;
		this.oreType = oreType;
		this.kilogramPrice = kilogramPrice;
		this.id = id;
		this.mineType = mineType;
		this.budgetMine = budgetMine;
	}
	/**
	 * Retorna el nombre de la mina.
	 * 
	 * @return Retorna el nombre de la mina.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Retorna los M2 de la mina.
	 * 
	 * @return Retorna los M2 de la mina.
	 */

	public int getMeter() {
		return meter;
	}
	/**
	 * Retorna el tipo de  mineral que explota mina.
	 * 
	 * @return Retorna el tipo de mineral que explota  la mina.
	 */
	public OreType getOreType() {
		return oreType;
	}
	/**
	 * Retorna el precio por Kg del mineral explotado por la mina.
	 * 
	 * @return Retorna el precio por Kg del mineral explotado por la mina.
	 */
	public int getKilogramPrice() {
		return kilogramPrice;
	}
	/**
	 * Retorna el numero de identificacion de la mina.
	 * 
	 * @return Numero de identificacion de la  mina.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Retorna el tipo de mina(al aire libre/subterranea).
	 * @return Retorna el tipo de mina.
	 */
	public MineType getMineType() {
		return mineType;
	}
	/**
	 * Retorna el presupuesto de  la mina.
	 * @return Retorna presupuesto de la mina.
	 */

	public int getBudgetMine() {
		return budgetMine;
	}

	/**
	 * Genera un vector de objetos que guarda datos importantes de la mina.
	 * @return Retorna un vectorde objetos con los datos de la mina.
	 */
	
	public Object[] toObjectVector() {
		return new Object[] {id,name,meter,oreType.getOreType(),kilogramPrice,mineType.getMineType(),budgetMine};
	}

	/**
	 * Modifica el tipo de mineral que explota una mina.
	 * 
	 * @param oreType 
	 * Nuevo tipo de mineral que se desea modificar en una mina.
	 */
	public void setOreType(OreType oreType) {
		this.oreType = oreType;
	}
	/**
	 * Modifica el precio del mineral que explota una mina.
	 * @param kilogramPrice
	 * Nuevo precio  del mineral que se desea modificar en una mina.
	 */
	public void setKilogramPrice(int kilogramPrice) {
		this.kilogramPrice = kilogramPrice;
	}
	
	/**
	 * Modifica el tipo de explotacion de una mina.
	 * @param mineType
	 * Nuevo tipo de explotacion de cierta mina(al aire libre/subterranea).
	 */
	public void setMineType(MineType mineType) {
		this.mineType = mineType;
	}
	
	/**
	 * Vende un x kilogramos del mineral que explota la mina.
	 * @param kilos
	 * Cantidad de kilogramos a vender.
	 * @return
	 * Retorna el valor de la ganancia obtenida con la venta.
	 */
	public int sellOre(int kilos) {
		transaction = new Sell();
		int finalMount = transaction.transaction(budgetMine, kilos*kilogramPrice);
		int mount = (finalMount - budgetMine);
		gain += mount;
		budgetMine = finalMount;
		return mount;
	}
	
	/**
	 * Compra insumos para el correcto funcionamiento de la mina.
	 * @param value
	 * Valor total de los insumos a comprar.
	 * @return
	 * Retorna el dinero gastado del presupuesto de la mina.
	 */
	public int buyInsumes(int value) {
		transaction = new Buy();
		int finalMount = transaction.transaction(budgetMine, value);
		int mount = (budgetMine - finalMount);
		gain-= mount;
		budgetMine = finalMount;
		return mount;
	}

	/**
	 * Retorna la ganancia de la mina
	 * @return
	 * Retorna el valor de la ganancia de la mina.
	 */
	public int getGain() {
		return gain;
	}

}
