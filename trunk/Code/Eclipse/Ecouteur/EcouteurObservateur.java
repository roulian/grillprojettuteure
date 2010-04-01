package Ecouteur;

import images.GestionIcon;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controleur.ControleurM;
import controleur.ControleurVues;

import src.Grille;
import src.Observateur;

/**
 * cette écouteur permet de gérer le cas ou l'on génère des grilles de jeu via leur observateurs
 * @author Andres Gomez Thomas
 *
 */
public class EcouteurObservateur implements MouseListener, KeyListener{

	private JLabel myLabel ;
	private int cardinal ;
	private int position ;
	private Observateur observateur ;
	private ControleurVues ctrlV ;
	
	public EcouteurObservateur(ControleurVues pCtrlV,JLabel plabel, int pCardinal, int pPosition, Observateur pObs){
		myLabel = plabel ;
		cardinal = pCardinal ;
		position = pPosition ;
		observateur = pObs ;
		ctrlV = pCtrlV ;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		myLabel.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.RED)) ;
		myLabel.requestFocus();	// nécessaire pour le Keylistener
	}

	@Override
	public void mouseExited(MouseEvent e) {
		myLabel.setBorder(BorderFactory.createEtchedBorder()) ;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("card:"+cardinal+" posi:"+position+" KeyPressed:"+e.getKeyChar());
		if(e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'
			||e.getKeyChar()=='4'||e.getKeyChar()=='5'||e.getKeyChar()=='6'||e.getKeyChar()=='0'){
			int temp = Integer.parseInt(e.getKeyChar()+"") ;
			if (ctrlV.getPanelGeneration().isVerifOk() && ctrlV.getPanelGeneration().isBoolOk())
				keypush() ;
			observateur.setObservateur(cardinal, position-1, temp);
			myLabel.setIcon(new ImageIcon(GestionIcon.getImage(temp,"obs"))) ;
		}
		if(e.getKeyChar()=='&'||e.getKeyChar()=='é'||e.getKeyChar()=='"'
			||e.getKeyChar()=='\''||e.getKeyChar()=='('||e.getKeyChar()=='-'||e.getKeyChar()=='à'){
			int temp = 0 ;
			if(e.getKeyChar()=='&')
				temp = 1 ;
			if(e.getKeyChar()=='é')
				temp = 2 ;
			if(e.getKeyChar()=='"')
				temp = 3 ;
			if(e.getKeyChar()=='\'')
				temp = 4 ;
			if(e.getKeyChar()=='(')
				temp = 5 ;
			if(e.getKeyChar()=='-')
				temp = 6 ;
			if(e.getKeyChar()=='à')
				temp = 0 ;
	
			if (ctrlV.getPanelGeneration().isVerifOk() && ctrlV.getPanelGeneration().isBoolOk())
				keypush() ;
			observateur.setObservateur(cardinal, position-1, temp);
			myLabel.setIcon(new ImageIcon(GestionIcon.getImage(temp,"obs"))) ;
			ctrlV.getPanelGeneration().setVerifOk(false) ;
			ctrlV.getPanelGeneration().refresh() ;
		}
	}

	private void keypush(){
		ctrlV.getCtrlM().setLaGrille(new Grille(ctrlV.getCtrlM(),ctrlV.getCtrlM().getTailleGrille())) ;
		ctrlV.getCtrlM().resetBatConstruit() ;
		ctrlV.getPanelGeneration().getAffichage().refreshGrilleDisplay() ;
	}
}
