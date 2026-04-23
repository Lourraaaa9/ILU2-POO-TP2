package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}else {
			String[] donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0].equals("true")) {
				StringBuilder chaine = new StringBuilder("Vous avez vendu ");
				chaine.append(donneesEtal[4]);
				chaine.append(" sur ");
				chaine.append(donneesEtal[3]);
				chaine.append(" ");
				chaine.append(donneesEtal[2]);
				chaine.append(".");
				System.out.println(chaine.toString());
			}
		}
	}

}
