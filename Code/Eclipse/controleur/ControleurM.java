package controleur;

import src.Grille;

public class ControleurM {
	int tailleGrille ;
	Grille laGrille ;
	ControleurVues ctrlVues ;
	
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
	
	
}
