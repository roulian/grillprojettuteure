package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Insets;

public class PanelAutoGénérer extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8924003417133315838L;
	private JButton jbCommencer = null;
	private JButton jbRetour = null;
	private JLabel jlTaille = null;
	private JLabel jlDifficulté = null;
	private JComboBox jcTaille = null;
	private JComboBox jcDifficulté = null;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public PanelAutoGénérer() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
		gridBagConstraints12.gridx = 0;
		gridBagConstraints12.gridy = 2;
		jLabel = new JLabel();
		jLabel.setText("                      ");
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints11.gridy = 1;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.insets = new Insets(0, 0, 80, 0);
		gridBagConstraints11.gridx = 2;
		GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
		gridBagConstraints10.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints10.gridy = 0;
		gridBagConstraints10.weightx = 1.0;
		gridBagConstraints10.insets = new Insets(0, 0, 80, 0);
		gridBagConstraints10.ipadx = 30;
		gridBagConstraints10.ipady = 0;
		gridBagConstraints10.gridx = 2;
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 1;
		gridBagConstraints7.insets = new Insets(0, 0, 80, 0);
		gridBagConstraints7.gridy = 1;
		jlDifficulté = new JLabel();
		jlDifficulté.setText("Difficulté");
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 1;
		gridBagConstraints6.insets = new Insets(0, 0, 80, 0);
		gridBagConstraints6.ipadx = 20;
		gridBagConstraints6.ipady = 0;
		gridBagConstraints6.gridy = 0;
		jlTaille = new JLabel();
		jlTaille.setText("Taille");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 2;
		gridBagConstraints1.gridy = 2;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		this.setSize(426, 343);
		this.setLayout(new GridBagLayout());
		this.add(getJbCommencer(), gridBagConstraints);
		this.add(getJbRetour(), gridBagConstraints1);
		this.add(jlTaille, gridBagConstraints6);
		this.add(jlDifficulté, gridBagConstraints7);
		this.add(getJcTaille(), gridBagConstraints10);
		this.add(getJcDifficulté(), gridBagConstraints11);
		this.add(jLabel, gridBagConstraints12);
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
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
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

}  //  @jve:decl-index=0:visual-constraint="109,-77"
