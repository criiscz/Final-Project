package models.utils;

import java.util.HashMap;
import java.util.Map;

public class MatrixReport {
	public static final String DEPART = "Depart:  ";
	public static final String ORE = "Mineral: ";
	public static final String TYPE_MINE = "Tipo:    ";
	
	public static Object[] generateMatrixReport(Map<String,Integer> map, String option, int scale) {
		Object[] keys = map.keySet().toArray();
		Object[] values = map.values().toArray(); 
		
		HashMap<String,Integer> name = new HashMap<String,Integer>();
		
		for (int i = 0; i < keys.length; i++) {
			name.put(keys[i].toString(),i);
		}
		
		Object[] nameDepartment = name.keySet().toArray();
		Object[] num = name.values().toArray();
		
		String[][] matrix = new String[defineParOrNot(searchMayor(values), scale) + 2][num.length + 1];
		int counter = scale;
		return new Object[] {generateGraphic(matrix, values, num, counter, option,scale), createConventions(nameDepartment, num)};
		
			
	}
	
	private static int searchMayor(Object[] values) {
		int mayor = (int)values[0];
		for (Object i : values) {
			if((int)i > mayor)
				mayor = (int)i;
		}
		return mayor;
	}
	
	private static int defineParOrNot(int values, int scale) {
		if(values%scale== 0)
			return values/scale;
		else
			return (values/scale)+1;
	}
	
	private static String[][] generateGraphic(String[][] matrix, Object[] values, Object[] num, int counter, String option, int scale){
		for (int i = 1; i < matrix[0].length ; i++) {
			int val = defineParOrNot((int)values[i-1], scale);
			for (int j = 0; j < val; j++) {
				if((int)values[i-1] % scale != 0 && j + 1 == val)
					matrix[j+2][i] = "[" + (int)values[i-1]%scale + "]";
				else
					matrix[j+2][i] = "[+]";
				matrix[j+2][0] = " "+counter+"	|";
				counter+=scale;
			}
			matrix[1][0] = "---------";
			matrix[1][i] = "---";
			matrix[0][i] = " " + num[i-1] + " ";
			counter = scale;
		}
		matrix[0][0] = option;
		
		return matrix;
	}
	
	private static String[][] createConventions(Object[] names, Object[] values){
		String[][] data = new String[names.length][2];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = names[i].toString();
			data[i][1] = values[i].toString();
		}
		return data;
	}
	
	
}
