package vue;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAutoGenerer 
{
	private JPanel jpanel;
	private JButton jbCommencer, jbRetour;
	private JLabel jlTaille, jlDifficulte;
	
	public PanelAutoGenerer() 
	{
		jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(2,1));
		
			jlTaille = new JLabel("Taille  ");
			
			jlDifficulte = new JLable("Difficulté  ");
	}
}
