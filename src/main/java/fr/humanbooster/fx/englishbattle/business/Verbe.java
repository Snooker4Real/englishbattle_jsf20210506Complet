package fr.humanbooster.fx.englishbattle.business;

public class Verbe {

	private Long id;
	private String baseVerbale;
	private String preterit;
	private String participePasse;
	private String traduction;
	private static Long compteur = 0L;
	
	public Verbe() {
		this.id = ++compteur;
	}	

	public Verbe(String baseVerbale, String preterit, String participePasse) {
		super();
		this.baseVerbale = baseVerbale;
		this.preterit = preterit;
		this.participePasse = participePasse;
	}

	public Verbe(String baseVerbale, String preterit, String participePasse, String traduction) {
		this(baseVerbale, preterit, participePasse);
		this.traduction = traduction;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBaseVerbale() {
		return baseVerbale;
	}

	public void setBaseVerbale(String baseVerbale) {
		this.baseVerbale = baseVerbale;
	}

	public String getPreterit() {
		return preterit;
	}

	public void setPreterit(String preterit) {
		this.preterit = preterit;
	}

	public String getParticipePasse() {
		return participePasse;
	}

	public void setParticipePasse(String participePasse) {
		this.participePasse = participePasse;
	}

	public String getTraduction() {
		return traduction;
	}

	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}

	@Override
	public String toString() {
		return "Verbe [baseVerbale=" + baseVerbale + ", preterit=" + preterit + ", participePasse=" + participePasse
				+ ", traduction=" + traduction + "]";
	}

}