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
	private PanelGrilleDeJeu affichage ;
	public enum Mode {
		NORMAL,DEBUG
	}
	private Mode modeOuverture = Mode.NORMAL;
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
	
	/**
	 * Retourne le panel Grille à droite
	 * @return JPanel
	 */
	private JPanel getJpGrill() {
		if (jpGrill == null){
			jpGrill = new JPanel();
			jpGrill.setBounds(200,0,400,350) ;
			jpGrill.setLayout(new GridBagLayout()) ;
			taille = (Integer)(jCTaille.getSelectedItem()) ;
			affichage = new PanelGrilleDeJeu(ctrlV.getCtrlM(),taille,ctrlV.getCtrlM().getObservateur(),true) ;
			jpGrill.add(affichage) ;
		}
		return jpGrill;
	}
	
	/**
	 * Retourne le panel contenant les bouttons
	 * @return JPanel
	 */
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
	
	/**
	 * Retourne le panel contenant les tailles
	 * @return JPanel
	 */
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
					//on effectue le traitement nécessaire à la résolution plus tard
					ControleurM ctrlTemp = ctrlV.getCtrlM() ;
					int tailleTemp = (Integer)(jCTaille.getSelectedItem()) ;
					//on creer une nouvelle grille vierge dans le controleurM.
					ctrlTemp.setLaGrille(new Grille(ctrlTemp,tailleTemp)) ;
					//on détermine la taille de la grille dans le controleurM.
					ctrlTemp.setTailleGrille(tailleTemp) ;
					//on creer un observateur vierge dans le controleurM.
					ctrlTemp.setObservateur(new Observateur(tailleTemp)) ;
					//on remet à zero le compteur de batiment construit
					ctrlTemp.resetBatConstruit() ;
					boolOk = true ;
					
					// on (re)construit la grille visible sur la droite
					jpGrill.setVisible(false) ;
					PanelGeneration.this.remove(getJpGrill()) ;
					jpGrill = null ;
					PanelGeneration.this.add(getJpGrill()) ;
					validate() ;
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

	/**
	 * Retourne le boutton Vérification
	 * @return JButton
	 */
	private JButton getJbVerif() {
		if (jbVerif == null) {
			jbVerif = new JButton();
			jbVerif.setBounds(20,140,170,30) ;
			jbVerif.setText("Vérification");
			jbVerif.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
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

	/**
	 * Retourne le boutton Sauvegarder
	 * @return JButton
	 */
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

	/**
	 * Retourne le boutton Retour
	 * @return JButton
	 */
	private JButton getJbRetour() {
		if (jbRetour == null) {
			jbRetour = new JButton();
			jbRetour.setText("Retour");
			jbRetour.setBounds(20,245,170,30) ;
			jbRetour.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrlV.getCtrlM().setLaGrille(null) ;
					ctrlV.getCtrlM().setTailleGrille(0) ;
					ctrlV.getCtrlM().setObservateur(null) ;
					ctrlV.switchPanel(ctrlV.getPanelAcceuil()) ;
				}
			});
		}
		return jbRetour;
	}
	
	/**
	 * Permet de griser ou pas les bouttons suivant les actions de l'utilisateur
	 * @return void
	 */
	public void refresh(){
		jbVerif.setEnabled(boolOk) ;
		jbGenSpont.setEnabled(boolOk) ;
		jbSauvegarder.setEnabled(boolOk && verifOk) ;
		if(modeOuverture==Mode.DEBUG){
			jbVerif.setEnabled(true) ;
			jbGenSpont.setEnabled(false) ;
			jbSauvegarder.setEnabled(true) ;
		}
	}

	/**
	 * Retourne la grille de jeu
	 * @return PanelGrilleDeJeu
	 */
	public PanelGrilleDeJeu getAffichage() {
		return affichage;
	}

	/**
	 * Permet de savoir si le boolean ok est True ou False
	 * @return boolean
	 */
	public boolean isBoolOk() {
		return boolOk;
	}

	/**
	 * Permet de mettre à jour le booléen ok
	 * @return void
	 */
	public void setBoolOk(boolean boolOk) {
		this.boolOk = boolOk;
	}

	/**
	 * Permet de savoir si le booléen verifOk est True ou False
	 * @return boolean
	 */
	public boolean isVerifOk() {
		return verifOk;
	}

	/**
	 * Permet de mettre à jour le booléen verifOk
	 * @return void
	 */
	public void setVerifOk(boolean verifOk) {
		this.verifOk = verifOk;
	}

	/**
	 * Permet de mettre à jour lmode d'ouverture
	 * @return void
	 */
	public void setModeOuverture(Mode modeOuverture) {
		this.modeOuverture = modeOuverture;
	}
}  //  @jve:decl-index=0:visual-constraint="36,20"
