package fr.humanbooster.fx.englishbattle.coordination;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpSession;

import fr.humanbooster.fx.englishbattle.business.Joueur;
import fr.humanbooster.fx.englishbattle.business.Message;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.MessageService;
import fr.humanbooster.fx.englishbattle.service.impl.JoueurServiceImpl;
import fr.humanbooster.fx.englishbattle.service.impl.MessageServiceImpl;

@ManagedBean(name = "messagerieBean")
@RequestScoped
public class MessagerieBean {
    private JoueurService joueurService = new JoueurServiceImpl();
    private MessageService messageService = new MessageServiceImpl();
    private HttpSession session = SessionBean.getSession();
    private Joueur joueur = null;
    private List<Joueur> joueurs = null;
    private List<Message> messages = null;
    private Message message = null;
    
    public MessagerieBean () {
        joueur  = (Joueur) session.getAttribute("joueur");
        joueurs = joueurService.recupererJoueursSaufJoueurAyantId(joueur.getId());
        messages = messageService.recupererMessages(joueur.getId());
        System.out.println("Dans MessagerieBean : " + joueur.getNom());
        message = new Message();
        message.setDestinataire(new Joueur());
     }
    
	public String envoyerMessage() {
		message = messageService.ajouterMessage(joueur.getId(), message.getDestinataire().getId(), message.getObjet(), message.getCorps());
		System.out.println(message);
		return "tableauDeBord";
	}
    
    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}