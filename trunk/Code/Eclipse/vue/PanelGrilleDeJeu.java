package vue;

import images.Bat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.ControleurVues;
import src.Grille;
import src.Observateur;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Vector;


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
		int lenght = ctrlV.getTailleGrille() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				JLabel tempLabel = new JLabel();
				tempLabel.setIcon(new ImageIcon(Bat.NUM0)) ;
				affGrille[i][j] = tempLabel ;
			}
		}
		
		int JGTaille = ctrlV.getTailleGrille() + 2 ; //+(ctrlV.getTailleGrille()+1) ;
		GridLayout gridLayout = new GridLayout(JGTaille,JGTaille);
		this.setLayout(gridLayout);
		
		//gestion de l'observateur NORD
		add(new JLabel(""));
		for (int i=0 ; i<lenght ; i++)
			add(new JLabel(new ImageIcon(Bat.associatO(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.NORD,i+1)))));
		add(new JLabel(""));
		//gestion de l'observateur OUEST, de la grille et de l'observateur EST
		for (int i=0 ; i<lenght ; i++){
			add(new JLabel(new ImageIcon(Bat.associatO(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.OUEST,i+1)))));
			for (int j=0 ; j<lenght ; j++){
				add(affGrille[i][j]);
			}
			add(new JLabel(new ImageIcon(Bat.associatO(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.EST,i+1)))));
		}
		//gestion de l'observateur SUD
		add(new JLabel(""));
		for (int i=0 ; i<lenght ; i++)
			add(new JLabel(new ImageIcon(Bat.associatO(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.SUD,i+1)))));
		add(new JLabel(""));
		
		refreshGrilleBuffer() ;
	}
	
	public void refreshGrilleBuffer(){
		int lenght = ctrlV.getTailleGrille() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
//				affGrille[i][j].setText(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment()+"") ;
//				if(ctrlV.getCtrlM().GetGameStart()){
					affGrille[i][j].setIcon(new ImageIcon(Bat.associatB(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment()))) ;
//					affGrille[i][j].setText(vecpo(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getPossibilite())+"") ;
//				}
			}
		}
		validate();
		
	}
	
//	public void refreshGrilleBuffer(int abscisse,int ordonnee){
//		affGrille[ordonnee-1][abscisse-1].setIcon(new ImageIcon(Bat.associatB(ctrlV.getCtrlM().getLaGrille().getCase(abscisse,ordonnee).getBatiment()))) ;
//		validate();
//	}
	
	private String vecpo( final Vector<Integer> pt){
		String ret = "" ;
		
		for(int i=0; i<pt.size(); i++)
			ret = ret + pt.elementAt(i) ;
			
		return ret;
	}
	
	public ControleurVues getCtrlV() {
		return ctrlV;
	}
	
	public JLabel[][] getAffGrille(){
		return affGrille ;
	}
	
	
}

