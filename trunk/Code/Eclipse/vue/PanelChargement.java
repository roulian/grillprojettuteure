package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Rectangle;

public class PanelChargement extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jbCharger = null;
	private JPanel jpGrille = null;
	private JList jlPartie1 = null;
	private JScrollPane js;
	private JButton jbRetour = null;
	/**
	 * This is the default constructor
	 */
	public PanelChargement() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(null);
		this.setSize(347, 274);
		this.add(js, null);
		this.add(getJpGrille(), null);
		this.add(getJbCharger(), null);
		this.add(getJbRetour(), null);
		this.add(js, null);
		this.add(js, null);
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
			jbCharger.setBounds(new Rectangle(140, 235, 80, 26));
			jbCharger.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jbCharger;
	}

	/**
	 * This method initializes jpGrille	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpGrille() {
		if (jpGrille == null) {
			jpGrille = new JPanel();
			jpGrille.setLayout(null);
			jpGrille.setBounds(new Rectangle(130, 11, 204, 207));
		}
		return jpGrille;
	}

	/**
	 * This method initializes jlPartie1	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJlPartie1() {
		JScrollPane js;
       // JScrollPane pour les ascenseurs de la JList.
       js = new JScrollPane ();
       js.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

       js.setBounds(new Rectangle(10, 10, 104, 252));
		if (jlPartie1 == null) {
			jlPartie1 = new JList();
			js.setViewportView(getJlPartie1());
		}
		return jlPartie1;
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
			jbRetour.setBounds(new Rectangle(251, 235, 80, 26));
			jbRetour.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jbRetour;
	}

}  //  @jve:decl-index=0:visual-constraint="25,29"
