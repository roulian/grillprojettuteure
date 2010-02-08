package controleur;

import vue.VuePrincipale;

public class ControleurVues {
	public ControleurVues() {
		VuePrincipale vue = new VuePrincipale(this) ;
		vue.setVisible(true);
	}
}
