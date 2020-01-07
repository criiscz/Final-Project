package views;

import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import exceptions.OptionInvalidException;
import models.Department;
import models.DepartmentName;
import models.MineType;
import models.OreType;

public class IOManager {
	private Scanner in;
	public static final String SHOW_MENU = "Seleccione una opcion:\n"
			+ "1. Ver tabla\n"
			+ "2. Agregar mina\n"
			+ "3. Remover mine\n"
			+ "4. Editar Mina\n"
			+ "5. Economia de Mina\n"
			+ "6. Reportes\n"
			+ "7. Salir\n";
	public static final String SHOW_MENU_EDIT = "Seleccione una opcion:\n"
			+ "1. Editar Valor por kilogramo de la mina\n"
			+ "2. Editar Tipo de mineral de mina\n"
			+ "3. Atras.\n";
	public static final String TOTAL_METERS = "content";
	public static final String WELCOME = "content";
	public static final String MINE = "content";
	public static final String MINE_NAME = "Nombre Mina";
	public static final String SEPARATOR = "--------------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String DEPARTMENT = "Departamento";
	public static final String BUDGET_DEPARTMENT = "Presupuesto";
	public static final String ID_MINE = "Id Mina";
	public static final String METERS_MINE = "m2";
	public static final String ORE = "Mineral";
	public static final String KILOGRAM_PRICE = "$ Kilo";
	public static final String MINE_TYPE = "Tipo de Mina";
	public static final String BUDGET_MINE = "Presupuesto Mina";
	public static final Object[] TITLES_TABLE = {DEPARTMENT, BUDGET_DEPARTMENT,ID_MINE,MINE_NAME,METERS_MINE, ORE, KILOGRAM_PRICE, MINE_TYPE, BUDGET_MINE};
	public static final String FORMAT = "%1$-22s %2$-15s | %3$-10s %4$-15s %5$-15s %6$-15s %7$-10s %8$-20s %9$-11s";

	public IOManager() {
		in = new Scanner(System.in);
	}

	public int selectOptionMenu() {
		System.out.println(SHOW_MENU);
		return Integer.parseInt(in.nextLine());
	}
	
	public int selectOptionMenuEdit() {
		System.out.println(SHOW_MENU_EDIT);
		return Integer.parseInt(in.nextLine());
	}
	
	public String readNameMine() {
		System.out.println("Digite el nombre de la mina: ");
		return in.nextLine();
	}

	public int readMeterMine() {
		System.out.println("Digite el numero de metros cuadrados de la mina: ");
		return Integer.parseInt(in.nextLine());
	}

	public OreType readOreType() {
		System.out.println("Elija el tipo de mineral: ");
		for (int i = 0; i < OreType.values().length; i++) {
			System.out.println(1+i + " " + OreType.values()[i].getOreType());
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
		System.out.println("Digite el precio por kilogramo de este producto:");
		return Integer.parseInt(in.nextLine());
	}

	public int readId() {
		System.out.println("Digite el numero de indentificacion de la mina: ");
		return Integer.parseInt(in.nextLine());
	}

	public MineType readMineType() {
		System.out.println("Ingrese un tipo de mina: ");
		for (int i = 0; i < MineType.values().length; i++) {
			System.out.println(i+1 + " " + MineType.values()[i].getMineType());
		}
		
		try {
			int option = Integer.parseInt(in.nextLine());
			return selectMineType(option);
		} catch (OptionInvalidException | NumberFormatException e) {
			System.out.println("Error");
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
		System.out.println("Digite el presupuesto destinado a la mina.");
		return Integer.parseInt(in.nextLine());
	}
	
	public DepartmentName readDepartment() {
		System.out.println("Seleccion el departamento: ");
		for (int i = 0; i < DepartmentName.values().length; i++) {
			System.out.println(i+1 + "  " + DepartmentName.values()[i].getName());
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
		System.out.println("La mina se agrego exitosamente");
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
				System.out.println(String.format("%1$-22s %2$-15s | %3$-10s %4$-15s %5$-15s %6$-15s %7$-10s %8$-20s %9$-11s", department.toObjectMatrix()[i]));
				System.out.println(SEPARATOR);
			}
		}
	}
	
	public void showSucesfull() {
		System.out.println("Operacion Ejecutada Exitosamente");
	}

	public int readMount() {
		System.out.print("Ingrese el valor total de los insumos a comprar: $");
		return Integer.parseInt(in.nextLine());
	}

	public int readOptionEconomy() {
		System.out.println("Que desea hacer?\n"
				+ "1. Vender mineral por kilos.\n"
				+ "2. Comprar insumos.\n"
				+ "3. Atras.");
		return Integer.parseInt(in.nextLine());
	}
	
	public void showReportOne(Object[] report) {
		String[][] data = (String[][]) report[0];
		String[][] convention = (String[][]) report[1];
		System.out.println("N° Minas|");
		for (int i = data.length - 1; i >= 0 ; i--) {
			for (int j = 0; j < data[i].length; j++) {
				if(data[i][j] == null) 
					System.out.print("   ");
				else
					System.out.print(data[i][j]);
			}
			System.out.println("");
		}
		System.out.println();
		System.out.println();
		System.out.println("----------------------------");
		System.out.println("	Convenciones");
		System.out.println("----------------------------");
		System.out.println(String.format("%2$-5s %1$-10s", new Object[] {"Nombre","Num"}));
		System.out.println("----------------------------");
		
		for (int i = 0; i < convention.length; i++) {
				System.out.println(String.format("%2$-5s %1$-10s",(Object[]) convention[i]));
				System.out.println("----------------------------");
		}
	}
	
	public int showMenuGeneralReports() {
		System.out.println("1. Reporte de cantidad de minasa.\n"
				+ "2. Reporte de ganancias.\n"
				+ "3. Atras.");
		return Integer.parseInt(in.nextLine());
	}
	
	public int showMenuQuantityMines() {
		System.out.println("1. Reporte de cantidad de minas por departamento.\n"
				+ "2. Atras.");
		return Integer.parseInt(in.nextLine());
	}
	
	public int showMenuGains() {
		System.out.println("1. Reporte de ganancias de minas por departamento.\n"
				+ "2. Reporte de ganancias por departamento.\n"
				+ "3. Atras.");
		return Integer.parseInt(in.nextLine());
	}
	
	public void showReportQuantityMines(Object[] arrayData) {
		JFreeChart graphic = ChartFactory.createBarChart3D("Cantidad de ganancias de cada mina en " + arrayData[1], "#Minas", "Ganancias($)",(DefaultCategoryDataset) arrayData[0], PlotOrientation.VERTICAL, true, true, false);//D("Minas", "#minas", "cantidad de minas", data, PlotOrientation.VERTICAL, true, true, false);
		ChartPanel control = new ChartPanel(graphic);
		JFrame  window  = new JFrame ("Reporte De Ganancias Por Mina");
		window.add(control);
		window.setSize(800, 600);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setAlwaysOnTop(true);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	

}

