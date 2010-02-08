package vue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VuePrincipale extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8508924519782174481L;
	private JMenuBar menu ;
	private JPanel currentPanel ;
	
	public VuePrincipale(){
		super("GRILL") ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				rafraichirVue(new PanelAutoGénérer());
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
		
//		PanelAutoGénérerV2 pouet2 = new PanelAutoGénérerV2() ;
//		panelAccueilV2 pouet3 = new panelAccueilV2();
		
		currentPanel = new PanelAccueil(this);
//		currentPanel = new PanelAutoGénérerV2() ;
		add(currentPanel);
		
//		menu = new JMenu() ;
//		add(menu);
		//setVisible(true); //Effectué dans le main
	}
	
	void rafraichirVue(JPanel pPanel){
		
		//changement du panel principal
		VuePrincipale.this.remove(currentPanel);
		currentPanel = pPanel;
		VuePrincipale.this.add(pPanel);
		VuePrincipale.this.validate();
	}
}
