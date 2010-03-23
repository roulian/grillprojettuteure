package Ecouteur;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import src.Observateur;

import controleur.ControleurVues;

public class EcouteCharger implements MouseListener{
	private String fichier ;
	private ControleurVues ctrlV ;
	private JLabel myLabel ;
	
	public EcouteCharger(ControleurVues pCtrlV, String pFichier,JLabel pLabel){
		fichier = pFichier ; 
		ctrlV = pCtrlV ;
		myLabel = pLabel ;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		myLabel.setForeground(Color.RED) ;
		myLabel.setFont(new Font("Dialog",Font.BOLD,13)) ;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		myLabel.setForeground(Color.BLACK) ;
		myLabel.setFont(new Font("Dialog",Font.PLAIN,13)) ;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(fichier);
		Vector<Integer[][]> temp = new Vector<Integer[][]>() ;
		temp = ctrlV.getCtrlM().chargerGrille(fichier) ;
		
//		System.out.println("Clické sur la grille, dans l'EcouteurChargment");
//	    System.out.print("GRILLE");
//	    int pTaille = temp.elementAt(0).length ;
//	    for(int i=0; i<pTaille*2-6; i++)
//	    	System.out.print(" ");
//	    System.out.println("| OBS");
//	    for(int i= 0; i < pTaille; i++){
//	    	//grille
//	    	for(int j = 0; j < pTaille ;j++)
//	    		System.out.print(temp.elementAt(0)[i][j]+" ");
//	    	//observateur
//	    	System.out.print("| ");
//	    	if(i<4)
//		    	for(int j = 0; j < pTaille ;j++)
//		    		System.out.print(temp.elementAt(1)[i][j]+" ");
//	    	System.out.println();
//		}		   
		ctrlV.getCtrlM().setAideGrilleErreur(temp.elementAt(0)) ;
	    ctrlV.getPanelChargement().setObsChargement(new Observateur(temp.elementAt(1),temp.elementAt(0).length),temp.elementAt(0),temp.elementAt(0).length) ;
		ctrlV.getPanelChargement().refreshGrille() ;
	}

}
