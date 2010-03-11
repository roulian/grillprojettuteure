package regleResolutionLogicObservateur;

import java.util.Vector;

import controleur.ControleurR;
import regleResolutionLogic.Regle;

/**
 * 
 * @author Andres Gomez Thomas
 * @category Semi Controleur de Regle
 * @see ControleurR
 *
 * Cette classe à été créer pour gérer les règles plus spécialisées,
 * elle fonctionne comme le ControleurR, mais permet de gérer en plus des regles ne s'appliquant qu'a une taille de grille particulière. 
 * 
 */
public class Regle_ObservateurDoitVoir implements Regle{
	private Vector<Regle> tabRegle ;
		
	public Regle_ObservateurDoitVoir(ControleurR pCtrlR, int pTailleGrille){
		tabRegle = new Vector<Regle>() ;
		
		//regle spécifique à la taille
		switch(pTailleGrille){
		case 4 :
			//contruction du simili controleur pour taille 4
		break ;
		case 5 :
			//contruction du simili controleur pour taille 5			
		break ;
		case 6 :
			//contruction du simili controleur pour taille 6			
		break ;
		}
	}
	
	@Override
	public boolean resolve() {
		int nbRegle = tabRegle.size();
		boolean solve = true ;
		boolean temp ;

		solve = false ;
		for (int i=0; i <nbRegle; i++){
			System.out.println("--> "+tabRegle.elementAt(i).getClass());
			temp = tabRegle.elementAt(i).resolve() ;
			solve = solve || temp ;
			System.out.println("<-- RETOUR - solve "+temp);
		}
		return solve ;
	}
}
