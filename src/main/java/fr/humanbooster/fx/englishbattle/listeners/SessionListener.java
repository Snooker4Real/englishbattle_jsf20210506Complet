package fr.humanbooster.fx.englishbattle.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.humanbooster.fx.englishbattle.business.Partie;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent evenement) {
		System.out.println("Connexion ");
	}

	/**
	 * Patron Observateur/Observé
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent evenement) {
		Partie partie = (Partie) evenement.getSession().getAttribute("partie");
		if (partie != null) {
			partie.getJoueur().setEstEnLigne(false);
			System.out.println("Déconnexion de " + partie.getJoueur().getPrenom());
		}
	}

}
