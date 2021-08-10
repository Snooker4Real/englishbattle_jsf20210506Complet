package fr.humanbooster.fx.englishbattle.service;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;

public interface QuestionService {

	Question ajouterQuestion(Partie partie, Verbe verbe);
}
