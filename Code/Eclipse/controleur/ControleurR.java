package controleur;

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
		
		//définition des regles logiques de résolution dans le tableau de regle
		tabRegle = new Vector<Regle>() ;
		tabRegle.add(new Regle1(this)) ;
		tabRegle.add(new Regle2(this)) ;
		tabRegle.add(new Regle3(this)) ;
		tabRegle.add(new Regle4(this)) ;
		tabRegle.add(new Regle5(this)) ; 
	}
	
	// méthode de résolution des grilles.
	public void applyRegle(){
		int nbRegle = tabRegle.size();
		for (int i=0; i <nbRegle; i++)
			tabRegle.elementAt(i).resolve() ;
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
