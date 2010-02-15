package controleur;

import src.Grille;
import src.Observateur;

public class ControleurM {
	private int tailleGrille ;
	private Grille laGrille ;
	private Observateur observateur ;
	private int difficulte ;
	private ControleurVues ctrlVues ;
	private ControleurR ctrlRegl;
	private boolean gameStart;
	private boolean tricheBouton = false;
	
	public ControleurM(){
		gameStart = false ;
		laGrille = null ;
		observateur = null ;
		difficulte = 0 ;
		tailleGrille = 4 ;
		
		ctrlVues = new ControleurVues(this) ;
	}
	
	public void commencerPartie(int pTaille, int pDifficulte){
		tailleGrille = pTaille ;
		difficulte = pDifficulte ;
		gameStart = true ; // pour l'instant on ne gere pas la fin de partie
//		normalement on devrait g�n�rer la grille l�, sauf que pour l'instant on ne sait pas encore la r�soudre...
		
		// ce code ne sert qu'a tester
		laGrille = new Grille(tailleGrille) ;
		for(int i=0;i<tailleGrille;i++){
			for(int j=0;j<tailleGrille;j++){
				laGrille.construire(i+1, j+1, 0) ;
			}
		}
		observateur = new Observateur();
		
//		pour r�soudre une grille c'est comme �a =) 
		ctrlRegl = new ControleurR(this) ;
		ctrlRegl.applyRegle() ;
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

	public Observateur getObservateur() {
		return observateur;
	}

	public void setLaGrille(Grille laGrille) {
		this.laGrille = laGrille;
	}
}
