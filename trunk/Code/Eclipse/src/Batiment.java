/**
 * @(#)Batiment.java
 *
 *
 * @author 
 * @version 1.00 2009/11/18
 */
package src ;

public class Batiment {
	int hauteur ;

	// a reprendre dans le diag de classe...
    public Batiment(int pHauteur) {
    	hauteur = pHauteur ;
    }
    
    public int getHauteur(){
    	return hauteur ;
    }
    
    public String toString(){
    	String temp = new String() ;
    	return temp.valueOf(hauteur) ;
    }
}