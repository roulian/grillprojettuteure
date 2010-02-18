package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle8 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle8(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}

	// heu à défaut de trouver une meilleur regle :
	// Des observateurs égaux à 1 et 2 opposés impliquent de construire le bâtiment de taille [maximum]
	// à l’orée de l’observateur égal à 1 ainsi que de construire le bâtiment de taille [maximum – 1]
	// à coté de l’observateur égal 2.
	public boolean resolve() {
		boolean solve = false ;
		
		// TO DO
		
		return solve ;
	}
}