package src;

public class SaveObject {
	private Grille grilleSave ;
	private Observateur observateurSave; 
	private int tailleGrilleSave ;
	
	public SaveObject(Grille _grille,Observateur _observateur,int _taille){
		grilleSave = _grille ;
		observateurSave = _observateur ;
		tailleGrilleSave = _taille ;
	}

	public Integer[][] getSavableObject(){
		
		System.out.println("azf azifzfno anof naofn "+tailleGrilleSave);
		
		Integer[][] save = new Integer[tailleGrilleSave+4][tailleGrilleSave] ;
		for(int ord=0; ord<tailleGrilleSave; ord++){
			for(int abs=0; ord<tailleGrilleSave; abs++){
				save[abs][ord] = grilleSave.getCase(abs+1,ord+1).getBatiment() ;
			}
		}
		for(int card=0; card<4; card++)
			for(int abs=0; abs<tailleGrilleSave; abs++)
				save[tailleGrilleSave+card][abs] = observateurSave.getObservateur(card,abs+1) ;
		
		return save ;
	}
	
	public Grille getGrilleSave() {
		return grilleSave;
	}

	public Observateur getObservateurSave() {
		return observateurSave;
	}

	public int getTailleGrilleSave() {
		return tailleGrilleSave;
	}
}
