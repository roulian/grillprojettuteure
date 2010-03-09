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
			observateur[NORD][i] = 0;
			observateur[SUD][i] = 0;
			observateur[EST][i] = 0;
			observateur[OUEST][i] = 0;
		}
    }
    
    public Observateur(int[][] pObs) {
    	observateur = pObs ;
    }
    
    public Observateur(Integer[][] pObs,int taille){
    	int[][] pObsTemp = new int[taille][taille];
    	for(int i=0;i<4;i++){
    		for(int j=0;j<taille;j++){
    			pObsTemp[i][j] = pObs[i][j] ;
        	}
    	}
    	observateur = pObsTemp ;
    }
    
    public int getObservateur(int pCardinal, int pPosition){
    	return observateur[pCardinal][pPosition-1] ;
    }
    
    public void setObservateur(int pCardinal,int pPosition,int temp){
    	observateur[pCardinal][pPosition] = temp ;
    }
}