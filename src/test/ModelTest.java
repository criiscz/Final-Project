package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.DepartmentNotFoundException;
import exceptions.MineNotFoundException;
import models.Colombia;
import models.Department;
import models.DepartmentName;
import models.Mine;
import models.MineType;
import models.OreType;

public class ModelTest {
	static Department depart;
	static Colombia country;

	@BeforeClass
	public static void generateData() throws MineNotFoundException {
		System.out.println("xui");
		country = new Colombia();
		depart = new Department(DepartmentName.ANTIOQUIA, 250000);
	}

	@Test
	public void whenSearchMine_thenok() throws MineNotFoundException {

		System.out.println("222");
		int id = 0;
		int mine = depart.searchPositionMine(id);
		assertEquals(0, mine);
	}

	@Test(expected = MineNotFoundException.class)
	public void whenRemoveMine_thenFail() throws MineNotFoundException {
		assertEquals(MineNotFoundException.class, depart.removeMine(10));
	}
	
	

	@Test
	public void whenSearchMineTwo_thenOk() throws MineNotFoundException {
		int id = depart.getListMine().size() + 1;
		Mine testMine = new Mine("minaDePrueba", 150, OreType.COBRE, 1200, id, MineType.SUBTERRANEAN_MINE, 20000);
		depart.addMine(testMine);
		System.out.println(depart.getListMine().size());
		assertEquals("minaDePrueba", depart.searchMine(id).getName());
	}
	
	@Test
	public void whenSellOre_thenOk() throws MineNotFoundException {
		
		depart.sellOre(depart.getListMine().size(), 50);
	}
	
	@Before
	public void generateDepartments() throws MineNotFoundException {
		country.autogenerateDepartment();
		System.out.println("Antes");
	}
	
	@Test
	public void  whenCreateMine_thenOk() throws DepartmentNotFoundException {
		country.createMine(DepartmentName.ANTIOQUIA, "YO-No-se", 1500, OreType.COAL, 1900, MineType.SUBTERRANEAN_MINE, 5520);
	}
	
	
	@Test
	public void whenRemoveMine_thenOk() throws MineNotFoundException {
		depart.removeMine(0);
	}
	
	
}
