/**
 * @(#)batiment.java
 *
 *
 * @author 
 * @version 1.00 2009/10/19
 */


public class Batiment {
	
	Case coordonnee ;
	int hauteur ;
	
    public Batiment() {
    	this(new Case(),0);
    }
    
    public Batiment(Case pCoordonnee, int pHauteur){
    	hauteur = pHauteur ;
    	coordonnee = new Case();
    	coordonnee.setCoordonnee(pCoordonnee.getCoordonnee()) ;
    }
    
    public int getHauteur(){
    	return hauteur ;
    }
    
    public Case getCase(){
    	return coordonnee;
    }
	
	// inutil de faire des modificateur ici, je ne pense pas que ça sera itilisé dans le code
}