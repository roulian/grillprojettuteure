package controleur;

import src.Grille;

public class ControleurM {
	private int tailleGrille ;
	private Grille laGrille ;
	private ControleurVues ctrlVues ;
	private boolean gameStart = false ;
	
	public ControleurM(int pTaille){
		tailleGrille = pTaille ;
		laGrille = new Grille(tailleGrille) ;
		ctrlVues = new ControleurVues(this) ;
	}

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
}
