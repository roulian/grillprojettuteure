package regleResolutionLogic;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

/**
 * lorsqu'il ne reste plus qu'une valeur dans le vecteur de possibilit� cette regle contruit le batiemnet sur la grille
 * @author Andres Gomez Thomas
 */
public class Regle_DernierVecBat implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle_DernierVecBat(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = ctrlR.getTailleGrille();
	}
	
	public void refreshBuffer() {
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
	}

	// Cette regle permet de construire un batiment de fa�on automatique lorsque 
	// le vector de possibilit� ne contient plus qu'un batiment. (int) 
	public boolean resolve() {
		boolean solve = false ;
		refreshBuffer() ;
		for(int abscisse=1; abscisse<=tailleGrille; abscisse++){
			for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){
//				si le vector ne contient qu'un �l�ment on le construit
				if(grille.getCase(abscisse,ordonnee).getPossibilite().size()==1){
//					System.out.println("--------- appel regle 2 --------");
//					System.out.print("abs : "+abscisse);
//					System.out.print(" ord : "+ordonnee);
//					System.out.print(" siz : "+grille.getCase(abscisse,ordonnee).getPossibilite().size());
//					System.out.println(" bat : "+grille.getCase(abscisse,ordonnee).getPossibilite().elementAt(0));
					solve = grille.construire(abscisse,ordonnee,grille.getCase(abscisse,ordonnee).getPossibilite().elementAt(0));
				}
			}
		}
		applyResolve() ;
		return solve ;
	}

	public void applyResolve() {
		ctrlR.getCtrlM().setLaGrille(grille) ;
	}

}
