/**
 * @(#)TestCase.java
 *
 *
 * @author 
 * @version 1.00 2009/11/18
 */
package TestClasse ;
import src.* ;


public class TestCase {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("--- DEBUT TEST DE LA CLASSE 'CASE'\n") ;
        
        Case testDeCase = new Case(5) ;
        Batiment bat ;
        
        for( int i=0 ; i<10 ; i++)
        	System.out.println("bat de taille "+i+" est constructible: "+ testDeCase.estConstrutible(new Batiment(i)))  ;
        	
        
    }
}
