/**
 * @(#)Observateur.java
 *
 *
 * @author 
 * @version 1.00 2009/10/21
 */


public class Observateur {
	private int[] obs ;
	    
    public Observateur(int[] pListe){
    	int i ;
    	int tailleListe = pListe.length ;
    	obs = new int[tailleListe] ;
    	for (i=0;i<tailleListe;i++)
    		obs[i] = pListe[i] ;
    }
    
    public int[] getObservateur(){
    	return obs ;
    }
    
    public int getObservateur(int indice){
    	return obs[indice-1] ;
    }
    
    public void setObservateur(int[] pListe){
    	int i ;
    	int tailleListe = pListe.length ;
    	obs = new int[tailleListe] ;
    	for (i=0;i<tailleListe;i++)
    		obs[i] = pListe[i] ;
    }
    
    public void setObservateur(int pNum, int indice){
    	obs[indice-1] = pNum ;
    }
}