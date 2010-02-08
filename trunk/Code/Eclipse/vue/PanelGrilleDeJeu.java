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
		
		int taille = vue.getCtrl().getTailleGrille() ;
		
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				tempGrille[i][j] = new JLabel(""+vue.getCtrl().getCtrlM().getLaGrille().getCase(i,j).getBatiment().getHauteur());
				this.add(tempGrille[i][j]) ;
			}
		}
	}

	public VuePrincipale getVue() {
		return vue;
	}
	
}

