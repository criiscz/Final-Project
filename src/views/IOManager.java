package views;

import java.util.Scanner;

import exceptions.DepartmentNotFoundException;
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
			+ "4. Salir\n";
	public static final String TOTAL_METERS = "content";
	public static final String WELCOME = "content";
	public static final String MINE = "content";
	public static final String MINE_NAME = "Nombre Mina";
	public static final String SEPARATOR = "-------------------------------------------------------------------------------------------------";
	public static final String DEPARTMENT = "Departamento";
	public static final String BUDGET_DEPARTMENT = "presupuesto";
	public static final String ID_MINE = "mina";
	public static final String METERS_MINE = "m2 mina";
	public static final String ORE = "Mineral";
	public static final Object[] TITLES_TABLE = {DEPARTMENT, BUDGET_DEPARTMENT,ID_MINE,MINE_NAME,METERS_MINE, ORE};
	public static final String FORMAT = "%1$-15s %2$-15s %3$-10s %4$-15s %5$-15s %6$-10s ";

	public IOManager() {
		in = new Scanner(System.in);
	}

	public int selectOptionMenu() {
		System.out.println(SHOW_MENU);
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
		try {
			int option = Integer.parseInt(in.nextLine());
			return selectOreType(option);
		} catch (Exception e) {
			System.out.println("Error");
			return readOreType();
		}

	}

	public OreType selectOreType(int option) throws Exception {
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
			throw new Exception();
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
		int option = Integer.parseInt(in.nextLine());
		try {
			return selectMineType(option);
		} catch (Exception e) {
			System.out.println("Error");
			return readMineType();
		}
	}

	public MineType selectMineType(int option) throws Exception {
		switch (option) {
		case 1:
			return MineType.OPEN_PIT_MINE;
		case 2:
			return MineType.SUBTERRANEAN_MINE;
		default:
			throw new Exception();
		}
	}
	
	public int readBudgetMine() {
		System.out.println("Digite el presupuesto destinado a la mina.");
		return Integer.parseInt(in.nextLine());
	}
	
	public DepartmentName readDepartment() {
		System.out.println("Seleccion el departamento: ");
		try {
			return selectDepartment(Integer.parseInt(in.nextLine()));
		} catch (Exception e) {
			showError(e.toString());
			return readDepartment();
		}
	}
	
	public DepartmentName selectDepartment(int option) throws Exception {
		switch (option) {
		case 1:
			return DepartmentName.BOYACA;
		default:
			throw new DepartmentNotFoundException();
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
				System.out.println(String.format("%1$-15s %2$-15s %3$-10s %4$-15s %5$-15s %6$-15s %7$-10s %8$-20s %9$-11s", department.toObjectMatrix()[i]));
				System.out.println(SEPARATOR);
			}
		}
	}

}




















