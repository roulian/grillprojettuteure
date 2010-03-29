package controleur;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControleurM.Dificulty;

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
	private ControleurM ctrlM ;
	private VuePrincipale vuePrincipal ;
	private PanelAccueil panelAcceuil = null ;
	private PanelAutoGénérer panelAutoGenerer = null ;
	private PanelGeneration panelGeneration = null ;
	private PanelChargement panelChargement = null ;
	private PanelJeu panelJeu = null ;
	private PanelGrilleDeJeu panelGrilleDeJeu = null ;
	private JPanel currentPanel = null ;
	
	public ControleurVues(ControleurM pCtrlM) {
		ctrlM = pCtrlM ;
		vuePrincipal = new VuePrincipale(this) ;
		vuePrincipal.setLocationRelativeTo(null) ;
		vuePrincipal.setVisible(true);
		
		switchPanel(getPanelAcceuil()) ;
	}

//*********** Accesseur Généraux ***************/
	public int getTailleGrille() {
		return ctrlM.getTailleGrille();
	}
	
	public ControleurM getCtrlM(){
		return ctrlM ;
	}
	
//*********** Gestion VUE PRINCIPAL ***************/	
	public void switchPanel(JPanel pPanel){	
		
		
		// on change le panel afficher
		if (pPanel == panelAcceuil){
			vuePrincipal.setSize(300, 400) ;
			reinitialisePanel() ;
			vuePrincipal.setContentPane(getPanelAcceuil());
		}
		if (pPanel == panelAutoGenerer){
			vuePrincipal.setSize(300, 400) ;
			reinitialisePanel() ;
			vuePrincipal.setContentPane(getPanelAutoGenerer());
		}
		if (pPanel == panelGeneration){
			vuePrincipal.setSize(600, 400) ;
			reinitialisePanel() ;
			vuePrincipal.setContentPane(getPanelGeneration());
		}
		if (pPanel == panelGrilleDeJeu){
			vuePrincipal.setSize(300, 400) ;
			reinitialisePanel() ;
			vuePrincipal.setContentPane(getPanelGrilleDeJeu());
		}
		if (pPanel == panelChargement){
			vuePrincipal.setSize(600, 400) ;
			reinitialisePanel() ;
			vuePrincipal.setContentPane(getPanelChargement());
		}
		if (pPanel == panelJeu){
			vuePrincipal.setSize(300, 400) ;
			reinitialisePanel() ;
			vuePrincipal.setContentPane(getPanelJeu());
		}
		currentPanel = pPanel ;
		vuePrincipal.refreshMenu();
		vuePrincipal.validate();
	}
	
	public void reinitialisePanel(){
		panelAcceuil = null ;
		panelAutoGenerer = null ;
		panelGeneration = null ;
		panelGrilleDeJeu = null ;
		panelChargement = null ;
		panelJeu = null ;
	}
	
	public void reinitialisePanelGrilleDeJeu(){
		panelGrilleDeJeu = null ;
	}
	
	public void reinitialisePanelJeu(){
		panelJeu = null ;
	}

//*********** Partie Grille de jeu ***************/
	public void refreshGrilleDeJeu(){
		if(ctrlM.isAideTrouver()&&ctrlM.getBatAideTrouver()!=0){
			redlyGrilleDeJeu(ctrlM.getBatAideTrouver()) ;
		}
		else{
			if(ctrlM.isAideErreur()){
				redlyGrilleDeJeu() ;
			}
			else{
				panelGrilleDeJeu.refreshGrilleDisplay() ;
			}
		}
	}
	
	public void refreshGrilleDeJeu(int pAbscisse, int pOrdonnee, String pImBat){
		panelGrilleDeJeu.refreshGrilleDisplay(pAbscisse, pOrdonnee, pImBat) ;
	}
	
	private void redlyGrilleDeJeu(int pBat){
		panelGrilleDeJeu.redlyGrilleDisplay(pBat) ;
	}
	
	private void redlyGrilleDeJeu(){
		panelGrilleDeJeu.redlyGrilleDisplay() ;
	}

	
//*********** Accesseur des PANELS ***************/
	public PanelAccueil getPanelAcceuil() {
		if(panelAcceuil==null)
			panelAcceuil = new PanelAccueil(this) ;
		return panelAcceuil;
	}

	public PanelAutoGénérer getPanelAutoGenerer() {
		if(panelAutoGenerer==null)
			panelAutoGenerer = new PanelAutoGénérer(this) ;
		return panelAutoGenerer;
	}

	public PanelChargement getPanelChargement() {
		if(panelChargement==null)
			panelChargement = new PanelChargement(this) ; 
		return panelChargement;
	}

	public PanelGeneration getPanelGeneration() {
		if(panelGeneration==null)
			panelGeneration = new PanelGeneration(this) ;
		return panelGeneration;
	}

	public PanelGrilleDeJeu getPanelGrilleDeJeu() {
		if (panelGrilleDeJeu==null) ;
			panelGrilleDeJeu = new PanelGrilleDeJeu(this) ;
		return panelGrilleDeJeu;
	}

	public PanelJeu getPanelJeu() {
		if (panelJeu==null)
			panelJeu = new PanelJeu(this) ;
		return panelJeu;
	}

	public VuePrincipale getVuePrincipal() {
		if(vuePrincipal==null)
			vuePrincipal = new VuePrincipale(this) ;
		return vuePrincipal;
	}
	
	public void getVictoire(){
		JDialog victoire = new JDialog(vuePrincipal) ;
		JPanel contentPane = new JPanel();
		victoire.setContentPane(contentPane) ;
		victoire.setLayout(new BorderLayout()) ;
		victoire.setSize(300,150) ;
		victoire.setModal(true) ;
		victoire.setLocationRelativeTo(vuePrincipal) ;
		contentPane.add(new JLabel("  "),BorderLayout.NORTH) ;
		contentPane.add(new JLabel("  "),BorderLayout.SOUTH) ;
		contentPane.add(new JLabel("         "),BorderLayout.WEST) ;
		contentPane.add(new JLabel("         "),BorderLayout.EAST) ;
		victoire.setTitle("Victoire") ;
		
		if(ctrlM.getDifficulte()==Dificulty.FACILE){
			contentPane.add(new JLabel("Félicitation vous avez complété la grille !"),BorderLayout.CENTER) ;
			contentPane.setBorder(BorderFactory.createEtchedBorder()) ;
		}
		if(ctrlM.getDifficulte()==Dificulty.FACILE){
			contentPane.add(new JLabel("Félicitation vous avez complété la grille !"),BorderLayout.CENTER) ;
			contentPane.setBorder(BorderFactory.createEtchedBorder()) ;
		}
		if(ctrlM.getDifficulte()==Dificulty.FACILE){
			contentPane.add(new JLabel("Félicitation vous avez complété la grille !"),BorderLayout.CENTER) ;
			contentPane.setBorder(BorderFactory.createEtchedBorder()) ;
		}
		
		victoire.setVisible(true) ;
	}
}
