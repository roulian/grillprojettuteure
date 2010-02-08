package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelAutoGénérerV2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jbCommencer = null;
	private JButton jbRetour = null;
	private JLabel jlTaille = null;
	private JLabel jlDifficulté = null;
	private JTextField jtTaille = null;
	private JTextField jtDifficulté = null;

	/**
	 * This is the default constructor
	 */
	public PanelAutoGénérerV2() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
		gridBagConstraints9.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints9.gridy = 1;
		gridBagConstraints9.weightx = 1.0;
		gridBagConstraints9.gridx = 1;
		GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
		gridBagConstraints8.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints8.gridy = 0;
		gridBagConstraints8.weightx = 1.0;
		gridBagConstraints8.gridx = 1;
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 0;
		gridBagConstraints7.gridy = 1;
		jlDifficulté = new JLabel();
		jlDifficulté.setText("Difficulté");
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 0;
		gridBagConstraints6.gridy = 0;
		jlTaille = new JLabel();
		jlTaille.setText("Taille");
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.gridy = 2;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		this.setSize(250, 245);
		this.setLayout(new GridBagLayout());
		this.add(getJbCommencer(), gridBagConstraints);
		this.add(getJbRetour(), gridBagConstraints1);
		this.add(jlTaille, gridBagConstraints6);
		this.add(jlDifficulté, gridBagConstraints7);
		this.add(getJtTaille(), gridBagConstraints8);
		this.add(getJtDifficulté(), gridBagConstraints9);
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
		}
		return jbRetour;
	}

	/**
	 * This method initializes jtTaille	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtTaille() {
		if (jtTaille == null) {
			jtTaille = new JTextField();
		}
		return jtTaille;
	}

	/**
	 * This method initializes jtDifficulté	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtDifficulté() {
		if (jtDifficulté == null) {
			jtDifficulté = new JTextField();
		}
		return jtDifficulté;
	}

}  //  @jve:decl-index=0:visual-constraint="109,20"
