package dataBase;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CompteDb {

	public static Connection con = null;

	//// Connector to dataBase

	public static Connection dbConnector() {

		String jdbcDriver = "com.mysql.jdbc.Driver";
		String urlBd = "jdbc:mysql://localhost/agencebanquaire";
		String user = "root";
		String pwd = "";
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(urlBd, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// add a new CompteSalaire,CompteEpargne,CompteVip to the dataBase
	public static void insertCompteSalaire(String solde, String idAgence_fk, String idClient_fk) {
		con = CompteDb.dbConnector();
		String query = "insert into compte(solde,idAgence_fk,idClient_fk,typeCompte) values(?,?,?,?)";
		try {
			PreparedStatement insertQuery = con.prepareStatement(query);
			insertQuery.setString(1, solde);
			insertQuery.setString(2, idAgence_fk);
			insertQuery.setString(3, idClient_fk);
			insertQuery.setString(4, "Salaire");
			insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertCompteEpargne(String solde, String idAgence_fk, String idClient_fk) {
		con = CompteDb.dbConnector();
		String query = "insert into compte(solde,	montantMensuel,dateCreation,dateDernierVersement,idAgence_fk,idClient_fk,typeCompte) values(?,?,?,?,?,?,?)";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		try {
			PreparedStatement insertQuery = con.prepareStatement(query);
			insertQuery.setString(1, solde);
			insertQuery.setString(2, solde);
			insertQuery.setString(3, dtf.format(now));
			insertQuery.setString(4, dtf.format(now));
			insertQuery.setString(5, idAgence_fk);
			insertQuery.setString(6, idClient_fk);
			insertQuery.setString(7, "Epargne");
			insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertCompteVip(String solde, String idAgence_fk, String idClient_fk) {
		con = CompteDb.dbConnector();
		String query = "insert into compte(solde,idAgence_fk,idClient_fk,typeCompte) values(?,?,?,?)";
		try {
			PreparedStatement insertQuery = con.prepareStatement(query);
			insertQuery.setString(1, solde);
			insertQuery.setString(2, idAgence_fk);
			insertQuery.setString(3, idClient_fk);
			insertQuery.setString(4, "Vip");
			insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Getters from the database
	// verifiy the user's login
	public static boolean verifLogin(String rib) {
		con = CompteDb.dbConnector();
		boolean resultat = false;
		ResultSet rs = null;
		String req = "select rib from compte where rib =" + rib;
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next()) {
				if (Integer.parseInt(rs.getString(1)) == Integer.parseInt(rib)) {
					resultat = true;
				}
			}
			stm.close();
			con.close();
			return resultat;

		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}

	}

	// get the compteType through the rib
	public static String getCompteType(String rib) {
		con = CompteDb.dbConnector();
		String resultat = "";
		ResultSet rs = null;
		String req = "select typeCompte from compte where rib =" + rib;
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next()) {
				resultat = rs.getString(1);
			}
			stm.close();
			con.close();
			return resultat;

		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}

	public static String getMontant(String rib) {
		con = CompteDb.dbConnector();
		String resultat = "";
		ResultSet rs = null;
		String req = "SELECT solde FROM compte where rib =" + rib;
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next()) {
				resultat = rs.getString(1);
			}
			stm.close();
			con.close();
			return resultat;

		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}

	public static String getIdClient(String rib) {
		con = CompteDb.dbConnector();
		String resultat = "";
		ResultSet rs = null;
		String req = "SELECT idClient_fk FROM compte where rib =" + rib;
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next()) {
				resultat = rs.getString(1);
			}
			stm.close();
			con.close();
			return resultat;

		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}

	public static String getIdAgece(String rib) {
		con = CompteDb.dbConnector();
		String resultat = "";
		ResultSet rs = null;
		String req = "SELECT idAgence_fk FROM compte where rib =" + rib;
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next()) {
				resultat = rs.getString(1);
			}
			stm.close();
			con.close();
			return resultat;

		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}

	public static String getTransactions(String rib) {

		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT * FROM transaction WHERE ribCompteDepart=" + rib + " or ribCompteArrive=" + rib;
		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				i++;
				message += i + "/";
				message += "RIB Compte Départ : " + rs.getString(2) + " ";
				message += "RIB Compte Arrive : " + rs.getString(3) + " ";
				message += "Montant: " + rs.getString(4) + " ";
				message += "Type Transactionrs : " + rs.getString(5) + " ";
				message += "<br>";
			}
			stm.close();
			con.close();
			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}
	}

	public static String getAllTransactions() {

		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT * FROM transaction";
		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				i++;
				message += i + "/";
				message += "RIB Compte Départ : " + rs.getString(2) + " ";
				message += "RIB Compte Arrive : " + rs.getString(3) + " ";
				message += "Montant : " + rs.getString(4) + " ";
				message += "Type Transactionrs : " + rs.getString(5) + " ";
				message += "<br>";
			}
			stm.close();
			con.close();
			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}
	}

	public static String getAllSolde() {
		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT sum(solde) FROM compte";
		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			while (rs.next()) {
				message += "Montant total dans la Banque (dt) : " + rs.getString(1) + "<br>";
			}
			stm.close();
			con.close();
			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}
	}

	public static String getDebitGlobal() {
		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT sum(montant) FROM transaction WHERE typeTransaction='Depot'";
		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			while (rs.next()) {
				message += "Debit Global Banque (dt) : " + rs.getString(1) + "<br>";
			}
			stm.close();
			con.close();
			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}
	}

	public static String getCreditGlobal() {
		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT sum(montant) FROM transaction WHERE typeTransaction='Retrait'";
		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			while (rs.next()) {

				message += "Crédit Global Banque (dt) : " + rs.getString(1) + "<br>";

			}
			stm.close();
			con.close();
			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}
	}

	public static String getNbrComptes() {
		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT count(rib) FROM compte";

		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			while (rs.next()) {
				message += "Nombre de Comptes dans la banque : " + rs.getString(1) + "<br>";

			}
			stm.close();
			con.close();
			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}
	}

	public static String getInfoCompte(String rib, String info) {
		con = ClientDb.dbConnector();
		String resultat = "";
		ResultSet rs = null;
		String req = "select " + info + " from compte where rib =" + rib;
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next()) {
				resultat = rs.getString(1);
			}
			stm.close();
			con.close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}

	}

	public static String getAllComptes() {

		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT * FROM compte";
		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				i++;
				message += i + "/";
				message += "RIB Compte : " + rs.getString(1) + " ";
				message += "Solde : " + rs.getString(2) + " ";
				message += "Montant Mensuel : " + rs.getString(3) + " ";
				message += "Date Creation : " + rs.getString(4) + " ";
				message += "Date Dernier Versement : " + rs.getString(5) + " ";
				message += "Type du Compte : " + rs.getString(8) + " ";
				message += "<br>";
			}
			stm.close();
			con.close();
			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}
	}
	//transactions methodes 
	public static int depot(String montant, String rib) {
		int resultat = 0;
		con = CompteDb.dbConnector();
		String query1 = "UPDATE compte SET solde = solde+ ? WHERE rib= ?";
		String query2 = "INSERT INTO transaction (ribCompteDepart,montant,typeTransaction) values(?,?,?)";
		try {
			PreparedStatement updateQuery = con.prepareStatement(query1);
			updateQuery.setString(1, montant);
			updateQuery.setString(2, rib);
			resultat += updateQuery.executeUpdate();
			updateQuery.close();
			PreparedStatement insertQuery = con.prepareStatement(query2);
			insertQuery.setString(1, rib);
			insertQuery.setString(2, montant);
			insertQuery.setString(3, "Depot");
			resultat += insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}
	//a special transaction methode for the "compte d'epargne" that changes the date and adds the amount of money
	public static int depotEpargne(String montant, String rib) {
		int resultat = 0;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		con = CompteDb.dbConnector();
		String query1 = "UPDATE compte SET solde = solde+ ? ,dateCreation=?,montantMensuel=montantMensuel+? WHERE rib= ?";
		String query2 = "INSERT INTO transaction (ribCompteDepart,montant,typeTransaction) values(?,?,?)";
		try {
			PreparedStatement updateQuery = con.prepareStatement(query1);
			updateQuery.setString(1, montant);
			updateQuery.setString(2, dtf.format(now));
			updateQuery.setString(3, montant);
			updateQuery.setString(4, rib);
			resultat += updateQuery.executeUpdate();
			updateQuery.close();
			PreparedStatement insertQuery = con.prepareStatement(query2);
			insertQuery.setString(1, rib);
			insertQuery.setString(2, montant);
			insertQuery.setString(3, "Depot");
			resultat += insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}

	public static int retrait(String montant, String rib) {
		int resultat = 0;
		con = CompteDb.dbConnector();
		String query1 = "UPDATE compte SET solde = solde- ? WHERE rib= ?";
		String query2 = "INSERT INTO transaction (ribCompteDepart,montant,typeTransaction) values(?,?,?)";
		try {
			PreparedStatement updateQuery = con.prepareStatement(query1);
			updateQuery.setString(1, montant);
			updateQuery.setString(2, rib);
			resultat += updateQuery.executeUpdate();
			updateQuery.close();
			PreparedStatement insertQuery = con.prepareStatement(query2);
			insertQuery.setString(1, rib);
			insertQuery.setString(2, montant);
			insertQuery.setString(3, "Retrait");
			resultat += insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}

	public static int virement(String montant, String rib, String rib1) {
		int resultat = 0;
		con = CompteDb.dbConnector();
		String query0 = "UPDATE compte SET solde = solde+ ? WHERE rib= ?";
		String query1 = "UPDATE compte SET solde = solde- ? WHERE rib= ?";
		String query2 = "INSERT INTO transaction (ribCompteDepart,ribCompteArrive,montant,typeTransaction) values(?,?,?,?)";
		try {
			PreparedStatement updateQuery = con.prepareStatement(query0);
			updateQuery.setString(1, montant);
			updateQuery.setString(2, rib1);
			resultat += updateQuery.executeUpdate();
			updateQuery.close();
			PreparedStatement updateQuery1 = con.prepareStatement(query1);
			updateQuery1.setString(1, montant);
			updateQuery1.setString(2, rib);
			resultat += updateQuery1.executeUpdate();
			updateQuery1.close();
			PreparedStatement insertQuery = con.prepareStatement(query2);
			insertQuery.setString(1, rib);
			insertQuery.setString(2, rib1);
			insertQuery.setString(3, montant);
			insertQuery.setString(4, "Virement");
			resultat += insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}
}
