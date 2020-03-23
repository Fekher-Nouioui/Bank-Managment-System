package agenceBanquaire;

import exceptions.SoldeEnRougeException;
import exceptions.SoldeNegatifException;

abstract public class Compte {

	private Agence agence;
	private long RIB;
	private double solde;

	static int nbreClients;
	static double debitGlobalBanque;
	static double creditGlobalBanque;

	// Constructor

	public Compte(Agence agence, long rib, double montant) throws SoldeNegatifException {

		if (montant < 0)
			throw new SoldeNegatifException("Instance d'un objet avec un solde Négatif ! Le programme vas s'arréter");
		this.agence = agence;
		this.RIB = rib;
		this.solde = montant;

		Compte.debitGlobalBanque += montant;
		this.getAgence().setDebitGlobalAgence(this.getAgence().getDebitGlobalAgence() + montant);

		Compte.nbreClients++;
		this.getAgence().ajouterCompte(this);
	}

	// Transactions Methods

	abstract public void versement(double montant);

	abstract public boolean retrait(double montant) throws SoldeNegatifException, SoldeEnRougeException;

	abstract public void virement(Compte c, double montant);

	// Comparing Methods

	public static boolean compare_soldes(Compte c1, Compte c2) {
		return c1.getSolde() == c2.getSolde();
	}

	public boolean compare_soldes(Compte c1) {
		return this.solde == c1.getSolde();
	}

	// Getters and Setters

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public long getRIB() {
		return RIB;
	}

	public void setRIB(long rIB) {
		RIB = rIB;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [agence=" + agence + ", RIB=" + RIB + ", solde=" + solde + "]";
	}

}
