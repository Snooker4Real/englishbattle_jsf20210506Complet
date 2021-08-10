package fr.humanbooster.fx.englishbattle.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.humanbooster.fx.englishbattle.business.Partie;
import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.exceptions.AucunVerbeException;
import fr.humanbooster.fx.englishbattle.service.PartieService;
import fr.humanbooster.fx.englishbattle.service.VerbeService;

public class VerbeServiceImpl implements VerbeService {

	private static List<Verbe> verbes = new ArrayList<>();
	private PartieService partieService = new PartieServiceImpl();

	public VerbeServiceImpl() {
		if (verbes.isEmpty()) {
			System.out.println("Chargement des verbes à partir du fichier CSV en ligne");
			recupererVerbes("https://www.clelia.fr/Battle/englishbattle.csv");
			System.out.println("Nombre de verbes chargés=" + verbes.size());
		}
	}

	private void recupererVerbes(String nomFichier) {
		BufferedReader br = null;
		String cvsSplitBy = ",";
		String line = "";

		try {
			URL u = new URL(nomFichier);
			br = new BufferedReader(new InputStreamReader(u.openStream(), "UTF-8"));

			while ((line = br.readLine()) != null) {
				String[] info = line.split(cvsSplitBy);
				// On enlève les guillements qui entourent chaque info
				for (int i = 1; i < info.length; i++) {
					info[i] = info[i].substring(1, info[i].length() - 1);
				}
				Verbe verbe = new Verbe(info[1], info[3], info[2], info[4]);
				verbes.add(verbe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Verbe recupererVerbeAleatoire() {
		Random random = new Random();
		return verbes.get(random.nextInt(verbes.size()));
	}

	@Override
	public Verbe recupererVerbeAleatoire(Partie partie) throws AucunVerbeException {
		// Si la partie contient un nombre de verbes égale à la taille de la liste
		// verbes
		// lever l'exception AucunVerbeException: le joueur sait tout !!
		if (partie.getNbQuestions() == verbes.size())
			throw new AucunVerbeException("Perfect !");

		Verbe verbe = null;

		// un verbe, pas encore demandé dans la partie, est choisi de manière aléatoire
		do {
			verbe = recupererVerbeAleatoire();
		} while (partieService.estPresent(partie, verbe));

		return verbe;
	}

	@Override
	public boolean verifierReponse(Question question) {
		return question.getVerbe().getPreterit().equals(question.getReponsePreterit())
				&& question.getVerbe().getParticipePasse().equals(question.getReponseParticipePasse());
	}

	@Override
	public Verbe recupererVerbe(String baseVerbale) {
		for (Verbe verbe : verbes) {
			if (verbe.getBaseVerbale().equals(baseVerbale))
				return verbe;
		}
		return null;
	}

	@Override
	public int getNbVerbes() {
		return verbes.size();
	}

	@Override
	public Verbe ajouterVerbe(String baseVerbale, String preterit, String participePasse, String traduction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Verbe> recupererVerbes() {
		// TODO Auto-generated method stub
		return verbes;
	}

	@Override
	public Verbe recupererVerbeParId(Long idVerbe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Verbe modifierVerbe(Long idVerbe, String baseVerbale, String preterit, String participePasse,
			String traduction) {
		// TODO Auto-generated method stub
		return null;
	}

}
