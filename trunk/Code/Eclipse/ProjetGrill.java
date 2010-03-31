import javax.swing.UIManager;

import controleur.ControleurM;

/**
 * Classe main du projet Tuteuré Grill IUT Blagnac 2009-2010
 * @author Andres Gomez Thomas, Thibault Brad, Julien Escudery, Jérémie Lapalu
 * @version 1.0
 */
public class ProjetGrill {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		}
		catch (Exception e) {
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		System.out.println("lancement du PROJET TUTEURE");
		
		new ControleurM(false);
	}
}
