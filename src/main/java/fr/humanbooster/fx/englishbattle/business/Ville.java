package fr.humanbooster.fx.englishbattle.business;

public class Ville {

	private Long id;
	private String nom;
	private int nbHabitants;
	private static Long compteur = 0L;
	
	public Ville(String nom) {
		super();
		this.id = ++compteur;
		this.nom = nom;
	}

	public Ville(String nom, int nbHabitants) {
		this(nom);
		this.nbHabitants = nbHabitants;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Ville [id=" + id + ", nom=" + nom + "]";
	}

	public int getNbHabitants() {
		return nbHabitants;
	}

	public void setNbHabitants(int nbHabitants) {
		this.nbHabitants = nbHabitants;
	}
	
}
