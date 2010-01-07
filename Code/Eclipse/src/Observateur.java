/**
 * @(#)Observateur.java
 *
 *
 * @author 
 * @version 1.00 2009/11/18
 */
package src ;

public class Observateur {
	int[] haut ;
	int[] bas ;
	int[] gauche ;
	int[] droite ;
	
	// modifier le diagramme de classe
    public Observateur(int[] pHaut,int[] pBas, int[] pGauche, int[] pDroite) {
    	haut = pHaut ;
    	bas = pBas ;
    	gauche = pGauche ;
    	droite = pDroite ;
    }
    
    public int[] getHaut(){
    	return haut ;
    }
    
    public int[] getBas(){
    	return bas ;
    }
    
    public int[] getGauche(){
    	return gauche ;
    }
    
    public int[] getDroite(){
    	return droite ;
    }
}