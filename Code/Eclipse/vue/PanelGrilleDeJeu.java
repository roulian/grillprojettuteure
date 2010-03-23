package vue;
import images.GestionIcon;
import images.IconBat;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Ecouteur.EcouteurGrille;
import Ecouteur.EcouteurObservateur;
import controleur.ControleurM;
import controleur.ControleurVues;
import src.Grille;
import src.Observateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class PanelGrilleDeJeu extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel[][] affGrille ;
	private Observateur obsSaisie ;
	private Grille grille ;
	private ControleurVues ctrlV; 
	private JPanel panelGrille ;
	private JPanel panelObsNord ;
	private JPanel panelObsSud ;
	private JPanel panelObsEst ;
	private JPanel panelObsOuest ;
	private int lenght ;
	
	/**
	 * This is the default constructor,
	 * il est nécessaire de l'utiliser pour construire une grille jouable
	 * @param pCtrlV controleur des vues
	 */
	public PanelGrilleDeJeu(ControleurVues pCtrlV) {
		super();
		ctrlV = pCtrlV ;
		int lenght = ctrlV.getTailleGrille() ;
		initialize(lenght) ;
		
		//************ LIEE AU JEUX ***********/

		// gestion des panels observateurs
		panelObsNord.add(new JLabel());				// blancs nécessaire pour centrer 
		panelObsSud.add(new JLabel());				// blancs nécessaire pour centrer
		// gestion du type dobservateur (affichage)
		for (int i=1 ; i<=lenght ; i++){
			//dans l'ordre Nord, Est, Sud, Ouest
			panelObsNord.add(new JLabel(new ImageIcon(GestionIcon.getImage(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.NORD,i),"obs"))));
			panelObsEst.add(new JLabel(new ImageIcon(GestionIcon.getImage(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.EST,i),"obs"))));
			panelObsSud.add(new JLabel(new ImageIcon(GestionIcon.getImage(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.SUD,i),"obs"))));
			panelObsOuest.add(new JLabel(new ImageIcon(GestionIcon.getImage(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.OUEST,i),"obs"))));
		}
		panelObsNord.add(new JLabel());				// blancs nécessaire pour centrer
		panelObsSud.add(new JLabel());				// blancs nécessaire pour centrer
		
		// gestion du panel de la grille de jeu
		// on donne au panel les références des label présent dans le tableaux et initialiser plus tot
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				affGrille[i][j].setBorder(BorderFactory.createEtchedBorder()) ;
				panelGrille.add(affGrille[i][j]);	// passe la référense du label au panel
				EcouteurGrille listenCase = new EcouteurGrille(ctrlV,affGrille[i][j],j+1,i+1) ;
				affGrille[i][j].addMouseListener(listenCase) ;
				affGrille[i][j].addKeyListener(listenCase) ;
			}
		}
	}
	
	/**
	 * c'est le deuxieme construteur
	 * il est nécessaire de l'utiliser pour construire une grille non jouable avec Obs modifiable
	 * @param pCtrlV controleur des vues
	 */
	public PanelGrilleDeJeu(ControleurM pCtrlM,int pTaille,Observateur pObservateur,boolean pModifiable){
		super();
		if(pObservateur!=null){
			ctrlV = pCtrlM.getCtrlVues() ;
			lenght = pTaille ;
			initialize(lenght) ;
			obsSaisie = pObservateur ;
			//************ LIEE AU CHARGEMENT / GENERATION ***********/
	
			// gestion des panels observateurs
			panelObsNord.add(new JLabel());				// blancs nécessaire pour centrer 
			panelObsSud.add(new JLabel());				// blancs nécessaire pour centrer
			// gestion du type dobservateur (affichage)
			JLabel temp  ;
			EcouteurObservateur ecoutTemp ;
			for (int i=1 ; i<=lenght ; i++){
				//Nord
				temp = new JLabel(new ImageIcon(GestionIcon.getImage(obsSaisie.getObservateur(Observateur.NORD,i),"obs"))) ;
				temp.setBorder(BorderFactory.createEtchedBorder()) ;
				if(pModifiable){
					ecoutTemp = new EcouteurObservateur(ctrlV,temp,Observateur.NORD,i,obsSaisie) ;
					temp.addMouseListener(ecoutTemp) ;
					temp.addKeyListener(ecoutTemp) ;
				}
				panelObsNord.add(temp);
				
				//Est
				temp = new JLabel(new ImageIcon(GestionIcon.getImage(obsSaisie.getObservateur(Observateur.EST,i),"obs"))) ;
				temp.setBorder(BorderFactory.createEtchedBorder()) ;
				if(pModifiable){
					ecoutTemp = new EcouteurObservateur(ctrlV,temp,Observateur.EST,i,obsSaisie) ;
					temp.addMouseListener(ecoutTemp) ;
					temp.addKeyListener(ecoutTemp) ;
				}
				panelObsEst.add(temp);
				
				//Sud
				temp = new JLabel(new ImageIcon(GestionIcon.getImage(obsSaisie.getObservateur(Observateur.SUD,i),"obs"))) ;
				temp.setBorder(BorderFactory.createEtchedBorder()) ;
				if(pModifiable){
					ecoutTemp = new EcouteurObservateur(ctrlV,temp,Observateur.SUD,i,obsSaisie) ;
					temp.addMouseListener(ecoutTemp) ;
					temp.addKeyListener(ecoutTemp) ;
				}
				panelObsSud.add(temp);
				
				//Ouest
				temp = new JLabel(new ImageIcon(GestionIcon.getImage(obsSaisie.getObservateur(Observateur.OUEST,i),"obs"))) ;
				temp.setBorder(BorderFactory.createEtchedBorder()) ;
				if(pModifiable){
					ecoutTemp = new EcouteurObservateur(ctrlV,temp,Observateur.OUEST,i,obsSaisie) ;
					temp.addMouseListener(ecoutTemp) ;
					temp.addKeyListener(ecoutTemp) ;
				}
				panelObsOuest.add(temp);
			}
			panelObsNord.add(new JLabel());				// blancs nécessaire pour centrer
			panelObsSud.add(new JLabel());				// blancs nécessaire pour centrer
			
			// gestion du panel de la grille de jeu
			// on donne au panel les références des label présent dans le tableaux et initialiser plus tot
			for (int i=0 ; i<lenght ; i++){
				for (int j=0 ; j<lenght ; j++)
					panelGrille.add(affGrille[i][j]);	// passe la référense du label au panel
			}
		}
	}
	
	public void initialize(int pTaille){
		// on initialise le tableau à double entrée qui nous permettra par la suite d'afficher
		// les batiments. c'est un tableau de label, plus facil d'afficher ainsi
		affGrille = new JLabel[pTaille][pTaille];
		lenght = pTaille ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				JLabel tempLabel = new JLabel();
				tempLabel.setIcon(new ImageIcon(IconBat.BLANC)) ;	// image vide
				affGrille[i][j] = tempLabel ;
			}
		}
		
		//définition des différents layouts
		BorderLayout gridLayoutPrincipal = new BorderLayout();			// définition du layout principal
		GridLayout gridLayoutNordSud = new GridLayout(1,lenght+2);		// layout pour les observateurs nord et sud
		GridLayout gridLayoutEstOuest = new GridLayout(lenght,1);		// layout pour les observateurs Ouest et est
		GridLayout gridLayoutGrille = new GridLayout(lenght,lenght);	// layout pour les observateurs nord et sud
		
		//définition des panels qui nous permettrons l'affichage de la grille
		panelGrille = new JPanel() ;
		panelObsNord = new JPanel() ;
		panelObsSud = new JPanel() ;
		panelObsEst = new JPanel() ;
		panelObsOuest = new JPanel() ;
		
		//association des panel avec leurs layouts respectifs
		panelObsNord.setLayout(gridLayoutNordSud) ;
		panelObsSud.setLayout(gridLayoutNordSud) ;
		panelObsEst.setLayout(gridLayoutEstOuest) ;
		panelObsOuest.setLayout(gridLayoutEstOuest) ;
		panelGrille.setLayout(gridLayoutGrille) ;
		this.setLayout(gridLayoutPrincipal);
		
		//Mise en page des différents panels
		add(panelObsNord,BorderLayout.NORTH);		// ajout du panel Nord
		add(panelObsOuest,BorderLayout.WEST) ;		// ajout du panel Ouest
		add(panelGrille,BorderLayout.CENTER) ;		// ajout du panel de la grille de jeu
		add(panelObsEst,BorderLayout.EAST) ;		// ajout du panel Est
		add(panelObsSud,BorderLayout.SOUTH) ;		// ajout du panel Sud
	}
	
	public void refreshGrilleDisplay(int pAbscisse, int pOrdonnee, String pImBat){
		if(pImBat==null)
			pImBat = GestionIcon.getImage(ctrlV.getCtrlM().getLaGrille().getCase(pAbscisse,pOrdonnee).getBatiment(),"bat") ;
		affGrille[pOrdonnee-1][pAbscisse-1].setIcon(new ImageIcon(pImBat)) ;		
		validate();
	}
	
	public void redlyGrilleDisplay(int pBat){
		refreshGrilleDisplay() ;
		System.out.println("appel de redlyGrilleDisplay param: "+pBat);
		GestionIcon.switchRedBat() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				if(!ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).estConstrutible(pBat)){
					affGrille[i][j].setIcon(new ImageIcon(GestionIcon.getImage(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment(),"bat"))) ;
				}
			}
		}
		GestionIcon.switchRedBat() ;
		validate();
	}
	
	public void redlyGrilleDisplay(){
		refreshGrilleDisplay() ;
		System.out.println("appel de redlyGrilleDisplay -SANS PARAMETRE-");
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				// si le batiment est différent de zéro
				int tempbat = ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment() ;
				if( tempbat != 0 ){
					if( tempbat != ctrlV.getCtrlM().getAideGrilleErreur(j+1,i+1)){
						GestionIcon.switchRedBat() ;
						affGrille[i][j].setIcon(new ImageIcon(GestionIcon.getImage(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment(),"bat"))) ;
						GestionIcon.switchRedBat() ;
					}
					else{
						affGrille[i][j].setIcon(new ImageIcon(GestionIcon.getImage(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment(),"bat"))) ;
					}
				}
			}
		}
		validate();
	}
	
	/**
	 * méthode qui permet d'afficher les batiments de la grille selon leur taille
	 */
	public void refreshGrilleDisplay(){
		System.out.println("appel de refresGrilleDisplay");
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
//				System.out.print("| "+ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment()+" ");
				affGrille[i][j].setIcon(new ImageIcon(GestionIcon.getImage(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment(),"bat"))) ;
			}
//			System.out.println("|");
		}
		validate();
	}
	
	/**
	 * revoit le controleur des vues passer en parametre du constructeur
	 * @return {@link ControleurVues}
	 */
	public ControleurVues getCtrlV() {
		return ctrlV;
	}

	public Observateur getObsSaisie() {
		return obsSaisie;
	}
}

