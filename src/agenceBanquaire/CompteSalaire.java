package agenceBanquaire;

import exceptions.SoldeEnRougeException;
import exceptions.SoldeNegatifException;

public class CompteSalaire extends Compte {

	private ClientNormal client;

	// Contructor

	public CompteSalaire(Agence agence, ClientNormal client, long rib, double montant) throws SoldeNegatifException {

		super(agence, rib, montant);

		this.client = client;

	}

	// Transaction Methods

	@Override
	public void versement(double montant) {

		this.setSolde(this.getSolde() + montant);
		this.getAgence().setDebitGlobalAgence(this.getAgence().getDebitGlobalAgence() + montant);
		Compte.debitGlobalBanque += montant;
		System.out.println(
				"Versement de " + montant + " DT dans le compte possédant le RIB " + this.getRIB() + " avec succées");
	}

	@Override
	public boolean retrait(double montant) throws SoldeEnRougeException {

		final double VALEUR_SEUIL = -this.getSolde() * 0.05;
		final double MONTANT_APRES_RETRAIT = this.getSolde() - montant;
		if (MONTANT_APRES_RETRAIT >= VALEUR_SEUIL) {
			this.setSolde(this.getSolde() - montant);
			Compte.debitGlobalBanque += montant;
			this.getAgence().setCreditGlobalAgence(this.getAgence().getCreditGlobalAgence() + montant);
			System.out.println(
					"Retrait de " + montant + " DT du compte possédant le RIB " + this.getRIB() + " avec sucées !");
			if (MONTANT_APRES_RETRAIT < 0) {
				System.out.println(
						"Attention ! Le compte possédant le RIB " + this.getRIB() + " contient un solde négatif");
			}
			return true;
		} else {
			throw new SoldeEnRougeException("Retrait de " + montant + " DT du compte possédant le RIB " + this.getRIB()
					+ " a échoué car ça dépasse le plafond de retrait en Rouge, le programme va s'arréter !");
		}
	}

	@Override
	public void virement(Compte c, double montant) {
		try {
			if (this.retrait(montant))
				c.versement(montant);
		} catch (SoldeEnRougeException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	// Getters and Setters

	public ClientNormal getClient() {
		return client;
	}

	public void setClient(ClientNormal client) {
		this.client = client;
	}

	// toString

	@Override
	public String toString() {
		String message = "Compte Salaire :\n\tNom Agence :" + this.getAgence().getNom() + "\n\tAdresse Agence :"
				+ this.getAgence().getAdresse() + "\n\tRIB : " + this.getRIB() + "\n\tSolde : " + this.getSolde()
				+ this.getClient().toString();
		return message;
	}

}
