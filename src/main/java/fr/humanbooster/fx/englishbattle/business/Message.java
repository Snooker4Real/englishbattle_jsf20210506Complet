package fr.humanbooster.fx.englishbattle.business;

import java.util.Date;

public class Message {

	private Long id;
	private Joueur expediteur;
	private Joueur destinataire;
	private String objet;
	private String corps;
	private Date dateEnvoi;
	private Date dateLecture;
	private Date dateReponse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Joueur getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Joueur expediteur) {
		this.expediteur = expediteur;
	}

	public Joueur getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Joueur destinataire) {
		this.destinataire = destinataire;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}

	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	public Date getDateLecture() {
		return dateLecture;
	}

	public void setDateLecture(Date dateLecture) {
		this.dateLecture = dateLecture;
	}

	public Date getDateReponse() {
		return dateReponse;
	}

	public void setDateReponse(Date dateReponse) {
		this.dateReponse = dateReponse;
	}

	@Override
	public String toString() {
		return "Message [expediteur=" + expediteur + ", destinataire=" + destinataire + ", objet=" + objet + ", corps="
				+ corps + ", dateEnvoi=" + dateEnvoi + ", dateLecture=" + dateLecture + ", dateReponse=" + dateReponse
				+ "]";
	}

}
