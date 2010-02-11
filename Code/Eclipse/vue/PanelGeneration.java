package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

import controleur.ControleurVues;

import java.awt.Rectangle;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelGeneration extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jpGrill = null;
	private JPanel jpBoutton = null;
	private JButton jbVerif = null;
	private JButton jbGenSpont = null;
	private JButton jbSauvegarder = null;
	private JButton jbRetour = null;
	private JPanel jpTaille = null;
	private JPanel jpBout = null;
	private JLabel jlTaille = null;
	private JTextField jtTaille = null;
	private JPanel jPanel = null;
	private ControleurVues ctrl;
	/**
	 * This is the default constructor
	 */
	public PanelGeneration(ControleurVues contr) {
		super();
		this.ctrl = contr;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		gridLayout.setColumns(2);
		this.setLayout(gridLayout);
		this.setSize(385, 229);
		this.add(getJpBoutton(), null);
		this.add(getJpGrill(), null);
	}

	/**
	 * This method initializes jpGrill	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpGrill() {
		if (jpGrill == null) {
			jpGrill = new JPanel();
			jpGrill.setLayout(null);
		}
		return jpGrill;
	}

	/**
	 * This method initializes jpBoutton	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpBoutton() {
		if (jpBoutton == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(2);
			gridLayout1.setColumns(1);
			jpBoutton = new JPanel();
			jpBoutton.setLayout(gridLayout1);
			jpBoutton.add(getJpTaille(), null);
			jpBoutton.add(getJpBout(), null);
		}
		return jpBoutton;
	}

	/**
	 * This method initializes jbVerif	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbVerif() {
		if (jbVerif == null) {
			jbVerif = new JButton();
			jbVerif.setText("Vérification");
			jbVerif.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jbVerif;
	}

	/**
	 * This method initializes jbGenSpont	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbGenSpont() {
		if (jbGenSpont == null) {
			jbGenSpont = new JButton();
			jbGenSpont.setText("Génération \nspontanée");
			jbGenSpont.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jbGenSpont;
	}

	/**
	 * This method initializes jbSauvegarder	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbSauvegarder() {
		if (jbSauvegarder == null) {
			jbSauvegarder = new JButton();
			jbSauvegarder.setText("Sauvegarder");
			jbSauvegarder.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jbSauvegarder;
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
	 * This method initializes jpTaille	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpTaille() {
		if (jpTaille == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(1);
			gridLayout2.setColumns(2);
			jpTaille = new JPanel();
			jpTaille.setLayout(gridLayout2);
			jpTaille.add(getJPanel(), null);
		}
		return jpTaille;
	}

	/**
	 * This method initializes jpBout	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpBout() {
		if (jpBout == null) {
			GridLayout gridLayout3 = new GridLayout();
			gridLayout3.setRows(4);
			gridLayout3.setColumns(1);
			jpBout = new JPanel();
			jpBout.setLayout(gridLayout3);
			jpBout.add(getJbVerif(), null);
			jpBout.add(getJbGenSpont(), null);
			jpBout.add(getJbSauvegarder(), null);
			jpBout.add(getJbRetour(), null);
		}
		return jpBout;
	}

	/**
	 * This method initializes jlTaille	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJlTaille() {
		if (jlTaille == null) {
			jlTaille = new JLabel();
			jlTaille.setText("Taille");
			jlTaille.setBounds(new Rectangle(18, 51, 30, 16));
			jlTaille.setBackground(Color.white);
		}
		return jlTaille;
	}

	/**
	 * This method initializes jtTaille	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtTaille() {
		if (jtTaille == null) {
			jtTaille = new JTextField(15);
			jtTaille.setColumns(5);
			jtTaille.setBounds(new Rectangle(102, 51, 59, 20));
		}
		return jtTaille;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJlTaille(), null);
			jPanel.add(getJtTaille(), null);
		}
		return jPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="36,20"
