package vue;
import images.Bat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controleur.ControleurVues;
import src.Grille;
import src.Observateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class PanelGrilleDeJeu extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel[][] affGrille ;
	private ControleurVues ctrlV; 

	/**
	 * This is the default constructor
	 * @param pCtrlV controleur des vues
	 */
	public PanelGrilleDeJeu(ControleurVues pCtrlV) {
		super();
		ctrlV = pCtrlV ;
		
		// on initialise le tableau à double entrée qui nous permettra par la suite d'afficher
		// les batiments. c'est un tableau de label, plus facil d'afficher ainsi
		affGrille = new JLabel[ctrlV.getTailleGrille()][ctrlV.getTailleGrille()];
		int lenght = ctrlV.getTailleGrille() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				JLabel tempLabel = new JLabel();
				tempLabel.setIcon(new ImageIcon(Bat.BLANC)) ;	// image vide
				affGrille[i][j] = tempLabel ;
			}
		}
		
		//définition des différents layouts
		BorderLayout gridLayoutPrincipal = new BorderLayout();			// définition du layout principal
		GridLayout gridLayoutNordSud = new GridLayout(1,lenght+2);		// layout pour les observateurs nord et sud
		GridLayout gridLayoutEstOuest = new GridLayout(lenght,1);		// layout pour les observateurs Ouest et est
		GridLayout gridLayoutGrille = new GridLayout(lenght,lenght);	// layout pour les observateurs nord et sud
		
		//définition des panels qui nous permettrons l'affichage de la grille
		JPanel panelGrille = new JPanel() ;
		JPanel panelObsNord = new JPanel() ;
		JPanel panelObsSud = new JPanel() ;
		JPanel panelObsEst = new JPanel() ;
		JPanel panelObsOuest = new JPanel() ;
		
		//association des panel avec leurs layouts respectifs
		panelObsNord.setLayout(gridLayoutNordSud) ;
		panelObsSud.setLayout(gridLayoutNordSud) ;
		panelObsEst.setLayout(gridLayoutEstOuest) ;
		panelObsOuest.setLayout(gridLayoutEstOuest) ;
		panelGrille.setLayout(gridLayoutGrille) ;
		this.setLayout(gridLayoutPrincipal);
		
		//Mise en page des différents panels
		add(panelObsNord,BorderLayout.NORTH);		// ajout du panel Nord
		add(panelObsOuest,BorderLayout.WEST) ;		// ajout du panel Ouest
		add(panelGrille,BorderLayout.CENTER) ;		// ajout du panel de la grille de jeu
		add(panelObsEst,BorderLayout.EAST) ;		// ajout du panel Est
		add(panelObsSud,BorderLayout.SOUTH) ;		// ajout du panel Sud
		
		//gestion des panels observateurs
		panelObsNord.add(new JLabel());				// blancs nécessaire pour centrer 
		panelObsSud.add(new JLabel());				// blancs nécessaire pour centrer
		for (int i=1 ; i<=lenght ; i++){
			//dans l'ordre Nord, Est, Sud, Ouest
			panelObsNord.add(new JLabel(new ImageIcon(Bat.associatNC(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.NORD,i)))));
			panelObsEst.add(new JLabel(new ImageIcon(Bat.associatNC(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.EST,i)))));
			panelObsSud.add(new JLabel(new ImageIcon(Bat.associatNC(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.SUD,i)))));
			panelObsOuest.add(new JLabel(new ImageIcon(Bat.associatNC(ctrlV.getCtrlM().getObservateur().getObservateur(Observateur.OUEST,i)))));
		}
		panelObsNord.add(new JLabel());				// blancs nécessaire pour centrer
		panelObsSud.add(new JLabel());				// blancs nécessaire pour centrer
		
		// gestion du panel de la grille de jeu
		// on donne au panel les références des label présent dans le tableaux et initialiser plus tot
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++){
				panelGrille.add(affGrille[i][j]);	// passe la référense du label au panel
				affGrille[i][j].addMouseListener(new EcouteurGrille(ctrlV,affGrille[i][j],j+1,i+1)) ;
			}
		}
		
		refreshGrilleDisplay() ;
	}
	
	/**
	 * méthode qui permet d'afficher les batiments de la grille selon leur taille
	 */
	public void refreshGrilleDisplay(){
		int lenght = ctrlV.getTailleGrille() ;
		for (int i=0 ; i<lenght ; i++){
			for (int j=0 ; j<lenght ; j++)
				affGrille[i][j].setIcon(new ImageIcon(Bat.associatBA(ctrlV.getCtrlM().getLaGrille().getCase(j+1,i+1).getBatiment()))) ;
		}
		validate();
	}
	
	/**
	 * revoit le controleur des vues passer en parametre du constructeur
	 * @return {@link ControleurVues}
	 */
	public ControleurVues getCtrlV() {
		return ctrlV;
	}
}

