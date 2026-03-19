package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder bienvenue = new StringBuilder();
					bienvenue.append("Bienvenue villageois ");
					bienvenue.append(nomVisiteur);
					System.out.println(bienvenue.toString());
					int force=0;
					force=Clavier.entrerEntier("Quelle est votre force ?");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder bienvenue = new StringBuilder();
		bienvenue.append("Bienvenue druide ");
		bienvenue.append(nomVisiteur);
		System.out.println(bienvenue.toString());
		int forceDruide=0;
		int effetPotionMin=1;
		int effetPotionMax=0;
		forceDruide=Clavier.entrerEntier("Quelle est votre force ?");
		while (effetPotionMax<effetPotionMin) {
			effetPotionMin=Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMax=Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?");
			if(effetPotionMax<effetPotionMin) {
				System.out.println("Attention druide, vous vous êtes trompé entre le maximum et le minimum.");
			}
		}		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
