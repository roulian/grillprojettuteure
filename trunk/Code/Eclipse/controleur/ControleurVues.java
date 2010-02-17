package controleur;

import javax.swing.JLabel;
import javax.swing.JPanel;

import src.Grille;
import vue.DifficulteGeneration;
import vue.PanelAccueil;
import vue.PanelAutoGénérer;
import vue.PanelChargement;
import vue.PanelGeneration;
import vue.PanelGrilleDeJeu;
import vue.PanelJeu;
import vue.VuePrincipale;

public class ControleurVues {
	private int tailleGrille ;
	private ControleurM ctrlM ;
	private VuePrincipale vuePrincipal ;
	private PanelAccueil panelAcceuil ;
	private PanelAutoGénérer panelAutoGenerer ;
	private PanelGeneration panelGeneration ;
	private PanelChargement panelChargement ;
	private PanelJeu panelJeu ;
	private PanelGrilleDeJeu panelGrilleDeJeu ;
	
	public ControleurVues(ControleurM pCtrlM) {
		ctrlM = pCtrlM ;
		tailleGrille = ctrlM.getTailleGrille() ;
		vuePrincipal = new VuePrincipale(this) ;
		vuePrincipal.setLocationRelativeTo(null) ;
		vuePrincipal.setVisible(true);
		panelAcceuil = new PanelAccueil(this);
		panelAutoGenerer = new PanelAutoGénérer(this);
		panelGeneration = new PanelGeneration(this);
		panelChargement = new PanelChargement(this);
		
		panelJeu = new PanelJeu(this);
		
		switchPanel(panelAcceuil) ;
	}

//*********** Accesseur Généraux ***************/
	public int getTailleGrille() {
		return tailleGrille;
	}
	
	public ControleurM getCtrlM(){
		return ctrlM ;
	}
	
//*********** Gestion VUE PRINCIPAL ***************/	
	public void switchPanel(JPanel pPanel){
		if (pPanel == panelGeneration || pPanel == panelGrilleDeJeu)
			vuePrincipal.setSize(600, 400) ;
		else
			vuePrincipal.setSize(300, 400) ;
		vuePrincipal.setContentPane(pPanel) ;
		vuePrincipal.refreshMenu();
		vuePrincipal.validate();
	}

//*********** Partie Grille de jeu ***************/
	public void refreshGrilleDeJeu(){
		panelGrilleDeJeu.refreshGrilleBuffer() ;
	}
	
//	public void refreshGrilleDeJeu(int abscisse, int ordonnee){
//		panelGrilleDeJeu.refreshGrilleBuffer(abscisse, ordonnee) ;
//	}

	
//*********** Accesseur des PANELS ***************/
	public PanelAccueil getPanelAcceuil() {
		return panelAcceuil;
	}

	public PanelAutoGénérer getPanelAutoGenerer() {
		return panelAutoGenerer;
	}

	public PanelChargement getPanelChargement() {
		return panelChargement;
	}

	public PanelGeneration getPanelGeneration() {
		return panelGeneration;
	}

	public PanelGrilleDeJeu getPanelGrilleDeJeu() {
		if (panelGrilleDeJeu==null) ;
			panelGrilleDeJeu = new PanelGrilleDeJeu(this) ;
		
		return panelGrilleDeJeu;
	}

	public PanelJeu getPanelJeu() {
		return panelJeu;
	}

	public VuePrincipale getVuePrincipal() {
		return vuePrincipal;
	}

	
}
