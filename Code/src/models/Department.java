package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.MineNotFoundException;
import models.utils.RandomizeGenerator;

/**
 * Almacena y administra las minas por departamento.
 * 
 * @author Felipe and Cristian
 */
public class Department {
	private DepartmentName name;
	private List<Mine> listMine;
	private int budgetDepartment;
	private int gain;

	/**
	 * Constructor encargado de dar valores a los atributos y de inicializar algunos
	 * datos.
	 * 
	 * @param name             Nombre del departamento
	 * @param budgetDepartment Presupuesto del departamento.
	 */
	public Department(DepartmentName name, int budgetDepartment) {
		this.name = name;
		this.budgetDepartment = budgetDepartment;
		gain = 0;
		listMine = new ArrayList<>();
		autoGenerateData();
	}

	/**
	 * Retorna el nombre del departamento.
	 * 
	 * @return Retorna el nombre del departamento.
	 */
	public String getName() {
		return name.getName();
	}

	/**
	 * Retorna el presupuesto del departamento.
	 * 
	 * @return Retorna el presupuesto del departamento.
	 */
	public int getBudgetDepartment() {
		return budgetDepartment;
	}

	/**
	 * Retorna el listado de minas del departamento.
	 * 
	 * @return Retorna el listado de minas del departamento.
	 */
	public List<Mine> getListMine() {
		return listMine;
	}

	/**
	 * Genera automaticamente de forma aleatoria los datos de las minas para cada
	 * departamento.
	 */
	public void autoGenerateData() {
		for (int i = 0; i < RandomizeGenerator.generateRandomInt(1, 10); i++) {
			addMine(new Mine(RandomizeGenerator.generateRandomName(), RandomizeGenerator.generateRandomInt(50, 800),
					RandomizeGenerator.generateRandomOreType(), RandomizeGenerator.generateRandomInt(100, 5000),
					listMine.size(), RandomizeGenerator.generateRandomMineType(),
					RandomizeGenerator.generateRandomInt(2000, 100000)));
		}
	}

	/**
	 * Agrega una mina a la lista de departamentos.
	 * 
	 * @param mine Mina que se quiere agregar en el listado del departamento.
	 */
	public void addMine(Mine mine) {
		budgetDepartment -= mine.getBudgetMine();
		listMine.add(mine);
	}

	/**
	 * Busca y retorna una mina por su numero de identificacion (id).
	 * 
	 * @param id numero de identificacion de una mina.
	 * @return Retorna la mina deseada.
	 * @throws MineNotFoundException De no ser encontrada la mina por el id
	 *                               indicado, lanzara la excepcion.
	 * 
	 */
	public Mine searchMine(int id) throws MineNotFoundException {
		for (int i = 0; i < listMine.size(); i++) {
			if (listMine.get(i).getId() == id) {
				return listMine.get(i);
			}
		}
		throw new MineNotFoundException();
	}

	/**
	 * Busca la posicion de una mina por su id en el listado de minas del
	 * departamento.
	 * 
	 * @param id numero de identificacion de una mina.
	 * @return Retorna la posicion que ocupa cierta mina dentro de la lista de minas
	 *         del departamento.
	 * @throws MineNotFoundException De no ser encontrada la mina por el id
	 *                               indicado, lanzara la excepcion.
	 */
	public int searchPositionMine(int id) throws MineNotFoundException {
		for (int i = 0; i < listMine.size(); i++) {
			if (listMine.get(i).getId() == id) {
				return i;
			}
		}
		throw new MineNotFoundException();
	}

	/**
	 * Elimina una mina del listado de minas de un departamento.
	 * 
	 * @param id Numero de identificacion de la mina que se desea eliminar.
	 * @throws MineNotFoundException De no ser encontrada la mina por el id
	 *                               indicado, lanzara la excepcion.
	 * @return Retorna la mina removida.
	 */
	public Mine removeMine(int id) throws MineNotFoundException {
		int positionFound = searchPositionMine(id);
		budgetDepartment += listMine.get(positionFound).getBudgetMine();
		Mine saveMine = listMine.get(positionFound);
		listMine.remove(positionFound);
		return saveMine;
	}

	/**
	 * Edita el tipo de mineral que explota una mina.
	 * 
	 * @param newType Nuevo tipo de recurso que explota la mina.
	 * @param id      Numero de identificacion de la mina que se quiere editar.
	 * @throws MineNotFoundException De no ser encontrada la mina por el id
	 *                               indicado, lanzara la excepcion.
	 */
	// ----------------------------------------------------------------------------------//
	public void editOreType(OreType newType, int id) throws MineNotFoundException {
		searchMine(id).setOreType(newType);
	}

	/**
	 * Edita el tipo de mina,(Subterranea/al aire libre)
	 * 
	 * @param mineType Nuevo tipo de mina.
	 * @param id       Numero de identificacion de la mina que se quiere editar.
	 * @throws MineNotFoundException De no ser encontrada la mina por el id
	 *                               indicado, lanzara la excepcion.
	 */
	public void editMineType(MineType mineType, int id) throws MineNotFoundException {
		searchMine(id).setMineType(mineType);
	}

	/**
	 * Edita el valor del mineral que explota una mina.
	 * 
	 * @param price Nuevo valor del mineral que explota la mina.
	 * @param id    Numero de identificacion de la mina que se quiere editar.
	 * @throws MineNotFoundException De no ser encontrada la mina por el id
	 *                               indicado, lanzara la excepcion.
	 */
	public void editKilogramPrice(int price, int id) throws MineNotFoundException {
		searchMine(id).setKilogramPrice(price);
	}
	// ----------------------------------------------------------------------------------//

	/**
	 * Administra la venta de cierto mineral de una mina.
	 * 
	 * @param idMine Numero de identificacion de la mina que realizara la venta.
	 * @param kilos  Cantidad de kilos que vendera la mina.
	 * @throws MineNotFoundException De no ser encontrada la mina por el id
	 *                               indicado, lanzara la excepcion.
	 */
	public void sellOre(int idMine, int kilos) throws MineNotFoundException {
		int finalMount = searchMine(idMine).sellOre(kilos);
		budgetDepartment += finalMount;
		gain += finalMount;
	}

	/**
	 * Da la instruccion de comprar insumos para la mina especificada.
	 * 
	 * @param idMine Numero de identificacion de la mina para la cual van dirigidos
	 *               los insumos.
	 * @param mount  Valor monetario por el cual se desean comprar los insumos.
	 * @throws MineNotFoundException La excepcion es lanzada al no encontrar la mina
	 *                               especificada con el numero de identificacion.
	 */
	public void buyInsumes(int idMine, int mount) throws MineNotFoundException {
		Mine mine = searchMine(idMine);
		int finalMount = mine.buyInsumes(mount);
		budgetDepartment -= finalMount;
		gain -= finalMount;
	}
	// ----------------------------------------------------------------------------------//

	/**
	 * Genera automaticaticamente solicitudes de venta y compra en la mina para
	 * crear datos economicos previos al inicio del programa.
	 * 
	 * @throws MineNotFoundException La excepcion es lanzada al no encontrar la mina
	 *                               especificada con el numero de identificacion.
	 */
	public void autoGenerateEconomy() throws MineNotFoundException {
		for (int i = 0; i < RandomizeGenerator.generateRandomInt(1, 6); i++) {
			if (RandomizeGenerator.generateRandomInt(1, 2) == 1) {
				sellOre(RandomizeGenerator.generateRandomInt(listMine.size()),
						RandomizeGenerator.generateRandomInt(50));
			} else {
				buyInsumes(RandomizeGenerator.generateRandomInt(listMine.size()),
						RandomizeGenerator.generateRandomInt(1000));
			}
		}
	}

	/**
	 * Retorna un vector con el nombre del departamento y el presupuesto.
	 * 
	 * @return Retorna un vector que contiene el nombre de departamento y
	 *         presupuesto del mismo.
	 */
	public Object[] toObjectVector() {
		return new Object[] { name.getName(), budgetDepartment };
	}

	/**
	 * Crea una matriz con todos los datos del departamento.
	 * 
	 * @return Retorna una matriz de Objetos con los datos del departamento.
	 */
	public Object[][] toObjectMatrix() {
		Object[][] matrix = new Object[listMine.size()][];
		int counter = 0;
		for (Mine mine : listMine) {
			matrix[counter] = mergeVectors(toObjectVector(), mine.toObjectVector());
			counter++;
		}

		return matrix;
	}

	/**
	 * Suma dos vectores de objetos.
	 * 
	 * @param vectorOne Vector de objetos numero 1 a sumar.
	 * @param vectorTwo Vector de objetos numero 2 a sumar.
	 * @return Retorna un vector que contiene los dos vectores a sumar.
	 */
	public Object[] mergeVectors(Object[] vectorOne, Object[] vectorTwo) {
		Object[] finalVector = new Object[vectorOne.length + vectorTwo.length];
		System.arraycopy(vectorOne, 0, finalVector, 0, vectorOne.length);
		System.arraycopy(vectorTwo, 0, finalVector, vectorOne.length, vectorTwo.length);
		return finalVector;
	}

	/**
	 * Retorna la ganancia del departamento.
	 * 
	 * @return Retorna el valor de la ganancia economica del departamento.
	 */
	public int getGain() {
		return gain;
	}
}
