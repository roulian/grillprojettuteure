package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle3 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle3(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}

	public void refreshBuffer() {
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
	}

	// il s'agit de placer les batiment 
	public void resolve() {
		refreshBuffer() ;
		
	}

	public void applyResolve() {
		// TODO Auto-generated method stub
		
	}

}
