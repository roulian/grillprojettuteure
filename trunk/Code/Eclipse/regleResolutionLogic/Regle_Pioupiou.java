package regleResolutionLogic;

import java.util.Vector;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle_Pioupiou implements Regle {
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle_Pioupiou(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = ctrlR.getTailleGrille();
	}

	// construit les batiment dans l'ordre croisant depuis l'observateur lorsque ce dernier = taillegrille
	public boolean resolve() {
		boolean solve = false ;
		
		// parcourt des lignes
		// comparaisons 2à2 des case d'une ligne
		for(int i=1; i<tailleGrille; i++){
			for(int j=i+1; j<=tailleGrille; j++){
				if(grille.getCase(i,j).getPossibilite().equals(grille.getCase(i,j).getPossibilite())){
					// piou piou
				}
			}
		}
		
		// parcourt des colonnes.
		
		
		return solve ;
	}
	
	// permet de comparer deux vecteurs entre eux (leur contenu et non pas leur adresse)
	private boolean vecEqual(Vector<Integer> pVec1, Vector<Integer> pVec2){
		// semble assez useless puisque .equal existe, a refléchir si le vecteur de possibilité contient les
		// éléments dans le meme ordre à chaque fois
		
		// mais oui en fait...
		return false ;
	}
}
