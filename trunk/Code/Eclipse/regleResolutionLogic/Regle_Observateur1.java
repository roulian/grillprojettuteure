package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

/**
 * place le batiement de taille maximum adjacent au observateur de taille 1
 * @author Andres Gomez Thomas
 */
public class Regle_Observateur1 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle_Observateur1(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = ctrlR.getTailleGrille();
	}

	// il s'agit de construire les batiments de taille maximum lorsque l'Observateur = 1 
	public boolean resolve() {
		boolean solve = false;
		for(int i=1; i<=4; i++){
			if(observateur.getObservateur(Observateur.NORD,i)==1)	
				solve = solve || grille.construire(i,1,tailleGrille) ; 
			if(observateur.getObservateur(Observateur.SUD,i)==1)
				solve = solve || grille.construire(i,tailleGrille,tailleGrille); 
			if(observateur.getObservateur(Observateur.EST,i)==1)
				solve = solve || grille.construire(tailleGrille,i,tailleGrille);
			if(observateur.getObservateur(Observateur.OUEST,i)==1)
				solve = solve || grille.construire(1,i,tailleGrille);
		}
		return solve ;
	}
}
