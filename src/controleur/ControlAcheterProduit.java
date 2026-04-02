package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}

	public Etal trouverEtal(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}

	public Gaulois[] rechercherVendeursProduit(String produit)  {
		return village.rechercherVendeursProduit(produit);
	}
	
	public int acheterProduit(String nomGaulois, int quantite) {
		Gaulois gaulois=village.trouverHabitant(nomGaulois);
		Etal etal = village.rechercherEtal(gaulois);
		etal.acheterProduit(quantite);
		return quantite;
	}
	
	public String getNom(Gaulois gaulois) {
		return gaulois.getNom();
	}
	
}