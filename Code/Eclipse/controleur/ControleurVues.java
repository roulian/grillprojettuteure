package controleur;

import vue.VuePrincipale;

public class ControleurVues {
	private int tailleGrille ;
	private ControleurM ctrlM ;
	
	public ControleurVues(ControleurM pCtrlM) {
		ctrlM = pCtrlM ;
		tailleGrille = ctrlM.getTailleGrille() ;
		VuePrincipale vue = new VuePrincipale(this) ;
		vue.setVisible(true);
	}

	public int getTailleGrille() {
		return tailleGrille;
	}
	
	public ControleurM getCtrlM(){
		return ctrlM ;
	}
}
