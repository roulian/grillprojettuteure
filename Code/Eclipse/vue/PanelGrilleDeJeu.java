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
				
				tempLabel.setIcon(new ImageIcon(Bat.BLANC)) ;
				tempLabel.addMouseListener(new java.awt.event.MouseListener() {
					public void mouseClicked(MouseEvent arg0) {
//						Comment récup le label courant...
//						avec des parametre en entré
//						JLabel.this.tempLabel.setText(tempLabel.getText()+"1");
					}
					public void mouseEntered(MouseEvent arg0) {}
					public void mouseExited(MouseEvent arg0) {}
					public void mousePressed(MouseEvent arg0) {}
					public void mouseReleased(MouseEvent arg0) {}
				});
				affGrille[i][j] = tempLabel ;
			}
		}
		refreshGrilleBuffer() ; 
		
		GridLayout gridLayout = new GridLayout(ctrlV.getTailleGrille()+2,ctrlV.getTailleGrille()+2);
		this.setLayout(gridLayout);
		
		//gestion de l'observateur NORD
		add(new JLabel(""));
		for (int i=0 ; i<lenght ; i++)
			add(new JLabel(new ImageIcon(Bat.associatO(ctrlV.getCtrlM().getObservateur().getObservateur()[Observateur.NORD][i]))));
		add(new JLabel(""));
		
		//gestion de l'observateur OUEST, de la grille et de l'observateur EST
		for (int i=0 ; i<lenght ; i++){
			add(new JLabel(new ImageIcon(Bat.associatO(ctrlV.getCtrlM().getObservateur().getObservateur()[Observateur.OUEST][i]))));
			for (int j=0 ; j<lenght ; j++){
				add(affGrille[i][j]);
			}
			add(new JLabel(new ImageIcon(Bat.associatO(ctrlV.getCtrlM().getObservateur().getObservateur()[Observateur.EST][i]))));
		}
		
		//gestion de l'observateur SUD
		add(new JLabel(""));
		for (int i=0 ; i<lenght ; i++)
			add(new JLabel(new ImageIcon(Bat.associatO(ctrlV.getCtrlM().getObservateur().getObservateur()[Observateur.SUD][i]))));
		add(new JLabel(""));
		
		refreshGrilleBuffer(1,1) ;
	}
	
	public void refreshGrilleBuffer(){
		int lenght = ctrlV.getTailleGrille() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
//				affGrille[i][j].setText(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment()+"") ;
				affGrille[i][j].setIcon(new ImageIcon(Bat.associatB(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment()))) ;
			}
		}
		validate();
	}
	
	public void refreshGrilleBuffer(int abscisse,int ordonnee){
		affGrille[ordonnee-1][abscisse-1].setIcon(new ImageIcon(Bat.associatB(ctrlV.getCtrlM().getLaGrille().getCase(abscisse,ordonnee).getBatiment()))) ;
		validate();
	}
	
	public ControleurVues getCtrlV() {
		return ctrlV;
	}
	
	public JLabel[][] getAffGrille(){
		return affGrille ;
	}
	
	
}

