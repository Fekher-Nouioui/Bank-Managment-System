package interfaceGraphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import dataBase.ClientDb;
import dataBase.CompteDb;
import interfaceGraphique.ClientVipInterface.EventHandler;

public class ClientEpargneInterface extends JFrame {

	private JPanel contentPane;
	private JPanel retraitPanel;
	private JPanel depotPanel;
	private JPanel infosComptePanel;
	private JPanel historiqueTransactionPanel;

	private JButton infoCompteJButton;
	private JButton histoTransactionJButton;
	private JButton depotJButton;
	private JButton retraitJButton;
	private JPasswordField passwordFieldDepot;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	private JLabel nomJLabel;
	private JLabel prenomJLabel;
	private JLabel professionJLabel;
	private JLabel TelephoneJLabel;
	private JLabel cinJLabel;
	private JLabel montantJLabel;
	private JLabel agenceJLabel;
	private JLabel lblDateCration;
	private JLabel lblDateDernierVersement;

	private JLabel error;
	private JLabel lblMontantdt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientEpargneInterface frame = new ClientEpargneInterface();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientEpargneInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new LineBorder(Color.BLACK, 2));
		headerPanel.setBounds(10, 0, 1266, 99);
		contentPane.add(headerPanel);
		headerPanel.setLayout(null);

		JLabel bienvenueJLabel = new JLabel("Bienvenue dans votre Compte d'Epargne");
		bienvenueJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		bienvenueJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenueJLabel.setBounds(25, 10, 1231, 79);
		headerPanel.add(bienvenueJLabel);

		JPanel sidePanel = new JPanel();
		sidePanel.setBorder(new LineBorder(Color.BLACK, 2));
		sidePanel.setBounds(10, 106, 393, 597);
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);

		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(10, 98, 373, 314);
		sidePanel.add(menuPanel);
		menuPanel.setLayout(null);

		Image imgInfoCompte = new ImageIcon(this.getClass().getResource("/infoCompte.png")).getImage();
		Image imgHistoriqueTransaction = new ImageIcon(this.getClass().getResource("/histo.png")).getImage();
		Image imgDepot = new ImageIcon(this.getClass().getResource("/depot.png")).getImage();
		Image imgRetrait = new ImageIcon(this.getClass().getResource("/retrait.png")).getImage();
		Image imgVirement = new ImageIcon(this.getClass().getResource("/virement.png")).getImage();

		infoCompteJButton = new JButton("Infos Compte");
		infoCompteJButton.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		infoCompteJButton.setBounds(0, 10, 373, 76);
		menuPanel.add(infoCompteJButton);
		infoCompteJButton.setIcon(new ImageIcon(imgInfoCompte));

		histoTransactionJButton = new JButton("Historique de Transactions");
		histoTransactionJButton.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		histoTransactionJButton.setBounds(0, 84, 373, 76);
		menuPanel.add(histoTransactionJButton);
		histoTransactionJButton.setIcon(new ImageIcon(imgHistoriqueTransaction));

		depotJButton = new JButton("D\u00E9p\u00F4t d'argent");
		depotJButton.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		depotJButton.setBounds(0, 157, 373, 76);
		menuPanel.add(depotJButton);
		depotJButton.setIcon(new ImageIcon(imgDepot));

		retraitJButton = new JButton("Retrait d'argent");
		retraitJButton.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		retraitJButton.setBounds(0, 229, 373, 76);
		menuPanel.add(retraitJButton);
		retraitJButton.setIcon(new ImageIcon(imgRetrait));

		JPanel sectionPanel = new JPanel();
		sectionPanel.setBorder(new LineBorder(Color.BLACK, 2));
		sectionPanel.setBounds(423, 106, 863, 597);
		contentPane.add(sectionPanel);

		retraitPanel = new JPanel();
		retraitPanel.setBounds(147, 10, 607, 577);
		retraitPanel.setLayout(null);
		retraitPanel.setVisible(false);

		JLabel montantATransfererJLabel2 = new JLabel("Montant \u00E0 retirer (dt):");
		montantATransfererJLabel2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		montantATransfererJLabel2.setBounds(20, 108, 168, 37);
		retraitPanel.add(montantATransfererJLabel2);

		JFormattedTextField montantFormattedTextField2 = new JFormattedTextField();
		montantFormattedTextField2.setBounds(186, 110, 168, 35);
		retraitPanel.add(montantFormattedTextField2);

		JButton confirmerButton2 = new JButton("Confirmer");
		confirmerButton2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		confirmerButton2.setBounds(225, 196, 139, 36);
		retraitPanel.add(confirmerButton2);
		confirmerButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				error.setVisible(true);
			}

		});

		JLabel retraitJLabel = new JLabel("Retrait");
		retraitJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		retraitJLabel.setForeground(Color.RED);
		retraitJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		retraitJLabel.setBounds(168, 10, 139, 39);
		retraitPanel.add(retraitJLabel);

		JLabel label = new JLabel("RIB de votre Compte :");
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label.setBounds(20, 51, 219, 36);
		retraitPanel.add(label);

		passwordField = new JPasswordField();
		passwordField.setBounds(186, 54, 168, 36);
		retraitPanel.add(passwordField);
		passwordField.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String rib = String.valueOf(passwordField.getPassword());
				if (CompteDb.verifLogin(rib) == false) {
					JOptionPane.showMessageDialog(null, "RIB incorrecte");
				}
			}

		});
		sectionPanel.setLayout(null);

		depotPanel = new JPanel();
		depotPanel.setBounds(145, 30, 698, 322);
		sectionPanel.add(depotPanel);
		depotPanel.setLayout(null);
		depotPanel.setVisible(false);

		JLabel montantATransfererJLabel1 = new JLabel("Montant \u00E0 D\u00E9poser :");
		montantATransfererJLabel1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		montantATransfererJLabel1.setBounds(10, 44, 176, 46);
		depotPanel.add(montantATransfererJLabel1);

		JFormattedTextField montantFormattedTextField1 = new JFormattedTextField();
		montantFormattedTextField1.setBounds(214, 52, 251, 35);
		depotPanel.add(montantFormattedTextField1);

		JButton confirmerButton1 = new JButton("Confirmer");
		confirmerButton1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		confirmerButton1.setBounds(350, 144, 139, 36);
		depotPanel.add(confirmerButton1);
		confirmerButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rib = String.valueOf(passwordFieldDepot.getPassword());
				if (CompteDb.verifLogin(rib)) {
					int resultat = CompteDb.depotEpargne(montantFormattedTextField1.getText(), rib);
					if (resultat == 2) {
						JOptionPane.showMessageDialog(null, "Dépôt efféctué avec succés !");
						montantFormattedTextField1.setText(null);
						passwordFieldDepot.setText(null);
					}

					else {
						JOptionPane.showMessageDialog(null, "Erreur d'effectuation du Dépot");
						montantFormattedTextField1.setText(null);
						passwordFieldDepot.setText(null);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Veuillez revérifiez votre RIB !");
					montantFormattedTextField1.setText(null);
					passwordFieldDepot.setText(null);
				}

			}

		});

		JLabel depotJLabel = new JLabel("D\u00E9p\u00F4t ");
		depotJLabel.setBounds(163, 10, 139, 39);
		depotPanel.add(depotJLabel);
		depotJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		depotJLabel.setForeground(Color.RED);
		depotJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));

		JLabel ribDepot = new JLabel("RIB de votre Compte :");
		ribDepot.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		ribDepot.setBounds(10, 96, 219, 36);
		depotPanel.add(ribDepot);

		passwordFieldDepot = new JPasswordField();
		passwordFieldDepot.setBounds(214, 97, 251, 36);
		depotPanel.add(passwordFieldDepot);
		sectionPanel.add(retraitPanel);

		error = new JLabel("Votre Compte doit \u00E9tre ag\u00E9 de 2 ans et avoir plus de 2000 dt");
		error.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setBounds(79, 155, 367, 29);
		retraitPanel.add(error);
		error.setVisible(false);

		historiqueTransactionPanel = new JPanel();
		historiqueTransactionPanel.setBounds(203, 10, 540, 553);
		sectionPanel.add(historiqueTransactionPanel);
		historiqueTransactionPanel.setLayout(null);
		historiqueTransactionPanel.setVisible(false);

		JLabel histoTransactionJLabel = new JLabel("Historique de Transactions");
		histoTransactionJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		histoTransactionJLabel.setForeground(Color.RED);
		histoTransactionJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		histoTransactionJLabel.setBounds(10, 5, 491, 41);
		historiqueTransactionPanel.add(histoTransactionJLabel);

		JLabel histoTransaction = new JLabel("");
		histoTransaction.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		histoTransaction.setBounds(41, 142, 438, 411);
		historiqueTransactionPanel.add(histoTransaction);

		JLabel label_1 = new JLabel("RIB de votre Compte :");
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		label_1.setBounds(10, 56, 219, 36);
		historiqueTransactionPanel.add(label_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(190, 56, 238, 36);
		historiqueTransactionPanel.add(passwordField_2);

		JButton histoButton = new JButton("Voir Historiques");
		histoButton.setBounds(318, 102, 183, 30);
		historiqueTransactionPanel.add(histoButton);

		infosComptePanel = new JPanel();
		infosComptePanel.setBounds(74, 10, 570, 569);
		sectionPanel.add(infosComptePanel);
		infosComptePanel.setLayout(null);
		infosComptePanel.setVisible(false);

		nomJLabel = new JLabel("Nom : ");
		nomJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		nomJLabel.setBounds(10, 67, 430, 36);
		infosComptePanel.add(nomJLabel);

		prenomJLabel = new JLabel("Prenom : ");
		prenomJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		prenomJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		prenomJLabel.setBounds(10, 104, 430, 36);
		infosComptePanel.add(prenomJLabel);

		professionJLabel = new JLabel("Profession : ");
		professionJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		professionJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		professionJLabel.setBounds(10, 138, 430, 36);
		infosComptePanel.add(professionJLabel);

		TelephoneJLabel = new JLabel("Telephone : ");
		TelephoneJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		TelephoneJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		TelephoneJLabel.setBounds(8, 173, 432, 36);
		infosComptePanel.add(TelephoneJLabel);

		cinJLabel = new JLabel("CIN : ");
		cinJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		cinJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		cinJLabel.setBounds(10, 207, 430, 36);
		infosComptePanel.add(cinJLabel);

		montantJLabel = new JLabel("Montant Mensuel (dt) : ");
		montantJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		montantJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		montantJLabel.setBounds(10, 247, 430, 36);
		infosComptePanel.add(montantJLabel);

		agenceJLabel = new JLabel("Agence : ");
		agenceJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		agenceJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		agenceJLabel.setBounds(10, 395, 430, 30);
		infosComptePanel.add(agenceJLabel);

		JLabel infoCompteJLabel = new JLabel("Information du Compte");
		infoCompteJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoCompteJLabel.setForeground(Color.RED);
		infoCompteJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		infoCompteJLabel.setBounds(83, 11, 324, 54);
		infosComptePanel.add(infoCompteJLabel);

		JLabel lblVotreRib = new JLabel("Votre RIB :");
		lblVotreRib.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		lblVotreRib.setBounds(10, 427, 129, 36);
		infosComptePanel.add(lblVotreRib);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(161, 427, 176, 36);
		infosComptePanel.add(passwordField_1);

		lblDateCration = new JLabel("Date Cr\u00E9ation :");
		lblDateCration.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateCration.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		lblDateCration.setBounds(10, 326, 430, 36);
		infosComptePanel.add(lblDateCration);

		lblDateDernierVersement = new JLabel("Date dernier versement :");
		lblDateDernierVersement.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateDernierVersement.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		lblDateDernierVersement.setBounds(10, 360, 430, 36);
		infosComptePanel.add(lblDateDernierVersement);

		JButton voirInfoJLabel = new JButton("Voir informations");
		voirInfoJLabel.setBounds(174, 529, 203, 40);
		infosComptePanel.add(voirInfoJLabel);
		voirInfoJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

		lblMontantdt = new JLabel("Montant Mensuel (dt) : ");
		lblMontantdt.setHorizontalAlignment(SwingConstants.LEFT);
		lblMontantdt.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		lblMontantdt.setBounds(10, 293, 430, 36);
		infosComptePanel.add(lblMontantdt);
		voirInfoJLabel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rib = String.valueOf(passwordField_1.getPassword());
				if (CompteDb.verifLogin(rib)) {
					String idClient = CompteDb.getIdClient(rib);
					String idAgence = CompteDb.getIdAgece(rib);
					nomJLabel.setText("Nom : " + ClientDb.getInfoClient(idClient, "nom"));
					prenomJLabel.setText("Prenom : " + ClientDb.getInfoClient(idClient, "prenom"));
					professionJLabel.setText("Profession : " + ClientDb.getInfoClient(idClient, "profession"));
					TelephoneJLabel.setText("Telephone : " + ClientDb.getInfoClient(idClient, "telephone"));
					cinJLabel.setText("CIN : " + ClientDb.getInfoClient(idClient, "cin"));
					montantJLabel.setText("Montant Actuel (dt) : " + CompteDb.getMontant(rib));
					agenceJLabel.setText("Agence : " + ClientDb.getAgence(idAgence));
					lblDateCration.setText("Date Création : " + CompteDb.getInfoCompte(rib, "dateCreation"));
					lblDateDernierVersement
							.setText("Date dernier versement : " + CompteDb.getInfoCompte(rib, "dateDernierVersement"));
					lblMontantdt.setText("Montant Mensuel (dt) : " + CompteDb.getInfoCompte(rib, "montantMensuel"));
				} else
					JOptionPane.showMessageDialog(null, "Données erronées ! Veuillez reverifiez votre RIB");

			}

		});
		histoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rib = String.valueOf(passwordField_2.getPassword());
				String resultat = CompteDb.getTransactions(rib);
				histoTransaction.setText(resultat);

			}

		});
		EventHandler handler = new EventHandler();
		infoCompteJButton.addActionListener(handler);
		histoTransactionJButton.addActionListener(handler);
		depotJButton.addActionListener(handler);
		retraitJButton.addActionListener(handler);

	}

	public class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton sourceButton = (JButton) e.getSource();
			if (sourceButton == infoCompteJButton) {

				retraitPanel.setVisible(false);
				depotPanel.setVisible(false);
				historiqueTransactionPanel.setVisible(false);
				infosComptePanel.setVisible(true);
			} else if (sourceButton == histoTransactionJButton) {

				retraitPanel.setVisible(false);
				depotPanel.setVisible(false);
				infosComptePanel.setVisible(false);
				historiqueTransactionPanel.setVisible(true);
			} else if (sourceButton == depotJButton) {
				retraitPanel.setVisible(false);
				infosComptePanel.setVisible(false);
				historiqueTransactionPanel.setVisible(false);
				depotPanel.setVisible(true);

			} else if (sourceButton == retraitJButton) {

				depotPanel.setVisible(false);
				infosComptePanel.setVisible(false);
				historiqueTransactionPanel.setVisible(false);
				retraitPanel.setVisible(true);

			}
		}

	}
}