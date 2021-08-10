package fr.humanbooster.fx.englishbattle.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Connexion;
import fr.humanbooster.fx.englishbattle.service.ConnexionService;
import fr.humanbooster.fx.englishbattle.service.JoueurService;

public class ConnexionServiceImpl implements ConnexionService {

	private static List<Connexion> connexions = new ArrayList<>();
	private JoueurService joueurService = new JoueurServiceImpl();
	
	@Override
	public Connexion ajouterConnexion(String idConnexion, Long idJoueur, String ip)
	{
		Connexion connexion = new Connexion();
		connexion.setIdConnexion(idConnexion);
		connexion.setJoueur(joueurService.recupererJoueurParId(idJoueur));
		connexion.setIp(ip);
		connexions.add(connexion);
		return connexion;
	}
	
	@Override
	public Connexion recupererConnexionParId(String idConnexion)
	{
		for (Connexion connexion : connexions) {
			if (connexion.getIdConnexion().equals(idConnexion))
				return connexion;
		}
		return null;
	}

	@Override
	public Connexion terminerConnexion(String idConnexion)
	{
		Connexion connexion = recupererConnexionParId(idConnexion);
		connexion.setDateFin(new Date());
		return connexion;
	}
	
	@Override
	public List<Connexion> recupererConnexionsParIdJoueur(Long idJoueur)
	{
		List<Connexion> connexionsDuJoueur = new ArrayList<>();
		for (Connexion connexion : connexions) {
			if (connexion.getJoueur().getId().equals(idJoueur))
			{
				connexionsDuJoueur.add(connexion);
			}
		}
		return connexionsDuJoueur;
	}

}