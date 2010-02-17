package vue;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controleur.ControleurVues;

public class DifficulteGeneration extends JDialog {
	private JButton jbOk, jbAnnuler;
	private JPanel jpSud, jpCentre;
	private ControleurVues ctrlV;
	private JComboBox jcDifficulté = null;
	private Vector<String> difficulte;
	
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
		
		jpCentre = new JPanel();
		jpCentre.setLayout(new FlowLayout());
			this.jpCentre.add(new JLabel ("Difficulté"));
			this.jcDifficulté = new JComboBox(difficulte);
			this.jpCentre.add(jcDifficulté);
					
		this.add(jpCentre,BorderLayout.CENTER);		
		
		jpSud = new JPanel ();
		jpSud.setLayout(new GridLayout(2,1));
			this.jbOk = new JButton ("OK");
			this.jpSud.add(jbOk);
			this.jbAnnuler = new JButton ("Annuler");
			this.jpSud.add (jbAnnuler);
		
		this.add(jpSud, BorderLayout.SOUTH);
		
		this.pack();
	
	}

	public ControleurVues getCtrlV() {
		return ctrlV;
	}

	public Vector<String> getDifficulte() {
		return difficulte;
	}

	public JButton getJbAnnuler() {
		return jbAnnuler;
	}

	public JButton getJbOk() {
		return jbOk;
	}

	public JComboBox getJcDifficulté() {
		return jcDifficulté;
	}

	public JPanel getJpCentre() {
		return jpCentre;
	}

	public JPanel getJpSud() {
		return jpSud;
	}
}
