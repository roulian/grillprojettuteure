/**
 * @(#)Observateur.java
 *
 *
 * @author 
 * @version 1.00 2009/11/18
 */
package src ;

public class Observateur {
	// c'est 4 variable sont en public car se sont des constantes !  
	public static final int NORD = 0;
	public static final int SUD = 1;
	public static final int EST = 2;
	public static final int OUEST = 3;
	private int[][] observateur ;
	
    public Observateur(int pTailleGrille) {
		observateur = new int[4][pTailleGrille] ;
		for (int i=0; i<pTailleGrille; i++){
			observateur[NORD][i] = (int)(Math.random()*4+1);
			observateur[SUD][i] = (int)(Math.random()*4+1);
			observateur[EST][i] = (int)(Math.random()*4+1);
			observateur[OUEST][i] = (int)(Math.random()*4+1);
		}
    }
    
    public Observateur(int[][] pObs) {
    	observateur = pObs ;
    }
    
    public int getObservateur(int pCardinal, int pPosition){
    	return observateur[pCardinal][pPosition-1] ;
    }
}