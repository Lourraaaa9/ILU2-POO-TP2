package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche=controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length==0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}else {
			StringBuilder message=new StringBuilder(nomAcheteur);
			message.append(", vous trouverez au marché :\n");
			int i=0;
			while(i<infosMarche.length) {
				message.append("- ");
				message.append(infosMarche[i]);
				message.append(" qui vend ");
				i++;
				message.append(infosMarche[i]);
				message.append(" ");
				i++;
				message.append(infosMarche[i]);
				i++;
			}
			System.out.println(message.toString());
		}
		
	}
}
