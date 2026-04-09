package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	public void initSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}
	
	@Test
	void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		String[] noms = controlAfficherVillage.donnerNomsVillageois();
		assertNotNull(noms, "La liste des noms ne doit pas être nulle");
		assertEquals("Abraracourcix", noms[0], "Le premier villageois doit être le chef");
	}

	@Test
	void testDonnerNomVillage() {
		assertEquals("le village des irréductibles", controlAfficherVillage.donnerNomVillage(), "Le nom du village doit correspondre");
	}

	@Test
	void testDonnerNbEtals() {
		assertEquals(5, controlAfficherVillage.donnerNbEtals(), "Le nombre d'étals doit être 5");
	}
}