/**
 * @(#)Case.java
 *
 *
 * @author 
 * @version 1.00 2009/10/19
 */


public class Case {

	private int abscisse ;
	private int ordonnee ;

    public Case() {
    	this(0,0) ;
    }
    
    public Case(int pX, int pY) {
    	abscisse = pX ;
    	ordonnee = pY ;
    }
    
    public int getAbscisse(){
    	return abscisse ;
    }
    
    public int getOrdonnee(){
    	return ordonnee ;
    }
    
    public int[] getCoordonnee(){
    	int[] tabTemp = new int[2] ;
    	tabTemp[0]=abscisse;
    	tabTemp[1]=ordonnee;
    	return tabTemp ;
    }
    
    public void setAbscisse(int pX){
    	abscisse = pX;
    }
    
    public void setOrdonnee(int pY){
    	ordonnee = pY;
    }
    
    public void setCoordonnee(int[] pCoord){
    	abscisse = pCoord[0];				//setAbscisse(pX);
		ordonnee = pCoord[1];				//setOrdonnee(pY);
    }
}