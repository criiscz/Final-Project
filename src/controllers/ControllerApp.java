package controllers;
import java.util.HashMap;
import java.util.Map;

import exceptions.DepartmentNotFoundException;
import exceptions.MineNotFoundException;
import exceptions.OptionInvalidException;
import models.Colombia;
import models.DepartmentName;
import models.MineType;
import models.OreType;
import views.IOManager;
/**
 * Clase encargada de ejecutar las opciones deseadas del usuario
 * @author Felipe and Cristian
 */
public class ControllerApp {
	private IOManager view;
	private Colombia model;
	/**
	 *Constructor de la clase que se encarga de instanciar algunos objetos que necesitamos para poder ejecutar las opciones deseadas por el usuario y asi interactuar con el.
	 */
	public ControllerApp() {
		view = new IOManager();
		model = new Colombia();
		view.showWelcome();
		init();
	}
	/**
	 * Metodo encargado de generar el menu principal del proyecto, en el que se muestran las opciones que se ofrecen al usuario.
	 */
	public void init() {
		//		addMine();
		
		try {
			int option;
			do {
				option = view.selectOptionMenu();
				switch (option) {
				case 1:
					showTable();
					break;
				case 2: 
					addMine();
					break;
				case 3: 
					removeMine();
					break;
				case 4: 
					editMine();
					break;
				case 5:
					realizeEconomy();
					break;
				case 6:
					selectReports();
					break;
				case 7:
					System.exit(0);
					break;
				default:
					throw new OptionInvalidException();
				}
			} while (option != 7 );
		} catch(OptionInvalidException e) {
			view.showError(e.getMessage());
			init();
		} catch(NumberFormatException e2) {
			view.showError("Opcion Invalida");
			init();
		} catch (DepartmentNotFoundException e) {
			view.showError(e.getMessage());
			init();
		}
	}
	
	/**
	 * Genera una tabla en la cual se muestran diferentes listados de departamentos con sus respectivas minas.
	 */
	public void showTable() {
		view.showTable(model.getListDepartment());
	}
	/**
	 * Permite crear y agregar una mina en el departamento deseado por el usuario.
	 */
	public void addMine() {
		try {
			model.createMine(view.readDepartment(), view.readNameMine(), view.readMeterMine(), view.readOreType(), view.readKilogram(), view.readMineType(), view.readBudgetMine());
			view.showSucesfull();
		} catch (DepartmentNotFoundException | NumberFormatException e) {
			view.showError(e.getMessage());
		}
	}
	/**
	 * Permite eliminar una mina del listado de minas de un departamento.
	 */
	public void removeMine() {
		try {
			model.sendRemoveMine(view.readDepartment(), view.readId());
			view.showSucesfull();
		} catch (MineNotFoundException | NumberFormatException e) {
			view.showError(e.getMessage());
		}
	}
	/**
	 * Permite editar datos especificos de una mina tales como el precio por Kg del mineral que explota o el tipo de mineral que explota.
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 */
	public void editMine() throws OptionInvalidException {
		int option = view.selectOptionMenuEdit();
		switch (option) {
		case 1:
			editKilogramPrice();
			break;
		case 2:
			editOreType();
			break;
		case 3:
			break;
		default:
			throw new OptionInvalidException();
		}
	}
	/**
	 * Permite editar el  valor por Kg del mineral que explota una mina.
	 */
	public void editKilogramPrice() {
		try {
			model.editKilogramPriceMine(view.readDepartment(), view.readId(), view.readKilogram());
			view.showSucesfull();
		} catch (MineNotFoundException | DepartmentNotFoundException e) {
			view.showError(e.getMessage());
		}
		
	}
	/**
	 * Permite editar el tipo de mineral que explota una mina.
	 */
	public void editOreType() {
		try {
			DepartmentName department = view.readDepartment();
			int id = view.readId();
			MineType mineType = view.readMineType();
			OreType oreType = view.readOreType();
			model.editOreType(department,id,oreType);
			model.editMineType(department, id, mineType);
			view.showSucesfull();
		} catch (MineNotFoundException | DepartmentNotFoundException e) {
			view.showError(e.getMessage());
		}
	}
	/**
	 * Genera un menu de opciones(comprar o vender ciertos recursos) y ejecuta la que el usuario desee.
	 */
	private void realizeEconomy() {
		try {
			int option = view.readOptionEconomy();
			switch (option) {
			case 1:
				sellOre( view.readDepartment(), view.readId(), view.readKilogram());
				break;
			case 2:
				buyInsume( view.readDepartment(), view.readId(), view.readMount());
			case 3:
				break;
			default:
				throw new OptionInvalidException();
			}
		} catch (OptionInvalidException|NumberFormatException e) {
			view.showError(e.getMessage());
			realizeEconomy();
		}
	}
	/**
	 * Realiza la transaccion de vender mineral de una mina.
	 * @param department
	 * Departamento donde esta ubicada la mina que desea vender algun mineral.
	 * @param idMine
	 * Numero de identificacion de la mina que desea vender algun mineral.
	 * @param kilos
	 * Cantidad de Kg del mineral se desea vender.
	 */
	private void sellOre( DepartmentName department, int idMine, int kilos) {
		try {
			model.sellOre(department, idMine, kilos);
			view.showSucesfull();
		} catch (MineNotFoundException | DepartmentNotFoundException e) {
			view.showError(e.getMessage());
		}
	}
	/**
	 * Realiza la transaccion de comprar insumos para una mina.
	 * @param department
	 * Nombre del departamento donde se encuentra la mina con la cual realizar la transaccion.
	 * @param idMine
	 * Numero de identificacion de la mina a realizar la transaccion.
	 * @param mount
	 * Cantidad monetaria de insumos a comprar.
	 */
	private void buyInsume( DepartmentName department, int idMine, int mount ) {
		try {
			model.buyInsumes(department, idMine, mount);
			view.showSucesfull();
		} catch (MineNotFoundException | DepartmentNotFoundException e) {
			view.showError(e.getMessage());
		}
	}
	/**
	 *Genera un menu y ejecuta los diferentes tipos de reportes graficos que se ofrecen al usuario.
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 * @throws DepartmentNotFoundException
	 * Excepcion que se presenta cuando cierto departamento no ha sido encontrado o no existe.
	 */
	private void selectReports() throws OptionInvalidException, DepartmentNotFoundException {
		int option = view.showMenuGeneralReports();
		switch (option) {
		case 1:
			selectTypeReportQuantityMines();
			break;
		case 2:
			selectTypeReportGain();
			break;
		case 3:
			selectTypeReportExtention();
			break;
		case 4:
			selectReportPriceMines();
			break;
		default:
			throw new OptionInvalidException();
		}
	}
	/**
	 * Metodo encargado de ofrecer a traves de un menu y generar los reportes que el usuario desee ver sobre precios.
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 */
	private void selectReportPriceMines() throws OptionInvalidException {
		int option = view.showMenuPriceMines();
		switch(option) {
		case 1:
			createReportPriceMines();
			break;
		case 2:
			createReportPricePerDepartment();
			break;
		case 3:
			break;
		default:
			throw new OptionInvalidException();
		}
	}
	/**
	 * Genera un  reporte del valor total por kilogramo de todos los minerales en cada departamento.
	 */
	private void createReportPricePerDepartment() {
		view.showReportOne(model.generateReportPricePerDepartment());
	}

	/**
	 * Genera reporte del valor del kilogramo de cada mineral.
	 */
	private void createReportPriceMines() {
		Map<String, Integer> data = new HashMap<String, Integer>();
		view.showReportOne(model.generateReportPricePerKilogram(0, data));
	}
	
	/**
	 * Genera un menu con los distintos reportes sobre la cantidad de minas, y ejecuta el que el usuario desee.
	 * @throws DepartmentNotFoundException
	 * Excepcion que se presenta cuando cierto departamento no ha sido encontrado o no existe.
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 */
	private void selectTypeReportQuantityMines() throws DepartmentNotFoundException, OptionInvalidException {
		int option = view.showMenuQuantityMines();
		switch (option) {
		case 1:
			createReportMinesPerDepartment();
			break;
		case 2:
			createReportMinesPerOre();
			break;
		case 3:
			createReportTypeMines();
			break;
		case 4:
			createReportMinesInColombia();
			break;
		case 5:
			break;
		default:
			throw new OptionInvalidException();
			
		}
	}

	/**
	 * Genera un menu con los distintos reportes sobre las ganancias, y ejecuta el que el usuario desee.
	 * @throws DepartmentNotFoundException
	 * Excepcion que se presenta cuando cierto departamento no ha sido encontrado o no existe.
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 */
	private void selectTypeReportGain() throws DepartmentNotFoundException, OptionInvalidException {
		int option = view.showMenuGains();
		switch (option) {
		case 1:
			createReportGainPerMine();
			break;
		case 2:
			createReportGainPerDepartment();
			break;
		case 3:
			break;
		default:
			throw new OptionInvalidException();
		}
	}
	
	/**
	 * Genera un menu con los distintos reportes sobre la extension de minas, y ejecuta el que el usuario desee.
	 * @throws DepartmentNotFoundException
	 * Excepcion que se presenta cuando cierto departamento no ha sido encontrado o no existe.
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 */
	private void selectTypeReportExtention() throws DepartmentNotFoundException, OptionInvalidException {
		int option = view.showMenuExtention();
		switch (option) {
		case 1:
			createReportExtentionMinePerDepartment();
			break;
		case 2:
			createReportExtention();
			break;
		case 3:
			break;
		default:
			throw new OptionInvalidException();
		}
	}
	
	/**
	 * Genera reporte de metros cuadrados explotados por cada mina en un departamento especificado.
	 * @throws DepartmentNotFoundException
	 * Excepcion que se presenta cuando cierto departamento no ha sido encontrado o no existe.
	 */
	private void createReportExtentionMinePerDepartment() throws DepartmentNotFoundException {
		Map<String, Integer> data = new HashMap<String, Integer>();
		view.showReportOne(model.generateReportm2PerDepartment(view.readDepartment(),0,data));
	}
	
	/**
	 * Genera reporte de ganancias que tiene cada mina en un departamento especificado.
	 * @throws DepartmentNotFoundException
	 * Excepcion que se presenta cuando cierto departamento no ha sido encontrado o no existe.
	 */
	private void createReportGainPerMine() throws DepartmentNotFoundException {
		view.showReportOne(model.generateReportGainsPerMine(view.readDepartment()));
	}
	
	/**
	 *Genera reporte de cantidad de minas por  cada departamento.
	 */
	private void createReportMinesPerDepartment() {
			view.showReportOne(model.generateReportMinesPerDepartment());
	}
	
	/**
	 * Genera reporte de cantidad de minas que explotan cada uno de los minerales.
	 */
	private void createReportMinesPerOre() {
			view.showReportOne(model.generateReportMinesPerOre());
	}
	
	/**
	 *Genera reporte de ganancias por departamento.
	 */
	private void createReportGainPerDepartment() {
		Map<String,Integer> data = new HashMap<String, Integer>();
		view.showReportOne(model.generateReportGain(0,data));
	}
	
	/**
	 *Genera reporte de cantidad de minas por su tipo.
	 */
	private void createReportTypeMines() {
		Map<String, Integer> data = new HashMap<String, Integer>();
		view.showReportOne(model.generateReportQuantityTypeMines(data,0));
	}
	
	/**
	 * Genera reporte de cantidad de metros cuadrados que cada departamento explota en total.
	 */
	private void createReportExtention(){
		view.showReportOne(model.generateReportM2perDepartment());
	}
	
	/**
	 * Genera reporte de cantidad de minas en total.
	 */
	private void createReportMinesInColombia() {
			view.showReportOne(model.generateReportQuantityMinesInColombia());
	}
}