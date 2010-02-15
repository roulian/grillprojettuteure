package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle2 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle2(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}
	
	public void refreshBuffer() {
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
	}

	// Cette regle permet de construire un batiment de façon automatique lorsque 
	// le vector de possibilité ne contient plus qu'un batiment. (int) 
	public void resolve() {
		refreshBuffer() ;
		for(int abscisse=1; abscisse<=tailleGrille; abscisse++){
			for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){
//				si le vector ne contient qu'un élément on le construit
				if(grille.getCase(abscisse,ordonnee).getPossibilite().size()==1)
					grille.construire(abscisse,ordonnee,grille.getCase(abscisse,ordonnee).getPossibilite().elementAt(0));
			}
		}
		applyResolve() ;
	}

	public void applyResolve() {
		ctrlR.getCtrlM().setLaGrille(grille) ;
	}

}
