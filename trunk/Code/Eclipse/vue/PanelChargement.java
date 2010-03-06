package vue;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.border.Border;

import Ecouteur.EcouteCharger;

import java.io.* ;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.Observateur;
import controleur.ControleurR;
import controleur.ControleurVues;

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
	private JPanel listeFichier ;

	/**
	 * This is the default constructor
	 */
	public PanelChargement() {
		super();
		initialize();
	}
	
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
		this.setSize(507, 353);
		this.setLayout(new BorderLayout());
		this.add(getJsList(), BorderLayout.WEST);
		this.add(getJpSud(), BorderLayout.SOUTH);
		this.add(getJpGrilleJeu(), BorderLayout.CENTER);
		this.add(new JLabel(" "), BorderLayout.EAST) ;
	}

	/**
	 * This method initializes jbCharger	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbCharger() {
		if (jbCharger == null) {
			jbCharger = new JButton();
			jbCharger.setText("Charger");
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
			jbRetour.setText("Retour");
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
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jpSud = new JPanel();
			jpSud.setLayout(gridLayout);
			jpSud.add(getJLvide(), null);
			jpSud.add(getJbCharger(), null);
			jpSud.add(getJbRetour(), null);
		}
		return jpSud;
	}

	/**
	 * This method initializes jLvide	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLvide() {
		if (jLvide == null) {
			jLvide = new JLabel();
			jLvide.setText("     ");
		}
		return jLvide;
	}

	/**
	 * This method initializes jsList	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJsList() {
		if (jsList == null) {
			jsList = new JScrollPane();
			jsList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
		if (listeFichier == null) {
			listeFichier = new JPanel();
			jlPartieCharger = new JList();
			
			String[] listeFichiers;
			File repertoire = new File(ctrlV.getCtrlM().getPath());
			listeFichiers = repertoire.list();
					
			int nbelem = listeFichiers.length;
			listeFichier.setLayout(new GridLayout(nbelem,1)); 
			for(int i=0;i<listeFichiers.length;i++){
				if(listeFichiers[i].endsWith(".grille")){
					JLabel tempLabel = new JLabel(listeFichiers[i]) ;
					tempLabel.addMouseListener(new EcouteCharger(ctrlV,listeFichiers[i])) ;
					listeFichier.add(tempLabel);
				}
			}
		}
		return listeFichier ;
	}
	
	public void refreshGrille(){
		this.remove(jpGrilleJeu) ;
		jpGrilleJeu = null ;
		this.add(getJpGrilleJeu()) ;
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
			jpGrilleJeu.setLayout(new GridBagLayout());
			jpGrilleJeu.setSize(new Dimension(227, 189));
			jpGrilleJeu.add(new PanelGrilleDeJeu(4,obsChargement,false));
		}
		return jpGrilleJeu;
	}

	public Observateur getObsChargement() {
		return obsChargement;
	}

	public void setObsChargement(Observateur obsChargement) {
		this.obsChargement = obsChargement;
	}

}  //  @jve:decl-index=0:visual-constraint="33,17"
