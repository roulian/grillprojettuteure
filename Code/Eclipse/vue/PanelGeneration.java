package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

import src.Grille;
import src.Observateur;

import controleur.ControleurVues;

import java.awt.Rectangle;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;

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
	private JPanel jPanel = null;
	private ControleurVues ctrlV;
	private DifficulteGeneration difGen;
	private JComboBox jCTaille = null;
	private JButton jbOk = null ;
	private PanelGrilleDeJeu jPanelSasieObs = null;
	/**
	 * This is the default constructor
	 */
	public PanelGeneration(ControleurVues contr) {
		super() ;
		this.ctrlV = contr;
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
		if (jpGrill == null) 
		{
			jpGrill = new JPanel();
			jpGrill.setLayout(new GridBagLayout());
			int tempTaille = (Integer)(jCTaille.getSelectedItem()) ;
			jPanelSasieObs = new PanelGrilleDeJeu(tempTaille,new Observateur(tempTaille),true) ;
			jpGrill.add(jPanelSasieObs);
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
					System.out.println("actionPerformed()");
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
					difGen = new DifficulteGeneration(ctrlV.getVuePrincipal(),"difficulté", ctrlV);
					difGen.setVisible(true);
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
					System.out.println("actionPerformed ON Bouton Sauvegarder");
					ctrlV.getCtrlM().sauvegarderGrille("test", new Grille((Integer)(jCTaille.getSelectedItem())), jPanelSasieObs.getObsSaisie(),(Integer)(jCTaille.getSelectedItem())) ;
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
					ctrlV.switchPanel(ctrlV.getPanelAcceuil()) ;
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
		}
		return jlTaille;
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
			jPanel.add(getJCTaille(), null);
			jbOk = new JButton() ;
			jbOk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					PanelGeneration.this.remove(jpGrill) ;
					jpGrill = null ;
					jpGrill = getJpGrill() ;
					PanelGeneration.this.add(jpGrill) ;
					validate() ;
				}
			}) ;
			jbOk.setBounds(new Rectangle(120, 49, 70, 25)) ;
			jbOk.setText("ok") ;
			jPanel.add(jbOk) ;
		}
		return jPanel;
	}

	/**
	 * This method initializes jCTaille	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJCTaille() {
		if (jCTaille == null) {
			Vector<Integer> taille;
			//Choix des réponses
			taille = new Vector<Integer>();
			taille.add(4);
			taille.add(5);
			taille.add(6);
			jCTaille = new JComboBox(taille);
			jCTaille.setBounds(new Rectangle(60, 49, 43, 25));
		}
		
		return jCTaille;
	}

}  //  @jve:decl-index=0:visual-constraint="36,20"
