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
	
	/**
	 * constructeur par défaut du controleur Maître
	 * initialise quelques variables.
	 */
	public ControleurM(){
		gameStart = false ;
		laGrille = null ;
		observateur = null ;
		difficulte = 0 ;
		tailleGrille = 0 ;
		ctrlVues = new ControleurVues(this) ;
	}
	
	/**
	 * méthode d'initialisation de partie.
	 * @param pTaille	     taille de la grille souhaité 
	 * @param pDifficulte	 dificulté de la grille 
	 */
	public void commencerPartie(int pTaille, int pDifficulte){
		tailleGrille = pTaille ;
		difficulte = pDifficulte ;
		gameStart = true ; // pour l'instant on ne gere pas la fin de partie
//		normalement on devrait générer la grille là, sauf que pour l'instant on ne sait pas encore la résoudre...
		
		// ce code ne sert qu'a tester
		laGrille = new Grille(tailleGrille) ;
		for(int i=0;i<tailleGrille;i++){
			for(int j=0;j<tailleGrille;j++){
				laGrille.construire(i+1, j+1, 0) ;
			}
		}
		int[][] obsTemp = new int[4][4] ;
//		obsTemp[Observateur.NORD][0] = 2;
//		obsTemp[Observateur.NORD][1] = 3;
//		obsTemp[Observateur.NORD][2] = 1;
//		obsTemp[Observateur.NORD][3] = 2;
//		obsTemp[Observateur.EST][0] = 2;
//		obsTemp[Observateur.EST][1] = 3;
//		obsTemp[Observateur.EST][2] = 3;
//		obsTemp[Observateur.EST][3] = 1;
//		obsTemp[Observateur.SUD][0] = 2;
//		obsTemp[Observateur.SUD][1] = 2;
//		obsTemp[Observateur.SUD][2] = 3;
//		obsTemp[Observateur.SUD][3] = 1;
//		obsTemp[Observateur.OUEST][0] = 3;
//		obsTemp[Observateur.OUEST][1] = 1;
//		obsTemp[Observateur.OUEST][2] = 2;
//		obsTemp[Observateur.OUEST][3] = 2;
//		observateur = new Observateur(obsTemp);
		
		obsTemp[Observateur.NORD][0] = 1;
		obsTemp[Observateur.NORD][1] = 2;
		obsTemp[Observateur.NORD][2] = 2;
		obsTemp[Observateur.NORD][3] = 2;
		obsTemp[Observateur.EST][0] = 3;
		obsTemp[Observateur.EST][1] = 3;
		obsTemp[Observateur.EST][2] = 1;
		obsTemp[Observateur.EST][3] = 2;
		obsTemp[Observateur.SUD][0] = 4;
		obsTemp[Observateur.SUD][1] = 3;
		obsTemp[Observateur.SUD][2] = 1;
		obsTemp[Observateur.SUD][3] = 2;
		obsTemp[Observateur.OUEST][0] = 1;
		obsTemp[Observateur.OUEST][1] = 2;
		obsTemp[Observateur.OUEST][2] = 3;
		obsTemp[Observateur.OUEST][3] = 3;
		observateur = new Observateur(obsTemp);
		
//		pour résoudre une grille c'est comme ça =) 
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
