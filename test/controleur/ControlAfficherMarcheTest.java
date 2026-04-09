package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherMarche controlAfficherMarche;

	@BeforeEach
	public void initSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche, "Le contrôleur ne doit pas être null");
	}

	@Test
	void testDonnerInfosMarche() {
	    Gaulois asterix = new Gaulois("Astérix", 5);
	    village.installerVendeur(asterix, "fleurs", 10);
	    
	    String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
	    
	    for (String s : infosMarche) {
	        System.out.println("Contenu de l'étal : " + s);
	    }

	    assertNotNull(infosMarche);
	    assertTrue(infosMarche.length > 0, "Le marché ne devrait pas être vide");

	    boolean trouveVendeur = false;
	    for (String info : infosMarche) {
	        if (info != null && info.contains("Astérix")) {
	            trouveVendeur = true;
	            break;
	        }
	    }
	    assertTrue(trouveVendeur, "Le nom du vendeur 'Astérix' devrait figurer dans les infos du marché");
	}
}