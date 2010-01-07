/**
 * @(#)grille.java
 *
 *
 * @author 
 * @version 1.00 2009/10/19
 */
import java.util.Vector ;

public class Grille {

	private Batiment[][] grilleDeJeu ;
	private EstConstructible[][] possibilite ;
	private Observateur obsHaut ;
	private Observateur obsBas ;
	private Observateur obsGauche ;
	private Observateur obsDroit ;
	private int tailleGrille ;			// .lenght() semble ne pas marcher pour les tableau à double entré

    public Grille() {
    	this(4,new Observateur(new int[4]),new Observateur(new int[4]),new Observateur(new int[4]),new Observateur(new int[4]));
    }
    
    public Grille(int nb){
    	this(nb,new Observateur(new int[nb]),new Observateur(new int[nb]),new Observateur(new int[nb]),new Observateur(new int[nb]));
    }
    
    public Grille(int nb, Observateur pObsHaut, Observateur pObsBas, Observateur pObsGauche, Observateur pObsDroit){
    	int i,j,k ;
    	grilleDeJeu = new Batiment[nb][nb] ;
    	possibilite = new EstConstructible[nb][nb] ;
    	
    	tailleGrille = nb ;
    	for(i=0;i<tailleGrille;i++){
    		for(j=0;j<tailleGrille;j++){
    			grilleDeJeu[i][j] = new Batiment() ;
    		}
    	}
    	for(i=0;i<tailleGrille;i++){
    		for(j=0;j<tailleGrille;j++){
    			Case localisation = new Case(i+1,j+1);
    			possibilite[i][j] = new EstConstructible(localisation,tailleGrille) ;
    		}
    	}
    	obsBas = pObsBas ;
    	obsDroit = pObsDroit ;
    	obsGauche = pObsGauche ;
    	obsHaut = pObsHaut ;
    	
    }
    
    public void display(){
    	int i, j; 	
    		
    	System.out.print("    ");
    	for (i=1;i<=tailleGrille;i++)
    		System.out.print(obsHaut.getObservateur(i)+" ") ;
    	System.out.println();
    	
    	System.out.print("   -");
    	for (i=0;i<tailleGrille;i++)
    		System.out.print("--") ;
    	System.out.println();
    	
    	for (i=0;i<tailleGrille;i++){
    		System.out.print(obsGauche.getObservateur(i+1)+" | ") ;
    		for (j=0;j<tailleGrille;j++){
    			System.out.print(grilleDeJeu[i][j].getHauteur()+" ") ;
    		}
    		System.out.print("| "+obsDroit.getObservateur(i+1)) ;
    		System.out.println();
    	}
    	
    	System.out.print("    ");
    	for (i=0;i<tailleGrille;i++)
    		System.out.print("--") ;
    	System.out.println();
    	
    	System.out.print("    ");
    	for (i=1;i<=tailleGrille;i++)
    		System.out.print(obsBas.getObservateur(i)+" ") ;
    	System.out.println() ;
    	System.out.println() ;
    }
    
    public void displayPossible(){
    	int i, j ;
    	System.out.println("Liste des possibilités") ;
    	for(i=0;i<tailleGrille;i++){
    		for(j=0;j<tailleGrille;j++){
    			possibilite[i][j].display() ;
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }
    
    public boolean construire(Batiment pBat){
    	int i ;
    	int ord = pBat.coordonnee.getOrdonnee()-1 ;
    	int abs = pBat.coordonnee.getAbscisse()-1 ;
    	boolean constructible ;
    	
    	constructible = true ;					// si oui
    	  	
    	grilleDeJeu[ord][abs] = pBat ;			// on le construit ! 			
   		
   		System.out.print("("+pBat.getCase().getAbscisse()+",");
   		System.out.print(pBat.getCase().getOrdonnee()+")");
   		System.out.print(":"+pBat.getHauteur());
   		System.out.println();
		debug();
   		
   		for(i=0;i<tailleGrille;i++){					
   			possibilite[ord][i].setImpossible(pBat); // on supprime la possibilité sur la ligne
   			possibilite[i][abs].setImpossible(pBat); // on supprime la possibilité sur la colonne
   		}
   		possibilite[ord][abs].liste().clear() ; // on supprime toute possibilité sur cette case !
    
    	return constructible ;
    }
    
    public void debug(){
    	int i,j ;
    	for (i=0;i<tailleGrille;i++){
    		for(j=0;j<tailleGrille;j++){
    			System.out.print(grilleDeJeu[i][j].getHauteur()) ;
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    
    public boolean evidence(){
    	int i, j ;
    	boolean unBatConstruit = false;
    	for(i=1;i<=tailleGrille;i++){
    		
    		// haut
    		if (obsHaut.getObservateur(i)==tailleGrille){
    			for (j=1;j<=tailleGrille;j++){
    				Case localisation = new Case(i,j) ;
	    			Batiment tempBat = new Batiment(localisation,j) ;
	    			construire(tempBat) ;
    			}   			
    			unBatConstruit = true ;
    		}
    		if (obsHaut.getObservateur(i)==1){
    			Case localisation = new Case(i,1) ;
    			Batiment tempBat = new Batiment(localisation,tailleGrille) ;
    			construire(tempBat) ;
    			unBatConstruit = true ;
    		}
    		
    		//bas
    		if (obsBas.getObservateur(i)==tailleGrille){
    			for (j=1;j<=tailleGrille;j++){
    				Case localisation = new Case(i,tailleGrille + 1 - j) ;
	    			Batiment tempBat = new Batiment(localisation,j) ;
	    			construire(tempBat) ;
    			}   			
    			unBatConstruit = true ;
    		}
    		if (obsBas.getObservateur(i)==1){
    			Case localisation = new Case(i,tailleGrille) ;
    			Batiment tempBat = new Batiment(localisation,tailleGrille) ;
    			construire(tempBat) ;
    			unBatConstruit = true ;
    		}
    		
    		//droit
    		if (obsDroit.getObservateur(i)==tailleGrille){
    			for (j=1;j<=tailleGrille;j++){
    				Case localisation = new Case(tailleGrille + 1 - j,i) ;
	    			Batiment tempBat = new Batiment(localisation,j) ;
	    			construire(tempBat) ;
    			}   			
    			unBatConstruit = true ;
    		}
    		if (obsDroit.getObservateur(i)==1){
    			Case localisation = new Case(tailleGrille,i) ;
    			Batiment tempBat = new Batiment(localisation,tailleGrille) ;
    			construire(tempBat) ;
    			unBatConstruit = true ;
    		}
    		
    		//gauche
    		if (obsGauche.getObservateur(i)==tailleGrille){
    			for (j=1;j<=tailleGrille;j++){
    				Case localisation = new Case(j,i) ;
	    			Batiment tempBat = new Batiment(localisation,j) ;
	    			construire(tempBat) ;
    			}   			
    			unBatConstruit = true ;
    		}
    		if (obsGauche.getObservateur(i)==1){
    			Case localisation = new Case(1,i) ;
    			Batiment tempBat = new Batiment(localisation,tailleGrille) ;
    			construire(tempBat) ;
    			unBatConstruit = true ;
    		}
    	}
    	
    	for (i=0;i<tailleGrille;i++){
    		for (j=0;j<tailleGrille;j++){
    			if (possibilite[i][j].liste().size()==1){
    				
    				Case localisation = new Case(i+1,j+1) ;
	    			Batiment tempBat = new Batiment(localisation,possibilite[i][j].liste().elementAt(0).getHauteur()) ;
	    			if (construire(tempBat)){
	    				System.out.print("OK") ;
	    			}
    								
    				unBatConstruit = true ;
    			}
    		}
    	}
    	
    	return unBatConstruit ;
    }
    
    // retourne les hauteurs des bat unique
    public int[] monome(){
    	int[] monome = new int[tailleGrille] ;
    	int i, j, k, tailleListe;
    	for(i=0;i<tailleGrille;i++){
    		for(j=0;i<tailleGrille;j++){
    			tailleListe = possibilite[j][i].liste().size() ;
    			for(k=0;k<tailleListe;k++)
    				monome[possibilite[j][i].liste().elementAt(k).getHauteur()-1]++;
    		}
    	}
    	for(i=0;i<tailleGrille;i++){
    		if (monome[i]!=1)
    			monome[i] = 0 ;
    	}
    	return monome ;
    }
    
    public Observateur getObsHaut(){
    	return obsHaut ;
    }
    
    public Observateur getObsBas(){
    	return obsBas ;
    }
    
    public Observateur getObsGauche(){
    	return obsGauche ;
    }
    
    public Observateur getObsDroit(){
    	return obsDroit ;
    }
}