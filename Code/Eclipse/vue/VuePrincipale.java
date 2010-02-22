package vue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.ControleurVues;

import vue.DialogRegles;

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
	private DialogRegles DialogRegles ;
	
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
				System.out.println("--> onglet : Nouvelle partie");
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelAutoGenerer()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Partie rapide (temp)");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : partie rapide");
				ctrlV.getCtrlM().commencerPartie(4,1) ;
				ctrlV.switchPanel(ctrlV.getPanelJeu()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Charger");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : Charger");
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelChargement()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Retour Menu");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : Retour Menu");
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelAcceuil()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Quitter");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : Quitter");
				System.exit(0);
			}
		});
		
		jAide = new JMenu("Aide");
		menu.add(jAide);
		itemTemp = new JMenuItem("Aide visuelle trouver");
		jAide.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.print("--> onglet : Aide visuelle trouver");
				ctrlV.getCtrlM().aideTrouver() ;
				System.out.println(" "+ctrlV.getCtrlM().isAideTrouver());
			}
		});
		itemTemp = new JMenuItem("Aide visuelle erreur");
		jAide.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.print("--> onglet : Aide visuelle erreur");
				ctrlV.getCtrlM().aideErreur() ;
				System.out.println(" "+ctrlV.getCtrlM().isAideErreur());
			}
		});
		itemTemp = new JMenuItem("Mode triche");
		jAide.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.print("--> onglet : Mode triche");
				ctrlV.getCtrlM().tricheBouton() ;
				System.out.println(" "+ctrlV.getCtrlM().isTricheBouton());
			}
		});
		itemTemp = new JMenuItem("Résolution grille");
		jAide.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.print("--> onglet : Resolution grille");
				ctrlV.getCtrlM().resolve() ;
				ctrlV.refreshGrilleDeJeu() ;
			}
		});
			
		jAutre = new JMenu("?");
		menu.add(jAutre);
		itemTemp = new JMenuItem("Règles");
		jAutre.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				DialogRegles = new DialogRegles((VuePrincipale.this));
			}
		});
		itemTemp = new JMenuItem("A propos");
		jAutre.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Jeux GRILL\nVersion 0.5\nCopyright © IUT Toulouse II Blagnac\nDéveloppé en Java", "A propos de Jeux GRILL", JOptionPane.INFORMATION_MESSAGE);
			}
		});
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
