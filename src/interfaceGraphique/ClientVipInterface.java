package interfaceGraphique;

import java.awt.BorderLayout;
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
import interfaceGraphique.ClientSalaireInterface.EventHandler;

public class ClientVipInterface extends JFrame {

	private JPanel contentPane;
	private JPasswordField ribTextField3;

	private JPanel virementPanel;
	private JPanel retraitPanel;
	private JPanel depotPanel;
	private JPanel infosComptePanel;
	private JPanel historiqueTransactionPanel;

	private JButton infoCompteJButton;
	private JButton histoTransactionJButton;
	private JButton depotJButton;
	private JButton retraitJButton;
	private JButton virementJButton;
	private JPasswordField ribVotreCompteTextField3;
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
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientVipInterface frame = new ClientVipInterface();
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
	public ClientVipInterface() {
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

		JLabel bienvenueJLabel = new JLabel("Bienvenue dans votre Compte VIP");
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
		menuPanel.setBounds(10, 98, 373, 387);
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

		virementJButton = new JButton("Virement");
		virementJButton.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		virementJButton.setBounds(0, 301, 373, 76);
		menuPanel.add(virementJButton);
		virementJButton.setIcon(new ImageIcon(imgVirement));

		JPanel sectionPanel = new JPanel();
		sectionPanel.setBorder(new LineBorder(Color.BLACK, 2));
		sectionPanel.setBounds(413, 106, 863, 597);
		contentPane.add(sectionPanel);

		retraitPanel = new JPanel();
		retraitPanel.setBounds(147, 43, 607, 544);
		retraitPanel.setLayout(null);
		retraitPanel.setVisible(false);

		JLabel soldeCourantJLabel2 = new JLabel("Solde Courant (dt) :");
		soldeCourantJLabel2.setBounds(20, 79, 459, 35);
		soldeCourantJLabel2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		retraitPanel.add(soldeCourantJLabel2);

		JLabel montantMaxJLabel2 = new JLabel("Montant Max \u00E0 retirer (dt) : ");
		montantMaxJLabel2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		montantMaxJLabel2.setBounds(21, 109, 458, 37);
		retraitPanel.add(montantMaxJLabel2);

		JLabel montantATransfererJLabel2 = new JLabel("Montant \u00E0 retirer (dt):");
		montantATransfererJLabel2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		montantATransfererJLabel2.setBounds(21, 140, 168, 37);
		retraitPanel.add(montantATransfererJLabel2);

		JFormattedTextField montantFormattedTextField2 = new JFormattedTextField();
		montantFormattedTextField2.setBounds(186, 143, 168, 35);
		retraitPanel.add(montantFormattedTextField2);

		JButton confirmerButton2 = new JButton("Confirmer");
		confirmerButton2.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		confirmerButton2.setBounds(225, 196, 139, 36);
		retraitPanel.add(confirmerButton2);
		confirmerButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rib = String.valueOf(passwordField.getPassword());
				Double montant = Double.parseDouble(CompteDb.getMontant(rib));
				Double valeurSeuil = 0.0;
				Double montantMaximal = 0.0;
				if (montant >= 0) {
					valeurSeuil = -montant * 0.05;
					montantMaximal = montant + Math.abs(valeurSeuil);
					if (montantMaximal - Double.parseDouble(montantFormattedTextField2.getText()) > 0) {
						if (montant - Double.parseDouble(montantFormattedTextField2.getText()) < 0) {
							int result = JOptionPane.showConfirmDialog(null,
									"Attention à l'issue de cette transaction votre solde sera en Rouge ! Confirmez ?");
							if (result == 0) {
								int resultat = CompteDb.retrait(montantFormattedTextField2.getText(), rib);
								if (resultat == 2) {
									JOptionPane.showMessageDialog(null, "Retrait avec succées !");
								} else {
									JOptionPane.showMessageDialog(null, "Echéc du retrait !");
								}
							}
						} else {
							int resultat = CompteDb.retrait(montantFormattedTextField2.getText(), rib);
							if (resultat == 2) {
								JOptionPane.showMessageDialog(null, "Retrait avec succées !");
							} else {
								JOptionPane.showMessageDialog(null, "Echéc du retrait !");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Le montant demandé dépassera la valeur seuil de votre compte,Retrait impossible");

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Votre Solde est déja en Rouge vous devez déposer de l'argent d'abord");
				}

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

				if (CompteDb.verifLogin(rib)) {
					if (Double.parseDouble(CompteDb.getMontant(rib)) >= 0) {
						String montant = CompteDb.getMontant(rib);
						Double valeurSeuil = -Double.parseDouble(montant) * 0.05;
						Double montantMax = Double.parseDouble(montant) + Math.abs(valeurSeuil);
						soldeCourantJLabel2.setText("Solde Courant (dt) :" + montant);
						montantMaxJLabel2.setText("Montant Max à retirer : " + Double.toString(montantMax));
					} else {
						soldeCourantJLabel2.setText("Solde Courant (dt) :" + CompteDb.getMontant(rib));
						montantMaxJLabel2.setText("Montant Max à retirer (dt) : 0");
					}
				} else {
					JOptionPane.showMessageDialog(null, "RIB incorrecte");
				}

			}

		});

		virementPanel = new JPanel();
		virementPanel.setBounds(112, 36, 648, 544);
		virementPanel.setLayout(null);
		virementPanel.setVisible(false);

		JLabel desitinationAccountRibJLabel3 = new JLabel("RIB Du Compte destinataire :");
		desitinationAccountRibJLabel3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		desitinationAccountRibJLabel3.setBounds(20, 59, 219, 36);
		virementPanel.add(desitinationAccountRibJLabel3);

		JLabel montantATransfererJLabel3 = new JLabel("Montant \u00E0 Transf\u00E9rer :");
		montantATransfererJLabel3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		montantATransfererJLabel3.setBounds(20, 243, 176, 36);
		virementPanel.add(montantATransfererJLabel3);

		ribTextField3 = new JPasswordField();
		ribTextField3.setBounds(239, 62, 229, 36);
		virementPanel.add(ribTextField3);
		ribTextField3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String rib = String.valueOf(ribTextField3.getPassword());
				if (CompteDb.verifLogin(rib) == false) {
					JOptionPane.showMessageDialog(null, "RIB incorrecte");
				}

			}

		});

		JFormattedTextField montantATransferFormattedTextField3 = new JFormattedTextField();
		montantATransferFormattedTextField3.setBounds(225, 246, 229, 35);
		virementPanel.add(montantATransferFormattedTextField3);

		JButton confirmerButton3 = new JButton("Confirmer");
		confirmerButton3.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		confirmerButton3.setBounds(399, 317, 139, 36);
		virementPanel.add(confirmerButton3);
		confirmerButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String rib = String.valueOf(ribVotreCompteTextField3.getPassword());
				String rib1 = String.valueOf(ribTextField3.getPassword());
				Double montant = Double.parseDouble(CompteDb.getMontant(rib));
				Double valeurSeuil = 0.0;
				Double montantMaximal = 0.0;
				if (montant >= 0) {
					valeurSeuil = -montant * 0.05;
					montantMaximal = montant + Math.abs(valeurSeuil);
					if (montantMaximal - Double.parseDouble(montantATransferFormattedTextField3.getText()) > 0) {
						if (montant - Double.parseDouble(montantATransferFormattedTextField3.getText()) < 0) {
							int result = JOptionPane.showConfirmDialog(null,
									"Attention à l'issue de cette transaction votre solde sera en Rouge ! Confirmez ?");
							if (result == 0) {
								int resultat = CompteDb.virement(montantATransferFormattedTextField3.getText(), rib,
										rib1);
								if (resultat == 3) {
									JOptionPane.showMessageDialog(null, "Retrait avec succées !");
								} else {
									JOptionPane.showMessageDialog(null, "Echéc du retrait !");
								}
							}
						} else {
							int resultat = CompteDb.virement(montantATransferFormattedTextField3.getText(), rib, rib1);
							if (resultat == 3) {
								JOptionPane.showMessageDialog(null, "Retrait avec succées !");
							} else {
								JOptionPane.showMessageDialog(null, "Echéc du retrait !");
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Le montant demandé dépassera la valeur seuil de votre compte,Retrait impossible");

					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Votre Solde est déja en Rouge vous devez déposer de l'argent d'abord");
				}

			}

		});

		JLabel soldeCourantJLabel3 = new JLabel("Solde Courant (dt) :");
		soldeCourantJLabel3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		soldeCourantJLabel3.setBounds(20, 151, 469, 36);
		virementPanel.add(soldeCourantJLabel3);

		JLabel montantMaxJLabel3 = new JLabel("Montant Max \u00E0 retirer :");
		montantMaxJLabel3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		montantMaxJLabel3.setBounds(20, 196, 458, 37);
		virementPanel.add(montantMaxJLabel3);

		JLabel virementJLabel = new JLabel("Virement");
		virementJLabel.setForeground(Color.RED);
		virementJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		virementJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		virementJLabel.setBounds(165, 10, 139, 39);
		virementPanel.add(virementJLabel);

		JLabel ribCompteEnvoie = new JLabel("RIB de votre Compte :");
		ribCompteEnvoie.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		ribCompteEnvoie.setBounds(20, 105, 219, 36);
		virementPanel.add(ribCompteEnvoie);

		ribVotreCompteTextField3 = new JPasswordField();
		ribVotreCompteTextField3.setBounds(239, 105, 229, 36);
		virementPanel.add(ribVotreCompteTextField3);
		ribVotreCompteTextField3.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				String rib = String.valueOf(ribVotreCompteTextField3.getPassword());
				if (CompteDb.verifLogin(rib) == false) {
					JOptionPane.showMessageDialog(null, "RIB incorrecte");
				} else {
					if (Double.parseDouble(CompteDb.getMontant(rib)) >= 0) {
						String montant = CompteDb.getMontant(rib);
						Double valeurSeuil = -Double.parseDouble(montant) * 0.05;
						Double montantMax = Double.parseDouble(montant) + Math.abs(valeurSeuil);
						soldeCourantJLabel3.setText("Solde Courant (dt) :" + montant);
						montantMaxJLabel3.setText("Montant Max à retirer : " + Double.toString(montantMax));
					} else {
						soldeCourantJLabel3.setText("Solde Courant (dt) :" + CompteDb.getMontant(rib));
						montantMaxJLabel3.setText("Montant Max à retirer (dt) : 0");
					}
				}

			}

		});
		sectionPanel.setLayout(null);
		sectionPanel.add(virementPanel);

		infosComptePanel = new JPanel();
		infosComptePanel.setBounds(10, 18, 570, 569);
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

		montantJLabel = new JLabel("Montant Actuel (dt) : ");
		montantJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		montantJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		montantJLabel.setBounds(10, 242, 430, 36);
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

		label_2 = new JLabel("Chiffre d'affaire (dt) :");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		label_2.setBounds(10, 287, 430, 29);
		infosComptePanel.add(label_2);

		label_4 = new JLabel("Nom Entreprise :");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		label_4.setBounds(10, 356, 430, 29);
		infosComptePanel.add(label_4);

		label_3 = new JLabel("Capacit\u00E9 :");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		label_3.setBounds(10, 322, 430, 36);
		infosComptePanel.add(label_3);

		JButton voirInfoJLabel = new JButton("Voir informations");
		voirInfoJLabel.setBounds(174, 529, 203, 40);
		infosComptePanel.add(voirInfoJLabel);
		voirInfoJLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
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
					label_2.setText("Chiffre d'affaire (dt) : " + ClientDb.getInfoClient(idClient, "chiffreAffaire"));
					label_3.setText("Capacité : " + ClientDb.getInfoClient(idClient, "capacite"));
					label_4.setText("Nom Entreprise :  " + ClientDb.getInfoClient(idClient, "nomEntreprise"));
				} else
					JOptionPane.showMessageDialog(null, "Données erronées ! Veuillez reverifiez votre RIB");

			}

		});

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
					int resultat = CompteDb.depot(montantFormattedTextField1.getText(), rib);
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
		virementJButton.addActionListener(handler);

	}

	public class EventHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton sourceButton = (JButton) e.getSource();
			if (sourceButton == infoCompteJButton) {

				retraitPanel.setVisible(false);
				depotPanel.setVisible(false);

				historiqueTransactionPanel.setVisible(false);
				virementPanel.setVisible(false);
				infosComptePanel.setVisible(true);
			} else if (sourceButton == histoTransactionJButton) {
				virementPanel.setVisible(false);
				retraitPanel.setVisible(false);
				depotPanel.setVisible(false);
				infosComptePanel.setVisible(false);
				historiqueTransactionPanel.setVisible(true);
			} else if (sourceButton == depotJButton) {
				virementPanel.setVisible(false);
				retraitPanel.setVisible(false);
				infosComptePanel.setVisible(false);
				historiqueTransactionPanel.setVisible(false);
				depotPanel.setVisible(true);

			} else if (sourceButton == retraitJButton) {
				virementPanel.setVisible(false);
				depotPanel.setVisible(false);
				infosComptePanel.setVisible(false);
				historiqueTransactionPanel.setVisible(false);
				retraitPanel.setVisible(true);

			} else if (sourceButton == virementJButton) {
				retraitPanel.setVisible(false);
				depotPanel.setVisible(false);
				infosComptePanel.setVisible(false);
				historiqueTransactionPanel.setVisible(false);
				virementPanel.setVisible(true);

			}

		}

	}
}
