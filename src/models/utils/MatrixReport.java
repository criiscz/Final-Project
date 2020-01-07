package models.utils;

import java.util.HashMap;
import java.util.Map;

public class MatrixReport {
	
	public static Object[] generateMatrixReport(Map<String,Integer> map) {
		Object[] keys = map.keySet().toArray();
		Object[] values = map.values().toArray(); 
		
		HashMap<String,Integer> name = new HashMap<String,Integer>();
		
		for (int i = 0; i < keys.length; i++) {
			name.put(keys[i].toString(),i);
		}
		
		Object[] nameDepartment = name.keySet().toArray();
		Object[] num = name.values().toArray();
		
		String[][] matrix = new String[defineParOrNot(searchMayor(values)) + 2][num.length + 1];
		int counter = 1;
		return new Object[] {generateGraphic(matrix, values, num, counter), createConventions(nameDepartment, num)};
		
			
	}
	
	private static int searchMayor(Object[] values) {
		int mayor = (int)values[0];
		for (Object i : values) {
			if((int)i > mayor)
				mayor = (int)i;
		}
		return mayor;
	}
	
	private static int defineParOrNot(int values) {
		if(values%1 == 0)
			return values/1;
		else
			return (values/1)+1;
	}
	
	private static String[][] generateGraphic(String[][] matrix, Object[] values, Object[] num, int counter){
		for (int i = 1; i < matrix[0].length ; i++) {
			int val = defineParOrNot((int)values[i-1]);
			for (int j = 0; j < val; j++) {
				if((int)values[i-1] % 1 != 0 && j + 1 == val)
					matrix[j+2][i] = "[" + (int)values[i-1]%1 + "]";
				else
					matrix[j+2][i] = "[+]";
				matrix[j+2][0] = " "+counter+"	|";
				counter+=1;
			}
			matrix[1][0] = "---------";
			matrix[1][i] = "---";
			matrix[0][i] = " " + num[i-1] + " ";
			counter = 1;
		}
		matrix[0][0] = "Depart:  ";
		
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
