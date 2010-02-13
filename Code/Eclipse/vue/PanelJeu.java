package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;

import controleur.ControleurVues;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Dimension;



public class PanelJeu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jbTricher = null;
	private JPanel jpGrille = null;
	private ControleurVues ctrlV ;
	
	/**
	 * This is the default constructor
	 */
	public PanelJeu(ControleurVues pCtrlV) {
		super();
		ctrlV = pCtrlV ;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 300);
		this.setLayout(null);
		this.add(getJbTricher(), null);
		this.add(getJpGrille(), null);
	}

	/**
	 * This method initializes jbTricher	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbTricher() {
		if (jbTricher == null) {
			jbTricher = new JButton();
			jbTricher.setBounds(new Rectangle(75, 262, 151, 31));
			jbTricher.setText("Tricher");
		}
		return jbTricher;
	}

	/**
	 * This method initializes jpGrille	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpGrille() {
		if (jpGrille == null) {
			jpGrille = new JPanel();
			jpGrille.setLayout(new GridBagLayout());
			jpGrille.setBounds(new Rectangle(25, 10, 250, 250));
		}
		return jpGrille;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
