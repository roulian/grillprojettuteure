package controleur;

import src.Grille;
import src.Observateur;

public class ControleurR {
	private ControleurM ctrlM ;
	private Grille grille ;
	private Observateur observateur ;
	
	public ControleurR(ControleurM pCtrlM){
		ctrlM = pCtrlM ;
		grille = ctrlM.getLaGrille() ;
//		observateur = ctrlM.ge
	}
}
