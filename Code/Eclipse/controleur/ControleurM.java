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
	private int difficulte ;
	private ControleurVues ctrlVues ;
	private ControleurR ctrlRegl;
	private boolean gameStart;
	private boolean tricheBouton = false ;
	private boolean aideTrouver = false ;
	private int batAideTrouver ;
	private boolean aideErreur = false ;
	/**
	 * 
	 */
	private Integer[][] aideGrilleErreur ;
	
	/**
	 * constructeur par défaut du controleur Maître
	 * initialise quelques variables.
	 */
	public ControleurM(){
		gameStart = false ;
		laGrille = null ;
		observateur = null ;
		difficulte = 0 ;
		tailleGrille = 0 ;
		ctrlVues = new ControleurVues(this) ;
	}
	
	/**
	 * méthode d'initialisation de partie.
	 * @param pTaille	     taille de la grille souhaité 
	 * @param pDifficulte	 dificulté de la grille 
	 */
	public void commencerPartie(int pTaille, int pDifficulte){
		System.out.println("-> appel commencerPartie : taille de la grille:"+pTaille);
		tailleGrille = pTaille ;
		difficulte = pDifficulte ;
		gameStart = true ;
		observateur = new Observateur(tailleGrille) ;
		laGrille = new Grille(tailleGrille) ;
		
		String[] listeFichiersTemp,listeFichiers;
		File repertoire = new File(getPath());
		listeFichiersTemp = repertoire.list();
				
		int nbelemMax = listeFichiersTemp.length;
		int nbelem = 0 ;
		for(int i=0;i<nbelemMax;i++){
			if(listeFichiersTemp[i].endsWith(".grille")){
				nbelem++;
			}
		}
		listeFichiers = new String[nbelem] ;
		nbelem = 0 ;
		for(int i=0;i<nbelemMax;i++){
			if(listeFichiersTemp[i].endsWith(".grille")){
				listeFichiers[nbelem] = listeFichiersTemp[i] ;
				nbelem++;
			}
		}
		int random = (int)(Math.random()*nbelem) ;
		
		Vector<Integer[][]> temp = new Vector<Integer[][]>() ;
		temp = chargerGrille(listeFichiers[random]) ;
		
		tailleGrille = temp.elementAt(0).length ;
		observateur = new Observateur(temp.elementAt(1),tailleGrille) ;
		aideGrilleErreur = temp.elementAt(0) ;
		
		
		// le code ne sert qu'a tester
		//*********** GRILLE 4x4 *************//
//		tailleGrille = 4 ;
//		int[][] obsTemp = new int[4][4] ;
//		obsTemp[Observateur.NORD][0] = 2;
//		obsTemp[Observateur.NORD][1] = 3;
//		obsTemp[Observateur.NORD][2] = 1;
//		obsTemp[Observateur.NORD][3] = 2;
//		obsTemp[Observateur.EST][0] = 2;
//		obsTemp[Observateur.EST][1] = 3;
//		obsTemp[Observateur.EST][2] = 3;
//		obsTemp[Observateur.EST][3] = 1;
//		obsTemp[Observateur.SUD][0] = 2;
//		obsTemp[Observateur.SUD][1] = 2;
//		obsTemp[Observateur.SUD][2] = 3;
//		obsTemp[Observateur.SUD][3] = 1;
//		obsTemp[Observateur.OUEST][0] = 3;
//		obsTemp[Observateur.OUEST][1] = 1;
//		obsTemp[Observateur.OUEST][2] = 2;
//		obsTemp[Observateur.OUEST][3] = 2;
//		observateur = new Observateur(obsTemp);
		
//		tailleGrille = 4 ;
//		int[][] obsTemp = new int[4][4] ;
//		obsTemp[Observateur.NORD][0] = 0;
//		obsTemp[Observateur.NORD][1] = 3;
//		obsTemp[Observateur.NORD][2] = 0;
//		obsTemp[Observateur.NORD][3] = 0;
//		obsTemp[Observateur.EST][0] = 0;
//		obsTemp[Observateur.EST][1] = 0;
//		obsTemp[Observateur.EST][2] = 0;
//		obsTemp[Observateur.EST][3] = 0;
//		obsTemp[Observateur.SUD][0] = 0;
//		obsTemp[Observateur.SUD][1] = 0;
//		obsTemp[Observateur.SUD][2] = 0;
//		obsTemp[Observateur.SUD][3] = 1;
//		obsTemp[Observateur.OUEST][0] = 3;
//		obsTemp[Observateur.OUEST][1] = 0;
//		obsTemp[Observateur.OUEST][2] = 0;
//		obsTemp[Observateur.OUEST][3] = 2;
//		observateur = new Observateur(obsTemp);
		
//		tailleGrille = 4 ;
//		int[][] obsTemp = new int[4][4] ;
//		obsTemp[Observateur.NORD][0] = 1;
//		obsTemp[Observateur.NORD][1] = 2;
//		obsTemp[Observateur.NORD][2] = 2;
//		obsTemp[Observateur.NORD][3] = 2;
//		obsTemp[Observateur.EST][0] = 3;
//		obsTemp[Observateur.EST][1] = 3;
//		obsTemp[Observateur.EST][2] = 1;
//		obsTemp[Observateur.EST][3] = 2;
//		obsTemp[Observateur.SUD][0] = 4;
//		obsTemp[Observateur.SUD][1] = 3;
//		obsTemp[Observateur.SUD][2] = 1;
//		obsTemp[Observateur.SUD][3] = 2;
//		obsTemp[Observateur.OUEST][0] = 1;
//		obsTemp[Observateur.OUEST][1] = 2;
//		obsTemp[Observateur.OUEST][2] = 3;
//		obsTemp[Observateur.OUEST][3] = 3;
//		observateur = new Observateur(obsTemp); 
		
		//*********** GRILLE 5x5 *************//
//		tailleGrille = 5 ;
//		int[][] obsTemp = new int[5][5] ;
//		obsTemp[Observateur.NORD][0] = 5;
//		obsTemp[Observateur.NORD][1] = 0;
//		obsTemp[Observateur.NORD][2] = 3;
//		obsTemp[Observateur.NORD][3] = 1;
//		obsTemp[Observateur.NORD][4] = 0;
//		obsTemp[Observateur.EST][0] = 0;
//		obsTemp[Observateur.EST][1] = 0;
//		obsTemp[Observateur.EST][2] = 0;
//		obsTemp[Observateur.EST][3] = 0;
//		obsTemp[Observateur.EST][4] = 2;
//		obsTemp[Observateur.SUD][0] = 0;
//		obsTemp[Observateur.SUD][1] = 0;
//		obsTemp[Observateur.SUD][2] = 3;
//		obsTemp[Observateur.SUD][3] = 0;
//		obsTemp[Observateur.SUD][4] = 0;
//		obsTemp[Observateur.OUEST][0] = 0;
//		obsTemp[Observateur.OUEST][1] = 4;
//		obsTemp[Observateur.OUEST][2] = 0;
//		obsTemp[Observateur.OUEST][3] = 0;
//		obsTemp[Observateur.OUEST][4] = 0;
//		observateur = new Observateur(obsTemp);
		
		//*********** GRILLE 6x6 *************//
//		tailleGrille = 6 ;
//		int[][] obsTemp = new int[6][6] ;
//		obsTemp[Observateur.NORD][0] = 3;
//		obsTemp[Observateur.NORD][1] = 0;
//		obsTemp[Observateur.NORD][2] = 0;
//		obsTemp[Observateur.NORD][3] = 2;
//		obsTemp[Observateur.NORD][4] = 0;
//		obsTemp[Observateur.NORD][5] = 4;
//		obsTemp[Observateur.EST][0] = 3;
//		obsTemp[Observateur.EST][1] = 0;
//		obsTemp[Observateur.EST][2] = 2;
//		obsTemp[Observateur.EST][3] = 0;
//		obsTemp[Observateur.EST][4] = 5;
//		obsTemp[Observateur.EST][5] = 0;
//		obsTemp[Observateur.SUD][0] = 0;
//		obsTemp[Observateur.SUD][1] = 0;
//		obsTemp[Observateur.SUD][2] = 5;
//		obsTemp[Observateur.SUD][3] = 1;
//		obsTemp[Observateur.SUD][4] = 4;
//		obsTemp[Observateur.SUD][5] = 0;
//		obsTemp[Observateur.OUEST][0] = 3;
//		obsTemp[Observateur.OUEST][1] = 3;
//		obsTemp[Observateur.OUEST][2] = 0;
//		obsTemp[Observateur.OUEST][3] = 4;
//		obsTemp[Observateur.OUEST][4] = 0;
//		obsTemp[Observateur.OUEST][5] = 0;
//		observateur = new Observateur(obsTemp);
		
//		tailleGrille = 6 ;
//		int[][] obsTemp = new int[6][6] ;
//		obsTemp[Observateur.NORD][0] = 0;
//		obsTemp[Observateur.NORD][1] = 0;
//		obsTemp[Observateur.NORD][2] = 0;
//		obsTemp[Observateur.NORD][3] = 0;
//		obsTemp[Observateur.NORD][4] = 0;
//		obsTemp[Observateur.NORD][5] = 0;
//		obsTemp[Observateur.EST][0] = 0;
//		obsTemp[Observateur.EST][1] = 0;
//		obsTemp[Observateur.EST][2] = 0;
//		obsTemp[Observateur.EST][3] = 0;
//		obsTemp[Observateur.EST][4] = 0;
//		obsTemp[Observateur.EST][5] = 0;
//		obsTemp[Observateur.SUD][0] = 0;
//		obsTemp[Observateur.SUD][1] = 0;
//		obsTemp[Observateur.SUD][2] = 0;
//		obsTemp[Observateur.SUD][3] = 0;
//		obsTemp[Observateur.SUD][4] = 0;
//		obsTemp[Observateur.SUD][5] = 0;
//		obsTemp[Observateur.OUEST][0] = 1;
//		obsTemp[Observateur.OUEST][1] = 2;
//		obsTemp[Observateur.OUEST][2] = 3;
//		obsTemp[Observateur.OUEST][3] = 4;
//		obsTemp[Observateur.OUEST][4] = 5;
//		obsTemp[Observateur.OUEST][5] = 6;
//		observateur = new Observateur(obsTemp);
	}
	
	public void commencerPartie(int pTaille, int pDifficulte, Observateur pObs, Integer[][] grilleErreur){
		tailleGrille = pTaille ;
		difficulte = pDifficulte ;
		gameStart = true ;
		observateur = pObs ;
		laGrille = new Grille(tailleGrille) ;
		aideGrilleErreur = grilleErreur ;
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
		ctrlVues.getVuePrincipal().refreshMenu() ;
	}

	//******* Résolution de la Grille ********/
	public void resolve(){
		ctrlRegl = new ControleurR(this) ;
		ctrlRegl.applyRegle() ;
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
			ControleurR ctrlReglTemp = new ControleurR(this) ;
			ctrlReglTemp.applyRegle(laGrille, observateur) ;
			ctrlReglTemp = null ;
		}
		if(pLabelTriche.equals("aideErreur")){
			aideErreur = !aideErreur ;
			aideTrouver = false ;
			tricheBouton = false ;
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
	
	public int getDifficulte() {
		return difficulte;
	}

	public Integer[][] getAideGrilleErreur() {
		return aideGrilleErreur;
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

	public void setDifficulte(int difficulte) {
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
		    FileInputStream fichierP = new FileInputStream(nomFichier);
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
			return temp.getCanonicalPath() ;
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
			for(int i=0; i<pt.size(); i++)
				ret = ret + pt.elementAt(i) + "," ;
		}
		return ret;
	}
}
