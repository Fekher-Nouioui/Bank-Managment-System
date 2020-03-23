package agenceBanquaire;

public class ClientNormal extends Client {

	// Constructor
	public ClientNormal(String nom, String prenom, String profession, long telephone, long cin) {
		super(nom, prenom, profession, telephone, cin);
	}

	// toString
	@Override
	public String toString() {
		String message = "\n\tCLIENT NORMAL :\n\tNom : " + this.getNom() + "\n\tPr�nom : " + this.getPrenom()
				+ "\n\tProfession : " + this.getProfession() + "\n\tT�l�phone : " + this.getTelephone() + "\n\tCIN : "
				+ this.getCin() + "\n";
		return message;
	}

}
