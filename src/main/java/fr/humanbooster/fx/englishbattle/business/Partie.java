	package fr.humanbooster.fx.englishbattle.business;

import java.util.ArrayList;
import java.util.List;

public class Partie implements Comparable<Partie>{
	
	private Long id;
	private Joueur joueur;
	private List<Question> questions = new ArrayList<>();
	private static Long compteur = 0L;
	
	public Partie(Joueur joueur) {
		this.id = ++compteur;
		this.joueur = joueur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question getDerniereQuestion() {
		if (questions.isEmpty()) return null;
		return questions.get(questions.size()-1);
	}

	public int getNbQuestions()
	{
		return questions.size();
	}
	
	public int getScore() {
		if (questions.isEmpty()) { return 0; }
		// Est-ce que la dernière question a été répondu justement ?
		if (questions.get(questions.size()-1).getVerbe().getPreterit().equals(questions.get(questions.size()-1).getReponsePreterit()) 
				&& questions.get(questions.size()-1).getVerbe().getParticipePasse().equals(questions.get(questions.size()-1).getReponseParticipePasse()))
			return questions.size();
		return questions.size()-1;
	}
		
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	@Override
	public int compareTo(Partie autrePartie) {
		if (questions.size()==autrePartie.questions.size()) {
		return 0;
		}
		else if (questions.size()>autrePartie.questions.size()) return 1;
		else return -1;
	}
	
	@Override
	public String toString() {
		return "Partie [joueur=" + joueur + ", questions=" + questions + "]";
	}
	
}

