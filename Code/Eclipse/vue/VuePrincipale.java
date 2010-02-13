package vue;

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
	private JPanel currentPanel = null ;
	private ControleurVues ctrlV; 
	
	public VuePrincipale(ControleurVues pCtrl){
		super("GRILL") ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ctrlV = pCtrl ;
		setBounds(0,0,300,400);
		
		//intégration des onglet (menu)
		menu = new JMenuBar();
		setJMenuBar(menu);
		JMenu menuTemp ;
		JMenuItem itemTemp ;
		//premier menu
		menuTemp = new JMenu("Ficher");
		menu.add(menuTemp);
		//premier sous menu
		itemTemp = new JMenuItem("Nouveau");
		menuTemp.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelGeneration()) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Charger");
		menuTemp.add(itemTemp);
		//autre sous menu
		itemTemp = new JMenuItem("Retour Menu");
		menuTemp.add(itemTemp);
		//autre sous menu
		itemTemp = new JMenuItem("Quitter");
		menuTemp.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.exit(0);
			}
		});
		
		menuTemp = new JMenu("Aide");
		menu.add(menuTemp);
		itemTemp = new JMenuItem("Aide visuelle trouver");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("Aide visuelle erreur");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("Mode triche");
		menuTemp.add(itemTemp);
			
		menuTemp = new JMenu("?");
		menu.add(menuTemp);
		itemTemp = new JMenuItem("Règles");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("A propos");
		menuTemp.add(itemTemp);
		// fin menu
		
		currentPanel = new PanelAccueil(ctrlV) ;
		add(currentPanel);		
	}
	
	void rafraichirVue(JPanel pPanel){
		
		//changement du panel principal
		VuePrincipale.this.remove(currentPanel);
		currentPanel = pPanel;
		VuePrincipale.this.add(pPanel);
		VuePrincipale.this.validate();
	}

	public ControleurVues getCtrl() {
		return ctrlV;
	}

	public JPanel getCurrentPanel() {
		return currentPanel;
	}
}
