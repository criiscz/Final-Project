package models.utils;

import java.util.HashMap;
import java.util.Map;
 /**
  * Genera graficos de barras con ayuda de matrices.
  * @author Criis
  * @author Felipe
  *
  */
public class MatrixReport {
	/**
	 * Encabezado del eje x con el valor de "Depart: "
	 */
	public static final String DEPART = "Depart:  ";
	/**
	 * Encabezado del eje x con el valor de "Mineral: "
	 */
	public static final String ORE = "Mineral: ";
	/**
	 * Encabezado del eje x con el valor de "Tipo: "
	 */
	public static final String TYPE_MINE = "Tipo:    ";
	
	/**
	 * Genera la matriz en la que esta dibujado la grafica.
	 * @param map
	 * Mapa con los datos del eje "y" y el eje "x".
	 * @param option
	 * Tipo de encabezado del eje x.
	 * @param scale
	 * Escala a la cual se va a dibujar el grafico (1-10000)
	 * @return
	 * Retorna un vector de objetos con la grafica y las convenciones de esta.
	 */
	public static Object[] generateMatrixReport(Map<String,Integer> map, String option, int scale) {
		Object[] keys = map.keySet().toArray();
		Object[] values = map.values().toArray(); 
		
		HashMap<String,Integer> name = new HashMap<String,Integer>();
		
		for (int i = 0; i < keys.length; i++) {
			name.put(keys[i].toString(),i);
		}
		
		Object[] nameDepartment = name.keySet().toArray();
		Object[] num = name.values().toArray();
		
		String[][] matrix = new String[defineParOrNot(searchMayor(values), scale) + 2][num.length + num.length + 1];
		int counter = scale;
		return new Object[] {generateGraphic(matrix, values, num, counter, option,scale,num.length + 1), createConventions(nameDepartment, num)};
		
			
	}
	
	/**
	 * Retorna el numero mayor entre los datos.
	 * @param values
	 * Array con los valores a evaluar
	 * @return
	 * Retorna el valor mayor entre todo el array.
	 */
	private static int searchMayor(Object[] values) {
		int mayor = (int)values[0];
		for (Object i : values) {
			if((int)i > mayor)
				mayor = (int)i;
		}
		return mayor;
	}
	
	/**
	 * Define la altura de la matriz para realizar el grafico
	 * @param values
	 * valor maximo para determinar la altura.
	 * @param scale
	 * Escala con la que se dibujara la matriz.
	 * @return
	 * Retorna la altura de la matriz.
	 */
	private static int defineParOrNot(int values, int scale) {
		if(values%scale== 0)
			return values/scale;
		else
			return (values/scale)+1;
	}
	
	/**
	 * Metodo que dibuja la grafica de barras en la matriz.
	 * @param matrix
	 * Matriz lista para dibujar la grafica de barras.
	 * @param values
	 * Valores del eje X
	 * @param num
	 * valores del eje Y
	 * @param counter
	 * Valor de escala auxiliar
	 * @param option
	 * Valor del encabezado del eje Y
	 * @param scale
	 * Escala por la cual se cuadra la grafica.
	 * @param valueOfColumns
	 * Cantidad de columnas que tendra la grafica.
	 * @return
	 * Retorna una matriz con la grafica dibujada.
	 */
	private static String[][] generateGraphic(String[][] matrix, Object[] values, Object[] num, int counter, String option, int scale, int valueOfColumns){
		int test = 1;
		for (int i = 1; i < valueOfColumns; i++) {
			int val = defineParOrNot((int)values[i-1], scale);
			for (int j = 0; j < val; j++) {
				if((int)values[i-1] > 0) {
					
					if((int)values[i-1] % scale != 0 && j + 1 == val)
						matrix[j+2][test] =String.format("%1$-6s", ("[" + (int)values[i-1]%scale + "]"));
					else
						matrix[j+2][test] = String.format("%1$-6s", "[+]");
					matrix[j+2][0] = " "+counter+"	|";
					counter+=scale;
					
				}
			}
			matrix[1][0] = "---------";
			matrix[1][test-1] = String.format("%1$-6s","----");
			matrix[1][test] = String.format("%1$-6s","----");
			matrix[0][test] = String.format("%1$-6s",(" " + num[i-1] + " "));
			counter = scale;
			test += 2;
		}
		matrix[0][0] = option;
		
		return matrix;
	}
	
	/**
	 * Crea las convenciones de la grafica.
	 * @param names
	 * Array con los nombres de los valores de las convenciones.
	 * @param values
	 * Array con los valores de las convenciones.
	 * @return
	 * Retorna las convenciones en una matriz de Strings.
	 */
	private static String[][] createConventions(Object[] names, Object[] values){
		String[][] data = new String[names.length][2];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = names[i].toString();
			data[i][1] = values[i].toString();
		}
		return data;
	}
	
	
}
