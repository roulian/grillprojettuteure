package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

/** Cette Regle permet le placement du batiment de taille max sur une ligne/colonne devant le
 * l'obs 2 si l'unicité est respecté (soit que les batiment derriere celui de taillemax soient
 * construit)
 * 
 * @author Andres Gomez
 * @see {@link Regle}, {@link ControleurR}
 */
public class Regle_Obs2ConstruitN1 implements Regle {
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	
	public Regle_Obs2ConstruitN1(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = ctrlR.getTailleGrille();
	}
	
	@Override
	public boolean resolve() {
		boolean solve = false ;
		boolean unicite ;
		boolean noBatYet ;
		boolean maxTailleBat ;

		// observateur NORD
		for(int abscisse=1;abscisse<=tailleGrille;abscisse++){
			// on ne fait attention qu'aux observateur de taille 2
			if(observateur.getObservateur(Observateur.NORD,abscisse)==2){
				unicite = true ;
				noBatYet = true ;
				maxTailleBat = false ;
				for(int ordonnee=1; ordonnee<=tailleGrille; ordonnee++){
					if(grille.getCase(abscisse,ordonnee).getBatiment()!=0){
						// on rencontre une case construite
						if(grille.getCase(abscisse,ordonnee).getBatiment()==tailleGrille)
							maxTailleBat = true ;
						noBatYet = false ;
					}
					else{
						// on rencontre une case vide
						if((!noBatYet) && maxTailleBat)
							unicite = false ;
					}
				}
				// si on a l'unicité malgrès le fait que le bat de taille max soit present alors
				// on constuit le batiment le plus grand possible jouxtant l'obs 2
				if(unicite && maxTailleBat)
					solve = solve || grille.construire(abscisse,1,grille.getMaxColonne(abscisse)) ;
			}
		}
		
		// observateur SUD
		for(int abscisse=1;abscisse<=tailleGrille;abscisse++){
			// on ne fait attention qu'aux observateur de taille 2
			if(observateur.getObservateur(Observateur.SUD,abscisse)==2){
				unicite = true ;
				noBatYet = true ;
				maxTailleBat = false ;
				for(int ordonnee=tailleGrille; ordonnee>=1; ordonnee--){
					if(grille.getCase(abscisse,ordonnee).getBatiment()!=0){
						// on rencontre une case construite
						if(grille.getCase(abscisse,ordonnee).getBatiment()==tailleGrille)
							maxTailleBat = true ;
						noBatYet = false ;
					}
					else{
						// on rencontre une case vide
						if((!noBatYet) && maxTailleBat)
							unicite = false ;
					}
				}
				// si on a l'unicité malgrès le fait que le bat de taille max soit present alors
				// on constuit le batiment le plus grand possible jouxtant l'obs 2
				if(unicite && maxTailleBat)
					solve = solve || grille.construire(abscisse,tailleGrille,grille.getMaxColonne(abscisse)) ;
			}
		}

		// observateur OUEST
		for(int ordonnee=1;ordonnee<=tailleGrille;ordonnee++){
			// on ne fait attention qu'aux observateur de taille 2
			if(observateur.getObservateur(Observateur.OUEST,ordonnee)==2){
				unicite = true ;
				noBatYet = true ;
				maxTailleBat = false ;
				for(int abscisse=1; abscisse<=tailleGrille; abscisse++){
					if(grille.getCase(abscisse,ordonnee).getBatiment()!=0){
						// on rencontre une case construite
						if(grille.getCase(abscisse,ordonnee).getBatiment()==tailleGrille)
							maxTailleBat = true ;
						noBatYet = false ;
					}
					else{
						// on rencontre une case vide
						if((!noBatYet) && maxTailleBat)
							unicite = false ;
					}
				}
				// si on a l'unicité malgrès le fait que le bat de taille max soit present alors
				// on constuit le batiment le plus grand possible jouxtant l'obs 2
				if(unicite && maxTailleBat)
					solve = solve || grille.construire(1,ordonnee,grille.getMaxLigne(ordonnee)) ;
			}
		}
		
		// observateur EST
		for(int ordonnee=1;ordonnee<=tailleGrille;ordonnee++){
			// on ne fait attention qu'aux observateur de taille 2
			if(observateur.getObservateur(Observateur.EST,ordonnee)==2){
				unicite = true ;
				noBatYet = true ;
				maxTailleBat = false ;
				for(int abscisse=tailleGrille; abscisse>=1; abscisse--){
					if(grille.getCase(abscisse,ordonnee).getBatiment()!=0){
						// on rencontre une case construite
						if(grille.getCase(abscisse,ordonnee).getBatiment()==tailleGrille)
							maxTailleBat = true ;
						noBatYet = false ;
					}
					else{
						// on rencontre une case vide
						if((!noBatYet) && maxTailleBat)
							unicite = false ;
					}
				}
				// si on a l'unicité malgrès le fait que le bat de taille max soit present alors
				// on constuit le batiment le plus grand possible jouxtant l'obs 2
				if(unicite && maxTailleBat)
					solve = solve || grille.construire(tailleGrille,ordonnee,grille.getMaxLigne(ordonnee)) ;
			}
		}
		
		return solve;
	}

}
