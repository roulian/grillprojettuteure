/**
 * @(#)Main.java
 *
 *
 * @author 
 * @version 1.00 2009/10/20
 */

public class Main {
        
    /**
     * Creates a new instance of <code>Main</code>.
     */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
     	Grille test ;
    	test = new Grille() ;
    	    	
    	test.getObsGauche().setObservateur(4,2);
    	test.getObsDroit().setObservateur(4,3);
    	test.getObsHaut().setObservateur(4,2);
     	    	
    	test.evidence() ;
    	
    	test.display(); 
    	test.displayPossible() ;
    	/**
    	test.display() ;
    	
    	test.construire(new Batiment(new Case(2,3),4)) ;
    	test.display() ;
    	
    	test.construire(new Batiment(new Case(1,1),4)) ;
    	test.construire(new Batiment(new Case(4,4),4)) ;
    	test.construire(new Batiment(new Case(3,2),4)) ;
    	test.display() ;
    	
    	test.construire(new Batiment(new Case(1,3),4)) ;
    	test.display() ;
    	**/
    }
}
