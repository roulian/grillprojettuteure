package vue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controleur.ControleurVues;

public class VuePrincipale extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8508924519782174481L;
	private JMenuBar menu ;
	private ControleurVues ctrlV;
	private JMenu jFicher ;
	private JMenu jAide ;
	private JMenu jAutre ;
	
	public VuePrincipale(ControleurVues pCtrl){
		super("GRILL") ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ctrlV = pCtrl ;
		setBounds(0,0,300,400);
		
		//intégration des onglet (menu)
		menu = new JMenuBar();
		setJMenuBar(menu);
		JMenuItem itemTemp ;
		//premier menu
		jFicher = new JMenu("Ficher");
		menu.add(jFicher);
		//premier sous menu
		itemTemp = new JMenuItem("Nouvelle partie");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelAutoGenerer()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Partie rapide (temp)");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.getCtrlM().commencerPartie(4,1) ;
				ctrlV.switchPanel(ctrlV.getPanelJeu()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Charger");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelChargement()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Retour Menu");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelAcceuil()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Quitter");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.exit(0);
			}
		});
		
		jAide = new JMenu("Aide");
		menu.add(jAide);
		itemTemp = new JMenuItem("Aide visuelle trouver");
		jAide.add(itemTemp);
		itemTemp = new JMenuItem("Aide visuelle erreur");
		jAide.add(itemTemp);
		itemTemp = new JMenuItem("Mode triche");
		jAide.add(itemTemp);
			
		jAutre = new JMenu("?");
		menu.add(jAutre);
		itemTemp = new JMenuItem("Règles");
		jAutre.add(itemTemp);
		itemTemp = new JMenuItem("A propos");
		jAutre.add(itemTemp);
		// fin menu
		
		
		
		JMenu debug = new JMenu("DEBUG");
		menu.add(debug);
		//premier sous menu
		itemTemp = new JMenuItem("Nouvelle partie");
		debug.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.getCtrlM().commencerPartie(4,1) ;
				ctrlV.switchPanel(ctrlV.getPanelGrilleDeJeu()) ;
			}
		});
	}
	
	public void refreshMenu(){
		if (ctrlV.getCtrlM().GetGameStart()){
			jAide.setEnabled(true) ;
		}
		else{
			jAide.setEnabled(false) ;
		}
	}

	public ControleurVues getCtrl() {
		return ctrlV;
	}
}

/* devenu inutil avec les contraintes MVC respecté
void rafraichirVue(JPanel pPanel){
	
	//changement du panel principal
	VuePrincipale.this.remove(currentPanel);
	currentPanel = pPanel;
	VuePrincipale.this.add(pPanel);
	VuePrincipale.this.validate();
}*/
