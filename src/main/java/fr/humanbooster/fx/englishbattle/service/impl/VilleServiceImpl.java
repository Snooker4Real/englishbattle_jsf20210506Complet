package fr.humanbooster.fx.englishbattle.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.service.VilleService;

public class VilleServiceImpl implements VilleService {

	private static List<Ville> villes = new ArrayList<>();

	public VilleServiceImpl() {
		if (villes.isEmpty()) {
			villes.add(new Ville("Lyon"));
			villes.add(new Ville("Saint-Galmier"));
			villes.add(new Ville("Tassin"));
		}
	}

	@Override
	public List<Ville> recupererVilles() {
		return villes;
	}

	@Override
	public Ville recupererVilleParId(Long idVille) {
		for (Ville ville : villes) {
			if (ville.getId().equals(idVille)) {
				return ville;
			}
		}

		return null;
	}

}
