package fr.humanbooster.fx.englishbattle.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.util.ComparateurDeJoueurSurScore;

public class JoueurServiceImpl implements JoueurService {

	private static List<Joueur> joueurs = new ArrayList<>();
	private NiveauService niveauService = new NiveauServiceImpl();
	private VilleService villeService = new VilleServiceImpl();
	
	public JoueurServiceImpl() {
		if (joueurs.isEmpty()) {
			Joueur joueur1 = new Joueur("fx@hb.com", "COTE", "Fx", "1234");
			joueur1.setVille(villeService.recupererVilles().get(0));
			joueur1.setNiveau(niveauService.recupererNiveaux().get(0));
			joueurs.add(joueur1);
			Joueur joueur2 = new Joueur("js@hb.com", "SAMPLE", "John", "1234");
			joueur2.setVille(villeService.recupererVilles().get(0));
			joueur2.setNiveau(niveauService.recupererNiveaux().get(0));
			joueurs.add(joueur2);
		}
	}

	@Override
	public Joueur ajouterJoueur(String email, String motDePasse) {
		Joueur joueur = new Joueur(email, motDePasse);
		joueurs.add(joueur);
		return joueur;
	}

	@Override
	public Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse) {
		Joueur joueur = new Joueur(email, nom, prenom, motDePasse);
		joueurs.add(joueur);
		return joueur;
	}

	@Override
	public Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse, Long idNiveau) {
		Joueur joueur = ajouterJoueur(email, nom, prenom, motDePasse);
		joueur.setNiveau(niveauService.recupererNiveau(idNiveau));
		joueurs.add(joueur);
		return joueur;
	}

	@Override
	public Joueur ajouterJoueur(String email, String nom, String prenom, String motDePasse, Long idNiveau,
			Long idVille) {
		Joueur joueur = ajouterJoueur(email, nom, prenom, motDePasse);
		joueur.setNiveau(niveauService.recupererNiveau(idNiveau));
		joueur.setVille(villeService.recupererVilleParId(idVille));
		joueurs.add(joueur);
		return joueur;
	}

	@Override
	public Joueur ajouterJoueur(Joueur joueur) {
		joueurs.add(joueur);
		System.out.println(joueurs);
		return joueur;
	}
	
	@Override
	public List<Joueur> recupererJoueurs() {
		return joueurs;
	}

	@Override
	public List<Joueur> recupererJoueursDuHallOfFame() {
		Collections.sort(joueurs, new ComparateurDeJoueurSurScore());
		return joueurs;
	}

	@Override
	public Joueur recupererJoueur(String email) {
		for (Joueur joueur : joueurs) {
			if (joueur.getEmail().equals(email)) {
				return joueur;
			}
		}
		return null;
	}

	@Override
	public Joueur recupererJoueur(String email, String motDePasse) {
		for (Joueur joueur : joueurs) {
			if (joueur.getEmail().equals(email) && joueur.getMotDePasse().equals(motDePasse)) {
				return joueur;
			}
		}
		return null;
	}

	@Override
	public Joueur recupererJoueurParId(Long idJoueur) {
		for (Joueur joueur : joueurs) {
			if (joueur.getId().equals(idJoueur)) {
				return joueur;
			}
		}
		return null;
	}

	@Override
	public List<Joueur> recupererJoueursSaufJoueurAyantId(Long idJoueur) {
		List<Joueur> joueursCorrespondants = new ArrayList<>();
		for (Joueur joueur : joueurs) {
			if (!joueur.getId().equals(idJoueur)) {
				joueursCorrespondants.add(joueur);
			}
		}
		return joueursCorrespondants;
	}
	
	@Override
	public Joueur modifierMotDePasse(Long id, String motDePasse) {
		Joueur joueur = recupererJoueurParId(id);
		if (joueur!=null) joueur.setMotDePasse(motDePasse);
		return joueur;
	}

	@Override
	public boolean supprimerJoueur(Long id) {
		Joueur joueur = recupererJoueurParId(id);
		if (joueur!=null) {
			joueurs.remove(joueur);
			return true;
		}
		return false;
	}

}
