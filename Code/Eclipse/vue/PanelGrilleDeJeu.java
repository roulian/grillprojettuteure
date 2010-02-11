package vue;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import src.Grille;

import java.awt.GridLayout;
import java.util.Vector;

public class PanelGrilleDeJeu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel[][] tempGrille = null ;
	private VuePrincipale vue; 
	/**
	 * This is the default constructor
	 */
	public PanelGrilleDeJeu(VuePrincipale pVue) {
		super();
		vue = pVue ;
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		this.setLayout(gridLayout);
		
		vue.getCtrl().refreshGrilleDeJeu();
	}

	public VuePrincipale getVue() {
		return vue;
	}
	
}

