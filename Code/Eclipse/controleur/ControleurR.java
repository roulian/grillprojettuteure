package controleur;

import java.util.Vector;
import regleResolutionLogic.*;
import regleResolutionLogicObservateur.*;
import src.Grille;
import src.Observateur;

public class ControleurR {
	private ControleurM ctrlM ;
	private Grille grille ;
	private Observateur observateur ;
	private int tailleGrille ;
	
	// les règles logique de résolution ;
	private Vector<Regle> tabRegle ;
	
	public ControleurR(ControleurM pCtrlM){
		ctrlM = pCtrlM ;
		grille = ctrlM.getLaGrille() ;
		observateur = ctrlM.getObservateur();
		tailleGrille = ctrlM.getTailleGrille() ;
		initialise() ;
	}
	
	public ControleurR(ControleurM pCtrlM,Grille pGrille,int pTailleGrille,Observateur pObs){
		ctrlM = pCtrlM ;
		grille = pGrille ;
		observateur = pObs ;
		tailleGrille = pTailleGrille ;
		initialise() ;
	}
	
	public void initialise(){
		//définition des regles logiques de résolution dans le tableau de regle
		tabRegle = new Vector<Regle>() ;

		//regle "d'optimisation".
//		tabRegle.add(new Regle6(this)) ;
//		tabRegle.add(new Regle_Obs2etTailleGrille1(this)) ; 
//		tabRegle.add(new Regle8(this)) ;

		//regle normal
		tabRegle.add(new Regle_Observateur1(this)) ;
		tabRegle.add(new Regle_DernierVecBat(this)) ;
		tabRegle.add(new Regle_DernierTypBat(this)) ;
		tabRegle.add(new Regle_DistanceMin(this)) ;

		//regle deuxieme génération
		tabRegle.add(new Regle_MinTaille(this)) ;			// TESTER
//		tabRegle.add(new Regle_ObsVoit_N_1(pCtrlR)) ;		// foireuse !!!!!!
		tabRegle.add(new Regle_ImpoMax(this)) ;				// TESTER

		//regle basé sur une taille particuliere de grille
		tabRegle.add(new Regle_ObservateurDoitVoir(this,tailleGrille)) ;
	}
	
	// méthode de résolution des grilles.
	public boolean applyRegle(){
		System.out.println("--> DEBUT DE RESOLUTION DE LA GRILLE <--");
		int nbRegle = tabRegle.size();
		boolean solve = true ;
		boolean temp ;
		int total = ctrlM.getTailleGrille() * ctrlM.getTailleGrille() ;
		while(solve==true && ctrlM.getBatConstruit()!=total){
			solve = false ;
			for (int i=0; i <nbRegle; i++){
				System.out.println("--> "+tabRegle.elementAt(i).getClass());
				temp = tabRegle.elementAt(i).resolve() ;
				solve = solve || temp ;
				System.out.println("<-- RETOUR - solve "+temp);
			}
			System.out.println("boucle résolution CONTROLEURR : solve "+solve);
		}
		System.out.print("--> FIN DE RESOLUTION DE LA GRILLE <--");
		if(solve)
			System.out.println(" RESOLUE");
		else
			System.out.println(" probleme rencontré lors de la résolution...");
		return solve ;
	}
	
	public void applyRegle(Grille pGrille,Observateur pObservateur){
		Regle_DistanceMin pRegle = new Regle_DistanceMin(this) ;
		pRegle.resolve(pGrille,pObservateur) ;
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
