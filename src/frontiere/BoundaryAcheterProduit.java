package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	
	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
		
		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = Clavier.entrerChaine("");

		Gaulois[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);

		if (vendeurs != null) {
			int numMarchant = 0;
			do {
				System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
				for (int i = 0; i < vendeurs.length; i++) {
					System.out.println(Integer.toString(i + 1) + " - " + vendeurs[i].getNom());
				}
				numMarchant = Clavier.entrerEntier("");
			} while (numMarchant <= 0 || numMarchant > vendeurs.length);
			Gaulois marchant = vendeurs[numMarchant-1];
			
			String nomMarchant = controlAcheterProduit.getNom(marchant);
			
			System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomMarchant + ".");
			System.out.println("Bonjour " + nomAcheteur);

			System.out.println("Combien de " + produit + " voulez-vous acheter ?");
			int nbProduit = Clavier.entrerEntier("");

			Etal etal = controlAcheterProduit.trouverEtal(nomMarchant);
			
			int quantite = etal.getQuantite();
			if (quantite == 0) {
				System.out.println(nomAcheteur+" veut acheter "+nbProduit+" "+produit+", malheureusement il n’y en a plus !");
			} else if (quantite < nbProduit) {
				System.out.println(nomAcheteur + " veut acheter " + Integer.toString(nbProduit) + " " + produit
						+ ", malheureusement " + nomMarchant + " n’en a plus que " + Integer.toString(quantite)
						+ ". " + nomAcheteur + " achète tout le stock de " + nomMarchant + ".");

			} else {
				System.out.println(
						nomAcheteur + " achète " + nbProduit + " " + produit + " à " + nomMarchant + ".");
			}
			controlAcheterProduit.acheterProduit(nomMarchant, quantite);
		} else {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		}
	}}
}