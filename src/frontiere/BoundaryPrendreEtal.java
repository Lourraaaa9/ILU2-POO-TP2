package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			StringBuilder message=new StringBuilder("Je suis désolée ");
			message.append(nomVendeur);
			message.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(message.toString());
		}
		else {
			StringBuilder message=new StringBuilder("Bonjour ");
			message.append(nomVendeur);
			message.append(" je vais regarder si je peux vous trouver un étal.");
			System.out.println(message.toString());
			if(! controlPrendreEtal.resteEtals()) {
				StringBuilder messageErreur=new StringBuilder("Désolée ");
				messageErreur.append(nomVendeur);
				messageErreur.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(messageErreur.toString());
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit;
		int nbProduit;
		int numeroEtal=-1;
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques informations :");
		produit=Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		nbProduit=Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal!=-1) {
			StringBuilder messageInstallation=new StringBuilder("Le vendeur ");
			messageInstallation.append(nomVendeur);
			messageInstallation.append(" s'est installé à l'étal n° ");
			messageInstallation.append(numeroEtal +1);
			System.out.println(messageInstallation.toString());
		}
	}
}
