package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.ControleurVues;
import src.Grille;
import java.awt.GridLayout;


public class PanelGrilleDeJeu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel[][] affGrille ;
	private ControleurVues ctrlV; 
	/**
	 * This is the default constructor
	 */
	public PanelGrilleDeJeu(ControleurVues pCtrlV) {
		super();
		ctrlV = pCtrlV ;
		
		affGrille = new JLabel[ctrlV.getTailleGrille()][ctrlV.getTailleGrille()];
		refreshGrilleBuffer() ; 
		
		//gestion de la grille de jeu (pas observateur)
		GridLayout gridLayout = new GridLayout(ctrlV.getTailleGrille(),ctrlV.getTailleGrille());
		this.setLayout(gridLayout);
		int lenght = ctrlV.getTailleGrille() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				add(affGrille[i][j]);
			}
		}
		
	}
	
	public void refreshGrilleBuffer(){
		int lenght = ctrlV.getTailleGrille() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				affGrille[i][j] = new JLabel("test") ;
			}
		}
	}
	
	public ControleurVues getCtrlV() {
		return ctrlV;
	}
	
	public JLabel[][] getAffGrille(){
		return affGrille ;
	}
	
	
}

