package controleur;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Ecouteur.EcouteCharger;

import src.Grille;
import src.Observateur;

public class ControleurM {
	private int tailleGrille ;
	private Grille laGrille ;
	private Observateur observateur ;
	public enum Dificulty{
		FACILE,NORMAL,DIFFICILE
	}
	private Dificulty difficulte ;
	private ControleurVues ctrlVues ;
	private ControleurR ctrlRegl;
	private boolean gameStart;
	private boolean tricheBouton = false ;
	private boolean aideTrouver = false ;
	private int batAideTrouver ;
	private boolean aideErreur = false ;
	private boolean finJeu = false ;
	private int nbBatConstruit = 0 ;
	private boolean debugMode ;
	private Integer[][] aideGrilleErreur ;
	
	/**
	 * constructeur par défaut du controleur Maître
	 * initialise quelques variables.
	 */
	public ControleurM(boolean pDebugMode){
		//initialisation des attribues du controleur
		gameStart = false ;
		laGrille = null ;
		observateur = null ;
		difficulte = Dificulty.FACILE ;
		tailleGrille = 0 ;
		debugMode = pDebugMode ;
		//initialisation des controleurs
		ctrlRegl = new ControleurR(this) ;
		ctrlVues = new ControleurVues(this) ;
	}
	
	/**
	 * méthode d'initialisation de partie.
	 * @param pTaille	     taille de la grille souhaité 
	 * @param pDifficulte	 dificulté de la grille 
	 */
	public void commencerPartie(int pTaille, Dificulty pDifficulte){
		System.out.println("-> appel commencerPartie : taille de la grille:"+pTaille);
		tailleGrille = pTaille ;
		difficulte = pDifficulte ;
		gameStart = true ;
		finJeu = false ;
		nbBatConstruit = 0 ;
		
		initialisationGeneration(pTaille,pDifficulte) ;
		nbBatConstruit = 0 ;
		laGrille = new Grille(this, pTaille) ;
	}
	
	public void commencerPartie(int pTaille, Dificulty pDifficulte, Observateur pObs, Integer[][] grilleErreur){
		tailleGrille = pTaille ;
		difficulte = pDifficulte ;
		gameStart = true ;
		finJeu = false ;
		observateur = pObs ;
		laGrille = new Grille(this,tailleGrille) ;
		aideGrilleErreur = grilleErreur ;	
	}
	
	public void initialisationGeneration(int pTailleGrille, Dificulty pDifficulte){
		tailleGrille = pTailleGrille ;
		difficulte = pDifficulte ;
		
		boolean start = false ;
		//construction aléatoire d'une grille.
		do{
			generateGrille() ;
			generateObserver() ;
			nbBatConstruit = 0 ;
			laGrille = new Grille(this,tailleGrille) ;
			ctrlRegl = new ControleurR(this) ;
			if(pDifficulte==Dificulty.FACILE){
				start = ctrlRegl.applyRegleFACIL() ;
			}
			if(pDifficulte==Dificulty.NORMAL){
				start = ctrlRegl.applyRegleNORMAL() ;
			}
			if(pDifficulte==Dificulty.DIFFICILE){
				start = ctrlRegl.applyRegle() ;
			}	
		}while(!start) ;
		
		// ici on a une grille valide, il ne nou reste plus qu'a suprimer des observateurs.
//		// tout en vérifiant que la grille reste résoluble
		if(pDifficulte==Dificulty.DIFFICILE){
			Observateur obsswitch = new Observateur(observateur,pTailleGrille) ;
			for(int i=(int)(Math.random()*10); i<10; i++){
				// calcule d'un observateur à supprimer
				int cardinal = (int)(Math.random()*4) ;
				int position = (int)(Math.random()*tailleGrille) ;
				observateur.setObservateur(cardinal,position,0);
				// réinitialisation de la grille et de la variable comptant les batiments
				laGrille = new Grille(this,tailleGrille) ;
				nbBatConstruit = 0 ;
				// initialisation d'un nouveau controleur de regle
				ctrlRegl = new ControleurR(this) ;
				
				// si la grille est solvable on sauvegarde alors la nouvelle grille dans obsswitch
				// sinon on revient à la précédente grille.
				if(ctrlRegl.applyRegle())
					obsswitch = new Observateur(observateur,tailleGrille) ;
				else
					observateur = new Observateur(obsswitch,tailleGrille) ;
			}
			// au final par précaution (inutile) on recharge la grille switch 
			observateur = new Observateur(obsswitch,tailleGrille) ;
		}
		
		if(pDifficulte==Dificulty.NORMAL){
			Observateur obsswitch = new Observateur(observateur,pTailleGrille) ;
			for(int i=(int)(Math.random()*tailleGrille*3); i<tailleGrille*3; i++){
				// calcule d'un observateur à supprimer
				int cardinal = (int)(Math.random()*4) ;
				int position = (int)(Math.random()*tailleGrille) ;
				observateur.setObservateur(cardinal,position,0);
				// réinitialisation de la grille et de la variable comptant les batiments
				laGrille = new Grille(this,tailleGrille) ;
				nbBatConstruit = 0 ;
				// initialisation d'un nouveau controleur de regle
				ctrlRegl = new ControleurR(this) ;
				
				// si la grille est solvable on sauvegarde alors la nouvelle grille dans obsswitch
				// sinon on revient à la précédente grille.
				if(ctrlRegl.applyRegleNORMAL())
					obsswitch = new Observateur(observateur,tailleGrille) ;
				else
					observateur = new Observateur(obsswitch,tailleGrille) ;
			}
			// au final par précaution (inutile) on recharge la grille switch 
			observateur = new Observateur(obsswitch,tailleGrille) ;
		}
		
		if(pDifficulte==Dificulty.FACILE){
			Observateur obsswitch = new Observateur(observateur,pTailleGrille) ;
			for(int i=(int)(Math.random()*tailleGrille*3); i<tailleGrille*3; i++){
				// calcule d'un observateur à supprimer
				int cardinal = (int)(Math.random()*4) ;
				int position = (int)(Math.random()*tailleGrille) ;
				observateur.setObservateur(cardinal,position,0);
				// réinitialisation de la grille et de la variable comptant les batiments
				laGrille = new Grille(this,tailleGrille) ;
				nbBatConstruit = 0 ;
				// initialisation d'un nouveau controleur de regle
				ctrlRegl = new ControleurR(this) ;
				
				// si la grille est solvable on sauvegarde alors la nouvelle grille dans obsswitch
				// sinon on revient à la précédente grille.
				if(ctrlRegl.applyRegleFACIL())
					obsswitch = new Observateur(observateur,tailleGrille) ;
				else
					observateur = new Observateur(obsswitch,tailleGrille) ;
			}
			// au final par précaution (inutile) on recharge la grille switch 
			observateur = new Observateur(obsswitch,tailleGrille) ;
		}
		ctrlRegl = new ControleurR(this) ;
		ctrlRegl.applyRegle() ;
		aideGrilleErreur = generateGrilleErreur(laGrille) ;
		finJeu = false ;
		gameStart = true ;
		ctrlVues.switchPanel(ctrlVues.getPanelJeu()) ;
	}
	
	/**
	 * Génère la grille erreur a partir d'une grille.
	 */
	public Integer[][] generateGrilleErreur(Grille pGrille){
		int taille = pGrille.getTailleGrille() ;
		Integer[][] grilleTemp = new Integer[taille][taille];
		for(int i=0;i<taille;i++){
			for(int j=0;j<taille;j++){
				grilleTemp[i][j] = pGrille.getCase(i+1,j+1).getBatiment() ; 
			}
		}
		return grilleTemp ;
	}
	
	/**
	 * Genere une grille de façon aléatoire.
	 */
	private void generateGrille(){
		boolean generateSucces ;
		do{
			laGrille = new Grille(this, tailleGrille) ;
			generateSucces = true ;
			for(int nbBatRestant=tailleGrille; nbBatRestant>0 && generateSucces; nbBatRestant--){
				for(int nbTypeBatRestant=tailleGrille; nbTypeBatRestant>0 && generateSucces; nbTypeBatRestant--){
					int abscisse ;
					int ordonnee ;
					int nbTentative = 0 ;
					do{
						abscisse = (int)(Math.random()*tailleGrille+1) ;
						ordonnee = (int)(Math.random()*tailleGrille+1) ;
						nbTentative++ ;
						if(nbTentative>100)
							generateSucces = false ;
					}while(!laGrille.construire(abscisse,ordonnee, nbBatRestant) && generateSucces) ;
				}
			}
		}while(!generateSucces) ;
	}
	
	/**
	 * contruit les observateurs en comptant le nombre de batiment qu'ils voient
	 */
	private void generateObserver(){
		int[][] obsSee = new int[4][tailleGrille] ;
		int nbBatSee ;
		int tailleMaxSee ;
		int tempbat ;
		boolean finis ;
		
		// Observateur NORD
		for(int abscisse=1;abscisse<=tailleGrille;abscisse++){
			nbBatSee = 0 ;
			tailleMaxSee = 0 ;
			finis = false ;
			for(int ordonnee=1; ordonnee<=tailleGrille && !finis; ordonnee++){
				tempbat = laGrille.getCase(abscisse,ordonnee).getBatiment() ;
				if(tempbat==tailleGrille){
					obsSee[Observateur.NORD][abscisse-1] = nbBatSee+1 ;
					finis = true ;
				}
				else{
					if(tailleMaxSee < tempbat){
						nbBatSee++ ;
						tailleMaxSee = tempbat ;
					}
				}
			}
		}
		// Observateur SUD
		for(int abscisse=1;abscisse<=tailleGrille;abscisse++){
			nbBatSee = 0 ;
			tailleMaxSee = 0 ;
			finis = false ;
			for(int ordonnee=tailleGrille; ordonnee>=1 && !finis; ordonnee--){
				tempbat = laGrille.getCase(abscisse,ordonnee).getBatiment() ;
				if(tempbat==tailleGrille){
					obsSee[Observateur.SUD][abscisse-1] = nbBatSee+1 ;
					finis = true ;
				}
				else{
					if(tailleMaxSee < tempbat){
						nbBatSee++ ;
						tailleMaxSee = tempbat ;
					}
				}
			}
		}
		// Observateur OUEST
		for(int ordonnee=1;ordonnee<=tailleGrille;ordonnee++){
			nbBatSee = 0 ;
			tailleMaxSee = 0 ;
			finis = false ;
			for(int abscisse=1; abscisse<=tailleGrille && !finis; abscisse++){
				tempbat = laGrille.getCase(abscisse,ordonnee).getBatiment() ;
				if(tempbat==tailleGrille){
					obsSee[Observateur.OUEST][ordonnee-1] = nbBatSee+1 ;
					finis = true ;
				}
				else{
					if(tailleMaxSee < tempbat){
						nbBatSee++ ;
						tailleMaxSee = tempbat ;
					}
				}
			}
		}
		// Observateur EST
		for(int ordonnee=1;ordonnee<=tailleGrille;ordonnee++){
			nbBatSee = 0 ;
			tailleMaxSee = 0 ;
			finis = false ;
			for(int abscisse=tailleGrille; abscisse>=1 && !finis; abscisse--){
				tempbat = laGrille.getCase(abscisse,ordonnee).getBatiment() ;
				if(tempbat==tailleGrille){
					obsSee[Observateur.EST][ordonnee-1] = nbBatSee+1 ;
					finis = true ;
				}
				else{
					if(tailleMaxSee < tempbat){
						nbBatSee++ ;
						tailleMaxSee = tempbat ;
					}
				}
			}
		}
		observateur = new Observateur(obsSee) ;
	}
	
	
	public void finirPartie(){
		laGrille = null ;
		observateur = null ;
		ctrlVues.reinitialisePanelGrilleDeJeu();
		ctrlVues.reinitialisePanelJeu() ;
		gameStart = false ;
		aideErreur = false ;
		aideTrouver = false ;
		tricheBouton = false ;
		batAideTrouver = 0 ;
		nbBatConstruit = 0 ;
		ctrlVues.getVuePrincipal().refreshMenu() ;
	}
	
	public void addBatConstruit(){
		resetBatConstruit() ;
		for(int abs=1;abs<=tailleGrille;abs++){
			for(int ord=1; ord<=tailleGrille; ord++){
				if(laGrille.getCase(abs,ord).getBatiment()!=0)
					nbBatConstruit++ ;
			}
		}
	}
	
	public int getBatConstruit(){
		return nbBatConstruit ;
	}
	
	public void resetBatConstruit(){
		nbBatConstruit = 0 ;
	}
	
	public boolean isFinGame(){
		System.out.println("nombre de batiment construit"+nbBatConstruit);
		return (nbBatConstruit == (tailleGrille*tailleGrille)) ;
	}
	
	//******* Résolution de la Grille ********/
	public void resolve(){
		ctrlRegl = new ControleurR(this) ;
		ctrlRegl.applyRegle() ;
	}
	
	public void resolvePossibiliter(){
		ctrlRegl = new ControleurR(this) ;
		ctrlRegl.applyReglePossibilite() ;
	}
	
	public void resolveSansErreur(){
		for(int i=0; i<tailleGrille; i++){
			for(int j=0; j<tailleGrille; j++){
				laGrille.construireFORCE(i+1,j+1,aideGrilleErreur[i][j]) ;
			}
		}
	}
	
	//******* Gestion des booleen de triche ******/
	public void gestionTriche(String pLabelTriche){
		if(pLabelTriche.equals("tricheBouton")){
			tricheBouton = !tricheBouton ;
			aideTrouver = false ;
			aideErreur = false ;
		}
		if(pLabelTriche.equals("aideTrouver")){
			aideTrouver = !aideTrouver ;
			tricheBouton = false ;
			aideErreur = false ;
			ctrlRegl = new ControleurR(this) ;
			ctrlRegl.applyReglePossibilite() ;
			ctrlVues.refreshGrilleDeJeu() ;
		}
		if(pLabelTriche.equals("aideErreur")){
			aideErreur = !aideErreur ;
			aideTrouver = false ;
			tricheBouton = false ;
			ctrlVues.refreshGrilleDeJeu() ;
//			for(int i=1;i<=tailleGrille;i++){
//				for(int j=1;j<=tailleGrille;j++){
//					System.out.print(getAideGrilleErreur(j,i)) ;
//				}
//				System.out.println();
//			}
		}
		ctrlVues.getPanelJeu().getPanelVisuel().setVisible(ctrlVues.getCtrlM().isAideTrouver()) ;
		ctrlVues.getPanelJeu().getJbTricher().setVisible(ctrlVues.getCtrlM().isTricheBouton()) ;
		ctrlVues.refreshGrilleDeJeu() ;
	}
	
	//*********** Accesseur *************/
	public Grille getLaGrille() {
		return laGrille;
	}

	public int getTailleGrille() {
		return tailleGrille;
	}
	
	public ControleurVues getCtrlVues() {
		return ctrlVues ;
	}
	
	public boolean GetGameStart(){
		return gameStart ;
	}

	public boolean isTricheBouton() {
		return tricheBouton;
	}
	
	public boolean isAideTrouver(){
		return aideTrouver ;
	}
	
	public boolean isAideErreur(){
		return aideErreur ;
	}

	public int getThisObs(int pCardinal,int pPosition){
		return observateur.getObservateur(pCardinal, pPosition) ;
	}
	
	public Observateur getObservateur() {
		return observateur;
	}
	
	public int getBatAideTrouver() {
		return batAideTrouver;
	}
	
	public Dificulty getDifficulte() {
		return difficulte;
	}
	
	public Integer[][] getAideGrilleErreur() {
		return aideGrilleErreur ;
	}

	public int getAideGrilleErreur(int pAbscisse,int pOrdonnee) {
		return (int)(aideGrilleErreur[pAbscisse-1][pOrdonnee-1]);
	}
	
	//*********** Setters *************/
	public void setLaGrille(Grille laGrille) {
		this.laGrille = laGrille;
	}
	
	public void setBatAideTrouver(int batAideTrouver) {
		this.batAideTrouver = batAideTrouver;
	}
	
	public void setTailleGrille(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}

	public void setObservateur(Observateur observateur) {
		this.observateur = observateur;
	}

	public void setDifficulte(Dificulty difficulte) {
		this.difficulte = difficulte;
	}

	public void setAideGrilleErreur(Integer[][] aideGrilleErreur) {
		this.aideGrilleErreur = aideGrilleErreur;
	}
	
	//*************** GESTION DE FICHIER ****************** 
	public void sauvegarderGrille (String nomFichier,Grille pGrille,Observateur pObs,int pTaille)
	{
		try 
		{
			System.out.println(getPath()+"\\"+nomFichier);
		    FileOutputStream fichierP = new FileOutputStream(getPath()+"\\"+nomFichier);
		    ObjectOutputStream fichierV = new ObjectOutputStream(fichierP);
		    
		    Integer grille[][] = new Integer[pTaille][pTaille];
		    Integer observateurs[][] = new Integer[4][pTaille];
		    
		    for(int i = 0 ; i < pTaille ; i++)
		    	for(int j = 0; j < pTaille ; j++)
		    		grille[i][j] = pGrille.getCase(i+1, j+1).getBatiment();    
		    for(int i = 0; i < 4 ; i++)
		    	for(int j = 0; j < pTaille ; j++)
		    		observateurs[i][j] = pObs.getObservateur(i, j+1);
		    
		    System.out.println("Sauvegarde dans : "+nomFichier);
		    System.out.print("GRILLE");
		    for(int i=0; i<pTaille*2-6; i++)
		    	System.out.print(" ");
		    System.out.println("| OBS");
		    for(int i= 0; i < pTaille; i++){
		    	//grille
		    	for(int j = 0; j < pTaille ;j++)
		    		System.out.print(grille[i][j]+" ");
		    	//observateur
		    	System.out.print("| ");
		    	if(i<4)
			    	for(int j = 0; j < pTaille ;j++)
			    		System.out.print(observateurs[i][j]+" ");
		    	System.out.println();
			}
		    
		    fichierV.writeObject(grille);
		    fichierV.writeObject(observateurs);
		    fichierP.close() ;
		    fichierV.close() ;
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Vous ne pouvez pas enregistrer avec ce nom de fichier.");
		}
		
	}
	
	public Vector<Integer[][]> chargerGrille(String nomFichier)
	{
		try 
		{
		    FileInputStream fichierP = new FileInputStream(getPath()+"\\"+nomFichier);
		    ObjectInputStream fichierV = new ObjectInputStream(fichierP);
		    
		    Integer grille[][] = (Integer[][])fichierV.readObject();
		    Integer observateurs[][] = (Integer[][])fichierV.readObject();
		    
		    Vector<Integer[][]>  monV = new Vector<Integer[][]>();
		    monV.add(grille);
		    monV.add(observateurs);
		    
		    System.out.println("Chargement de : "+nomFichier);
		    System.out.print("GRILLE");
		    int pTaille = grille.length ;
		    for(int i=0; i<pTaille*2-6; i++)
		    	System.out.print(" ");
		    System.out.println("| OBS");
		    for(int i= 0; i < pTaille; i++){
		    	//grille
		    	for(int j = 0; j < pTaille ;j++)
		    		System.out.print(grille[i][j]+" ");
		    	//observateur
		    	System.out.print("| ");
		    	if(i<4)
			    	for(int j = 0; j < pTaille ;j++)
			    		System.out.print(observateurs[i][j]+" ");
		    	System.out.println();
			}		    

		    fichierP.close();
		    fichierV.close();
		    return monV;
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Le fichier n'a pas été trouvé.");
			//laGrille = new Grille();
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Ce fichier est inutilisable.");
		} 
		catch (ClassNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "Ce fichier contient des classes non connus.");
		}
		return null;
	}
	
	public String getPath(){
		File temp = new File(".") ;
		try {
			return temp.getCanonicalPath()+"\\sauvegardes" ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERREUR GET PATH");
			e.printStackTrace();
		}
		return null;
	}
	
	//DEBUGAGE
	/**
	 * méthode qui permet de renvoyer un string du contenu du vecteur de possibilité
	 * utiliser en Debugage des règles
	 * @param vector d'integer
	 * @return contenu du vecteur
	 */
	public String vecpo( final Vector<Integer> pt){
		String ret = "None" ;
		if (pt.size()!=0){
			ret = "";
			for(int i=0; i<pt.size(); i++)
				ret = ret + pt.elementAt(i) + "," ;
		}
		return ret;
	}

	public boolean isDebugMode() {
		return debugMode;
	}
	
	// CHARGEMENT ALEATOIRE D'UNE PARTIE

	//	String[] listeFichiersTemp,listeFichiers;
	//	File repertoire = new File(getPath());
	//	listeFichiersTemp = repertoire.list();
	//			
	//	int nbelemMax = listeFichiersTemp.length;
	//	int nbelem = 0 ;
	//	for(int i=0;i<nbelemMax;i++){
	//		if(listeFichiersTemp[i].endsWith(".grille")){
	//			nbelem++;
	//		}
	//	}
	//	listeFichiers = new String[nbelem] ;
	//	nbelem = 0 ;
	//	for(int i=0;i<nbelemMax;i++){
	//		if(listeFichiersTemp[i].endsWith(".grille")){
	//			listeFichiers[nbelem] = listeFichiersTemp[i] ;
	//			nbelem++;
	//		}
	//	}
	//	int random = (int)(Math.random()*nbelem) ;
	//	
	//	Vector<Integer[][]> temp = new Vector<Integer[][]>() ;
	//	temp = chargerGrille(listeFichiers[random]) ;
	//	
	//	tailleGrille = temp.elementAt(0).length ;
	//	observateur = new Observateur(temp.elementAt(1),tailleGrille) ;
	//	aideGrilleErreur = temp.elementAt(0) ;
}
