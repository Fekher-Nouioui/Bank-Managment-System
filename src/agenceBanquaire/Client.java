package agenceBanquaire;

public abstract class Client {

	private String nom;
	private String prenom;
	private String profession;
	private long telephone;
	private long cin;

	// Constructor
	public Client(String nom, String prenom, String profession, long telephone, long cin) {
		this.nom = nom;
		this.prenom = prenom;
		this.profession = profession;
		this.telephone = telephone;
		this.cin = cin;
	}

	// Getters and Setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}
}
