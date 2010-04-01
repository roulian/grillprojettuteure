package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controleur.ControleurVues;

public class DifficulteGeneration extends JDialog 
{
	private JButton jbOk, jbAnnuler;
	private JLabel jlDifficulte;
	private JPanel jpSud, jpCentre, jpDifficulte, jpBoutton;
	private ControleurVues ctrlV;
	private JComboBox jcDifficulte = null;
	private Vector<String> difficulte;
	
	/**
	 * Constructeur 
	 * 
	 * @param modale
	 * @param _t
	 * @param pCtrlVues
	 * 
	 * @author julien
	 */
	public DifficulteGeneration  (JFrame modale, String _t, ControleurVues pCtrlVues)
	{
		super(modale,_t,true);
		
		//Sur quoi la fenetre est modale
		this.setLocationRelativeTo (modale);
		
		this.ctrlV = pCtrlVues;
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		//Choix des difficultés insérées dans le vector
		difficulte = new Vector<String>();
		difficulte.add("Facile");
		difficulte.add("Moyen");
		difficulte.add("Difficile");
		
		jpCentre = new JPanel ();
		jpCentre.setLayout(new GridLayout (3,1));
			this.jpCentre.add(new JLabel (""));
			jpDifficulte = new JPanel();
			jpDifficulte.setLayout(new FlowLayout());
				this.jlDifficulte = new JLabel ("Choix de la difficulté : ");
				this.jpDifficulte.add(jlDifficulte);
				this.jcDifficulte = new JComboBox(difficulte);
				this.jpDifficulte.add(jcDifficulte);
			this.jpCentre.add(this.jpDifficulte);
			this.jpCentre.add(new JLabel (""));
				
		this.add(jpCentre,BorderLayout.CENTER);			
		
		jpSud = new JPanel ();
		jpSud.setLayout(new GridLayout(3,1));
			this.jpSud.add(new JLabel (""));
			jpBoutton = new JPanel ();
			jpBoutton.setLayout(new GridLayout(1,5));
				this.jpBoutton.add(new JLabel ("  "));
				this.jbOk = new JButton ("OK");
				this.jpBoutton.add(jbOk);
				this.jpBoutton.add(new JLabel ("  "));
				this.jbAnnuler = new JButton ("Annuler");
				this.jpBoutton.add (jbAnnuler);
				this.jpBoutton.add(new JLabel ("  "));
			this.jpSud.add(jpBoutton);
			this.jpSud.add(new JLabel (""));
		this.add(jpSud, BorderLayout.SOUTH);	
		
		jbAnnuler.addActionListener(new java.awt.event.ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				DifficulteGeneration.this.setVisible(false);
			}
		});
		
		this.addWindowListener(new java.awt.event.WindowListener()
		{
			public void windowClosing(WindowEvent arg0) 
			{
				DifficulteGeneration.this.setVisible(false);
			}

			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.pack();
	}

	/**
	 * Retourne le controleur des Vues
	 * @return ControleurVues
	 */
	public ControleurVues getCtrlV() {
		return ctrlV;
	}
	
	/**
	 * Retourne le vector des difficultés 
	 * @return Vector<String>
	 */
	public Vector<String> getDifficulte() 
	{
		return difficulte;
	}

	/**
	 * Retourne l'élément : boutton annuler
	 * @return JButton
	 */
	public JButton getJbAnnuler() 
	{
		return jbAnnuler;
	}

	/**
	 * Retourne l'élément : boutton ok
	 * @return JButton
	 */
	public JButton getJbOk() 
	{
		jbOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				//Pour sélectionner la valeure du ComboBox:
				//DifficulteGeneration.this.getJcDifficulté().getSelectedItem();
				System.out.println("A faire");
			}
		});
		return jbOk;
	}

	/**
	 * Retourne la comboBox des difficultées
	 * @return JComboBox
	 */
	public JComboBox getJcDifficulte() {
		return jcDifficulte;
	}

	/**
	 * Retourne le panel du centre
	 * @return JPanel
	 */
	public JPanel getJpCentre() {
		return jpCentre;
	}

	/**
	 * Retourne le panel du sud
	 * @return JPanel
	 */
	public JPanel getJpSud() {
		return jpSud;
	}
}
