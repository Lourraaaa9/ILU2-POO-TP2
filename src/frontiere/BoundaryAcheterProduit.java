package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			StringBuilder message=new StringBuilder("Je suis désolée ");
			message.append(nomAcheteur);
			message.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(message.toString());
		}
		else {
			String produit=Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String nomVendeur=identifierVendeur(produit);
			if (nomVendeur==null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}else {
				StringBuilder message=new StringBuilder(nomAcheteur);
				message.append(" se déplace jusqu'à l'étal du vendeur ");
				message.append(nomVendeur);
				message.append("\n Bonjour ");
				message.append(nomAcheteur);
				System.out.println(message.toString());
				StringBuilder question = new StringBuilder("Combien de ");
				question.append(produit);
				question.append(" voulez-vous acheter ?");
				int nbProduit=Clavier.entrerEntier(question.toString());
				achat(nbProduit,produit,nomAcheteur,nomVendeur);
			}
		}
	}
	
	private String identifierVendeur(String produit) {
		String[] vendeurs=controlAcheterProduit.rechercherVendeurs(produit);
		if(vendeurs.length!=0) {
			StringBuilder message=new StringBuilder("Chez quel commerçant voulez-vous acheter des ");
			message.append(produit);
			message.append("\n");
			for (int i=0;i<vendeurs.length;i++) {
				message.append(i+1);
				message.append(" - ");
				message.append(vendeurs[i]);
				message.append("\n");
			}
			int idVendeur=Clavier.entrerEntier(message.toString());
			return vendeurs[idVendeur-1];
		}
		return null;
	}
	
	private void achat(int quantiteVoulue, String produit, String nomAcheteur,String nomVendeur) {
		int quantiteRestante=controlAcheterProduit.nbProduitRestant(nomVendeur);	
		if(quantiteRestante==0) {
			StringBuilder message=new StringBuilder(nomAcheteur);
			message.append(" veut acheter ");
			message.append(quantiteVoulue);
			message.append(" ");
			message.append(produit);
			message.append(", malheureusement il n'y en a plus !");
			System.out.println(message.toString());
		}else {
			if(quantiteVoulue<quantiteRestante) {
				StringBuilder message=new StringBuilder(nomAcheteur);
				message.append(" veut acheter ");
				message.append(quantiteVoulue);
				message.append(" ");
				message.append(produit);
				message.append(", malheureusement ");
				message.append(nomVendeur);
				message.append(" n'en a plus que ");
				message.append(quantiteRestante);
				message.append(". ");
				message.append(nomAcheteur);
				message.append(" achète tout le stock de ");
				message.append(nomVendeur);
				message.append(".");
				controlAcheterProduit.acheterProduit(nomVendeur, quantiteRestante);
				System.out.println(message.toString());
			}else {
				controlAcheterProduit.acheterProduit(nomVendeur, quantiteVoulue);
				StringBuilder message=new StringBuilder(nomAcheteur);
				message.append(" achète ");
				message.append(quantiteVoulue);
				message.append(" ");
				message.append(produit);
				message.append(", à ");
				message.append(nomVendeur);
				message.append(".");
				System.out.println(message.toString());
			}
			
		}

	}
}