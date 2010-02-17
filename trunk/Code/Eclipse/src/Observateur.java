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
	
    public Observateur() {
		observateur = new int[4][4] ;
		for (int i=0; i<4; i++)
			observateur[NORD][i] = (int)(Math.random()*4+1);
		for (int i=0; i<4; i++)
			observateur[SUD][i] = 0;
		for (int i=0; i<4; i++)
			observateur[EST][i] = 0;
		for (int i=0; i<4; i++)
			observateur[OUEST][i] = 0;		
    }
    public Observateur(int[][] pObs) {
    	observateur = pObs ;
    }
    
    public int getObservateur(int pCardinal, int pPossition){
    	return observateur[pCardinal][pPossition-1] ;
    }
}