package vue;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;

import controleur.ControleurVues;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



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
		this.setLayout(new BorderLayout());
		this.add(getJpGrille(), BorderLayout.CENTER);
		JPanel panelTemp = new JPanel() ;
		panelTemp.setLayout(new FlowLayout()) ;
		panelTemp.add(getJbTricher()) ;
		this.add(panelTemp, BorderLayout.SOUTH);
	}

	/**
	 * This method initializes jbTricher	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJbTricher() {
		if (jbTricher == null) {
			jbTricher = new JButton();
//			jbTricher.setBounds(new Rectangle(75, 262, 151, 31));
			jbTricher.setSize(150, 30) ;
			jbTricher.setText("Tricher");
			jbTricher.setVisible(ctrlV.getCtrlM().isTricheBouton()) ;
			jbTricher.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Bouton Tricher pressé");
				}
			}) ;
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
		jpGrille.add(ctrlV.getPanelGrilleDeJeu(), null);
		return jpGrille;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
