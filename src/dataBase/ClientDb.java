package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDb {
	private static Connection con = null;

	// Connector to dataBase
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

	// adding a new ClientNormal,ClientVip
	public static int insertClientNormal(String nom, String prenom, String profession, String telephone, String cin) {
		con = ClientDb.dbConnector();
		String query = "insert into client(nom,prenom,profession,telephone,cin,typeClient) values(?,?,?,?,?,?)";
		int rowsInserted = 0;
		try {
			PreparedStatement insertQuery = con.prepareStatement(query);
			insertQuery.setString(1, nom);
			insertQuery.setString(2, prenom);
			insertQuery.setString(3, profession);
			insertQuery.setString(4, telephone);
			insertQuery.setString(5, cin);
			insertQuery.setString(6, "Normal");
			rowsInserted = insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
			return rowsInserted;

		} catch (SQLException e) {
			e.printStackTrace();
			return rowsInserted;
		}
	}

	public static int insertClientVip(String nom, String prenom, String profession, String telephone, String cin,
			String chiffreAffaire, String capacite, String nomEntreprise) {
		con = ClientDb.dbConnector();
		String query = "insert into client(nom,prenom,profession,telephone,cin,typeClient,chiffreAffaire,capacite,nomEntreprise) values(?,?,?,?,?,?,?,?,?)";
		int rowsInserted = 0;
		try {
			PreparedStatement insertQuery = con.prepareStatement(query);
			insertQuery.setString(1, nom);
			insertQuery.setString(2, prenom);
			insertQuery.setString(3, profession);
			insertQuery.setString(4, telephone);
			insertQuery.setString(5, cin);
			insertQuery.setString(6, "Vip");
			insertQuery.setString(7, chiffreAffaire);
			insertQuery.setString(8, capacite);
			insertQuery.setString(9, nomEntreprise);
			rowsInserted = insertQuery.executeUpdate();
			insertQuery.close();
			con.close();
			return rowsInserted;

		} catch (SQLException e) {
			e.printStackTrace();
			return rowsInserted;
		}
	}

	// verifiy if a client exists in the dataBase through his cin
	public static boolean verifClient(String cin) {
		con = ClientDb.dbConnector();
		boolean resultat = false;
		ResultSet rs = null;
		String req = "select cin from client where cin ='" + cin + "'";
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next()) {
				if (rs.getString(1) == cin) {
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

	// getting the clientId through his cin
	public static String getClientId(String cin) {
		con = ClientDb.dbConnector();
		String resultat = "";
		ResultSet rs = null;
		String req = "select idClient from client where cin ='" + cin + "'";
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

	public static String getInfoClient(String idClient, String info) {
		con = ClientDb.dbConnector();
		String resultat = "";
		ResultSet rs = null;
		String req = "select " + info + " from client where idClient =" + idClient;
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

	public static String getAllClients() {

		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT * FROM client";
		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			int i = 0;
			while (rs.next()) {

				i++;
				message += i + "/";
				message += "Nom : " + rs.getString(1) + " ";
				message += "Prenom : " + rs.getString(2) + " ";
				message += "Profession : " + rs.getString(3) + " ";
				message += "Telephone	 : " + rs.getString(4) + " ";
				message += "Cin : " + rs.getString(5) + " ";
				message += "Chiffre d'Affaire : " + rs.getString(7) + " ";
				message += "Capacité : " + rs.getString(8) + " ";
				message += "Nom Entreprise : " + rs.getString(9) + " ";
				message += "Type Client : " + rs.getString(10) + " ";
				message += "<br>";
			}
			stm.close();
			// con.close();

			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}

	}

	public static String getAgence(String idAgence) {
		con = ClientDb.dbConnector();
		String resultat = "";
		ResultSet rs = null;
		String req = "select * from agence where idAgence =" + idAgence;
		try {
			Statement stm = con.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next()) {
				resultat = rs.getString(2);
			}
			stm.close();
			con.close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultat;
		}
	}

	public static String getAllAgents() {
		CompteDb.dbConnector();
		String message = "<html>";
		String query = "SELECT * FROM agence";
		try {
			Statement stm = CompteDb.con.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			int i = 0;
			while (rs.next()) {
				i++;
				message += i + "/";
				message += "Nom : " + rs.getString(2) + " ";
				message += "Adresse : " + rs.getString(3) + " ";
				message += "<br>";
			}
			stm.close();
			// con.close();
			message += "</html>";
			return message;
		} catch (SQLException e) {
			e.printStackTrace();
			return message;
		}
	}

}
