package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Connexion;

public interface ConnexionService {

	Connexion ajouterConnexion(String idConnection, Long idJoueur, String ip);

	List<Connexion> recupererConnexionsParIdJoueur(Long idJoueur);
	Connexion recupererConnexionParId(String idConnexion);

	Connexion terminerConnexion(String idConnexion);

}
