/**
 * @(#)Grille.java
 *
 *
 * @author 
 * @version 1.00 2009/11/18
 */
package src ;

public class Grille {
	
	Case[][] grilleDejeu ;
	int tailleGrille ;
	Observateur obs ;
	
    public Grille() {
    }
    
    public Grille(int pTaille){
    	// on sauvegarde la taille de la grille dans une variable int
    	tailleGrille = pTaille ;
    	
    	// on fait une nouvelle instance d'une grille
    	grilleDejeu = new Case[pTaille][pTaille] ;
    	
    	// on instancie les cases
    	for(int i=0 ; i<tailleGrille ; i++ ){
    		for(int j=0 ; j<tailleGrille ; j++){
    			grilleDejeu[j][i] = new Case(tailleGrille) ;
    		}
    	}
    }
    
    // dans le diagramme de classe il manque le constructeur de Grille qui permet de "faire" des observateurs !
    
    
    public Case getCase(int pAbscisse, int pOrdonnee){
    	return grilleDejeu[pOrdonnee-1][pAbscisse-1] ;
    }
    
    public void construire(int pAbscisse, int pOrdonnee, Batiment pBatiment){
    	getCase(pAbscisse,pOrdonnee).construire(pBatiment) ;
    }
    
    public Observateur getObervateur(){
    	return obs ;
    }
}