package agenceBanquaire;

public class Banque {

	private String nom;
	static int nbAgences;
	static Agence[] agences = new Agence[20];

	// Constructor

	public Banque(String nom) {
		this.nom = nom;
	}

	// Méthode statique utilisé dans le constructeur de la classe agence qui permet
	// d'ajouter une agence à la table d'agence de la classe banque tout en
	// incrémentant le nombre d'agence
	public static void ajouterAgence(Agence ag) {
		Banque.agences[Banque.nbAgences] = ag;
		Banque.nbAgences++;
	}

	// Getters and Setters

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// toString
	@Override
	public String toString() {
		String message = "BANQUE : \n\tNom : " + nom + "\n\tDebit Global : " + Compte.debitGlobalBanque
				+ "\n\tCrédit Golobal : " + Compte.creditGlobalBanque + "\n\tNombre de Client : " + Compte.nbreClients
				+ "\n\tNombre d'agences : " + nbAgences + "\n\tLes agences :";
		for (int i = 0; i < Banque.nbAgences; i++) {
			message += Banque.agences[i].toString();
		}
		return message;
	}

}
