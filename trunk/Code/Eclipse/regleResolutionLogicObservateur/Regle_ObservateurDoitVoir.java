package regleResolutionLogicObservateur;

import java.util.Vector;

import controleur.ControleurR;
import regleResolutionLogic.Regle;


public class Regle_ObservateurDoitVoir implements Regle{
//	private ControleurR ctrlR ;
//	private Grille grille ;
//	private Observateur observateur ;
	private Vector<Regle> tabRegle ;
		
	public Regle_ObservateurDoitVoir(ControleurR pCtrlR, int pTailleGrille){
//		ctrlR = pCtrlR ;
//		grille = pCtrlR.getGrille() ;
//		observateur = pCtrlR.getObservateur() ;
		tabRegle = new Vector<Regle>() ;
		
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
		boolean resolveBool = false ;
		while(solve==true){
			solve = false ;
			for (int i=0; i <nbRegle; i++){
				temp = tabRegle.elementAt(i).resolve() ;
				solve = solve || temp ;
				System.out.println("- "+tabRegle.elementAt(i).getClass()+" - solve "+temp);
			}
			resolveBool = resolveBool || solve ;
		}
		return resolveBool;
	}
}
