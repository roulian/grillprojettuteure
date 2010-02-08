package controleur;

import vue.VuePrincipale;

public class ControleurVues {
	int tailleGrille ;
	
	public ControleurVues(int pTailleGrille) {
		tailleGrille = pTailleGrille ;
		VuePrincipale vue = new VuePrincipale(this) ;
		vue.setVisible(true);
	}

	public int getTailleGrille() {
		return tailleGrille;
	}
}
