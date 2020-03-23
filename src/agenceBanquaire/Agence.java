package agenceBanquaire;

public class Agence {

	private int id;
	private String nom;
	private String adresse;

	private double debitGlobalAgence;
	private double creditGlobalAgence;

	private int nbreClients;
	private Compte[] comptes = new Compte[20];

	// Constructor

	public Agence(int id, String nom, String adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		Banque.ajouterAgence(this);
	}

	public void ajouterCompte(Compte cpt) {
		comptes[this.getNbreClients()] = cpt;
		this.setNbreClients(this.getNbreClients() + 1);
	}
	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbreClients() {
		return nbreClients;
	}

	public void setNbreClients(int nbreClients) {
		this.nbreClients = nbreClients;
	}

	public double getDebitGlobalAgence() {
		return debitGlobalAgence;
	}

	public void setDebitGlobalAgence(double debitGlobalAgence) {
		this.debitGlobalAgence = debitGlobalAgence;
	}

	public double getCreditGlobalAgence() {
		return creditGlobalAgence;
	}

	public void setCreditGlobalAgence(double creditGlobalAgence) {
		this.creditGlobalAgence = creditGlobalAgence;
	}

	public Compte[] getComptes() {
		return comptes;
	}

	public void setComptes(Compte[] comptes) {
		this.comptes = comptes;
	}

	// toString
	@Override
	public String toString() {
		String message = "\n\tINFO AGENCE :\n\t\tid : " + this.id + "\n\t\tNom : " + this.nom + "\n\t\tAdresse : "
				+ this.adresse + "\n\t\tDebit Global : " + this.debitGlobalAgence + "\n\t\tCrédit Global : "
				+ this.creditGlobalAgence + "\n\t\tNombre Clients : " + this.nbreClients + "\n";
		return message;
	}

}
