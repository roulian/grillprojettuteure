package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

public class Regle5 implements Regle{
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle5(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = grille.getTailleGrille();
	}

	// on applique la loi bmax = m - n + d au vecteur de possibilité des batiments
	// l'algo est assez "complex" niveau temps d'execution... a voir si on ne peut pas simplifier
	public void resolve() {		
		refreshBuffer();
		//on parcour les casses de la grille
		for (int abscisse=1 ; abscisse<=tailleGrille ; abscisse++){
			for (int ordonnee=1 ; ordonnee<=tailleGrille ; ordonnee++){
				int hauteurMax = minBMax(abscisse, ordonnee) ;
				if (hauteurMax<tailleGrille){
					for (int i=hauteurMax ; i<tailleGrille ; i++)
						grille.getCase(abscisse,ordonnee).refreshPossibilite(i+1) ;
				}
			}
		}
		applyResolve() ;
	}

	public void refreshBuffer() {
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
	}
	
	private int minBMax(int abscisse, int ordonnee){
		int bNord = tailleGrille - observateur.getObservateur()[Observateur.NORD][abscisse-1] + ordonnee ;
		int bSud = tailleGrille - observateur.getObservateur()[Observateur.SUD][abscisse-1] + (tailleGrille+1-ordonnee) ;
		int bEst = tailleGrille - observateur.getObservateur()[Observateur.EST][ordonnee-1] + (tailleGrille+1-abscisse) ;
		int bOuest = tailleGrille - observateur.getObservateur()[Observateur.NORD][ordonnee-1] + abscisse ;
		
		if (bNord>bSud){
			if(bNord>bEst){
				if(bNord>bOuest)
					return bNord ;
				else
					return bOuest ;
			}
			else{
				if(bEst>bOuest)
					return bEst ;
				else
					return bOuest ;
			}
		}
		else{
			if(bSud>bEst){
				if(bSud>bOuest)
					return bSud ;
				else
					return bOuest ;
			}
			else{
				if(bEst>bOuest)
					return bEst ;
				else
					return bOuest ;
			}
		}
	}

	public void applyResolve() {
		ctrlR.getCtrlM().setLaGrille(grille) ;
	}
	
}