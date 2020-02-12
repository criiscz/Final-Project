package views;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.OptionInvalidException;
import exceptions.VeryLargeMineException;
import models.Department;
import models.DepartmentName;
import models.MineType;
import models.OreType;

/**
 * Clase encargada de interactuar con el usuario, recibiendo y enviando datos
 * del usuario.
 * 
 * @author Felipe and Cristian
 */
public class IOManager {
	private static final String INVALID_OPTION = "\nOpcion Invalida\n";
	private static final String DIGIT_QUANTITY_KILOGRAM = "Digite la cantidad de kilogramos: ";
	private static final String MENU_REPORT_PRICE = "1. Reporte de Precio promedio de cada mineral.\n2. Reporte de Precio total de material explotado por departamento.\n3. Atras.";
	private static final String MENU_REPORT_EXTENTION = "1. Reporte de Extencion de m2 de minas por departamento.\n2. Reporte de Extencion de m2 por departamento.\n3. Atras.";
	private static final String MENU_REPORT_GAINS = "1. Reporte de ganancias de minas por departamento.\n2. Reporte de ganancias por departamento.\n3. Atras.";
	private static final String MENU_REPORT_QUANTITY = "1. Reporte de cantidad de minas por departamento.\n2. Reporte de cantidad de minas de determinado mineral\n3. Reporte de cantidad de minas de determinado tipo.\n4. Reporte de cantidad de minas en Colombia\n5. Salir";
	private static final String MENU_REPORTS = "1. Reporte de cantidad de minas.\n2. Reporte de Ganancias.\n3. Reporte de Extension.\n4. Reporte de Precio.\n5. Atras.";
	private static final String SEPARATOR_SHORT = "----------------------------";
	private static final String NUM = "Num";
	private static final String NAME = "Nombre";
	private static final String FORMAT_CONVENTIONS = "%2$-5s %1$-10s";
	private static final String CONVENTIONS = "\n\n----------------------------\n	Convenciones\n----------------------------\n";
	private static final String FORMAT_GRAPHIC_ONE = "%1$-8s";
	private static final String MESSAGE_ECONOMY = "Que desea hacer?\n1. Vender mineral por kilos.\n2. Comprar insumos.\n3. Atras.";
	private static final String BUY_INSUMES = "Ingrese el valor total de los insumos a comprar: $";
	private static final String OPERATION_SUCCESFULL = "Operacion Ejecutada Exitosamente";
	private static final String TABLE_FORMAT = "%1$-22s %2$-15s | %3$-10s %4$-15s %5$-15s %6$-15s %7$-10s %8$-20s %9$-11s";
	private static final String SELECT_DEPARTMENT = "Seleccion el departamento: ";
	private static final String SELECT_BUDGET = "Digite el presupuesto destinado a la mina.";
	private static final String MINE_SUCCESFULL = "La mina se agrego exitosamente";
	private static final String DIGIT_MINE_TYPE = "Ingrese un tipo de mina: ";
	private static final String DIGIT_MINE_ID = "Digite el numero de indentificacion de la mina: ";
	private static final String DIGIT_KILOGRAM_PRICE = "Digite el precio por kilogramo de este producto:";
	private static final String CHOOSE_TYPE_MINERAL = "Elija el tipo de mineral: ";
	private static final String DIGIT_SQUARE_METERS = "Digite el numero de metros cuadrados de la mina: ";
	private static final String DIGIT_MINE_NAME = "Ingrese el nombre de la mina: ";
	private Scanner in;
	public static final String WELCOME = "---------------------------------\n" + "|Bienvenido a tu gestor de minas|\n"
			+ "---------------------------------";
	public static final String SHOW_MENU = "Seleccione una opcion:\n" + "______________________\n" + "1. Ver tabla\n"
			+ "______________________\n" + "2. Agregar mina\n" + "______________________\n" + "3. Remover mina\n"
			+ "______________________\n" + "4. Editar Mina\n" + "______________________\n" + "5. Economia de Mina\n"
			+ "______________________\n" + "6. Reportes\n" + "______________________\n" + "7. Salir\n"
			+ "______________________\n" + "Opcion: ";
	private static final String SHOW_MENU_EDIT = "Seleccione una opcion:\n"
			+ "1. Editar Valor por kilogramo de la mina\n" + "2. Editar Tipo de mineral de mina\n" + "3. Atras.\n";
	private static final String MINE_NAME = "Nombre Mina";
	private static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------------------------------------------------";
	private static final String DEPARTMENT = "Departamento";
	private static final String BUDGET_DEPARTMENT = "Presupuesto";
	private static final String ID_MINE = "Id Mina";
	private static final String METERS_MINE = "m2";
	private static final String ORE = "Mineral";
	private static final String KILOGRAM_PRICE = "$ Kilo";
	private static final String MINE_TYPE = "Tipo de Mina";
	private static final String BUDGET_MINE = "Presupuesto Mina";
	private static final Object[] TITLES_TABLE = { DEPARTMENT, BUDGET_DEPARTMENT, ID_MINE, MINE_NAME, METERS_MINE, ORE,
			KILOGRAM_PRICE, MINE_TYPE, BUDGET_MINE };
	public static final String FORMAT = TABLE_FORMAT;

	public static final String M2_GRAPHIC = "(m2)    |";
	public static final String NO_MINAS_GRAPHIC = "N° Minas|";
	public static final String GAINS_GRAPHIC = "Gains($)|";
	public static final String PRICE_GRAPHIC = "Price($)|";

	/**
	 * Constructor que instancia un objeto para recibir datos del usuario.
	 */
	public IOManager() {
		in = new Scanner(System.in);
	}
	/**
	 * Imprime por pantalla un mensaje de Bienvenida.
	 */
	public void showWelcome() {
		System.out.println(WELCOME);
	}

	/**
	 * Imprime por pantalla el menu principal.
	 * 
	 * @return Retorna la opcion del menu que el usuario desee.
	 */
	public int selectOptionMenu() {
		System.out.print(SHOW_MENU);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return selectOptionMenu();
		}

	}

	/**
	 * Imprime por pantalla el menu de edicion de datos.
	 * 
	 * @return Retorna la opcion del menu que el usuario desee.
	 */
	public int selectOptionMenuEdit() {
		System.out.println(SHOW_MENU_EDIT);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return selectOptionMenuEdit();
		}
	}

	/**
	 * Recibe el nombre de una mina por parte del usuario.
	 * 
	 * @return Retorna el nombre de una mina
	 */
	public String readNameMine() {
		System.out.println(DIGIT_MINE_NAME);
		return in.nextLine();
	}
	/**
	 * Recibe la cantidad de M2 de una mina.
	 * @return
	 * Cantidad de M2 de una mina.
	 */
	public int readMeterMine() {
		System.out.println(DIGIT_SQUARE_METERS);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		
		if (mat.matches()) {
			try {
			validateMetersOfMine(Integer.parseInt(text));
			return Integer.parseInt(text);
			}catch(VeryLargeMineException e){
				System.out.println(e.getMessage());
				return readMeterMine();
			}
		}else {
			System.err.println(INVALID_OPTION);
			return readMeterMine();
		}
	}
	public void validateMetersOfMine(int i)throws VeryLargeMineException {
		if (i > 800 || i == 0 || i < 0)
			throw new VeryLargeMineException();
		else {
				
			}
		
	}
	/**
	 *Recibe el tipo  de recurso que explota una mina. 
	 * @return
	 * Tipo de recurso que explota una mina.
	 */
	public OreType readOreType() {
		System.out.println(CHOOSE_TYPE_MINERAL);
		for (int i = 0; i < OreType.values().length; i++) {
			System.out.println(1 + i + " " + OreType.values()[i].getOreType());
		}
		try {
			int option = Integer.parseInt(in.nextLine());
			return selectOreType(option);
		} catch (OptionInvalidException | NumberFormatException e) {
			System.out.println(e.getMessage());
			return readOreType();
		}

	}
	/**
	 * Selecciona el tipo de mineral que explota una mina.
	 * @param option
	 * Opcion que el usuario eligio.
	 * @return
	 * Tipo de mineral que explota una mina correspondiente a la opcion que eligio usuario.
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 */
	public OreType selectOreType(int option) throws OptionInvalidException {
		switch (option) {
		case 1:
			return OreType.COBRE;
		case 2:
			return OreType.NIQUEL;
		case 3:
			return OreType.PETROL;
		case 4:
			return OreType.GOLD;
		case 5:
			return OreType.EMERALD;
		case 6:
			return OreType.IRON;
		case 7:
			return OreType.PLATE;
		case 8:
			return OreType.PLOMO;
		case 9:
			return OreType.PLATINO;
		case 10:
			return OreType.TITANIO;
		case 11:
			return OreType.MANGANESO;
		case 12:
			return OreType.AGREGADOS;
		default:
			throw new OptionInvalidException();
		}
	}
	/**
	 * Recibe el precio por Kg de un producto.
	 * @return
	 * Precio por Kg de un producto.
	 */
	public int readKilogram() {
		System.out.println(DIGIT_KILOGRAM_PRICE);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return readKilogram();
		}
	}
	/**
	 * Recibe la cantidad de Kg de una transaccion.
	 * @return
	 * Cantidad de Kg de una transaccion.
	 */
	public int readQuantityKilogram() {
		System.out.println(DIGIT_QUANTITY_KILOGRAM);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return readQuantityKilogram();
		}
	}
	/**
	 *Recibe el numero de identificacion de una mina. 
	 * @return
	 * Numero de identificacion de una mina.
	 */
	public int readId() {
		System.out.println(DIGIT_MINE_ID);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return readId();
		}
	}
	/**
	 * Recibe un tipo de mina(subterranea/al aire libre).
	 * @return
	 * Tipo de mina (subterranea/al aire libre).
	 */
	public MineType readMineType() {
		System.out.println(DIGIT_MINE_TYPE);
		for (int i = 0; i < MineType.values().length; i++) {
			System.out.println(i + 1 + " " + MineType.values()[i].getMineType());
		}

		try {
			int option = Integer.parseInt(in.nextLine());
			return selectMineType(option);
		} catch (OptionInvalidException | NumberFormatException e) {
			System.err.println(e.getMessage());
			return readMineType();
		}
	}
	/**
	 * Selecciona el tipo de mina a partir de la opcion ingresada por el usuario.
	 * @param option
	 * Opcion ingresada por el usuario.
	 * @return
	 * Tipo de mina(subterranea/al aire libre)..
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 */
	public MineType selectMineType(int option) throws OptionInvalidException {
		switch (option) {
		case 1:
			return MineType.OPEN_PIT_MINE;
		case 2:
			return MineType.SUBTERRANEAN_MINE;
		default:
			throw new OptionInvalidException();
		}
	}
	/**
	 * Recibe el presupuesto de una mina.
	 * @return
	 * Presupuesto de una mina.
	 */
	public int readBudgetMine() {
		System.out.println(SELECT_BUDGET);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return readBudgetMine();
		}
	}
	/**
	 *Permite que el usuario seleccione el departamento que desee.
	 * @return
	 * Departamento seleccionado por el usuario.
	 */
	public DepartmentName readDepartment() {
		System.out.println(SELECT_DEPARTMENT);
		for (int i = 0; i < DepartmentName.values().length; i++) {
			System.out.println(i + 1 + "  " + DepartmentName.values()[i].getName());
		}
		try {
			return selectDepartment(Integer.parseInt(in.nextLine()));
		} catch (OptionInvalidException | NumberFormatException e) {
			showError(e.getMessage());
			return readDepartment();
		}
	}
	/**
	 * Selecciona el departamento a partir de la opcion ingresada por el usuario.
	 * @param option
	 * Opcion ingresada por el usuario.
	 * @return
	 * Nombre del departamento seleccionado.
	 * @throws OptionInvalidException
	 * Excepcion que se presenta cuando el usuario ingresa una opcion que no es valida.
	 */
	public DepartmentName selectDepartment(int option) throws OptionInvalidException {
		switch (option) {
		case 1:
			return DepartmentName.BOYACA;
		case 2:
			return DepartmentName.CUNDINAMARCA;
		case 3:
			return DepartmentName.ANTIOQUIA;
		case 4:
			return DepartmentName.NORTE_DE_SANTANDER;
		case 5:
			return DepartmentName.SANTANDER;
		case 6:
			return DepartmentName.TOLIMA;
		case 7:
			return DepartmentName.CAUCA;
		case 8:
			return DepartmentName.LA_GUAJIRA;
		case 9:
			return DepartmentName.CESAR;
		case 10:
			return DepartmentName.CORDOBA;
		default:
			throw new OptionInvalidException();
		}
	}
	/**
	 * Imprime por pantalla cuando una mina es agregada.
	 */
	public void showConfirmationAdd() {
		System.out.println(MINE_SUCCESFULL);
	}
	/**
	 * Imprime por pantalla un mensaje cuando se presenta un error.
	 * @param error
	 * Mensaje de error que se desea imprimir.
	 */
	public void showError(String error) {
		System.err.println(error);
	}

	/**
	 * Genera los titulos de la tabla de datos.
	 */
	public void generateTitles() {
		System.out.println(SEPARATOR);
		System.out.println(String.format(FORMAT, TITLES_TABLE));
		System.out.println(SEPARATOR);
		System.out.println(SEPARATOR);
	}
	/**
	 * Imprime por pantalla la tabla de datos.
	 * @param listDepartment
	 * Listado de departamentos para generar la tabla con los datos de cada uno.
	 */
	public void showTable(Department[] listDepartment) {
		generateTitles();
		for (Department department : listDepartment) {
			for (int i = 0; i < department.toObjectMatrix().length; i++) {
				System.out.println(String.format(TABLE_FORMAT, department.toObjectMatrix()[i]));
				System.out.println(SEPARATOR);
			}
		}
	}
	/**
	 * Imprime por pantalla cuando una operacion es completada.
	 */
	public void showSucesfull() {
		System.out.println(OPERATION_SUCCESFULL);
	}
	/**
	 * Recibe la cantidad de insumos de una transaccion.
	 * @return
	 * Cantidad de insumos de una transaccion.
	 */
	public int readMount() {
		System.out.print(BUY_INSUMES);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return readMount();
		}
	}
	/**
	 * Imprime un menu de opciones de venta y compra.
	 * @return
	 * Opcion ingresada por el usuario.
	 */
	public int readOptionEconomy() {
		System.out.println(MESSAGE_ECONOMY);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return readOptionEconomy();
		}
	}

	/**
	 * Imprime por pantalla un reporte grafico.
	 * @param report
	 * Contiene datos y convenciones de una grafica.
	 * @param ejeY
	 * Encabezado del eje Y de la grafica.
	 */
	public void showReportOne(Object[] report, String ejeY) {
		String[][] data = (String[][]) report[0];
		String[][] convention = (String[][]) report[1];
		System.out.println(ejeY);
		for (int i = data.length - 1; i >= 0; i--) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] == null)
					System.out.printf(FORMAT_GRAPHIC_ONE, " . ");
				else
					System.out.print(data[i][j]);
			}
			System.out.println("");
		}
		System.out.println(CONVENTIONS);
		System.out.println(String.format(FORMAT_CONVENTIONS, NAME, NUM));
		System.out.println(SEPARATOR_SHORT);

		for (int i = 0; i < convention.length; i++) {
			System.out.println(String.format(FORMAT_CONVENTIONS, (Object[]) convention[i]));
			System.out.println(SEPARATOR_SHORT);
		}
	}
	/**
	 * Imprime un menu con diferentes reportes.
	 * @return
	 * Opcion ingresada por el usuario para ver cierto reporte.
	 */
	public int showMenuGeneralReports() {
		System.out.println(MENU_REPORTS);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return showMenuGeneralReports();
		}
	}
	/**
	 * Imprime un menu de opciones de reportes de cantidades.
	 * @return
	 * Opcion ingresada por el usuario para ver un reporte de cantidades.
	 */
	public int showMenuQuantityMines() {
		System.out.println(MENU_REPORT_QUANTITY);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return showMenuQuantityMines();
		}
	}

	/**
	 * Imprime un menu de opciones de reportes de ganancias.
	 * @return
	 * Opcion ingresada por el usuario para ver un reporte de ganancias.
	 */
	public int showMenuGains() {
		System.out.println(MENU_REPORT_GAINS);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return showMenuGains();
		}
	}
	/**
	 * Imprime un menu de opciones de reportes de extencion de minas. 
	 * @return
	 * Opcion ingresada por el usuario para ver un reporte de extencion de minas.
	 */
	public int showMenuExtention() {
		System.out.println(MENU_REPORT_EXTENTION);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return showMenuExtention();
		}
	}
	/**
	 * Imprime un menu de opciones de reportes de precios de ciertos materiales. 
	 * @return
	 * Opcion ingresada por el usuario para ver un reporte de precios de ciertos materiales. 
	 */
	public int showMenuPriceMines() {
		System.out.println(MENU_REPORT_PRICE);
		String text = in.nextLine();
		Pattern pat = Pattern.compile("\\d*");
		Matcher mat = pat.matcher(text);
		if (mat.matches())
			return Integer.parseInt(text);
		else {
			System.err.println(INVALID_OPTION);
			return showMenuPriceMines();
		}
	}

	/**
	 * Imprime por pantalla un mensaje cuando se cierra la aplicacion.
	 */
	public void showExitMessage() {
		System.err.println("Good Bye");
	}
}