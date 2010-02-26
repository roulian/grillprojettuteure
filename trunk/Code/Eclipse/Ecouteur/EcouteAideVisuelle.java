package Ecouteur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import controleur.ControleurVues;

public class EcouteAideVisuelle implements MouseListener{
	private int numBat ;
	private ControleurVues ctrlV ;
	private JLabel myLabel ;
	
	public EcouteAideVisuelle(ControleurVues pCtrlV, JLabel pLabel, int numeroBat){
		ctrlV = pCtrlV ;
		myLabel = pLabel ;
		numBat = numeroBat ;
		myLabel.setBorder(BorderFactory.createRaisedBevelBorder()) ;
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
		myLabel.setBorder(BorderFactory.createLoweredBevelBorder()) ;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		myLabel.setBorder(BorderFactory.createRaisedBevelBorder()) ;
	}

}
