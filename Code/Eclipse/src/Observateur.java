/**
 * @(#)Observateur.java
 *
 *
 * @author 
 * @version 1.00 2009/11/18
 */
package src ;

public class Observateur {
	public static final int NORD = 1;
	public static int SUD = 2;
	public static int EST = 3;
	public static int OUEST = 4;
	private int[][] observateur ;
	
    public Observateur() {
		observateur = new int[4][4] ;
		for (int i=0; i<4; i++)
			observateur[NORD][i] = 0;
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
    
    public int[][] getObservateur(){
    	return observateur ;
    }
}