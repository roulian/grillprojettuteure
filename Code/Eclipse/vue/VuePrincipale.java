package vue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class VuePrincipale extends JFrame
{
	JMenu menu ;
	
	public VuePrincipale(){
		super("GRILL") ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,400,500);

		PanelAccueil pouet = new PanelAccueil();
		add(pouet.getJpanel());
		
//		menu = new JMenu() ;
//		add(menu);
		setVisible(true);
	}
}
