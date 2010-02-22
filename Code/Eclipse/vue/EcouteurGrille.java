package vue;

import images.Bat;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import src.Observateur;

import controleur.ControleurM;
import controleur.ControleurVues;

public class EcouteurGrille implements MouseListener{
	private ControleurM ctrlM ;
	private JLabel caseLabel ;
	private ImageIcon prevIcon ;
	private int abscisse ;
	private int ordonnee ;
	
	public EcouteurGrille(ControleurVues pCtrlV,JLabel pLabel,int pAbscisse, int pOrdonnee) {
		super();
		caseLabel = pLabel ;
		abscisse = pAbscisse ;
		ordonnee = pOrdonnee ;
		ctrlM = pCtrlV.getCtrlM() ;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// affichage consol
		System.out.print("Mouse Clicked upon case Abs:"+abscisse+" Ord:"+ordonnee);
		System.out.print(" -- Batiment:"+ctrlM.getLaGrille().getCase(abscisse,ordonnee).getBatiment());
		System.out.print(" Possibilite:"+ctrlM.vecpo(ctrlM.getLaGrille().getCase(abscisse,ordonnee).getPossibilite()));
		System.out.print(" -- Observateur ||");
		System.out.print(" Nord "+ctrlM.getThisObs(Observateur.NORD,abscisse));
		System.out.print(" Est "+ctrlM.getThisObs(Observateur.EST,ordonnee));
		System.out.print(" Sud "+ctrlM.getThisObs(Observateur.SUD,abscisse));
		System.out.println(" Ouest "+ctrlM.getThisObs(Observateur.OUEST,ordonnee));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		prevIcon = (ImageIcon) caseLabel.getIcon() ;
		caseLabel.setIcon(new ImageIcon(Bat.switchToAnimatBatIcon(ctrlM.getLaGrille().getCase(abscisse,ordonnee).getBatiment()))) ;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		caseLabel.setIcon(prevIcon) ;
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}

}
