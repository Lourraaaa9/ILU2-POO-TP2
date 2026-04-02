package controleur;

import villagegaulois.Village;
import personnages.Chef;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initSituation() {
		System.out.println("Initialisation...");
		village=new Village("le village des irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix",10,village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlEmmenager() {
		fail("Not yet implemented");
	}

	@Test
	void testIsHabitant() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterDruide() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterGaulois() {
		fail("Not yet implemented");
	}

}
