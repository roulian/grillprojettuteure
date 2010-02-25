package regleResolutionLogic;

import java.util.Vector;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle_DernierTypBat implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	//
	public Regle_DernierTypBat(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}

	// construit un batiment lorsque c'est le dernier a construire 
	public boolean resolve() {
		boolean solve = false ;

		//on regarde dans les vector de possibilité de toutes les colonne pour voir un un batiment
		//ne serait pas constructible à un seul endroit sur une colonne
		for (int abscisse=1 ; abscisse<=tailleGrille ; abscisse++){
			//on crée un tableau et on l'initialise à zéro
			int[] temp = new int[tailleGrille+1] ;	// la taille +1 est pratique pour la suite
			for (int i=0; i<=tailleGrille; i++)
				temp[i] = 0 ;
			
			// on parcourt les cases verticalement et on stock le nombre de batiment encore constructible
			// par taille
			for (int ordonnee=1 ; ordonnee<=tailleGrille ; ordonnee++){
				int lenght = grille.getCase(abscisse,ordonnee).getPossibilite().size() ;
				for (int z=0 ; z<lenght ; z++)
					temp[grille.getCase(abscisse,ordonnee).getPossibilite().elementAt(z)]++ ;
			}

			for (int i=0; i<=tailleGrille; i++){
				// dans le cas ou il n'y aurait plus qu'un seul batiment sur une colonne
				if(temp[i]==1){
					for (int ordonnee=1 ; ordonnee<=tailleGrille ; ordonnee++)
						solve = solve || grille.construire(abscisse,ordonnee,i) ;
				}
			}
		}
		
		//on regarde dans les vector de possibilité de toutes les lignes pour voir un un batiment
		//ne serait pas constructible à un seul endroit sur une colonne
		for (int ordonnee=1 ; ordonnee<=tailleGrille ; ordonnee++){
			//on crée un tableau et on l'initialise à zéro
			int[] temp = new int[tailleGrille+1] ;	// la taille +1 est pratique pour la suite
			for (int i=0; i<=tailleGrille; i++)
				temp[i] = 0 ;
			
			// on parcourt les cases verticalement et on stock le nombre de batiment encore constructible
			// par taille
			for (int abscisse=1 ; abscisse<=tailleGrille ; abscisse++){
				int lenght = grille.getCase(abscisse,ordonnee).getPossibilite().size() ;
				for (int z=0 ; z<lenght ; z++)
					temp[grille.getCase(abscisse,ordonnee).getPossibilite().elementAt(z)]++ ;
			}

			for (int i=0; i<=tailleGrille; i++){
				// dans le cas ou il n'y aurait plus qu'un seul batiment sur une colonne
				if(temp[i]==1){
					for (int abscisse=1 ; abscisse<=tailleGrille ; abscisse++)
						solve = solve || grille.construire(abscisse,ordonnee,i) ;
				}
			}
		}
		
		return solve ;
	}
}
