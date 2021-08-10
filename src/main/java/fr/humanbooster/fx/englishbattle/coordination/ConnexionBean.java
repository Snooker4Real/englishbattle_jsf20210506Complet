package fr.humanbooster.fx.englishbattle.coordination;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.exceptions.AucunVerbeException;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.QuestionService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.PartieServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.QuestionServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.VerbeServiceImpl;

@ManagedBean(name = "connexionBean")
@RequestScoped
public class ConnexionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private JoueurService joueurService = new JoueurServiceImpl();
	private PartieService partieService = new PartieServiceImpl();
	private VerbeService verbeService = new VerbeServiceImpl();
	private QuestionService questionService = new QuestionServiceImpl();
	
	private Joueur joueur;
	
    public ConnexionBean() {
        joueur = new Joueur();
    }

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public String connexion() {

		System.out.println("Connexion de " + joueur);
		Joueur joueurExistant = joueurService.recupererJoueur(joueur.getEmail(), joueur.getMotDePasse());
		if (joueurExistant!=null) {
			HttpSession session = SessionBean.getSession();
			
			joueurExistant.setEstEnLigne(true);
			session.setAttribute("joueur", joueurExistant);
			// on ajoute une nouvelle partie et on la met en session
			Partie partie = partieService.ajouterPartie(joueurExistant);
			session.setAttribute("partie", partie);
			
			// on ajoute une nouvelle question et on la met en session
			try {
				Question nouvelleQuestion = questionService.ajouterQuestion(partie, verbeService.recupererVerbeAleatoire(partie));

				if (joueurExistant.getNiveau()!=null && !joueurExistant.getNiveau().getNom().equals("Expert")) {
					// Un indice
					if (Math.random()>0.5) {
						nouvelleQuestion.setReponseParticipePasse(nouvelleQuestion.getVerbe().getParticipePasse());
					} else {
						nouvelleQuestion.setReponsePreterit(nouvelleQuestion.getVerbe().getPreterit());						
					}
				}
				session.setAttribute("question", nouvelleQuestion);
			} catch (AucunVerbeException e) {
				e.printStackTrace();
			}
			System.out.println("ok");
			return "tableauDeBord";
		} else {
			System.out.println("pas ok");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Login ou mot de passe incorrect", "Veuillez saisir les bons identifiants"));
			return "index";
		}
	}

	public String logout() {
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "index";
	}

}