package dataBase;

import java.sql.DriverManager;

import java.sql.*;

public class Connector {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String URL_BD = "jdbc:mysql://localhost/agencebanquaire";
	static final String UTILISATEUR = "root";
	static final String MOT_PASS = "";

	private static Connection cnx = null;

	public static Connection dbConnector() {

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			cnx = DriverManager.getConnection(URL_BD, UTILISATEUR, MOT_PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnx;

	}

	public void afficher() {
		ResultSet rs = null;
		String req = "select * from agence";
		try {
			Statement stm = cnx.createStatement();
			rs = stm.executeQuery(req);
			while (rs.next())
				System.out.println(rs.getInt(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
