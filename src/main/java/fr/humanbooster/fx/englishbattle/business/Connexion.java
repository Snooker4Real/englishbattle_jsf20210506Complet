package fr.humanbooster.fx.englishbattle.business;

import java.util.Date;

public class Connexion {

	private String idConnexion;
	private Joueur joueur;
	private Date dateDebut;
	private Date dateFin;
	private String ip;
	
	public Connexion() {
		this.dateDebut = new Date();
	}
	
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIdConnexion() {
		return idConnexion;
	}

	public void setIdConnexion(String idConnexion) {
		this.idConnexion = idConnexion;
	}
	
}
