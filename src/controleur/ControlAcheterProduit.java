package controleur;

import villagegaulois.*;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public void acheterProduit(String nomVendeur, int nbProduit) {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		etal.acheterProduit(nbProduit);
	}
	
	public String[] recherchervendeurs(String produit) {
		Gaulois[] vendeurs= village.rechercherVendeursProduit(produit);
		String[] vendeursString=new String[vendeurs.length];
		for(int i=0;i<vendeurs.length;i++) {
			vendeursString[i]=vendeurs[i].getNom();
		}
		return vendeursString;
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
