package vue;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAccueil extends JPanel
{
	private JPanel jpanel;
	private JButton jbNouveau, jbCharger, jbGenerer;
	
	public PanelAccueil ()
	{
		jpanel = new JPanel ();
		jpanel.setLayout(new GridLayout(3,8));
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jbNouveau = new JButton ("Nouveau");
			jpanel.add(jbNouveau);
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jbCharger = new JButton ("Charger");
			jpanel.add(jbCharger);
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());
			jbGenerer = new JButton ("Générer");
			jpanel.add(jbGenerer);
			jpanel.add(new JLabel ());
			jpanel.add(new JLabel ());		
	}

	public JPanel getJpanel() {
		return jpanel;
	}

	public JButton getJbNouveau() {
		return jbNouveau;
	}

	public JButton getJbCharger() {
		return jbCharger;
	}

	public JButton getJbGenerer() {
		return jbGenerer;
	}
}

