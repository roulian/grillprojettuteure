package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.Border;

import Ecouteur.EcouteCharger;

import java.io.* ;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.Observateur;
import sun.awt.VerticalBagLayout;
import controleur.ControleurR;
import controleur.ControleurVues;
import controleur.ControleurM.Dificulty;

/**
 * Ce panel apparait lorsqu'on clique sur le boutton charger du panel Accueil.
 * Il permet de sélectionner une grille déjà générée et de la résoudre.
 * 
 * @author julien
 *
 */
public class PanelChargement extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton jbCharger = null;
	private JButton jbRetour = null;
	private JPanel jpSud = null;
	private JLabel jLvide = null;
	private JScrollPane jsList = null;
	private JList jlPartieCharger = null;
	private JPanel jpGrilleJeu = null;  //  @jve:decl-index=0:visual-constraint="537,58"
	private ControleurVues ctrlV;
	private Observateur obsChargement ;
	private JPanel panelListeFichier ;
	private int tailleObs = 1 ;
	private Integer[][] grlChargment ;

	/**
	 * This is the default constructor
	 */
	public PanelChargement() {
		super();
		initialize();
	}
	
	/**
	 * Constructeur du panel avec un controleur des vues en paramètre.
	 * @param pCtrlV
	 */
	public PanelChargement(ControleurVues pCtrlV) {
		super();
		this.ctrlV = pCtrlV;
		initialize();
	}


	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 400) ;
		this.setLayout(null);
		this.add(getJsList());
		this.add(getJpSud());
		this.add(getJpGrilleJeu());
		jbCharger.setEnabled(false) ;

		//ANCIENNE MISE EN PAGE; généré par eclipse, mais ne me convient pas du tout
//		this.setLayout(new BorderLayout());
//		this.add(getJsList(), BorderLayout.WEST);
//		this.add(getJpSud(), BorderLayout.SOUTH);
//		this.add(getJpGrilleJeu(), BorderLayout.CENTER);
//		this.add(new JLabel(" "), BorderLayout.EAST) ;
//		jbCharger.setEnabled(false) ;
	}

	/**
	 * This method initializes jbCharger	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbCharger() {
		if (jbCharger == null) {
			jbCharger = new JButton();
			jbCharger.setBounds(215, 5, 180, 35) ;
			jbCharger.setText("Charger");
			jbCharger.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ctrlV.getCtrlM().commencerPartie(tailleObs, Dificulty.FACILE, obsChargement, grlChargment) ;
					ctrlV.switchPanel(ctrlV.getPanelJeu()) ;			
				}
			});
		}
		return jbCharger;
	}

	/**
	 * This method initializes jbRetour	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbRetour() {
		if (jbRetour == null) {
			jbRetour = new JButton();
			jbRetour.setBounds(405, 5, 180, 35) ;
			jbRetour.setText("Retour");
			jbRetour.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ctrlV.switchPanel(ctrlV.getPanelAcceuil()) ;
				}
			}) ;
		}
		return jbRetour;
	}

	/**
	 * This method initializes jpSud	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpSud() {
		if (jpSud == null) {
			jpSud = new JPanel();
			jpSud.setBounds(0,300,600,50) ;
			jpSud.setLayout(null);
			jpSud.add(getJbCharger());
			jpSud.add(getJbRetour());
		}
		return jpSud;
	}

	/**
	 * This method initializes jsList	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJsList() {
		if (jsList == null) {
			jsList = new JScrollPane();
			jsList.setBounds(0,0,200,300) ;
			jsList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			panelListeFichier = null ;
			jsList.setViewportView(getJlPartieCharger());
			jsList.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		}
		return jsList;
	}

	/**
	 * This method initializes jlPartieCharger	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JPanel getJlPartieCharger() {
		if (panelListeFichier == null) {
			panelListeFichier = new JPanel();
			jlPartieCharger = new JList();
			panelListeFichier.setBackground(Color.WHITE) ;
			String[] listeFichiers;
			File repertoire = new File(ctrlV.getCtrlM().getPath());
			listeFichiers = repertoire.list();
					
			int nbelemMax = listeFichiers.length;
			int nbelem = 0 ;
			for(int i=0;i<listeFichiers.length;i++){
				if(listeFichiers[i].endsWith(".grille")){
					nbelem++;
				}
			}
			
			panelListeFichier.setLayout(new GridLayout(nbelem,1)); 
			for(int i=0;i<listeFichiers.length;i++){
				if(listeFichiers[i].endsWith(".grille")){
					JLabel tempLabel = new JLabel(listeFichiers[i].substring(0,listeFichiers[i].length()-7)) ;
					tempLabel.setFont(new Font("Dialog",Font.PLAIN,13)) ;
					tempLabel.addMouseListener(new EcouteCharger(ctrlV,listeFichiers[i],tempLabel)) ;
					panelListeFichier.add(tempLabel);
				}
			}
		}
		return panelListeFichier ;
	}
	
	/**
	 * Cette méthode permet de mettre à jour la grille en affichant la nouvelle grille sélectionné
	 * 
	 * @return void
	 */
	public void refreshGrille(){
		jpGrilleJeu.setVisible(false) ;			//évite de voir l'ancien panel sous le nouveau
		validate() ;							//on redessine
		this.remove(jpGrilleJeu) ;
		jpGrilleJeu = null ;
		this.add(getJpGrilleJeu()) ;
		
		if(tailleObs!=0)
			getJbCharger().setEnabled(true);
		else
			getJbCharger().setEnabled(false);
		
		validate() ;
	}
	
	/**
	 * Cette méthode met à jour la liste des grille à charger
	 * 
	 * @return void
	 */
	public void refreshListe(){
		jsList.setVisible(false) ;				//dans le cas ou le nouveau est plus petit
		validate() ;							//on redessine
		this.remove(jsList);
		jsList = null ;
		this.add(getJsList()) ;
		validate() ;
	}
	
	/**
	 * This method initializes jpGrilleJeu	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpGrilleJeu() {
		if (jpGrilleJeu == null) {
			jpGrilleJeu = new JPanel();
			jpGrilleJeu.setBounds(200,0,400,300) ;
			jpGrilleJeu.setLayout(new GridBagLayout());
			jpGrilleJeu.add(new PanelGrilleDeJeu(ctrlV.getCtrlM(),tailleObs,obsChargement,false));
		}
		return jpGrilleJeu;
	}

	/**
	 * Cette méthode retourne les observateurs de la grille sélectionnée.
	 * @return Observateur
	 */
	public Observateur getObsChargement() {
		return obsChargement;
	}

	/**
	 * Met à jour les observateurs dans la grille de jeu.
	 * 
	 * @param obsChargement
	 * @param grlChargment
	 * @param ptaille
	 * 
	 * @return void
	 */
	public void setObsChargement(Observateur obsChargement,Integer[][] grlChargment , int ptaille) {
		this.obsChargement = obsChargement;
		this.tailleObs = ptaille ;
		this.grlChargment = grlChargment ;
	}

}  //  @jve:decl-index=0:visual-constraint="33,17"
