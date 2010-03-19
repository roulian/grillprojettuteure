package regleResolutionLogic;

import java.util.Vector;

import javax.swing.text.StyledEditorKit.BoldAction;

import src.Grille;
import src.Observateur;
import controleur.ControleurR;

/**
 * La Regle permet de comparer les vecteurs de possibilités entre eux pour les simplifier si possible.
 * @author Andres Gomez Thomas
 * @see ControleurR
 */
public class Regle_Pioupiou implements Regle {
	private ControleurR ctrlR ;
	private Observateur observateur ;
	private Grille grille ;
	private int tailleGrille ;
	private enum Mode {
		LIGNE, COLONNE
	};
	
	/**
	 * constructeur par défaut
	 * @param pCtrlR
	 */
	public Regle_Pioupiou(ControleurR pCtrlR){
		ctrlR = pCtrlR ;
		observateur = ctrlR.getObservateur() ;
		grille = ctrlR.getGrille() ;
		tailleGrille = ctrlR.getTailleGrille();
	}

	/**
	 * construit les batiment dans l'ordre croisant depuis l'observateur lorsque ce dernier = taillegrille
	 * @return true si une midification a été faite, sinon false
	 */
	public boolean resolve() {
		boolean solve = false ;
		
		// parcourt des lignes
		// comparaisons 2à2 des case d'une ligne
		for(int ordonee=1;ordonee<=tailleGrille;ordonee++){
			Vector<Integer> temp1 ;
			Vector<Integer> temp2 ;
			for(int i=1; i<tailleGrille; i++){
				for(int j=i+1; j<=tailleGrille; j++){
					temp1 = grille.getCase(i,ordonee).getPossibilite();
					temp2 = grille.getCase(j,ordonee).getPossibilite();
					if(vecEqual(temp1,temp2)){
						// ici nous avons deux case qui on les meme vector de possibilité.
						if (temp1.size()==2){
							// on a deux fois les memes vecteurs de taille 2, Pioupiou s'applique donc.
							boolean[] tempIndex = new boolean[tailleGrille+1] ;
							tempIndex[0] = false ;
							for(int tempX=1; tempX<=tailleGrille; tempX++)
								tempIndex[tempX] = true ;
							tempIndex[i] = false ;
							tempIndex[j] = false ;
							solve = solve || pioupiou(Mode.LIGNE, ordonee, tempIndex, temp1) ;
						}
						else{
							// les vecteurs ne sont pas de tailles 2, on doit donc trouver au moins une autre case.
							Vector<Integer> temp3 ;
							for(int k=j+1; k<=tailleGrille; k++){
								temp3 = grille.getCase(k,ordonee).getPossibilite();
								if(vecEqual(temp2,temp3)){
									if (temp1.size()==3){
										// on a trois fois les memes vecteurs de taille 3, Pioupiou s'applique donc.
										boolean[] tempIndex = new boolean[tailleGrille+1] ;
										tempIndex[0] = false ;
										for(int tempX=1; tempX<=tailleGrille; tempX++)
											tempIndex[tempX] = true ;
										tempIndex[i] = false ;
										tempIndex[j] = false ;
										tempIndex[k] = false ;
										solve = solve || pioupiou(Mode.LIGNE, ordonee, tempIndex, temp1) ;
									}
									else{
										Vector<Integer> temp4 ;
										for(int l=k+1; l<=tailleGrille; l++){
											temp4 = grille.getCase(l,ordonee).getPossibilite();
											if(vecEqual(temp3,temp4)){
												if (temp1.size()==4){
													// on a quatre fois les memes vecteurs de taille 4, Pioupiou s'applique donc.
													boolean[] tempIndex = new boolean[tailleGrille+1] ;
													tempIndex[0] = false ;
													for(int tempX=1; tempX<=tailleGrille; tempX++)
														tempIndex[tempX] = true ;
													tempIndex[i] = false ;
													tempIndex[j] = false ;
													tempIndex[k] = false ;
													tempIndex[l] = false ;
													solve = solve || pioupiou(Mode.LIGNE, ordonee, tempIndex, temp1) ;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		// parcourt des colonnes.
		for(int abscisse=1;abscisse<=tailleGrille;abscisse++){
			Vector<Integer> temp1 ;
			Vector<Integer> temp2 ;
			for(int i=1; i<tailleGrille; i++){
				for(int j=i+1; j<=tailleGrille; j++){
					temp1 = grille.getCase(abscisse,i).getPossibilite();
					temp2 = grille.getCase(abscisse,j).getPossibilite();
					if(vecEqual(temp1,temp2)){
						// ici nous avons deux case qui on les meme vector de possibilité.
						if (temp1.size()==2){
							// on a deux fois les memes vecteurs de taille 2, Pioupiou s'applique donc.
							boolean[] tempIndex = new boolean[tailleGrille+1] ;
							tempIndex[0] = false ;
							for(int tempX=1; tempX<=tailleGrille; tempX++)
								tempIndex[tempX] = true ;
							tempIndex[i] = false ;
							tempIndex[j] = false ;
							solve = solve || pioupiou(Mode.COLONNE, abscisse, tempIndex, temp1) ;
						}
						else{
							// les vecteurs ne sont pas de tailles 2, on doit donc trouver au moins une autre case.
							Vector<Integer> temp3 ;
							for(int k=j+1; k<=tailleGrille; k++){
								temp3 = grille.getCase(abscisse,k).getPossibilite();
								if(vecEqual(temp2,temp3)){
									if (temp1.size()==3){
										// on a trois fois les memes vecteurs de taille 3, Pioupiou s'applique donc.
										boolean[] tempIndex = new boolean[tailleGrille+1] ;
										tempIndex[0] = false ;
										for(int tempX=1; tempX<=tailleGrille; tempX++)
											tempIndex[tempX] = true ;
										tempIndex[i] = false ;
										tempIndex[j] = false ;
										tempIndex[k] = false ;
										solve = solve || pioupiou(Mode.COLONNE, abscisse, tempIndex, temp1) ;									}
									else{
										Vector<Integer> temp4 ;
										for(int l=k+1; l<=tailleGrille; l++){
											temp4 = grille.getCase(abscisse,l).getPossibilite();
											if(vecEqual(temp3,temp4)){
												if (temp1.size()==4){
													// on a quatre fois les memes vecteurs de taille 4, Pioupiou s'applique donc.
													boolean[] tempIndex = new boolean[tailleGrille+1] ;
													tempIndex[0] = false ;
													for(int tempX=1; tempX<=tailleGrille; tempX++)
														tempIndex[tempX] = true ;
													tempIndex[i] = false ;
													tempIndex[j] = false ;
													tempIndex[k] = false ;
													tempIndex[l] = false ;
													solve = solve || pioupiou(Mode.COLONNE, abscisse, tempIndex, temp1) ;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return solve ;
	}
	
	public boolean pioupiou(Mode pMode,int pLigneCol,boolean[] pIndex, Vector<Integer> pPos){
		boolean solve = false ;
		if(pMode == Mode.LIGNE){
			for(int x=1; x<=tailleGrille; x++){
				if(pIndex[x]){
					for(int tempPosIndex=0; tempPosIndex<pPos.size(); tempPosIndex++)
						solve = solve || grille.getCase(x,pLigneCol).refreshPossibilite(pPos.elementAt(tempPosIndex)) ;
				}
			}
		}
		if(pMode == Mode.COLONNE){
			for(int x=1; x<=tailleGrille; x++){
				if(pIndex[x]){
					for(int tempPosIndex=0; tempPosIndex<pPos.size(); tempPosIndex++)
						solve = solve || grille.getCase(pLigneCol,x).refreshPossibilite(pPos.elementAt(tempPosIndex)) ;
				}
			}
		}
		return solve ;
	}
	
	/**
	 * permet de comparer deux vecteurs entre eux (leur contenu et non pas leur adresse)
	 * @param pVec1
	 * @param pVec2
	 * @return pVec1.equals(pVec2)
	 */
	private boolean vecEqual(Vector<Integer> pVec1, Vector<Integer> pVec2){
		// semble assez useless puisque .equal existe, a refléchir si le vecteur de possibilité contient les
		// éléments dans le meme ordre à chaque fois, logiquement oui, mais dans le doute je passe par cette
		// méthode pour pouvoir modifier mon code plus facilement par la suite s'il s'avère que .equals() ne
		// suffise pas.
		return pVec1.equals(pVec2) ;
	}
}
