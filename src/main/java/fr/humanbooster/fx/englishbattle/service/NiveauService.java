package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Niveau;

public interface NiveauService {

	List<Niveau> recupererNiveaux();

	Niveau recupererNiveau(Long idNiveau);

}
