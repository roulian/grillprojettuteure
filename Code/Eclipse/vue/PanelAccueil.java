package vue;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import controleur.ControleurVues;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelAccueil extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -248764331632761862L;
	private JButton jbNouveau = null;
	private JButton jbCharger = null;
	private JButton jbGénérer = null;
	private ControleurVues ctrlV; 
	/**
	 * This is the default constructor
	 */
	public PanelAccueil(ControleurVues pCtrlV) {
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
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 0;
		gridBagConstraints5.ipadx = 10;
		gridBagConstraints5.ipady = 8;
		gridBagConstraints5.insets = new Insets(0, 0, 0, 0);
		gridBagConstraints5.anchor = GridBagConstraints.SOUTH;
		gridBagConstraints5.gridy = 6;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 0;
		gridBagConstraints2.insets = new Insets(0, 0, 50, 0);
		gridBagConstraints2.ipady = 8;
		gridBagConstraints2.ipadx = 10;
		gridBagConstraints2.gridy = 3;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.insets = new Insets(0, 0, 50, 0);
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 8;
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		gridBagConstraints.gridy = 0;
		this.setSize(268, 265);
		this.setLayout(new GridBagLayout());
		this.add(getJbNouveau(), gridBagConstraints);
		this.add(getJbCharger(), gridBagConstraints2);
		this.add(getJbGénérer(), gridBagConstraints5);
		
		// test Gif
//		this.add(new JLabel(new ImageIcon("images/move.gif"))) ;
		
		jbNouveau.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.switchPanel(ctrlV.getPanelAutoGenerer()) ;
			}
		});
		jbGénérer.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.switchPanel(ctrlV.getPanelGeneration()) ;
			}
		});
		jbCharger.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.switchPanel(ctrlV.getPanelChargement()) ;
			}
		});
		
		
	}

	/**
	 * This method initializes jbNouveau	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbNouveau() {
		if (jbNouveau == null) {
			jbNouveau = new JButton();
			jbNouveau.setText("Nouveau");
		}
		return jbNouveau;
	}

	/**
	 * This method initializes jbCharger	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbCharger() {
		if (jbCharger == null) {
			jbCharger = new JButton();
			jbCharger.setText("Charger");
		}
		return jbCharger;
	}

	/**
	 * This method initializes jbGénérer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbGénérer() {
		if (jbGénérer == null) {
			jbGénérer = new JButton();
			jbGénérer.setText("Générer");
		}
		return jbGénérer;
	}

}  //  @jve:decl-index=0:visual-constraint="10,137"
