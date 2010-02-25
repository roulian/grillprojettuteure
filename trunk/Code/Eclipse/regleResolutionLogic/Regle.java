package regleResolutionLogic;

public interface Regle {
	
	public abstract boolean resolve() ; 
}

// Il nous faut une regle qui parcourt l'ensemble des ligne / colonne pour vérifier 
// qu'un batiment n'est pas constructible (c'est le dernier endroit possible pour lui) 