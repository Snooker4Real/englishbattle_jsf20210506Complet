package fr.humanbooster.fx.englishbattle.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joueur {

	private Long id;	
	private String email;
	private String nom;
	private String prenom;
	private String motDePasse;
	private List<Partie> parties = new ArrayList<>();
	private Niveau niveau;
	private Ville ville;
	private boolean estEnLigne = false;
	private List<Connexion> connexions = new ArrayList<>();
	private static Long compteur = 0L;

	public Joueur() {
		super();
		this.id = ++compteur;
	}

	public Joueur(String email, String motDePasse) {
		this();
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Joueur(String email, String nom, String prenom, String motDePasse) {
		this(email, motDePasse);
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getMeilleurScore() {
		// Trie les parties du joueur sur le score et renvoie le score de la meilleure
		if (parties.isEmpty()) { return 0; }
		Collections.sort(parties);
		return parties.get(parties.size()-1).getScore();
	}
	
	public void addPartie(Partie partie) {
		parties.add(partie);
	}
	
	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public boolean isEstEnLigne() {
		return estEnLigne;
	}

	public void setEstEnLigne(boolean estEnLigne) {
		this.estEnLigne = estEnLigne;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	public boolean getEstAdministrateur()
	{
		if (getEmail()!=null && getEmail().endsWith("humanbooster.com"))
			return true;
		return false;
	}
	
	public long getTempsMoyenDeReponseEnSecondes()
	{
		int nbQuestions = 0;
		long dureeTotaleEnMillisecondes = 0;
		if (parties.isEmpty()) return 0;
		for (Partie partie : parties) {
			for (Question question: partie.getQuestions()) {
				if (question.getDateReponse()!=null) {
					nbQuestions++;
					dureeTotaleEnMillisecondes += question.getDateReponse().getTime()-question.getDateEnvoi().getTime();
				}
			}
		}
		return dureeTotaleEnMillisecondes/(nbQuestions*1000);
	}

	public List<Connexion> getConnexions() {
		return connexions;
	}

	public void setConnexions(List<Connexion> connexions) {
		this.connexions = connexions;
	}

	@Override
	public String toString() {
		return "Joueur [idJoueur=" + id + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom
				+ ", motDePasse=" + motDePasse + ", niveau=" + niveau + ", estEnLigne=" + estEnLigne + "]";
	}
}