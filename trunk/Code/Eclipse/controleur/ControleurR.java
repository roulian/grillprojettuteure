package controleur;

import java.util.Vector;
import regleResolutionLogic.*;
import src.Grille;
import src.Observateur;
/**
 *le controleurR permet de résoudre une grille de jeu 
 * @author Andres Gomez Thomas
 *
 */
public class ControleurR {
	private ControleurM ctrlM ;
	private Grille grille ;
	private Observateur observateur ;
	private int tailleGrille ;
	
	// les règles logique de résolution ;
	private Vector<Regle> tabRegle ;
	private Vector<Regle> tabReglePossibilite ;
	private Vector<Regle> tabRegleFACILE ;
	private Vector<Regle> tabRegleNORMAL ;
	
	/**
	 * constructeur par défaut de la classe
	 * @param pCtrlM
	 */
	public ControleurR(ControleurM pCtrlM){
		ctrlM = pCtrlM ;
		grille = ctrlM.getLaGrille() ;
		observateur = ctrlM.getObservateur();
		tailleGrille = ctrlM.getTailleGrille() ;
		initialise() ;
	}
	
	/**
	 * constructeur paramêtré de la classe
	 * @param pCtrlM
	 */
	public ControleurR(ControleurM pCtrlM,Grille pGrille,int pTailleGrille,Observateur pObs){
		ctrlM = pCtrlM ;
		grille = pGrille ;
		observateur = pObs ;
		tailleGrille = pTailleGrille ;
		initialise() ;
	}
	
	/**
	 * méthode d'initialisation de la classe, est appellé par défaut par les constructeurs
	 */
	public void initialise(){
		//définition des regles logiques de résolution dans le tableau de regle
		tabRegle = new Vector<Regle>() ;
		tabReglePossibilite = new Vector<Regle>() ;
		tabRegleFACILE = new Vector<Regle>() ;
		tabRegleNORMAL = new Vector<Regle>() ;
		
		//Regles de contruction
		tabRegle.add(new Regle_Observateur1(this)) ;			// TESTER
		tabRegle.add(new Regle_DernierVecBat(this)) ;			// TESTER
		tabRegle.add(new Regle_DernierTypBat(this)) ;			// TESTER
		tabRegle.add(new Regle_Obs2etTailleGrille1(this)) ;		// TESTER
		tabRegle.add(new Regle_Obs2ConstruitN1(this)) ;			// TESTER
		//Regles de possibilité
		tabRegle.add(new Regle_DistanceMin(this)) ;				// TESTER
		tabRegle.add(new Regle_MinTaille(this)) ;				// TESTER
		tabRegle.add(new Regle_ImpoMax(this)) ;					// TESTER
		tabRegle.add(new Regle_Pioupiou(this)) ;				// TESTER
		tabRegle.add(new Regle_ObsVoitNmoins1(this)) ;			// TESTER
		
		// regle des possibilités
		tabReglePossibilite.add(new Regle_DistanceMin(this)) ;
		tabReglePossibilite.add(new Regle_MinTaille(this)) ;
		tabReglePossibilite.add(new Regle_ImpoMax(this)) ;
		tabReglePossibilite.add(new Regle_Pioupiou(this)) ;
		tabReglePossibilite.add(new Regle_ObsVoitNmoins1(this)) ;
		
		// regle facile
		tabRegleFACILE.add(new Regle_DistanceMin(this)) ;
		tabRegleFACILE.add(new Regle_Observateur1(this)) ;
		tabRegleFACILE.add(new Regle_DernierVecBat(this)) ;
		tabRegleFACILE.add(new Regle_DernierTypBat(this)) ;
		tabRegleFACILE.add(new Regle_Obs2etTailleGrille1(this)) ;
		tabRegleFACILE.add(new Regle_Obs2ConstruitN1(this)) ;
		// regle normal
		tabRegleNORMAL.add(new Regle_DistanceMin(this)) ;
		tabRegleNORMAL.add(new Regle_MinTaille(this)) ;
		tabRegleNORMAL.add(new Regle_ImpoMax(this)) ;
		tabRegleNORMAL.add(new Regle_ObsVoitNmoins1(this)) ;
		tabRegleNORMAL.add(new Regle_Observateur1(this)) ;
		tabRegleNORMAL.add(new Regle_DernierVecBat(this)) ;
		tabRegleNORMAL.add(new Regle_DernierTypBat(this)) ;
		tabRegleNORMAL.add(new Regle_Obs2etTailleGrille1(this)) ;
		tabRegleNORMAL.add(new Regle_Obs2ConstruitN1(this)) ;
	}
	
	/**
	 * méthode de résolution standart des grilles (difficile).
	 * @return {@link boolean}
	 */
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
		return ctrlM.getBatConstruit()==tailleGrille*tailleGrille ;
	}
	
	/**
	 * méthode de résolution des possibilités des grilles.
	 * @return {@link boolean}
	 */
	public boolean applyReglePossibilite(){
		System.out.println("--> DEBUT DE RESTRICTION DE LA GRILLE <--");
		int nbRegle = tabReglePossibilite.size();
		boolean solve = true ;
		boolean temp ;

		while(solve==true){
			solve = false ;
			for (int i=0; i <nbRegle; i++){
				System.out.println("--> "+tabReglePossibilite.elementAt(i).getClass());
				temp = tabReglePossibilite.elementAt(i).resolve() ;
				solve = solve || temp ;
				System.out.println("<-- RETOUR - solve: "+temp);
			}
			System.out.println("boucle résolution CONTROLEUR RESTRICTION : solve: "+solve);
		}
		System.out.print("--> FIN DE RESTRICTION DE LA GRILLE <--");
		
		return solve ;
	}
	
	/**
	 * méthode de résolution des grilles (facile).
	 * @return {@link boolean}
	 */
	public boolean applyRegleFACIL(){
		int nbRegle = tabRegleFACILE.size();
		boolean solve = true ;
		boolean temp ;
		while(solve==true){
			solve = false ;
			for (int i=0; i <nbRegle; i++){
				temp = tabRegleFACILE.elementAt(i).resolve() ;
				solve = solve || temp ;
			}
		}
		System.out.println(this.getClass()+" "+(ctrlM.getBatConstruit()==tailleGrille*tailleGrille));
		return ctrlM.getBatConstruit()==tailleGrille*tailleGrille ;
	}
	
	/**
	 * méthode de résolution des grilles (normal).
	 * @return {@link boolean}
	 */
	public boolean applyRegleNORMAL(){
		int nbRegle = tabRegleNORMAL.size();
		boolean solve = true ;
		boolean temp ;
		while(solve==true){
			solve = false ;
			for (int i=0; i <nbRegle; i++){
				temp = tabRegleNORMAL.elementAt(i).resolve() ;
				solve = solve || temp ;
			}
		}
		System.out.println(this.getClass()+" "+(ctrlM.getBatConstruit()==tailleGrille*tailleGrille));
		return ctrlM.getBatConstruit()==tailleGrille*tailleGrille ;
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

	public int getTailleGrille() {
		return tailleGrille;
	}
}
