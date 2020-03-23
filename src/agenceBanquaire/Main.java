package agenceBanquaire;

import exceptions.SoldeEnRougeException;
import exceptions.SoldeNegatifException;

public class Main {

	public static void main(String[] args) {

		Banque B = new Banque("BIAT");

		Agence Ag1 = new Agence(1, "BIAT 1", "Manar 1");
		Agence Ag2 = new Agence(2, "BIAT 2", "Manar 2");

		ClientNormal ClNrml1 = new ClientNormal("Fekher", "Nouioui", "Ingénieur Informatique", 54250148, 11656971);
		ClientNormal ClNrml2 = new ClientNormal("Oumayma", "Nouioui", "Ingénieur Biologie", 58965450, 11059725);

		ClientVIP ClVIP1 = new ClientVIP("Amor", "Nouioui", "Professeur", 97431570, 12578632, 3003, 30, "Mandoubia");
		ClientVIP ClVIP2 = new ClientVIP("Latifa", "Derbali", "Professeur", 98945040, 135978502, 1200, 50,
				"Ibn Khaldoun");
		try {
			CompteSalaire CompteSal1 = new CompteSalaire(Ag1, ClNrml1, 1, 1500);
			CompteSalaire CompteSal2 = new CompteSalaire(Ag2, ClNrml2, 2, 980.5);

			CompteEpargne CompteEpar1 = new CompteEpargne(Ag1, ClNrml1, 3, 1000);
			CompteEpargne CompteEpar2 = new CompteEpargne(Ag2, ClVIP1, 4, 2000);

			CompteVIP CompteVIP1 = new CompteVIP(Ag1, 5, ClVIP1, 500);
			CompteVIP CompteVIP2 = new CompteVIP(Ag2, 6, ClVIP2, 780);

			// Affichage
			System.out.println(B);
			System.out.println("\t***************************");
			System.out.println(CompteSal1);
			System.out.println(CompteSal2);
			System.out.println("\t***************************");
			System.out.println("\t***************************");
			System.out.println(CompteEpar1);
			System.out.println(CompteEpar2);
			System.out.println("\t***************************");
			System.out.println("\t***************************");
			System.out.println(CompteVIP1);
			System.out.println(CompteVIP2);
			System.out.println("\t***************************");
			// Quelques transactions
			try {
				CompteSal1.versement(100);
				CompteSal2.retrait(80.5);
				CompteSal2.virement(CompteSal1, 800);
				System.out.println("\t***************************");
				System.out.println(CompteSal1);
				System.out.println(CompteSal2);
				System.out.println("\t***************************");
				CompteEpar1.versement(15);
				CompteEpar2.retrait(2500);
				CompteEpar2.virement(CompteEpar1, 500);
				System.out.println("\t***************************");
				System.out.println(CompteEpar1);
				System.out.println(CompteEpar2);
				System.out.println("\t***************************");
				CompteVIP1.versement(100);
				CompteVIP2.retrait(80);
				CompteVIP2.virement(CompteVIP1, 500);
				System.out.println("\t***************************");
				System.out.println(CompteVIP1);
				System.out.println(CompteVIP2);
				System.out.println("\t***************************");
			} catch (SoldeEnRougeException e) {
				System.out.println(e.getMessage());
				System.exit(-1);
			}
		} catch (SoldeNegatifException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

}
