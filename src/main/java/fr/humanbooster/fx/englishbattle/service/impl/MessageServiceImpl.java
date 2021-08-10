package fr.humanbooster.fx.englishbattle.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Message;
import fr.humanbooster.fx.englishbattle.service.JoueurService;
import fr.humanbooster.fx.englishbattle.service.MessageService;

public class MessageServiceImpl implements MessageService {

	private static List<Message> messages = new ArrayList<>();
	private JoueurService joueurService = new JoueurServiceImpl();

	@Override
	public Message ajouterMessage(Long idJoueurExpediteur, Long idJoueurDestinataire, String objet, String corps) {
		Message message = new Message();
		message.setExpediteur(joueurService.recupererJoueurParId(idJoueurExpediteur));
		message.setDestinataire(joueurService.recupererJoueurParId(idJoueurDestinataire));
		message.setDateEnvoi(new Date());
		message.setObjet(objet);
		message.setCorps(corps);
		messages.add(message);
		return message;
	}

	@Override
	public List<Message> recupererMessages(Long idJoueurDestinataire) {
		List<Message> messagesDuDestinataire = new ArrayList<>();
		for (Message message : messages) {
			if (message.getDestinataire().getId().equals(idJoueurDestinataire)) {
				messagesDuDestinataire.add(message);
			}
		}
		return messagesDuDestinataire;
	}

}
