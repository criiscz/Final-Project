package models.utils;

import java.util.Random;

import models.DepartmentName;
import models.MineType;
import models.OreType;

public class RandomizeGenerator {
	static String[] names = new String[] {"mina1","mina2","mina3","mina4","mina5","mina6"};
	static DepartmentName[] depNames = DepartmentName.values();
	static MineType[] mineTypes = MineType.values();
	static OreType[] oreTypes = OreType.values();
	static  Random r = new Random();
	
	public static String generateRandomName() {
		return names[r.nextInt(names.length - 1)];
	}
	
	public static int generateRandomInt(int maximum) {
		return r.nextInt(maximum);
	}
	
	public static int generateRandomInt(int minimum,int maximum) {
		return r.nextInt(maximum) + minimum;
	}
	
	public static DepartmentName generateRandomDepartmentName() {
		return depNames[r.nextInt(depNames.length -1)];
	}
	
	public static MineType generateRandomMineType() {
		return mineTypes[r.nextInt(mineTypes.length -1)];
	}
	
	public static OreType generateRandomOreType() {
		return oreTypes[r.nextInt(oreTypes.length -1)];
	}
	
}
