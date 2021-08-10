package fr.humanbooster.fx.englishbattle.service;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Verbe;

public interface PartieService {

	Partie ajouterPartie(Joueur joueur);

	boolean estPresent(Partie partie, Verbe verbe);

}
