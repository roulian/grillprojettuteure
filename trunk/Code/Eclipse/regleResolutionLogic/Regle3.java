package regleResolutionLogic;

import java.util.Vector;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle3 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	//
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

	// construit un batiment lorsque c'est le dernier a construire 
	public boolean resolve() {
		boolean solve = false ;
		refreshBuffer() ;
		//on crée un tableau et on l'initialise
		int[] temp = new int[tailleGrille+1] ;
		for (int i=0; i<=tailleGrille; i++)
			temp[i] = 0 ;

		//on compte le nombre de batiment de toutes les taille
		for (int abscisse=1 ; abscisse<=tailleGrille ; abscisse++){
			for (int ordonnee=1 ; ordonnee<=tailleGrille ; ordonnee++){
				temp[grille.getCase(abscisse,ordonnee).getBatiment()]++ ;
			}
		}
		
		//on vérifie le nombre de batiment de toutes les tailles
		for (int i=0; i<=tailleGrille; i++){
			if(temp[i]==tailleGrille-1){
				for (int abscisse=1 ; abscisse<tailleGrille ; abscisse++){
					for (int ordonnee=1 ; ordonnee<=tailleGrille ; ordonnee++){
						if(grille.getCase(abscisse,ordonnee).estConstrutible(i))
							solve = grille.construire(abscisse,ordonnee,i) ;
					}
				}
			}
		}
		
		return solve ;
	}

	public void applyResolve() {
		// TODO Auto-generated method stub
		
	}

}
