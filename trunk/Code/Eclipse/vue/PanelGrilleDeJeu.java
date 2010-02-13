package vue;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControleurVues;

import src.Grille;

import java.awt.GridLayout;
import java.util.Vector;

public class PanelGrilleDeJeu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel[][] affGrille = null ;
	private ControleurVues ctrlV; 
	/**
	 * This is the default constructor
	 */
	public PanelGrilleDeJeu(ControleurVues pCtrlV) {
		super();
		ctrlV = pCtrlV ;
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		this.setLayout(gridLayout);
		
	}

	public ControleurVues getCtrlV() {
		return ctrlV;
	}
	
}

