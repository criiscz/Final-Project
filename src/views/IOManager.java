package views;

import java.util.Scanner;

import exceptions.OptionInvalidException;
import models.Department;
import models.DepartmentName;
import models.MineType;
import models.OreType;

public class IOManager {
	private static final String _1_REPORTE_DE_PRECIO_PROMEDIO_DE_CADA_MINERAL_2_REPORTE_DE_PRECIO_TOTAL_DE_MATERIAL_EXPLOTADO_POR_DEPARTAMENTO_3_ATRAS = "1. Reporte de Precio promedio de cada mineral.\n2. Reporte de Precio total de material explotado por departamento.\n3. Atras.";
	private static final String _1_REPORTE_DE_EXTENCION_DE_M2_DE_MINAS_POR_DEPARTAMENTO_2_REPORTE_DE_EXTENCION_DE_M2_POR_DEPARTAMENTO_3_ATRAS = "1. Reporte de Extencion de m2 de minas por departamento.\n2. Reporte de Extencion de m2 por departamento.\n3. Atras.";
	private static final String _1_REPORTE_DE_GANANCIAS_DE_MINAS_POR_DEPARTAMENTO_2_REPORTE_DE_GANANCIAS_POR_DEPARTAMENTO_3_ATRAS = "1. Reporte de ganancias de minas por departamento.\n2. Reporte de ganancias por departamento.\n3. Atras.";
	private static final String _1_REPORTE_DE_CANTIDAD_DE_MINAS_POR_DEPARTAMENTO_2_REPORTE_DE_CANTIDAD_DE_MINAS_DE_DETERMINADO_MINERAL_3_REPORTE_DE_CANTIDAD_DE_MINAS_DE_DETERMINADO_TIPO_4_REPORTE_DE_CANTIDAD_DE_MINAS_EN_COLOMBIA_5_SALIR = "1. Reporte de cantidad de minas por departamento.\n2. Reporte de cantidad de minas de determinado mineral\n3. Reporte de cantidad de minas de determinado tipo.\n4. Reporte de cantidad de minas en Colombia\n5. Salir";
	private static final String _1_REPORTE_DE_CANTIDAD_DE_MINAS_2_REPORTE_DE_GANANCIAS_3_REPORTE_DE_EXTENSION_4_REPORTE_DE_PRECIO_5_ATRAS = "1. Reporte de cantidad de minas.\n2. Reporte de Ganancias.\n3. Reporte de Extension.\n4. Reporte de Precio.\n5. Atras.";
	private static final String STRING = "----------------------------";
	private static final String NUM = "Num";
	private static final String NOMBRE = "Nombre";
	private static final String _2$_5S_1$_10S = "%2$-5s %1$-10s";
	private static final String CONVENCIONES = "\n\n----------------------------\n	Convenciones\n----------------------------\n";
	private static final String _1$_6S = "%1$-6s";
	private static final String ERROR = "Error";
	private static final String QUE_DESEA_HACER_1_VENDER_MINERAL_POR_KILOS_2_COMPRAR_INSUMOS_3_ATRAS = "Que desea hacer?\n1. Vender mineral por kilos.\n2. Comprar insumos.\n3. Atras.";
	private static final String INGRESE_EL_VALOR_TOTAL_DE_LOS_INSUMOS_A_COMPRAR_$ = "Ingrese el valor total de los insumos a comprar: $";
	private static final String OPERACION_EJECUTADA_EXITOSAMENTE = "Operacion Ejecutada Exitosamente";
	private static final String _1$_22S_2$_15S_3$_10S_4$_15S_5$_15S_6$_15S_7$_10S_8$_20S_9$_11S = "%1$-22s %2$-15s | %3$-10s %4$-15s %5$-15s %6$-15s %7$-10s %8$-20s %9$-11s";
	private static final String SELECCION_EL_DEPARTAMENTO = "Seleccion el departamento: ";
	private static final String DIGITE_EL_PRESUPUESTO_DESTINADO_A_LA_MINA = "Digite el presupuesto destinado a la mina.";
	private static final String LA_MINA_SE_AGREGO_EXITOSAMENTE = "La mina se agrego exitosamente";
	private static final String INGRESE_UN_TIPO_DE_MINA = "Ingrese un tipo de mina: ";
	private static final String DIGITE_EL_NUMERO_DE_INDENTIFICACION_DE_LA_MINA = "Digite el numero de indentificacion de la mina: ";
	private static final String DIGITE_EL_PRECIO_POR_KILOGRAMO_DE_ESTE_PRODUCTO = "Digite el precio por kilogramo de este producto:";
	private static final String ELIJA_EL_TIPO_DE_MINERAL = "Elija el tipo de mineral: ";
	private static final String DIGITE_EL_NUMERO_DE_METROS_CUADRADOS_DE_LA_MINA = "Digite el numero de metros cuadrados de la mina: ";
	private static final String DIGITE_EL_NOMBRE_DE_LA_MINA = "Digite el nombre de la mina: ";
	private Scanner in;
	public static final String WELCOME = "---------------------------------\n" + "|Bienvenido a tu gestor de minas|\n"
			+ "---------------------------------";
	public static final String SHOW_MENU = "Seleccione una opcion:\n" + "______________________\n" + "1. Ver tabla\n"
			+ "______________________\n" + "2. Agregar mina\n" + "______________________\n" + "3. Remover mine\n"
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
	public static final String FORMAT = _1$_22S_2$_15S_3$_10S_4$_15S_5$_15S_6$_15S_7$_10S_8$_20S_9$_11S;

	public IOManager() {
		in = new Scanner(System.in);
	}

	public void showWelcome() {
		System.out.println(WELCOME);
	}

	public int selectOptionMenu() {
		System.out.print(SHOW_MENU);
		return Integer.parseInt(in.nextLine());
	}

	public int selectOptionMenuEdit() {
		System.out.println(SHOW_MENU_EDIT);
		return Integer.parseInt(in.nextLine());
	}

	public String readNameMine() {
		System.out.println(DIGITE_EL_NOMBRE_DE_LA_MINA);
		return in.nextLine();
	}

	public int readMeterMine() {
		System.out.println(DIGITE_EL_NUMERO_DE_METROS_CUADRADOS_DE_LA_MINA);
		return Integer.parseInt(in.nextLine());
	}

	public OreType readOreType() {
		System.out.println(ELIJA_EL_TIPO_DE_MINERAL);
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

	public int readKilogram() {
		System.out.println(DIGITE_EL_PRECIO_POR_KILOGRAMO_DE_ESTE_PRODUCTO);
		return Integer.parseInt(in.nextLine());
	}

	public int readId() {
		System.out.println(DIGITE_EL_NUMERO_DE_INDENTIFICACION_DE_LA_MINA);
		return Integer.parseInt(in.nextLine());
	}

	public MineType readMineType() {
		System.out.println(INGRESE_UN_TIPO_DE_MINA);
		for (int i = 0; i < MineType.values().length; i++) {
			System.out.println(i + 1 + " " + MineType.values()[i].getMineType());
		}

		try {
			int option = Integer.parseInt(in.nextLine());
			return selectMineType(option);
		} catch (OptionInvalidException | NumberFormatException e) {
			System.out.println(ERROR);
			return readMineType();
		}
	}

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

	public int readBudgetMine() {
		System.out.println(DIGITE_EL_PRESUPUESTO_DESTINADO_A_LA_MINA);
		return Integer.parseInt(in.nextLine());
	}

	public DepartmentName readDepartment() {
		System.out.println(SELECCION_EL_DEPARTAMENTO);
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

	public void showConfirmationAdd() {
		System.out.println(LA_MINA_SE_AGREGO_EXITOSAMENTE);
	}

	public void showError(String error) {
		System.err.println(error);
	}

	public void generateTitles() {
		System.out.println(SEPARATOR);
		System.out.println(String.format(FORMAT, TITLES_TABLE));
		System.out.println(SEPARATOR);
		System.out.println(SEPARATOR);
	}

	public void showTable(Department[] listDepartment) {
		generateTitles();
		for (Department department : listDepartment) {
			for (int i = 0; i < department.toObjectMatrix().length; i++) {
				System.out.println(String.format(_1$_22S_2$_15S_3$_10S_4$_15S_5$_15S_6$_15S_7$_10S_8$_20S_9$_11S,
						department.toObjectMatrix()[i]));
				System.out.println(SEPARATOR);
			}
		}
	}

	public void showSucesfull() {
		System.out.println(OPERACION_EJECUTADA_EXITOSAMENTE);
	}

	public int readMount() {
		System.out.print(INGRESE_EL_VALOR_TOTAL_DE_LOS_INSUMOS_A_COMPRAR_$);
		return Integer.parseInt(in.nextLine());
	}

	public int readOptionEconomy() {
		System.out.println(QUE_DESEA_HACER_1_VENDER_MINERAL_POR_KILOS_2_COMPRAR_INSUMOS_3_ATRAS);
		return Integer.parseInt(in.nextLine());
	}

	public void showReportOne(Object[] report) {
		String[][] data = (String[][]) report[0];
		String[][] convention = (String[][]) report[1];
		System.out.println("N° Minas|");
		for (int i = data.length - 1; i >= 0; i--) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] == null)
					System.out.printf(_1$_6S, " . ");
				else
					System.out.print(data[i][j]);
			}
			System.out.println("");
		}
		System.out.println(CONVENCIONES);
		System.out.println(String.format(_2$_5S_1$_10S, NOMBRE, NUM));
		System.out.println(STRING);

		for (int i = 0; i < convention.length; i++) {
			System.out.println(String.format(_2$_5S_1$_10S, (Object[]) convention[i]));
			System.out.println(STRING);
		}
	}

	public int showMenuGeneralReports() {
		System.out.println(
				_1_REPORTE_DE_CANTIDAD_DE_MINAS_2_REPORTE_DE_GANANCIAS_3_REPORTE_DE_EXTENSION_4_REPORTE_DE_PRECIO_5_ATRAS);
		return Integer.parseInt(in.nextLine());
	}

	public int showMenuQuantityMines() {
		System.out.println(
				_1_REPORTE_DE_CANTIDAD_DE_MINAS_POR_DEPARTAMENTO_2_REPORTE_DE_CANTIDAD_DE_MINAS_DE_DETERMINADO_MINERAL_3_REPORTE_DE_CANTIDAD_DE_MINAS_DE_DETERMINADO_TIPO_4_REPORTE_DE_CANTIDAD_DE_MINAS_EN_COLOMBIA_5_SALIR);
		return Integer.parseInt(in.nextLine());
	}

	public int showMenuGains() {
		System.out.println(_1_REPORTE_DE_GANANCIAS_DE_MINAS_POR_DEPARTAMENTO_2_REPORTE_DE_GANANCIAS_POR_DEPARTAMENTO_3_ATRAS);
		return Integer.parseInt(in.nextLine());
	}

	public int showMenuExtention() {
		System.out.println(_1_REPORTE_DE_EXTENCION_DE_M2_DE_MINAS_POR_DEPARTAMENTO_2_REPORTE_DE_EXTENCION_DE_M2_POR_DEPARTAMENTO_3_ATRAS);
		return Integer.parseInt(in.nextLine());
	}

	public int showMenuPriceMines() {
		System.out.println(_1_REPORTE_DE_PRECIO_PROMEDIO_DE_CADA_MINERAL_2_REPORTE_DE_PRECIO_TOTAL_DE_MATERIAL_EXPLOTADO_POR_DEPARTAMENTO_3_ATRAS);
		return Integer.parseInt(in.nextLine());
	}

}
