package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle1 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle1(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}

	public void refreshBuffer() {
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
	}

	// il s'agit de construire les batiments de taille maximum lorsque l'Observateur = 1 
	public void resolve() {
		refreshBuffer() ;
		for(int i=1; i<=4; i++){
			if(observateur.getObservateur(Observateur.NORD,i)==1)
				grille.construire(i,1,4) ;
		}
		for(int i=1; i<=4; i++){
			if(observateur.getObservateur(Observateur.SUD,i)==1)
				grille.construire(i,tailleGrille,4);
		}
		for(int i=1; i<=4; i++){
			if(observateur.getObservateur(Observateur.EST,i)==1)
				grille.construire(tailleGrille,i,4);
		}
		for(int i=1; i<=4; i++){
			if(observateur.getObservateur(Observateur.OUEST,i)==1)
				grille.construire(1,i,4);
		}
		applyResolve() ;
	}

	public void applyResolve() {
		ctrlR.getCtrlM().setLaGrille(grille) ;
	}

}
