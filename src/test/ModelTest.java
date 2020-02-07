/*package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.MineNotFoundException;
import models.Department;
import models.DepartmentName;
import models.Mine;
import models.MineType;
import models.OreType;
public class ModelTest {
	static Department depart ;

	@BeforeClass
	public static void generateData() throws MineNotFoundException {
		System.out.println("xui");
	 depart = new Department(DepartmentName.ANTIOQUIA,250000);
	}
	@Test
	public void whenSearchMine_thenok() throws MineNotFoundException{
		
		System.out.println("222");
		int id = 0 ;
			int mine = depart.searchPositionMine(id);
			assertEquals(0, mine);
	}
	@Test(expected=MineNotFoundException.class)
	public void whenRemoveMine_thenFail() throws MineNotFoundException {
		assertEquals(MineNotFoundException.class, depart.removeMine(10));
	}
	@Test
	public void whenSearchMineTwo_thenOk() throws MineNotFoundException{
		int id = depart.getListMine().size() + 1;
		Mine testMine = new Mine("minaDePrueba",150,OreType.COBRE, 1200,id,MineType.SUBTERRANEAN_MINE,20000);
		depart.addMine(testMine);
		System.out.println(depart.getListMine().size());
		assertEquals("minaDePrueba", depart.searchMine(id).getName());
	}
}*/

