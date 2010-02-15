package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.ControleurVues;
import src.Grille;
import src.Observateur;

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
		
		GridLayout gridLayout = new GridLayout(ctrlV.getTailleGrille()+2,ctrlV.getTailleGrille()+2);
		this.setLayout(gridLayout);
		
		int lenght = ctrlV.getTailleGrille() ;

		//gestion de l'observateur NORD
		add(new JLabel(""));
		for (int i=0 ; i<lenght ; i++)
			add(new JLabel(""+ctrlV.getCtrlM().getObservateur().getObservateur()[Observateur.NORD][i]));
		add(new JLabel(""));
		
		//gestion de l'observateur OUEST, de la grille et de l'observateur EST
		for (int i=0 ; i<lenght ; i++){
			add(new JLabel(""+ctrlV.getCtrlM().getObservateur().getObservateur()[Observateur.OUEST][i]));
			for (int j=0 ; j<lenght ; j++){
				add(affGrille[i][j]);
			}
			add(new JLabel(""+ctrlV.getCtrlM().getObservateur().getObservateur()[Observateur.EST][i]));
		}
		
		//gestion de l'observateur SUD
		add(new JLabel(""));
		for (int i=0 ; i<lenght ; i++)
			add(new JLabel(""+ctrlV.getCtrlM().getObservateur().getObservateur()[Observateur.SUD][i]));
		add(new JLabel(""));
		
		refreshGrilleBuffer(1,2) ;
	}
	
	public void refreshGrilleBuffer(){
		int lenght = ctrlV.getTailleGrille() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				affGrille[i][j] = new JLabel(ctrlV.getCtrlM().getLaGrille().getCase(i+1,j+1).getBatiment()+"") ;
			}
		}
		validate();
	}
	
	//méthode qui a terme devrait disparetre.
	public void refreshGrilleBuffer(int abscisse,int ordonnee){
		affGrille[ordonnee-1][abscisse-1].setText("poruquoi") ;
		validate();
	}
	
	public ControleurVues getCtrlV() {
		return ctrlV;
	}
	
	public JLabel[][] getAffGrille(){
		return affGrille ;
	}
	
	
}

