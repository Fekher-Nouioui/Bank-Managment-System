package agenceBanquaire;

import java.util.Calendar;
import java.util.GregorianCalendar;
import exceptions.SoldeNegatifException;

public class CompteEpargne extends Compte {

	private Client client;

	private double montantMensuel;

	private GregorianCalendar dateCreation;
	private GregorianCalendar dateDernierVersement;

	// Constructor

	public CompteEpargne(Agence agence, Client client, long rib, double montant) throws SoldeNegatifException {

		super(agence, rib, montant);

		this.client = client;
		this.montantMensuel = montant;

		this.dateCreation = new GregorianCalendar();
		this.dateDernierVersement = new GregorianCalendar();

	}

	@Override
	public void versement(double montant) {
		int anDernierVersement = this.getDateDernierVersement().get(Calendar.YEAR);
		int moisDernierVersement = this.getDateDernierVersement().get(Calendar.MONTH) + 1;

		int anActuel = new GregorianCalendar().get(Calendar.YEAR);
		int moisActuel = new GregorianCalendar().get(Calendar.MONTH) + 1;

		if (anDernierVersement == anActuel && moisDernierVersement == moisActuel) {

			this.setSolde(this.getSolde() + montant);
			this.setMontantMensuel(this.getMontantMensuel() + montant);

			this.getAgence().setDebitGlobalAgence(this.getAgence().getDebitGlobalAgence() + montant);
			Compte.debitGlobalBanque += montant;

			this.setDateDernierVersement(new GregorianCalendar());

			if (this.getMontantMensuel() >= 20) {
				System.out.println("Vous avez payé les 20 dinars minimum de ce mois !");
			} else
				System.out.println(
						"Vous devez encore payer " + (20 - this.getMontantMensuel()) + " avant la fin de ce mois !");
		} else if (anDernierVersement == anActuel && moisDernierVersement < moisActuel) {

			int nbrMoisAPayer = moisActuel - moisDernierVersement;
			double montantManquantDuMontantMensuel = 20 - this.getMontantMensuel();// en cas ou le client a payé mois de
																					// 20 dt la derniere fois
			double montantAPayer = nbrMoisAPayer * 20 + montantManquantDuMontantMensuel;

			this.setSolde(this.getSolde() + (montant - montantManquantDuMontantMensuel));
			this.getAgence().setDebitGlobalAgence(this.getAgence().getDebitGlobalAgence() + montant);
			Compte.debitGlobalBanque += montant;

			if (montantAPayer < montant) {
				this.setMontantMensuel(this.getMontantMensuel() + (montant - montantAPayer));
				this.setDateDernierVersement(new GregorianCalendar());
				System.out.println(
						"Vous avez payé le montant minmial pour " + nbrMoisAPayer + " les mois précédents ! Merci ");
			} else {
				int nbrMoisPaye = (int) (montant / 20);
				this.setMontantMensuel(montant % 20);
				this.getDateDernierVersement().set(GregorianCalendar.MONTH, (moisDernierVersement + nbrMoisPaye) - 1);
				System.out.println("Vous avez payé le montant minimal pour les mois " + nbrMoisPaye
						+ " précédents , il vous reste encore " + (nbrMoisAPayer - nbrMoisPaye)
						+ " mois dont le montant total est : " + (montantAPayer - montant) + " DT ! Merci");
			}
		} else {
			int nbrMoisAPayer = moisActuel + (12 - moisDernierVersement) + 12 * ((anActuel - anDernierVersement) - 1);
			double montantManquantDuMontantMensuel = 20 - this.getMontantMensuel();// en cas ou le client a payé mois de
																					// 20 dt la derniere fois
			double montantAPayer = nbrMoisAPayer * 20 + montantManquantDuMontantMensuel;

			this.setSolde(this.getSolde() + (montant - montantManquantDuMontantMensuel));
			this.getAgence().setDebitGlobalAgence(this.getAgence().getDebitGlobalAgence() + montant);
			Compte.debitGlobalBanque += montant;

			if (montantAPayer < montant) {
				this.setMontantMensuel(this.getMontantMensuel() + (montant - montantAPayer));
				this.setDateDernierVersement(new GregorianCalendar());
				System.out.println(
						"Vous avez payé le montant minmial pour " + nbrMoisAPayer + " les mois précédents ! Merci ");
			} else {
				int nbrMoisPaye = (int) (montant / 20);
				this.setMontantMensuel(montant % 20);
				this.getDateDernierVersement().set(GregorianCalendar.MONTH,
						((moisDernierVersement + nbrMoisPaye) % 12) - 1);
				this.getDateDernierVersement().set(GregorianCalendar.YEAR, ((moisDernierVersement - nbrMoisPaye) / 12));
				System.out.println("Vous avez payé le montant minimal pour les mois " + nbrMoisPaye
						+ " précédents , il vous reste encore " + (nbrMoisAPayer - nbrMoisPaye)
						+ " mois dont le montant total est : " + (montantAPayer - montant) + "DT ! Merci");
			}
		}
	}

	@Override
	public boolean retrait(double montant) throws SoldeNegatifException {

		final long ANNEE_EN_MILLISECONDES = 365 * 24 * 60 * 60 * 1000;
		long ageDuCompteEnMilliSecondes = new GregorianCalendar().getTimeInMillis()
				- this.getDateCreation().getTimeInMillis();
		if (this.getSolde() >= 2000 && ageDuCompteEnMilliSecondes > ANNEE_EN_MILLISECONDES) {
			if (this.getSolde() - montant >= 0) {

				this.setSolde(this.getSolde() - montant);
				Compte.debitGlobalBanque += montant;
				this.getAgence().setCreditGlobalAgence(this.getAgence().getCreditGlobalAgence() + montant);

				System.out.println(
						"Retrait de " + montant + " DT du compte possédant le RIB " + this.getRIB() + " avec sucées !");
				return true;
			} else {
				throw new SoldeNegatifException(
						"Argent du compte non suffisante, le montant maximal à retirer est : " + this.getSolde()
								+ " DT, Un Compte épargne ne peut pas avoir un solde négatif ! Arrèt du programme");
			}
		} else {
			if (this.getSolde() < 2000) {
				System.out.println("Vous devez avoir 2000 DT dans le compte épargne pour faire un retrait !");
				return false;
			} else {
				System.out.println("Le compte doit étré crée avant un an !");
				return false;
			}
		}
	}

	@Override
	public void virement(Compte c, double montant) {
		System.out.println("Impossible de faire un virement d'un compte d'Epargne");
	}

	// Getters and setters

	public double getMontantMensuel() {
		return montantMensuel;
	}

	public void setMontantMensuel(double montantMensuel) {
		this.montantMensuel = montantMensuel;
	}

	public GregorianCalendar getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(GregorianCalendar dateCreation) {
		this.dateCreation = dateCreation;
	}

	public GregorianCalendar getDateDernierVersement() {
		return dateDernierVersement;
	}

	public void setDateDernierVersement(GregorianCalendar dateDernierVersement) {
		this.dateDernierVersement = dateDernierVersement;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		String message = "Compte d'épargne : \n\tNom Agence : " + this.getAgence().getNom() + "\n\tAdresse Agence : "
				+ this.getAgence().getAdresse() + "\n\tRIB : " + this.getRIB() + "\n\tSolde : " + this.getSolde()
				+ "\n\tMontant Mensuel : " + this.getMontantMensuel() + "\n\tDate de Création du Compte : "
				+ this.getDateCreation().getTime() + "\n\tDate de dernier Versement : "
				+ this.getDateDernierVersement().getTime() + this.getClient().toString();
		return message;
	}

}
