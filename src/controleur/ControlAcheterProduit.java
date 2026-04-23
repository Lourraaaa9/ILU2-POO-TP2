package controleur;

import villagegaulois.*;
import personnages.Gaulois;

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

	public int acheterProduit(String nomGaulois, int quantite) {
		Gaulois gaulois = village.trouverHabitant(nomGaulois);
		Etal etal = village.rechercherEtal(gaulois);
		return etal.acheterProduit(quantite);
	}

	public String[] rechercherVendeurs(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if (vendeurs == null) {
			String[] pasDeVendeur = new String[0];
			return pasDeVendeur;
		}
		String[] vendeursString = new String[vendeurs.length];
		for (int i = 0; i < vendeurs.length; i++) {
			vendeursString[i] = vendeurs[i].getNom();
		}
		return vendeursString;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}

	public int nbProduitRestant(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.getQuantite();
	}
}