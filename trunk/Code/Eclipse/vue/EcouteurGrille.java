package vue;

import images.Bat;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import src.Observateur;
import sun.awt.RequestFocusController;
import controleur.ControleurM;
import controleur.ControleurVues;

public class EcouteurGrille implements MouseListener, KeyListener{
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
		// affichage consoLE
		System.out.print("Mouse Clicked upon case Abs:"+abscisse+" Ord:"+ordonnee);
		System.out.print(" -- Batiment:"+ctrlM.getLaGrille().getCase(abscisse,ordonnee).getBatiment());
		System.out.print(" Possibilite:"+ctrlM.vecpo(ctrlM.getLaGrille().getCase(abscisse,ordonnee).getPossibilite()));
		System.out.print(" -- Observateur ||");
		System.out.print(" Nord "+ctrlM.getThisObs(Observateur.NORD,abscisse));
		System.out.print(" Est "+ctrlM.getThisObs(Observateur.EST,ordonnee));
		System.out.print(" Sud "+ctrlM.getThisObs(Observateur.SUD,abscisse));
		System.out.println(" Ouest "+ctrlM.getThisObs(Observateur.OUEST,ordonnee));
		//gestion du comportement du clic
		if(ctrlM.isAideTrouver())
			ctrlM.setBatAideTrouver(ctrlM.getLaGrille().getCase(abscisse,ordonnee).getBatiment()) ;
		
		ctrlM.getCtrlVues().refreshGrilleDeJeu() ;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		prevIcon = (ImageIcon) caseLabel.getIcon() ;
//		if(!ctrlM.isAideTrouver())
//			caseLabel.setIcon(new ImageIcon(Bat.switchToAnimatBatIcon(ctrlM.getLaGrille().getCase(abscisse,ordonnee).getBatiment()))) ;
		caseLabel.requestFocus();	// nécessaire pour le Keylistener
	}
	@Override
	public void mouseExited(MouseEvent e) {
//		if(!ctrlM.isAideTrouver())
//			caseLabel.setIcon(prevIcon) ;
	}

	@Override
	public void mousePressed(MouseEvent e){ }
	@Override
	public void mouseReleased(MouseEvent e){ }
	
	
	//PARTIE CLAVIER
	@Override
	public void keyPressed(KeyEvent e){ }

	@Override
	public void keyReleased(KeyEvent e){ }

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("abs:"+abscisse+" ord:"+ordonnee+" KeyPressed:"+e.getKeyChar());
		if(e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'
			||e.getKeyChar()=='4'||e.getKeyChar()=='5'||e.getKeyChar()=='6'){
			int temp = Integer.parseInt(e.getKeyChar()+"") ;
			if (ctrlM.getLaGrille().construire(abscisse,ordonnee,temp)){
				ctrlM.getCtrlVues().refreshGrilleDeJeu(abscisse,ordonnee,null);
				prevIcon = new ImageIcon(Bat.associatBA(temp));
			}
		}
	}

}
