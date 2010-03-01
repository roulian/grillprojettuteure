package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle_Obs2etTailleGrille1 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle_Obs2etTailleGrille1(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}

	// gere le cas observateur de taille tailleGrille-1 en face de 2 
	public boolean resolve() {
		boolean solve = false ;
		
		//Observateur NORD = 2 et SUD = tailleGrille -1
		for(int abscisse = 1 ; abscisse<=tailleGrille ; abscisse++)
		{
			if(observateur.getObservateur(Observateur.NORD, abscisse) == 2 && observateur.getObservateur(Observateur.SUD, abscisse) == tailleGrille - 1)
			{
				solve = solve || grille.construire(abscisse, 2, tailleGrille);
			}
		}
		
		//Observateur NORD = tailleGrille -1 et SUD = 2
		for(int abscisse = 1 ; abscisse<=tailleGrille ; abscisse++)
		{
			if(observateur.getObservateur(Observateur.NORD, abscisse) == tailleGrille - 1 && observateur.getObservateur(Observateur.SUD, abscisse) == 2)
			{
				solve = solve || grille.construire(abscisse, tailleGrille - 1 , tailleGrille);
			}
		}
		
		//Observateur OUEST = tailleGrille -1 et EST = 2
		for(int ordornee = 1 ; ordornee<=tailleGrille ; ordornee++)
		{
			if(observateur.getObservateur(Observateur.EST, ordornee) == 2 && observateur.getObservateur(Observateur.OUEST, ordornee) == tailleGrille - 1)
			{
				solve = solve || grille.construire(tailleGrille - 1 , ordornee , tailleGrille);
			}
		}
		
		//Observateur EST = tailleGrille -1 et OUEST = 2
		for(int ordornee = 1 ; ordornee<=tailleGrille ; ordornee++)
		{
			if(observateur.getObservateur(Observateur.EST, ordornee) == tailleGrille - 1 && observateur.getObservateur(Observateur.OUEST, ordornee) == 2)
			{
				solve = solve || grille.construire(2, ordornee , tailleGrille);
			}
		}
		
		return solve ;
	}
}