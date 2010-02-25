package controleur;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.Vector;

import regleResolutionLogic.*;
import src.Grille;
import src.Observateur;

public class ControleurR {
	private ControleurM ctrlM ;
	private Grille grille ;
	private Observateur observateur ;
	
	// les règles logique de résolution ;
	private Vector<Regle> tabRegle ;
	
	public ControleurR(ControleurM pCtrlM){
		ctrlM = pCtrlM ;
		grille = ctrlM.getLaGrille() ;
		observateur = ctrlM.getObservateur();
		initialise() ;
	}
	
	public ControleurR(ControleurM pCtrlM,Grille pGrille,Observateur pObs){
		ctrlM = pCtrlM ;
		grille = pGrille ;
		observateur = pObs ;
		initialise() ;
	}
	
	public void initialise(){
		//définition des regles logiques de résolution dans le tableau de regle
		tabRegle = new Vector<Regle>() ;
		//regle "d'optimisation".
		tabRegle.add(new Regle6(this)) ;
		tabRegle.add(new Regle7(this)) ; 
		tabRegle.add(new Regle8(this)) ;
		//regle normal
		tabRegle.add(new Regle_Observateur1(this)) ;
		tabRegle.add(new Regle_DernierVecBat(this)) ;
		tabRegle.add(new Regle_DernierTypBat(this)) ;
		tabRegle.add(new Regle_ObsDoitVoir(this)) ;
		tabRegle.add(new Regle_DistanceMin(this)) ;
	}
	
	// méthode de résolution des grilles.
	public void applyRegle(){
		System.out.println("--> DEBUT DE RESOLUTION DE LA GRILLE <--");
		int nbRegle = tabRegle.size();
		boolean solve = true ;
		boolean temp ;
		while(solve==true){
			solve = false ;
			for (int i=0; i <nbRegle; i++){
				temp = tabRegle.elementAt(i).resolve() ;
				solve = solve || temp ;
				System.out.println("- "+tabRegle.elementAt(i).getClass()+" - solve "+temp);
			}
			System.out.println("boucle résolution : solve "+solve);
		}
		System.out.println("--> FIN DE RESOLUTION DE LA GRILLE <--");
	}
	
	
	//***********	Accessur ***********//
	public ControleurM getCtrlM() {
		return ctrlM;
	}

	public Grille getGrille() {
		return grille;
	}

	public Observateur getObservateur() {
		return observateur;
	}
	
	
}
