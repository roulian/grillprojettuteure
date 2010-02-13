package controleur;

import src.Batiment;
import src.Grille;

public class ControleurM {
	private int tailleGrille ;
	private Grille laGrille ;
	private int difficulte ;
	private ControleurVues ctrlVues ;
	private boolean gameStart;
	private boolean tricheBouton = false;
	
	public ControleurM(){
		gameStart = false ;
		laGrille = null ;
		difficulte = 0 ;
		tailleGrille = 4 ;
		ctrlVues = new ControleurVues(this) ;
	}
	
	public void commencerPartie(int pTaille, int pDifficulte){
		tailleGrille = pTaille ;
		difficulte = pDifficulte ;
//		normalement on devrait générer la grille là, sauf que pour l'instant on ne sait pas encore la résoudre...
		
		laGrille = new Grille(tailleGrille) ;
		for(int i=0;i<tailleGrille;i++){
			for(int j=0;j<tailleGrille;j++){
				laGrille.construire(i+1, j+1, new Batiment(1)) ;
			}
		}
		
	}

	//******* Accesseur *************/
	public Grille getLaGrille() {
		return laGrille;
	}

	public int getTailleGrille() {
		return tailleGrille;
	}
	
	public ControleurVues getCtrlVues() {
		return ctrlVues ;
	}
	
	public boolean GetGameStart(){
		return gameStart ;
	}

	public boolean isTricheBouton() {
		return tricheBouton;
	}
}
