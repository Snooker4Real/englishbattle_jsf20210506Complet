package fr.humanbooster.fx.englishbattle.coordination;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Niveau;
import fr.humanbooster.fx.englishbattle.business.Ville;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.NiveauService;
import fr.humanbooster.fx.englishbattle.service.VilleService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.NiveauServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VilleServiceImpl;

@ManagedBean(name = "inscriptionBean")
@RequestScoped
public class InscriptionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NiveauService niveauService = new NiveauServiceImpl();
	public VilleService villeService = new VilleServiceImpl();
	public JoueurService joueurService = new JoueurServiceImpl();
	private String idVille;
	private String idNiveau;
	private List<Niveau> niveaux = niveauService.recupererNiveaux();
	private List<Ville> villes = villeService.recupererVilles();
	private List<Joueur> joueurs = joueurService.recupererJoueurs();
	private List<Joueur> joueursDuHallOfFame = joueurService.recupererJoueursDuHallOfFame();
	private Joueur joueur = new Joueur();

	public String getIdVille() {
		return idVille;
	}

	public void setIdVille(String idVille) {
		this.idVille = idVille;
	}

	public String getIdNiveau() {
		return idNiveau;
	}

	public void setIdNiveau(String idNiveau) {
		this.idNiveau = idNiveau;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public void setNiveaux(List<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public String ajouterJoueur() {
		joueur.setVille(villeService.recupererVilleParId(Long.parseLong(idVille)));
		joueur.setNiveau(niveauService.recupererNiveau(Long.parseLong(idNiveau)));
		joueurService.ajouterJoueur(joueur);
		return "index";
	}

	public List<Niveau> getNiveaux() {
		return niveaux;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public List<Joueur> getJoueursDuHallOfFame() {
		return joueursDuHallOfFame;
	}

	public void setJoueursDuHallOfFame(List<Joueur> joueursDuHallOfFame) {
		this.joueursDuHallOfFame = joueursDuHallOfFame;
	}
}
