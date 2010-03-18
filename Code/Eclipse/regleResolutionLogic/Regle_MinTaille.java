package regleResolutionLogic;

import controleur.ControleurR;
import src.Case;
import src.Grille;
import src.Observateur;


/**
 * 
 * @author Andres Gomez Thomas
 * @category Regle
 * 
 * permet de deminuer le vector de possibilité de case lorsque l'observateur n 
 * voit à une distance de n le batiment le plus grand de la grille (m)
 * Cette regle enleve les batiments de taille min des cases distantes (non adjacente) de l'observateur.
 */
public class Regle_MinTaille implements Regle {
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle_MinTaille(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = ctrlR.getTailleGrille();
	}

	public boolean resolve() {
		boolean solve = false ;
		
		//Gestion observateur nord
		for(int abscisse=1;abscisse<=tailleGrille;abscisse++){
			// vas chercher l'observateur, puis regarde le batiment construit à la distance = n
			// et regarde si ce batiment est celui qui est le plus grand de la grille: taille de la grille.
			int obsTemp = observateur.getObservateur(Observateur.NORD,abscisse);
			if(obsTemp!=0&&grille.getCase(abscisse,obsTemp).getBatiment() == tailleGrille){
				for(int i=1;i<obsTemp;i++){
					for(int j=1;j<i;j++){
						solve = solve || grille.getCase(abscisse,i).refreshPossibilite(j) ;
					}
				}
			}
		}
		
		//Gestion observateur EST
		for(int ordonne=1;ordonne<=tailleGrille;ordonne++){
			// vas chercher l'observateur, puis regarde le batiment construit à la distance = n
			// et regarde si ce batiment est celui qui est le plus grand de la grille: taille de la grille.
			int obsTemp = observateur.getObservateur(Observateur.EST,ordonne);
			if(obsTemp!=0&&grille.getCase(tailleGrille-obsTemp+1,ordonne).getBatiment() == tailleGrille){
				for(int i=1;i<obsTemp;i++){
					for(int j=1;j<i;j++){
						solve = solve || grille.getCase(tailleGrille+1-i,ordonne).refreshPossibilite(j) ;
					}
				}
			}
		}
		
		//Gestion observateur sud
		for(int abscisse=1;abscisse<=tailleGrille;abscisse++){
			// vas chercher l'observateur, puis regarde le batiment construit à la distance = n
			// et regarde si ce batiment est celui qui est le plus grand de la grille: taille de la grille.
			int obsTemp = observateur.getObservateur(Observateur.SUD,abscisse);
			if(obsTemp!=0&&grille.getCase(abscisse,tailleGrille-obsTemp+1).getBatiment() == tailleGrille){
				for(int i=1;i<obsTemp;i++){
					for(int j=1;j<i;j++){
						solve = solve || grille.getCase(abscisse,tailleGrille+1-i).refreshPossibilite(j) ;
					}
				}
			}
		}
		
		//gestion observateur ouest
		for(int ordonne=1;ordonne<=tailleGrille;ordonne++){
			// vas chercher l'observateur, puis regarde le batiment construit à la distance = n
			// et regarde si ce batiment est celui qui est le plus grand de la grille: taille de la grille.
			int obsTemp = observateur.getObservateur(Observateur.OUEST,ordonne);
			if(obsTemp!=0&&grille.getCase(obsTemp,ordonne).getBatiment() == tailleGrille){
				for(int i=1;i<obsTemp;i++){
					for(int j=1;j<i;j++){
						solve = solve || grille.getCase(i,ordonne).refreshPossibilite(j) ;
					}
				}
			}
		}
		
		return solve ;
	}
}
