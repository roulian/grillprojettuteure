package Ecouteur;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import controleur.ControleurVues;

/**
 * cette écouteur permet de traiter le cas de l'aideVisuel trouver
 * @author Andres Gomez Thomas
 *
 */
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
		// nothing to do, voir mouseRealised
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
		// mise en page
		myLabel.setBorder(BorderFactory.createLoweredBevelBorder()) ;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// mise ne page
		myLabel.setBorder(BorderFactory.createRaisedBevelBorder()) ;
		// traitement, gestion du clic
		System.out.println("Clik sur le représentant "+numBat);
		ctrlV.getCtrlM().setBatAideTrouver(numBat) ;
		ctrlV.refreshGrilleDeJeu() ;
	}

}
