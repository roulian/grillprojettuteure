package vue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VuePrincipale extends JFrame
{
	JMenuBar menu ;
	
	public VuePrincipale(){
		super("GRILL") ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,400,500);
		
		//intégration des onglet (menu)
		menu = new JMenuBar();
		setJMenuBar(menu);
		JMenu menuTemp ;
		JMenuItem itemTemp ;
		menuTemp = new JMenu("Nouveau");
		menu.add(menuTemp);
		itemTemp = new JMenuItem("Nouveau");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("Charger");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("Retour Menu");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("Quitter");
		menuTemp.add(itemTemp);
		

		/*"aide visuelle trouver"
		"aide visuelle erreur"
		"mode triche"
		
		"regle"
		"a propot" */

		menuTemp = new JMenu("Aide");
		menu.add(menuTemp);
		itemTemp = new JMenuItem("aide visuelle trouver");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("aide visuelle erreur");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("mode triche");
		menuTemp.add(itemTemp);
			
		menuTemp = new JMenu("?");
		menu.add(menuTemp);
		itemTemp = new JMenuItem("regle");
		menuTemp.add(itemTemp);
		itemTemp = new JMenuItem("a propot");
		menuTemp.add(itemTemp);
		
		panelAccueilV2 pouet3 = new panelAccueilV2();
		panelAccueilV2 pouet4 = new panelAccueilV2();
		PanelAccueil pouet = new PanelAccueil();
		add(pouet4);
		
//		menu = new JMenu() ;
//		add(menu);
		setVisible(true);
	}
}
