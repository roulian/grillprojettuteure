package vue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controleur.ControleurVues;

public class EcouteAideVisuelle implements MouseListener{
	private int numBat ;
	private ControleurVues ctrlV ;
	
	public EcouteAideVisuelle(ControleurVues pCtrlV , int numeroBat){
		ctrlV = pCtrlV ;
		numBat = numeroBat ;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clik sur le représentant "+numBat);
		ctrlV.getCtrlM().setBatAideTrouver(numBat) ;
		ctrlV.refreshGrilleDeJeu() ;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
