package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import controleur.ControleurVues;

import java.awt.Insets;
import java.awt.GridLayout;

public class PanelAutoGénérer extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8924003417133315838L;
	private ControleurVues ctrlV ;
	private JButton jbCommencer = null;
	private JButton jbRetour = null;
	private JLabel jlTaille = null;
	private JLabel jlDifficulté = null;
	private JComboBox jcTaille = null;
	private JComboBox jcDifficulté = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	private JPanel jPanel5 = null;
	/**
	 * This is the default constructor
	 */
	public PanelAutoGénérer(ControleurVues pCtrlV) {
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
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(3);
		gridLayout.setColumns(2);
		jlDifficulté = new JLabel();
		jlDifficulté.setText("Difficulté");
		jlTaille = new JLabel();
		jlTaille.setText("Taille");
		this.setLayout(gridLayout);
		this.setSize(343, 245);
		this.add(getJPanel5(), null);
		this.add(getJPanel3(), null);
		this.add(getJPanel4(), null);
		this.add(getJPanel2(), null);
		this.add(getJPanel1(), null);
		this.add(getJPanel(), null);
	}

	/**
	 * This method initializes jbCommencer	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbCommencer() {
		if (jbCommencer == null) {
			jbCommencer = new JButton();
			jbCommencer.setText("Commencer");
			jbCommencer.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrlV.getCtrlM().finirPartie() ;
					int taille = (Integer) jcTaille.getSelectedItem() ;
					ctrlV.getCtrlM().commencerPartie(taille,1) ;
					ctrlV.switchPanel(ctrlV.getPanelJeu()) ;
				}
			});
		}
		return jbCommencer;
	}

	/**
	 * This method initializes jbRetour	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbRetour() {
		if (jbRetour == null) {
			jbRetour = new JButton();
			jbRetour.setText("Retour");
			jbRetour.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrlV.switchPanel(ctrlV.getPanelAcceuil()) ;
				}
			});
		}
		return jbRetour;
	}

	/**
	 * This method initializes jcTaille	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcTaille() {
		Vector<Integer> taille;
		//Choix des réponses
		taille = new Vector<Integer>();
		taille.add(4);
		taille.add(5);
		taille.add(6);
		
		if (jcTaille == null) {
			jcTaille = new JComboBox(taille);
		}
		
		return jcTaille;
	}

	/**
	 * This method initializes jcDifficulté	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJcDifficulté() {
		Vector<String> difficulte;
		
		//Choix des réponses
		difficulte = new Vector<String>();
		difficulte.add("Facile");
		difficulte.add("Moyen");
		difficulte.add("Difficile");
		
		if (jcDifficulté == null) {
			jcDifficulté = new JComboBox(difficulte);
		}
		
		return jcDifficulté;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJbRetour(), gridBagConstraints);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(getJbCommencer(), gridBagConstraints1);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridx = 0;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getJcDifficulté(), gridBagConstraints2);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridx = 0;
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GridBagLayout());
			jPanel3.add(getJcTaille(), gridBagConstraints3);
		}
		return jPanel3;
	}

	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 0;
			jPanel4 = new JPanel();
			jPanel4.setLayout(new GridBagLayout());
			jPanel4.add(jlDifficulté, gridBagConstraints4);
		}
		return jPanel4;
	}

	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 0;
			jPanel5 = new JPanel();
			jPanel5.setLayout(new GridBagLayout());
			jPanel5.add(jlTaille, gridBagConstraints5);
		}
		return jPanel5;
	}

}  //  @jve:decl-index=0:visual-constraint="109,24"
