package vue;

import images.GestionIcon;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.ControleurVues;
import controleur.ControleurM.Dificulty;

import src.Observateur;
import vue.DialogRegles;

public class VuePrincipale extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8508924519782174481L;
	private JMenuBar menu ;
	private ControleurVues ctrlV;
	private JMenu jFicher ;
	private JMenu jAide ;
	private JMenu jAutre ;
	private JMenuItem itemReco ;
	private String GameTittle ;
	
	public VuePrincipale(ControleurVues pCtrl){
		super("GRILL") ;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ctrlV = pCtrl ;
		GameTittle = "Grilling Panic" ;
		setTitle(GameTittle) ;
		setBounds(0,0,300,400);
		
		//intégration des onglet (menu)
		menu = new JMenuBar();
		setJMenuBar(menu);
		JMenuItem itemTemp ;
		//premier menu
		jFicher = new JMenu(" Jeu ");
		menu.add(jFicher);
		//premier sous menu
		itemReco = new JMenuItem("Recommencer");
		jFicher.add(itemReco);
		itemReco.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : Recommencer");
				Observateur tempObs = ctrlV.getCtrlM().getObservateur() ;
				int tailleTemp = ctrlV.getCtrlM().getTailleGrille() ; 
				Dificulty difTemp = ctrlV.getCtrlM().getDifficulte() ;
				Integer[][] aideErreur = ctrlV.getCtrlM().getAideGrilleErreur() ;
				ctrlV.getCtrlM().finirPartie() ;
				ctrlV.getCtrlM().commencerPartie(tailleTemp,difTemp,tempObs,aideErreur) ;
				ctrlV.switchPanel(ctrlV.getPanelJeu()) ;
			}
		});
		//premier sous menu
		itemTemp = new JMenuItem("Nouvelle partie");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.getCtrlM().finirPartie() ;
				System.out.println("--> onglet : Nouvelle partie");
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelAutoGenerer()) ;
				setTitle(GameTittle) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Partie rapide");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : partie rapide");
				ctrlV.getCtrlM().finirPartie() ;
				int dif = (int)(Math.random()*3) ;
				int taille = (int)(Math.random()*2+4) ;
				String tittle = GameTittle+" "+taille+"x"+taille+" : ";
				switch (dif) {
				case 0:
					ctrlV.getCtrlM().commencerPartie(taille,Dificulty.FACILE) ;
					tittle = tittle + "facile" ;
				break;
				case 1:
					ctrlV.getCtrlM().commencerPartie(taille,Dificulty.NORMAL) ;
					tittle = tittle + "normal" ;
				break;
				default:
					ctrlV.getCtrlM().commencerPartie(taille,Dificulty.DIFFICILE) ;
					tittle = tittle + "difficile" ;
				break;
				}
				ctrlV.switchPanel(ctrlV.getPanelJeu()) ;
				VuePrincipale.this.setTitle(tittle) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Charger");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.getCtrlM().finirPartie() ;
				System.out.println("--> onglet : Charger");
				VuePrincipale.this.ctrlV.getPanelChargement().refreshListe() ;
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelChargement()) ;
				setTitle(GameTittle) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Générer");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.getCtrlM().finirPartie() ;
				System.out.println("--> onglet : Générer");
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelGeneration()) ;
				setTitle(GameTittle) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Retour Menu");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.getCtrlM().finirPartie() ;
				System.out.println("--> onglet : Retour Menu");
				VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelAcceuil()) ;
				setTitle(GameTittle) ;
			}
		});
		//autre sous menu
		itemTemp = new JMenuItem("Quitter");
		jFicher.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ctrlV.getCtrlM().finirPartie() ;
				System.out.println("--> onglet : Quitter");
				System.exit(0);
			}
		});
		
		jAide = new JMenu("Aide ");
		menu.add(jAide);
		itemTemp = new JMenuItem("Voir mes possibilités");
		jAide.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : Aide visuelle trouver");
				ctrlV.getCtrlM().gestionTriche("aideTrouver") ;
			}
		});
		itemTemp = new JMenuItem("Voir mes erreurs");
		jAide.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : Aide visuelle erreur");
				ctrlV.getCtrlM().gestionTriche("aideErreur") ;
			}
		});
		itemTemp = new JMenuItem("Mode triche");
		jAide.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println("--> onglet : Mode triche");
				ctrlV.getCtrlM().gestionTriche("tricheBouton") ;
			}
		});
		itemTemp = new JMenuItem("Résolution grille");
		jAide.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.print("--> onglet : Resolution grille");
				ctrlV.getCtrlM().resolveSansErreur() ;
				ctrlV.refreshGrilleDeJeu() ;
			}
		});
			
		jAutre = new JMenu("  ?  ");
		menu.add(jAutre);
		itemTemp = new JMenuItem("Option");
		jAutre.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				// ne fait rien pour l'instant
				// permettra de faire un choix de style d'affichage
				String[] option = new String[2] ;
				option[0] = "Style n°1" ;
				option[1] = "Style n°2" ;
				
				String message = "Choisissez entre les deux modes de vue possibles" +
						"\nStyle n°1 : Batiment: image / Observateur: couleur" +
						"\nStyle n°2 : Batiment: couleur / Observateur: noir" ;
				String titre = "style";
				
				int style = JOptionPane.showOptionDialog(
						VuePrincipale.this,
						message,
						titre,
						JOptionPane.YES_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						option,
						null) ; 
				if(style==0){
					// Style n°1 : Batiment: image / Observateur: couleur
					GestionIcon.setBatType(GestionIcon.BATIMAGE) ;
					GestionIcon.setObsType(GestionIcon.OBSCOUL) ;
				}
				else{
					// Style n°2 : Batiment: couleur / Observateur: noir
					GestionIcon.setBatType(GestionIcon.BATNUM) ;
					GestionIcon.setObsType(GestionIcon.OBSNOIR) ;
				}
				if(ctrlV.getCtrlM().GetGameStart()){
					ctrlV.switchPanel(ctrlV.getPanelJeu()) ;
					ctrlV.refreshGrilleDeJeu() ;
				}
			}
		});
		itemTemp = new JMenuItem("Règles");
		jAutre.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				new DialogRegles((VuePrincipale.this));
			}
		});
		itemTemp = new JMenuItem("A propos");
		jAutre.add(itemTemp);
		itemTemp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Jeux GRILL\nVersion 0.5\nCopyright © IUT Toulouse II Blagnac\nDéveloppé en Java", "A propos de Jeux GRILL", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// fin menu
		
		this.setResizable(false) ;
		
		// PARTIE DEBUGAGE
		System.out.println(ctrlV.getCtrlM().isDebugMode());
		if(ctrlV.getCtrlM().isDebugMode()){
			JMenu debug = new JMenu("DEBUG");
			menu.add(debug);
			itemTemp = new JMenuItem("Générer");
			debug.add(itemTemp);
			itemTemp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrlV.getCtrlM().finirPartie() ;
					System.out.println("--> onglet : Générer DEBUG");
					VuePrincipale.this.ctrlV.switchPanel(VuePrincipale.this.ctrlV.getPanelGeneration()) ;
					VuePrincipale.this.ctrlV.getPanelGeneration().setModeOuverture(PanelGeneration.Mode.DEBUG) ;
				}
			});
			itemTemp = new JMenuItem("Resoudre");
			debug.add(itemTemp);
			itemTemp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.print("--> onglet : Resolution grille");
					ctrlV.getCtrlM().resolve() ;
					ctrlV.refreshGrilleDeJeu() ;
				}
			});
		}
		
	}
	
	public void refreshMenu(){
		if (ctrlV.getCtrlM().GetGameStart()){
			jAide.setEnabled(true) ;
			itemReco.setEnabled(true) ;
		}
		else{
			jAide.setEnabled(false) ;
			itemReco.setEnabled(false) ;
		}
	}

	public ControleurVues getCtrl() {
		return ctrlV;
	}
}

/* devenu inutil avec les contraintes MVC respecté
void rafraichirVue(JPanel pPanel){
	
	//changement du panel principal
	VuePrincipale.this.remove(currentPanel);
	currentPanel = pPanel;
	VuePrincipale.this.add(pPanel);
	VuePrincipale.this.validate();
}*/
