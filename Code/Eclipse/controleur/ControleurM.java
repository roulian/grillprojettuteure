package controleur;

import src.Grille;

public class ControleurM {
	private int tailleGrille ;
	private Grille laGrille ;
	private ControleurVues ctrlVues ;
	private boolean gameStart;
	private boolean tricheBouton = false;
	
	public ControleurM(){
		gameStart = false ;
		laGrille = null ;
		tailleGrille = 4 ;
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

	public boolean isTricheBouton() {
		return tricheBouton;
	}
}
