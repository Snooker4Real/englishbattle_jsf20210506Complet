package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Ville;

public interface VilleService {

	List<Ville> recupererVilles();

	Ville recupererVilleParId(Long idVille);
}
