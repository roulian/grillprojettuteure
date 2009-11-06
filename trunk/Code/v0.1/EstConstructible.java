/**
 * @(#)EstConstructible.java
 *
 *
 * @author 
 * @version 1.00 2009/10/21
 */
import java.util.Vector ;

public class EstConstructible {
	
	private Vector<Batiment> possible ;
	
    public EstConstructible(Case localisation, int pNb) {
    	int i ;
    	possible = new Vector<Batiment>() ;
    	for (i=1;i<=pNb;i++){
    		possible.add(new Batiment(localisation,i)) ;
    	}
    }
    
    public Vector<Batiment> liste(){
    	return possible ;
    }
    
    public boolean contient(Batiment pBat){
    	int haut = pBat.getHauteur() ;
    	int taille = possible.size() ;
    	int i;
    	boolean contient = false ;
    	
    	for(i=0;i<taille;i++){
    		if(possible.elementAt(i).getHauteur()==haut)
    			contient = true ;
    	}
    	return contient ;
    }
    
    public void setImpossible(Batiment pBat){
    	int haut = pBat.getHauteur() ;
    	int taille = possible.size() ;
    	int i;
    	boolean stop = false ;
    	
    	for(i=0;i<taille && !stop;i++){
    		if(possible.elementAt(i).getHauteur()==haut){
    			possible.remove(i);
    			stop = true;
    		}
    	}
    }
    
    public void display(){
    	int tailleVec = possible.size();
    	int i ;
    	
    	if (tailleVec>0){
    		System.out.print("s"+possible.size());
    		System.out.print("("+possible.elementAt(0).getCase().getAbscisse()+",");
    		System.out.print(possible.elementAt(0).getCase().getOrdonnee()+")");
    	}
    	for(i=0;i<tailleVec;i++)
    		System.out.print("."+possible.elementAt(i).getHauteur());
    }    
}