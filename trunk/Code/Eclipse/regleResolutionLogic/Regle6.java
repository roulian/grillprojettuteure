package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle6 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle6(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = ctrlR.getTailleGrille();
	}

	// construit les batiment dans l'ordre croisant depuis l'observateur lorsque ce dernier = taillegrille
	public boolean resolve() {
		boolean solve = false ;
		
		// TO DO
		
		return solve ;
	}
}