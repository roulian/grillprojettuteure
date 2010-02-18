package vue;

import java.awt.BorderLayout;

import javax.swing.*;

import controleur.ControleurVues;

public class DialogRegles extends JDialog {

	public DialogRegles(JFrame parent){
		//On appelle le construteur de JDialog correspondant
		super(parent, "Règles", true);
		//On spécifie une taille
		this.setSize(400, 500);
		//La position
		this.setLocationRelativeTo(null);
		//La boîte ne devra pas être redimensionnable
		this.setResizable(false);

		this.add(new JLabel("En cours de jeu, le Jeu GRILL se compose d'une grille, elle-même composée de cases, entourée par des observateurs.\nChaque case contient un immeuble de ‘n’ étages. Les immeubles d’une même rangée, ligne ou colonnes, sont tous de tailles différentes. Les informations données sur les bords, c'est à dire par les observateurs, indiquent le nombre d’immeubles visibles sur la rangée correspondante par un observateur situé à cet endroit."),BorderLayout.CENTER);
		this.add(new JButton("Retour"),BorderLayout.SOUTH);
		//Enfin on l'affiche
		this.setVisible(true);
	}
}