package fr.humanbooster.fx.englishbattle.coordination;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.exceptions.AucunVerbeException;
import fr.humanbooster.fx.englishbattle.service.QuestionService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.QuestionServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;

@ManagedBean(name = "questionBean")
@RequestScoped
public class QuestionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VerbeService verbeService = new VerbeServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	private HttpSession session = SessionBean.getSession();

	public String verifierReponse() {
		Question question = (Question) session.getAttribute("question");
		Joueur joueur = (Joueur) session.getAttribute("joueur");

		if (joueur==null) {
			// La session a expiré
			return "index?faces-redirect=true";
		}
		if (verbeService.verifierReponse(question)) {
			// On récupère la partie en cours
			Partie partie = (Partie) session.getAttribute("partie");
			// On ajoute une nouvelle question à la partie en cours
			try {
				Question nouvelleQuestion = questionService.ajouterQuestion(partie, verbeService.recupererVerbeAleatoire(partie));
				if (joueur.getNiveau()!=null && !joueur.getNiveau().getNom().equals("Expert")) {
					// Un indice
					if (Math.random()>0.5) {
						nouvelleQuestion.setReponseParticipePasse(nouvelleQuestion.getVerbe().getParticipePasse());
					} else {
						nouvelleQuestion.setReponsePreterit(nouvelleQuestion.getVerbe().getPreterit());						
					}
				}
				session.setAttribute("question", nouvelleQuestion);
			} catch (AucunVerbeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "question?faces-redirect=true";
			}
		else {
			// Mauvaise réponse, on rend la session invalide
			session.invalidate();
			// On redirige vers la page d'accueil
			return "index?faces-redirect=true";
		}
	}

}