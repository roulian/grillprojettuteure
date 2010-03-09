package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import src.Grille;
import src.Observateur;
import controleur.ControleurM;
import controleur.ControleurR;
import controleur.ControleurVues;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JComboBox;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import javax.swing.BorderFactory;
//import java.awt.Color;
//import javax.swing.JTextField;
//import src.SaveObject;
//import java.awt.FlowLayout;
//import java.awt.Rectangle;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
//import java.awt.BorderLayout;

public class PanelGeneration extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jpGrill = null;
	private JPanel jpBoutton = null;
	private JButton jbVerif = null;
	private JButton jbGenSpont = null;
	private JButton jbSauvegarder = null;
	private JButton jbRetour = null;
	private JPanel jpBout = null;
	private ControleurVues ctrlV;
	private DifficulteGeneration difGen;
	private JComboBox jCTaille = null;
	private JButton jbOk = null ;
	private PanelGrilleDeJeu jPanelSasieObs = null;
	private boolean boolOk ;
	private boolean verifOk ;
	private int taille ;
	private Observateur obs ;
	private Grille grille ;
	private PanelGrilleDeJeu affichage ;
	/**
	 * This is the default constructor
	 */
	public PanelGeneration(ControleurVues contr) {
		super() ;
		this.ctrlV = contr;
		this.setLayout(null);
		this.add(getJpBoutton());
		this.add(getJpGrill());
		boolOk = false ;
		verifOk = false ;
		refresh();
	}
	
	private JPanel getJpGrill() {
		if (jpGrill == null){
			jpGrill = new JPanel();
			jpGrill.setBounds(200,0,400,350) ;
			jpGrill.setLayout(new GridBagLayout()) ;
			taille = (Integer)(jCTaille.getSelectedItem()) ;
			obs = new Observateur(taille);
			grille = new Grille(ctrlV.getCtrlM(),taille);
			affichage = new PanelGrilleDeJeu(ctrlV.getCtrlM(),taille,obs,true) ;
			jpGrill.add(affichage) ;
		}
		return jpGrill;
	}
	
	public JPanel getJpBoutton(){
		if(jpBoutton==null){
			jpBoutton = new JPanel() ;
			jpBoutton.setLayout(null) ;
			jpBoutton.add(getJpCombo()) ;
			jpBoutton.add(getJbVerif()) ;
			jpBoutton.add(getJbGenSpont()) ;
			jpBoutton.add(getJbSauvegarder()) ;
			jpBoutton.add(getJbRetour()) ;
			jpBoutton.setBounds(0,0,200,350) ;
		}
		return jpBoutton ;
	}
	
	private JPanel getJpCombo(){
		if(jpBout==null){
			Vector<Integer> taille;
			taille = new Vector<Integer>();
			taille.add(4);
			taille.add(5);
			taille.add(6);
			JLabel tempLabel = new JLabel("Taille") ;
			jCTaille = new JComboBox(taille) ;
			jCTaille.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					boolOk = false ;
					verifOk = false ;
					refresh() ;
				}
			});
			jbOk = new JButton("Ok") ;
			tempLabel.setBounds(0,0,60,35) ;
			jCTaille.setBounds(70,0,60,35) ;
			jbOk.setBounds(140,0,60,35) ;
			jbOk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jpGrill.setVisible(false) ;
					PanelGeneration.this.remove(getJpGrill()) ;
					jpGrill = null ;
					PanelGeneration.this.add(getJpGrill()) ;
					validate() ;
					boolOk = true ;
					refresh() ;
				}
			}) ;
			jpBout = new JPanel() ;
			jpBout.add(tempLabel);
			jpBout.add(jCTaille);
			jpBout.add(jbOk);
			jpBout.setBounds(20,80,170,35) ;
		}
		return jpBout ;
	}

	private JButton getJbVerif() {
		if (jbVerif == null) {
			jbVerif = new JButton();
			jbVerif.setBounds(20,140,170,30) ;
			jbVerif.setText("Vérification");
			jbVerif.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrlV.getCtrlM().setLaGrille(grille);
					ctrlV.getCtrlM().setTailleGrille(taille);
					ctrlV.getCtrlM().setObservateur(obs);
					ControleurR resol = new ControleurR(ctrlV.getCtrlM()) ;
					verifOk = resol.applyRegle() ;
					affichage.refreshGrilleDisplay() ;
					refresh() ;
				}
			});
		}
		return jbVerif;
	}

	private JButton getJbGenSpont() {
		if (jbGenSpont == null) {
			jbGenSpont = new JButton();
			jbGenSpont.setText("Génération spontanée");
			jbGenSpont.setBounds(20,175,170,30) ;
			jbGenSpont.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					difGen = new DifficulteGeneration(ctrlV.getVuePrincipal(),"difficulté", ctrlV);
					difGen.setVisible(true);
				}
			});
		}
		return jbGenSpont;
	}

	private JButton getJbSauvegarder() {
		if (jbSauvegarder == null) {
			jbSauvegarder = new JButton();
			jbSauvegarder.setText("Sauvegarder");
			jbSauvegarder.setBounds(20,210,170,30) ;
			jbSauvegarder.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed ON Bouton Sauvegarder");
					JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
					String nomFichier = jop.showInputDialog(PanelGeneration.this, "Veuillez saisir le nom du fichier", "Sauvegarde", JOptionPane.QUESTION_MESSAGE);
					if(!nomFichier.equals("")){
						ControleurM ctrl = ctrlV.getCtrlM();
						ctrl.sauvegarderGrille(nomFichier+".grille",ctrl.getLaGrille(),ctrl.getObservateur(),ctrl.getTailleGrille()) ;
					}
				}
			});
		}
		return jbSauvegarder;
	}

	private JButton getJbRetour() {
		if (jbRetour == null) {
			jbRetour = new JButton();
			jbRetour.setText("Retour");
			jbRetour.setBounds(20,245,170,30) ;
			jbRetour.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrlV.switchPanel(ctrlV.getPanelAcceuil()) ;
				}
			});
		}
		return jbRetour;
	}
	
	public void refresh(){
		jbVerif.setEnabled(boolOk) ;
		jbGenSpont.setEnabled(boolOk) ;
		jbSauvegarder.setEnabled(boolOk && verifOk) ;
	}

	public PanelGrilleDeJeu getAffichage() {
		return affichage;
	}

	public boolean isBoolOk() {
		return boolOk;
	}

	public void setBoolOk(boolean boolOk) {
		this.boolOk = boolOk;
	}

	public boolean isVerifOk() {
		return verifOk;
	}

	public void setVerifOk(boolean verifOk) {
		this.verifOk = verifOk;
	}
}  //  @jve:decl-index=0:visual-constraint="36,20"
