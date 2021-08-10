package fr.humanbooster.fx.englishbattle.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.service.PartieService;

public class PartieServiceImpl implements PartieService {

	private static List<Partie> parties = new ArrayList<>();

	@Override
	public Partie ajouterPartie(Joueur joueur) {
		Partie partie = new Partie(joueur);
		joueur.addPartie(partie);
		parties.add(partie);
		return partie;
	}

	@Override
	public boolean estPresent(Partie partie, Verbe verbe) {

		for (Question question : partie.getQuestions()) {
			if (question.getVerbe().getBaseVerbale().equals(verbe.getBaseVerbale())) {
				return true;
			}
		}

		return false;

	}
}
