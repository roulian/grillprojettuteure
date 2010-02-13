package controleur;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
		vuePrincipal.setVisible(true);
		panelAcceuil = new PanelAccueil(this);
		panelAutoGenerer = new PanelAutoGénérer(this);
		panelGeneration = new PanelGeneration(this);
		panelChargement = new PanelChargement(this);
		panelJeu = new PanelJeu(this);
		panelGrilleDeJeu = new PanelGrilleDeJeu(this) ;
		
		switchPanel(panelAcceuil) ;
	}

	public int getTailleGrille() {
		return tailleGrille;
	}
	
	public ControleurM getCtrlM(){
		return ctrlM ;
	}
	
	public void switchPanel(JPanel pPanel){
		vuePrincipal.remove(vuePrincipal.getCurrentPanel()) ;
		vuePrincipal.add(pPanel) ;
	}
	
	public void refreshGrilleDeJeu(){
		for (int i = 0; i < tailleGrille; i++) {
			for (int j = 0; j < tailleGrille; j++) {
				//panelGrilleDeJeu.add(new JLabel(""+getCtrlM().getLaGrille().getCase(i,j).getBatiment().getHauteur()));
			}
		}
	}
	
	public void refreshGrilleDeJeu(int abscisse, int ordonnee){
//		mmmh
	}

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
		return panelGrilleDeJeu;
	}

	public PanelJeu getPanelJeu() {
		return panelJeu;
	}

	public VuePrincipale getVuePrincipal() {
		return vuePrincipal;
	}
	
	
}
