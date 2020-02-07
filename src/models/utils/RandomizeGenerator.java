package models.utils;

import java.util.Random;

import models.DepartmentName;
import models.MineType;
import models.OreType;

/**
 * Crea numeros o nombres aleatoriamente.
 * 
 * @author Criis
 * @author Felipe
 */
public class RandomizeGenerator {
	static String[] names = new String[] { "Mina1", "Mina2", "Mina3", "Mina4", "Mina5", "Mina6", "Mina7", "Mina8",
			"Mina9", "Mina10", "Mina11", "Mina12", "Mina13", "Mina14", "Mina15" };
	static DepartmentName[] depNames = DepartmentName.values();
	static MineType[] mineTypes = MineType.values();
	static OreType[] oreTypes = OreType.values();
	static Random r = new Random();

	/**
	 * Genera nombre aleatorio de los nombres en el array designado.
	 * 
	 * @return Retorna un nombre aleatorio.
	 */
	public static String generateRandomName() {
		return names[r.nextInt(names.length - 1)];
	}

	/**
	 * Genera un numero aleatorio entre 0 y un valor maximo
	 * 
	 * @param maximum Valor maximo que puede ser el numero a generar.
	 * @return Retorna un numero aleatorio.
	 */
	public static int generateRandomInt(int maximum) {
		return r.nextInt(maximum);
	}

	/**
	 * Genera un numero aleatorio entre un numero minimo y numero maximo.
	 * 
	 * @param minimum Valor minimo para generar el numero.
	 * @param maximum Valor maximo para generar el numero.
	 * @return Retorna un numero aleatorio.
	 */
	public static int generateRandomInt(int minimum, int maximum) {
		return r.nextInt(maximum) + minimum;
	}

	/**
	 * Genera un departamento aleatorio.
	 * 
	 * @return Retorna un departamento aleatorio.
	 */
	public static DepartmentName generateRandomDepartmentName() {
		return depNames[r.nextInt(depNames.length - 1)];
	}

	/**
	 * Genera una tipo de mina aleatorio.
	 * 
	 * @return Retorna un tipo de mina aleatorio.
	 */
	public static MineType generateRandomMineType() {
		return mineTypes[r.nextInt(mineTypes.length)];
	}

	/**
	 * Genera un tipo de mineral aleatorio.
	 * 
	 * @return Retorna un tipo de mineral aleatorio.
	 */
	public static OreType generateRandomOreType() {
		return oreTypes[r.nextInt(oreTypes.length - 1)];
	}

}
