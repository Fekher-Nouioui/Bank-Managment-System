package agenceBanquaire;

public class ClientVIP extends ClientNormal {

	private double chiffreAffaire;
	private int capacite;
	private String nomEntreprise;

	// constructor
	public ClientVIP(String nom, String prenom, String profession, long telephone, long cin, double chiffreAffaire,
			int capacite, String nomEntreprise) {

		super(nom, prenom, profession, telephone, cin);
		this.chiffreAffaire = chiffreAffaire;
		this.capacite = capacite;
		this.nomEntreprise = nomEntreprise;
	}

	// getters and setters
	public double getChiffreAffaire() {
		return chiffreAffaire;
	}

	public void setChiffreAffaire(double chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	// toString
	@Override
	public String toString() {
		String message = "\n\t CLIENT VIP :\n\tNom : " + this.getNom() + "\n\tPrénom : " + this.getPrenom()
				+ "\n\tProfession : " + this.getProfession() + "\n\tTéléphone : " + this.getTelephone() + "\n\tCIN : "
				+ this.getCin() + "\n\tNom de l'entreprise : " + nomEntreprise + "\n\tchiffre d'affaire : "
				+ chiffreAffaire + "\n\tCapacité : " + capacite + "\n";
		return message;
	}

}
