package regleResolutionLogic;

import src.Grille;
import src.Observateur;
import sun.security.x509.AVA;
import controleur.ControleurR;


/**
 * Quand un observateur voit n-1 batiment et que toutes les cases n’ont pas été construite, 
 * le batiment le plus grand restant ne peut pas être placé sur toutes les cases constructibles non adjacentes à l’observateur 
 * devant le bâtiment de taille max
 * @author julien
 * @category regleResolutionLogicObservateur
 * 
 */
public class Regle_ObsVoitNmoins1 implements Regle
{
	private ControleurR ctrlR;
	private Observateur obs;
	private int tailleGrille;
	private Grille grille;
	
	public Regle_ObsVoitNmoins1 (ControleurR pCtrlR)
	{
		this.ctrlR = pCtrlR;
		grille = pCtrlR.getGrille();
		obs = pCtrlR.getObservateur();
		tailleGrille = pCtrlR.getTailleGrille();
	}

	public boolean resolve() {
		boolean solve = false;
		
		//------------------------OBSERVATEUR NORD------------------------
		for(int abscisse = 1 ; abscisse <= tailleGrille ; abscisse++) //Pour chaque abservateur du NORD
		{			
			int batVu = 0;								//Nombre de batiment que voit l'observateur
			int batMaxAConstruire = tailleGrille;		//Batimment maximum restant à construire					
			boolean existBatMax = false;				//Si le batiment de taille TailleGrille existe
			int nbCaseRestante = 0;						//Nombre de case restante avant le batiment maximum s'il existe
			int hauteurBatMaxObs = 0 ;					//On définit la hauteur max observer actuellement par l'obs
			boolean batConstruit = false;				//Si un batiment est construit sur la ligne/colonne
			int [] tab = new int[tailleGrille+1];
			
			for (int i=0 ; i<tailleGrille ; i++)
			{
				tab[i]=0;
			}
			
			//Pour chaque case de l'abscisse de l'observateur
			for(int ordonnee=1 ; ordonnee<=tailleGrille ; ordonnee++)	
			{
				int TempBat = this.grille.getCase(abscisse, ordonnee).getBatiment();
				
				if(TempBat != 0) //S'il y a un batiment construit
				{
					//Au premier passage batConstruit prend true
					batConstruit = true;
					
					//Rentrez du batiment ds le tableau des batiments (+1 pour faire comme si l'on démarrer de 1)
					if (existBatMax)
					{
						tab[TempBat] = 2;
					}
					else
					{
						tab[TempBat] = 1;
					}
					
					
					//Voir si le batiment de la case actuelle est vu par l'observateur
					if (hauteurBatMaxObs<TempBat)
					{
						hauteurBatMaxObs = TempBat;
						batVu ++;
					}
					
					//Gérer le batiment qui restera à construire après avoir passé toutes les cases
					if (TempBat == tailleGrille)
					{
						existBatMax = true;
					}
					
				}
				else 
				{
					if (batConstruit == false)
					{
						//nb de case qu'il reste a construire avant le premier batiment construit
						nbCaseRestante ++;
					}
				}
			}
			
			//Recherche du batiment maximum à construire grace au tableau
			if(batConstruit)
			{
				int cpt = tailleGrille - 1;
				while (tab[cpt] != 0)
				{
					cpt --;
				}
				
				if(tab[cpt] == 0)
				{
					batMaxAConstruire = cpt;
				}
			}
			
			//Restriction des vecteurs de possibilité
			if(existBatMax == true && batVu <= this.obs.getObservateur(Observateur.NORD,abscisse)-1)
			{
				//Pour les cases non adjacente à l'observateur (à partir de 2) pendant un nb de case "nbCaseRestante - la première"
				for (int i=2 ; i<(2+nbCaseRestante-1) ; i++) 
				{
					//On supprime dans le vecteur de possibilité la valeur max restante a construire défini au dessus
					solve = solve || this.grille.getCase(abscisse, i).refreshPossibilite(batMaxAConstruire); 
				}
			}
		}
		
		//------------------------OBSERVATEUR SUD------------------------
		
		for(int abscisse = 1 ; abscisse <= tailleGrille ; abscisse++) //Pour chaque abservateur du NORD
		{			
			int batVu = 0;								//Nombre de batiment que voit l'observateur
			int batMaxAConstruire = tailleGrille;		//Batimment maximum restant à construire					
			boolean existBatMax = false;				//Si le batiment de taille TailleGrille existe
			int nbCaseRestante = 0;						//Nombre de case restante avant le batiment maximum s'il existe
			int hauteurBatMaxObs = 0 ;					//On définit la hauteur max observer actuellement par l'obs
			boolean batConstruit = false;				//Si un batiment est construit sur la ligne/colonne
			int [] tab = new int[tailleGrille+1];
			
			for (int i=0 ; i<tailleGrille ; i++)
			{
				tab[i]=0;
			}
			
			//Pour chaque case de l'abscisse de l'observateur
			for(int ordonnee=tailleGrille; ordonnee>=1; ordonnee--)	
			{
				int TempBat = this.grille.getCase(abscisse, ordonnee).getBatiment();
				
				if(TempBat != 0) //S'il y a un batiment construit
				{
					//Au premier passage batConstruit prend true
					batConstruit = true;
					
					//Rentrez du batiment ds le tableau des batiments (+1 pour faire comme si l'on démarrer de 1)
					if (existBatMax)
					{
						tab[TempBat] = 2;
					}
					else
					{
						tab[TempBat] = 1;
					}
					
					//Voir si le batiment de la case actuelle est vu par l'observateur
					if (hauteurBatMaxObs<TempBat)
					{
						hauteurBatMaxObs = TempBat;
						batVu ++;
					}
					
					//Gérer le batiment qui restera à construire après avoir passé toutes les cases
					if (TempBat == tailleGrille)
					{
						existBatMax = true;
					}
					
				}
				else 
				{
					if (!batConstruit)
					{
						//nb de case qu'il reste a construire avant le batiment de taille tailleGrille
						nbCaseRestante ++;
					}
				}
				
			}
			
			//Recherche du batiment maximum à construire grace au tableau
			if(batConstruit)
			{
				int cpt = tailleGrille - 1;
				while (tab[cpt] != 0)
				{
					cpt --;
				}
				
				if(tab[cpt] == 0)
				{
					batMaxAConstruire = cpt;
				}
			}
			
			//Restriction des vecteurs de possibilité
			if(existBatMax == true && batVu <= this.obs.getObservateur(Observateur.SUD,abscisse)-1)
			{
				//Pour les cases non adjacente à l'observateur (à partir de 2) pendant un nb de case "nbCaseRestante - la première"
				for (int i=tailleGrille-1 ; i>tailleGrille-1 -(nbCaseRestante-1) ; i--) 
				{
					//On supprime dans le vecteur de possibilité la valeur max restante a construire défini au dessus
					solve = solve || this.grille.getCase(abscisse, i).refreshPossibilite(batMaxAConstruire); 
				}
			}
		}
		
		//-------------------------OBSERVATEUR EST------------------------
		
		for(int ordonnee = 1 ; ordonnee <= tailleGrille ; ordonnee++) //Pour chaque abservateur du NORD
		{			
			int batVu = 0;								//Nombre de batiment que voit l'observateur
			int batMaxAConstruire = tailleGrille;		//Batimment maximum restant à construire					
			boolean existBatMax = false;				//Si le batiment de taille TailleGrille existe
			int nbCaseRestante = 0;						//Nombre de case restante avant le batiment maximum s'il existe
			int hauteurBatMaxObs = 0 ;						//On définit la hauteur max observer actuellement par l'obs
			boolean batConstruit = false;				//Si un batiment est construit sur la ligne/colonne
			int [] tab = new int[tailleGrille+1];
			
			for (int i=0 ; i<tailleGrille ; i++)
			{
				tab[i]=0;
			}
			
			//Pour chaque case de l'abscisse de l'observateur
			for(int abscisse=tailleGrille; abscisse>=1; abscisse--)	
			{
				int TempBat = this.grille.getCase(abscisse, ordonnee).getBatiment();
				
				if(TempBat != 0) //S'il y a un batiment construit
				{
					//Au premier passage batConstruit prend true
					batConstruit = true;
					
					//Rentrez du batiment ds le tableau des batiments (+1 pour faire comme si l'on démarrer de 1)
					if (existBatMax)
					{
						tab[TempBat] = 2;
					}
					else
					{
						tab[TempBat] = 1;
					}
					
					//Voir si le batiment de la case actuelle est vu par l'observateur
					if (hauteurBatMaxObs<TempBat)
					{
						hauteurBatMaxObs = TempBat;
						batVu ++;
					}
					
					//Gérer le batiment qui restera à construire après avoir passé toutes les cases
					if (TempBat == tailleGrille)
					{
						existBatMax = true;
					}
					
				}
				else 
				{
					if (!batConstruit)
					{
						//nb de case qu'il reste a construire avant le batiment de taille tailleGrille
						nbCaseRestante ++;
					}
				}
			}
			
			//Recherche du batiment maximum à construire grace au tableau
			if(batConstruit)
			{
				int cpt = tailleGrille - 1;
				while (tab[cpt] != 0)
				{
					cpt --;
				}
				
				if(tab[cpt] == 0)
				{
					batMaxAConstruire = cpt;
				}
			}
			
			//Restriction des vecteurs de possibilité
			if(existBatMax == true && batVu <= this.obs.getObservateur(Observateur.EST,ordonnee)-1)
			{
				//Pour les cases non adjacente à l'observateur (à partir de 2) pendant un nb de case "nbCaseRestante - la première"
				for (int i=tailleGrille-1 ; i>tailleGrille-1 -(nbCaseRestante-1) ; i--) 
				{	
					//On supprime dans le vecteur de possibilité la valeur max restante a construire défini au dessus
					solve = solve || this.grille.getCase(i, ordonnee).refreshPossibilite(batMaxAConstruire); 
				}
			}
		}
		
		//------------------------OBSERVATEUR OUEST------------------------
		
		for(int ordonnee = 1 ; ordonnee <= tailleGrille ; ordonnee++) //Pour chaque observateur du NORD
		{			
			int batVu = 0;								//Nombre de batiment que voit l'observateur
			int batMaxAConstruire = tailleGrille;		//Batimment maximum restant à construire					
			boolean existBatMax = false;				//Si le batiment de taille TailleGrille existe
			int nbCaseRestante = 0;						//Nombre de case restante avant le batiment maximum s'il existe
			int hauteurBatMaxObs = 0 ;						//On définit la hauteur max observer actuellement par l'obs
			boolean batConstruit = false;				//Si un batiment est construit sur la ligne/colonne
			int [] tab = new int[tailleGrille+1];
			
			for (int i=0 ; i<tailleGrille ; i++)
			{
				tab[i]=0;
			}
			
			//Pour chaque case de l'abscisse de l'observateur
			for(int abscisse=1; abscisse<=tailleGrille; abscisse++)	
			{
				int TempBat = this.grille.getCase(abscisse, ordonnee).getBatiment();
				
				if(TempBat != 0) //S'il y a un batiment construit
				{
					//Au premier passage batConstruit prend true
					batConstruit = true;
					
					//Rentrez du batiment ds le tableau des batiments (+1 pour faire comme si l'on démarrer de 1)
					if (existBatMax)
					{
						tab[TempBat] = 2;
					}
					else
					{
						tab[TempBat] = 1;
					}
					
					//Voir si le batiment de la case actuelle est vu par l'observateur
					if (hauteurBatMaxObs<TempBat)
					{
						hauteurBatMaxObs = TempBat;
						batVu ++;
					}
					
					//Gérer le batiment qui restera à construire après avoir passé toutes les cases
					if (TempBat == tailleGrille)
					{
						existBatMax = true;
					}
					
				}
				else 
				{
					if (!batConstruit)
					{
						//nb de case qu'il reste a construire avant le batiment de taille tailleGrille
						nbCaseRestante ++;
					}
				}
			}
			
			//Recherche du batiment maximum à construire grace au tableau
			if(batConstruit)
			{
				int cpt = tailleGrille - 1;
				while (tab[cpt] != 0)
				{
					cpt --;
				}
				
				if(tab[cpt] == 0)
				{
					batMaxAConstruire = cpt;
				}
			}
			
			//Restriction des vecteurs de possibilité
			if(existBatMax == true && batVu <= this.obs.getObservateur(Observateur.OUEST,ordonnee)-1)
			{
				//Pour les cases non adjacente à l'observateur (à partir de 2) pendant un nb de case "nbCaseRestante - la première"
				for (int i=2 ; i<2+nbCaseRestante-1 ; i++) 
				{
					//On supprime dans le vecteur de possibilité la valeur max restante a construire défini au dessus
					solve = solve || this.grille.getCase(i, ordonnee).refreshPossibilite(batMaxAConstruire); 
				}
			}
		}
		return solve;
	}
	
}
