package fr.humanbooster.fx.englishbattle.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.service.NiveauService;

public class NiveauServiceImpl implements NiveauService {

	private static List<Niveau> niveaux = new ArrayList<>();

	public NiveauServiceImpl() {
		if (niveaux.isEmpty()) {
			niveaux.add(new Niveau("Débutant"));
			niveaux.add(new Niveau("Intermédiaire"));
			niveaux.add(new Niveau("Expert"));
		}
	}

	@Override
	public List<Niveau> recupererNiveaux() {
		return niveaux;
	}

	@Override
	public Niveau recupererNiveau(Long idNiveau) {
		for (Niveau niveau : niveaux) {
			if (niveau.getId().equals(idNiveau))
				return niveau;
		}
		return null;
	}

}
