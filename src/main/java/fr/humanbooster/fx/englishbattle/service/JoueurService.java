package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;

public interface JoueurService {

	Joueur ajouterJoueur(String email, String motDePasse);
	Joueur ajouterJoueur(String mail, String nom, String prenom, String motDePasse);
	Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse, Long idNiveau);
	Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse, Long idNiveau, Long idVille);
	Joueur ajouterJoueur(Joueur joueur);
	
	List<Joueur> recupererJoueurs();
	List<Joueur> recupererJoueursDuHallOfFame();
	Joueur recupererJoueur(String email);
	Joueur recupererJoueur(String email, String motDePasse);
	Joueur recupererJoueurParId(Long idJoueur);
	List<Joueur> recupererJoueursSaufJoueurAyantId(Long idJoueur);
	
	Joueur modifierMotDePasse(Long id, String motDePasse);
	
	boolean supprimerJoueur(Long id);
	
}
