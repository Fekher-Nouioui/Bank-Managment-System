package interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataBase.ClientDb;
import dataBase.CompteDb;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class CreateAccountInterface extends JFrame {

	private JPanel contentPane;
	private final JPanel instructionPanel = new JPanel();
	private final JPanel accountChoicePanel = new JPanel();
	private JPanel compteSalarierPanel;
	private JPanel compteEpargnePanel;
	private JPanel compteVipPanel;
	private JTextField nomTextField1;
	private JTextField prenomTextField1;
	private JTextField professionTextField1;
	private JTextField nomTextField2;
	private JTextField prenomTextField2;
	private JTextField professionTextField2;
	private JTextField nomTextField3;
	private JTextField prenomTextField3;
	private JTextField professionTextField3;
	private JTextField nomEntrepriseTextField3;
	private JFormattedTextField telephoneFormattedTextField1;
	private JFormattedTextField cinFormattedTextField1;
	private JFormattedTextField montantFormattedTextField1;
	private JFormattedTextField cinFormattedTextField3;
	private JFormattedTextField telephoneFormattedTextField3;
	private JFormattedTextField montantFormattedTextField3;
	private JFormattedTextField chiffreAffaireFormattedTextField3;
	private JFormattedTextField capaciteFormattedTextField3;
	private JRadioButton compteSalaireRadioButton;
	private JRadioButton compteEpargneRadioButton;
	private JRadioButton compteVipRadioButton;
	private ButtonGroup accountChoice = new ButtonGroup();
	private JButton createAccountJButton1;
	private JButton createAccountJButton2;
	private JButton createAccountJButton3;
	private JComboBox agenceComboBox1;
	private JComboBox agenceComboBox2;
	private JComboBox agenceComboBox3;

	private JFormattedTextField cinFormattedTextField2;
	private JFormattedTextField telephoneFormattedTextField2;
	private JFormattedTextField montantFormattedTextField2;

	private static CreateAccountInterface frame = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CreateAccountInterface();
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
	public CreateAccountInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		instructionPanel.setBounds(0, 0, 1286, 102);
		contentPane.add(instructionPanel);
		instructionPanel.setLayout(null);

		JLabel messageJLabel = new JLabel(
				"Pour cr\u00E9er un nouveau compte, veuillez suivre les \u00E9tapes suivantes :");
		messageJLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		messageJLabel.setBounds(10, 10, 634, 16);
		instructionPanel.add(messageJLabel);

		JLabel instruction1JLabel = new JLabel("1/Choisissez parmi les 3 types de comptes");
		instruction1JLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		instruction1JLabel.setBounds(30, 36, 479, 23);
		instructionPanel.add(instruction1JLabel);

		JLabel instruction2JLabel = new JLabel("2/Remplissez le forumlaire corr\u00E9spondant");
		instruction2JLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		instruction2JLabel.setBounds(30, 69, 389, 23);
		instructionPanel.add(instruction2JLabel);
		accountChoicePanel.setBounds(0, 103, 1286, 57);
		contentPane.add(accountChoicePanel);
		accountChoicePanel.setLayout(null);

		compteSalaireRadioButton = new JRadioButton("Compte Salaire");
		compteSalaireRadioButton.setSelected(true);
		compteSalaireRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		compteSalaireRadioButton.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		compteSalaireRadioButton.setBounds(60, 16, 211, 35);
		accountChoicePanel.add(compteSalaireRadioButton);
		accountChoice.add(compteSalaireRadioButton);
		compteSalaireRadioButton.addActionListener(new RadioButtonActionListener());

		compteEpargneRadioButton = new JRadioButton("Compte Epargne");
		compteEpargneRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		compteEpargneRadioButton.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		compteEpargneRadioButton.setBounds(525, 19, 250, 30);
		accountChoicePanel.add(compteEpargneRadioButton);
		accountChoice.add(compteEpargneRadioButton);
		compteEpargneRadioButton.addActionListener(new RadioButtonActionListener());

		compteVipRadioButton = new JRadioButton("Compte VIP");
		compteVipRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		compteVipRadioButton.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		compteVipRadioButton.setBounds(946, 16, 211, 33);
		accountChoicePanel.add(compteVipRadioButton);
		accountChoice.add(compteVipRadioButton);
		compteVipRadioButton.addActionListener(new RadioButtonActionListener());

		compteSalarierPanel = new JPanel();
		compteSalarierPanel.setBounds(0, 159, 500, 575);
		contentPane.add(compteSalarierPanel);
		compteSalarierPanel.setLayout(null);

		JLabel nomJLabel1 = new JLabel("Nom :");
		nomJLabel1.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		nomJLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		nomJLabel1.setBounds(10, 7, 103, 31);
		compteSalarierPanel.add(nomJLabel1);

		JLabel prenomJLabel1 = new JLabel("Prenom :");
		prenomJLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		prenomJLabel1.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		prenomJLabel1.setBounds(10, 58, 103, 31);
		compteSalarierPanel.add(prenomJLabel1);

		JLabel professionJLabel1 = new JLabel("Profession :");
		professionJLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		professionJLabel1.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		professionJLabel1.setBounds(10, 116, 127, 31);
		compteSalarierPanel.add(professionJLabel1);

		JLabel telephoneJLabel1 = new JLabel("Telephone :");
		telephoneJLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		telephoneJLabel1.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		telephoneJLabel1.setBounds(10, 174, 127, 31);
		compteSalarierPanel.add(telephoneJLabel1);

		JLabel cinJLabel1 = new JLabel("CIN :");
		cinJLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		cinJLabel1.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		cinJLabel1.setBounds(10, 226, 127, 31);
		compteSalarierPanel.add(cinJLabel1);

		JLabel montantJLabel1 = new JLabel("Salaire (dt) :");
		montantJLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		montantJLabel1.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		montantJLabel1.setBounds(10, 278, 127, 31);
		compteSalarierPanel.add(montantJLabel1);

		JLabel agenceJLabel1 = new JLabel("Agence :");
		agenceJLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		agenceJLabel1.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		agenceJLabel1.setBounds(10, 332, 127, 31);
		compteSalarierPanel.add(agenceJLabel1);

		nomTextField1 = new JTextField();
		nomTextField1.setBounds(123, 10, 318, 31);
		compteSalarierPanel.add(nomTextField1);
		nomTextField1.setColumns(10);

		prenomTextField1 = new JTextField();
		prenomTextField1.setColumns(10);
		prenomTextField1.setBounds(123, 61, 318, 31);
		compteSalarierPanel.add(prenomTextField1);

		String[] adresses = { "BIAT Omran Supérieur", "BIAT Manar 1", "BIAT Menzah 6", "BIAT Ennaser" };
		agenceComboBox1 = new JComboBox(adresses);
		agenceComboBox1.setBounds(123, 332, 318, 36);
		compteSalarierPanel.add(agenceComboBox1);

		telephoneFormattedTextField1 = new JFormattedTextField();
		telephoneFormattedTextField1.setBounds(123, 174, 318, 31);
		compteSalarierPanel.add(telephoneFormattedTextField1);

		cinFormattedTextField1 = new JFormattedTextField();
		cinFormattedTextField1.setBounds(123, 229, 318, 31);
		compteSalarierPanel.add(cinFormattedTextField1);

		montantFormattedTextField1 = new JFormattedTextField();
		montantFormattedTextField1.setBounds(133, 281, 308, 31);
		compteSalarierPanel.add(montantFormattedTextField1);

		professionTextField1 = new JTextField();
		professionTextField1.setColumns(10);
		professionTextField1.setBounds(123, 119, 318, 31);
		compteSalarierPanel.add(professionTextField1);
		Image imgSalaire = new ImageIcon(this.getClass().getResource("/salary.png")).getImage();

		JLabel salaryImg = new JLabel("");
		salaryImg.setIcon(new ImageIcon(imgSalaire));
		salaryImg.setBounds(148, 378, 127, 126);
		compteSalarierPanel.add(salaryImg);

		Image imgPlus1 = new ImageIcon(this.getClass().getResource("/createAccount.png")).getImage();

		createAccountJButton1 = new JButton("Cr\u00E9er Compte");
		createAccountJButton1.setHorizontalAlignment(SwingConstants.LEFT);
		createAccountJButton1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		createAccountJButton1.setBounds(285, 497, 205, 47);
		createAccountJButton1.setIcon(new ImageIcon(imgPlus1));
		compteSalarierPanel.add(createAccountJButton1);
		createAccountJButton1.addActionListener(new createAccountButtonListener());

		compteEpargnePanel = new JPanel();
		compteEpargnePanel.setBounds(409, 159, 500, 575);
		contentPane.add(compteEpargnePanel);
		compteEpargnePanel.setLayout(null);
		compteEpargnePanel.setVisible(false);

		JLabel nomJLabel2 = new JLabel("Nom :");
		nomJLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		nomJLabel2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		nomJLabel2.setBounds(10, 27, 103, 31);
		compteEpargnePanel.add(nomJLabel2);

		JLabel prenomJLabel2 = new JLabel("Prenom :");
		prenomJLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		prenomJLabel2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		prenomJLabel2.setBounds(10, 78, 103, 31);
		compteEpargnePanel.add(prenomJLabel2);

		JLabel professionJLabel2 = new JLabel("Profession :");
		professionJLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		professionJLabel2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		professionJLabel2.setBounds(10, 130, 127, 31);
		compteEpargnePanel.add(professionJLabel2);

		JLabel telephoneJLabel2 = new JLabel("Telephone :");
		telephoneJLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		telephoneJLabel2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		telephoneJLabel2.setBounds(10, 183, 127, 31);
		compteEpargnePanel.add(telephoneJLabel2);

		JLabel cinJLabel2 = new JLabel("CIN :");
		cinJLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		cinJLabel2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		cinJLabel2.setBounds(10, 235, 127, 31);
		compteEpargnePanel.add(cinJLabel2);

		JLabel montantJLabel2 = new JLabel("Montant initial (dt) :");
		montantJLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		montantJLabel2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		montantJLabel2.setBounds(10, 286, 193, 31);
		compteEpargnePanel.add(montantJLabel2);

		JLabel agenceJLabel2 = new JLabel("Agence :");
		agenceJLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		agenceJLabel2.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		agenceJLabel2.setBounds(10, 341, 127, 31);
		compteEpargnePanel.add(agenceJLabel2);

		nomTextField2 = new JTextField();
		nomTextField2.setColumns(10);
		nomTextField2.setBounds(129, 30, 318, 31);
		compteEpargnePanel.add(nomTextField2);

		prenomTextField2 = new JTextField();
		prenomTextField2.setColumns(10);
		prenomTextField2.setBounds(129, 81, 318, 31);
		compteEpargnePanel.add(prenomTextField2);

		professionTextField2 = new JTextField();
		professionTextField2.setColumns(10);
		professionTextField2.setBounds(129, 133, 318, 31);
		compteEpargnePanel.add(professionTextField2);

		telephoneFormattedTextField2 = new JFormattedTextField();
		telephoneFormattedTextField2.setBounds(129, 186, 318, 31);
		compteEpargnePanel.add(telephoneFormattedTextField2);

		cinFormattedTextField2 = new JFormattedTextField();
		cinFormattedTextField2.setBounds(129, 238, 318, 31);
		compteEpargnePanel.add(cinFormattedTextField2);

		montantFormattedTextField2 = new JFormattedTextField();
		montantFormattedTextField2.setBounds(230, 289, 217, 31);
		compteEpargnePanel.add(montantFormattedTextField2);

		agenceComboBox2 = new JComboBox(adresses);
		agenceComboBox2.setBounds(129, 341, 318, 36);
		compteEpargnePanel.add(agenceComboBox2);

		JLabel EpargneImg = new JLabel("");
		Image imgEpargne = new ImageIcon(this.getClass().getResource("/epargne.png")).getImage();
		EpargneImg.setIcon(new ImageIcon(imgEpargne));
		EpargneImg.setBounds(160, 387, 127, 126);
		compteEpargnePanel.add(EpargneImg);

		JButton createAccountJButton2 = new JButton("Cr\u00E9er Compte");
		createAccountJButton2.setHorizontalAlignment(SwingConstants.LEFT);
		createAccountJButton2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		createAccountJButton2.setBounds(295, 497, 205, 47);
		createAccountJButton2.setIcon(new ImageIcon(imgPlus1));
		compteEpargnePanel.add(createAccountJButton2);
		createAccountJButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(11);
				System.out.println(cinFormattedTextField2.getText());
				if (ClientDb.verifClient(cinFormattedTextField2.getText()) == false) {
					System.out.println(cinFormattedTextField2.getText());
					ClientDb.insertClientNormal(nomTextField2.getText(), prenomTextField2.getText(),
							professionTextField2.getText(), telephoneFormattedTextField2.getText(),
							cinFormattedTextField2.getText());
					String idClient = ClientDb.getClientId(cinFormattedTextField2.getText());
					switch (agenceComboBox2.getSelectedItem().toString()) {
					case "BIAT Omran Supérieur":
						CompteDb.insertCompteEpargne(montantFormattedTextField2.getText(), "1", idClient);
						break;
					case "BIAT Manar 1":
						CompteDb.insertCompteEpargne(montantFormattedTextField2.getText(), "2", idClient);
						break;
					case "BIAT Menzah 6":
						CompteDb.insertCompteEpargne(montantFormattedTextField2.getText(), "3", idClient);
						break;
					case "BIAT Ennaser":
						CompteDb.insertCompteEpargne(montantFormattedTextField2.getText(), "4", idClient);
						break;
					}
				} else {
					String idClient = ClientDb.getClientId(cinFormattedTextField2.getText());
					switch (agenceComboBox2.getSelectedItem().toString()) {
					case "BIAT Omran Supérieur":
						CompteDb.insertCompteEpargne(montantFormattedTextField2.getText(), "1", idClient);
						break;
					case "BIAT Manar 1":
						CompteDb.insertCompteEpargne(montantFormattedTextField2.getText(), "2", idClient);
						break;
					case "BIAT Menzah 6":
						CompteDb.insertCompteEpargne(montantFormattedTextField2.getText(), "3", idClient);
						break;
					case "BIAT Ennaser":
						CompteDb.insertCompteEpargne(montantFormattedTextField2.getText(), "4", idClient);
						break;
					}
				}
				// frame.dispose();
				ClientEpargneInterface ClientEpargne = new ClientEpargneInterface();
				ClientEpargne.setVisible(true);
				ClientEpargne.setLocationRelativeTo(null);
			}
		});

		compteVipPanel = new JPanel();
		compteVipPanel.setBounds(811, 159, 475, 575);
		contentPane.add(compteVipPanel);
		compteVipPanel.setLayout(null);
		compteVipPanel.setVisible(false);

		JLabel nomJLabel3 = new JLabel("Nom :");
		nomJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		nomJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		nomJLabel3.setBounds(10, 22, 103, 31);
		compteVipPanel.add(nomJLabel3);

		JLabel prenomJLabel3 = new JLabel("Prenom :");
		prenomJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		prenomJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		prenomJLabel3.setBounds(10, 63, 103, 31);
		compteVipPanel.add(prenomJLabel3);

		JLabel professionJLabel3 = new JLabel("Profession :");
		professionJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		professionJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		professionJLabel3.setBounds(10, 104, 127, 31);
		compteVipPanel.add(professionJLabel3);

		JLabel telephoneJLabel3 = new JLabel("Telephone :");
		telephoneJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		telephoneJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		telephoneJLabel3.setBounds(10, 145, 127, 31);
		compteVipPanel.add(telephoneJLabel3);

		JLabel cinJLabel3 = new JLabel("CIN :");
		cinJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		cinJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		cinJLabel3.setBounds(10, 186, 127, 31);
		compteVipPanel.add(cinJLabel3);

		JLabel montantJLabel3 = new JLabel("Montant (dt) :");
		montantJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		montantJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		montantJLabel3.setBounds(10, 364, 144, 31);
		compteVipPanel.add(montantJLabel3);

		JLabel agenceJLabel3 = new JLabel("Agence :");
		agenceJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		agenceJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		agenceJLabel3.setBounds(10, 405, 127, 31);
		compteVipPanel.add(agenceJLabel3);

		nomTextField3 = new JTextField();
		nomTextField3.setColumns(10);
		nomTextField3.setBounds(130, 22, 318, 31);
		compteVipPanel.add(nomTextField3);

		prenomTextField3 = new JTextField();
		prenomTextField3.setColumns(10);
		prenomTextField3.setBounds(130, 63, 318, 31);
		compteVipPanel.add(prenomTextField3);

		professionTextField3 = new JTextField();
		professionTextField3.setColumns(10);
		professionTextField3.setBounds(130, 104, 318, 31);
		compteVipPanel.add(professionTextField3);

		telephoneFormattedTextField3 = new JFormattedTextField();
		telephoneFormattedTextField3.setBounds(130, 145, 318, 31);
		compteVipPanel.add(telephoneFormattedTextField3);

		cinFormattedTextField3 = new JFormattedTextField();
		cinFormattedTextField3.setBounds(130, 186, 318, 31);
		compteVipPanel.add(cinFormattedTextField3);

		montantFormattedTextField3 = new JFormattedTextField();
		montantFormattedTextField3.setBounds(164, 364, 284, 31);
		compteVipPanel.add(montantFormattedTextField3);

		agenceComboBox3 = new JComboBox(adresses);
		agenceComboBox3.setBounds(130, 405, 318, 36);
		compteVipPanel.add(agenceComboBox3);

		JLabel chiffreDaffaireJLabel3 = new JLabel("Chiffre d'affaires:");
		chiffreDaffaireJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		chiffreDaffaireJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		chiffreDaffaireJLabel3.setBounds(10, 227, 166, 38);
		compteVipPanel.add(chiffreDaffaireJLabel3);

		JLabel capaciteJLabel3 = new JLabel("Capacit\u00E9 :");
		capaciteJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		capaciteJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		capaciteJLabel3.setBounds(10, 275, 103, 31);
		compteVipPanel.add(capaciteJLabel3);

		JLabel nomEntrepriseJLabel3 = new JLabel("Nom de L'entreprise :");
		nomEntrepriseJLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		nomEntrepriseJLabel3.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		nomEntrepriseJLabel3.setBounds(10, 314, 196, 43);
		compteVipPanel.add(nomEntrepriseJLabel3);

		chiffreAffaireFormattedTextField3 = new JFormattedTextField();
		chiffreAffaireFormattedTextField3.setBounds(175, 227, 273, 31);
		compteVipPanel.add(chiffreAffaireFormattedTextField3);

		capaciteFormattedTextField3 = new JFormattedTextField();
		capaciteFormattedTextField3.setBounds(175, 275, 273, 31);
		compteVipPanel.add(capaciteFormattedTextField3);

		nomEntrepriseTextField3 = new JTextField();
		nomEntrepriseTextField3.setColumns(10);
		nomEntrepriseTextField3.setBounds(216, 323, 232, 31);
		compteVipPanel.add(nomEntrepriseTextField3);

		JLabel VipImg = new JLabel("");
		Image imgVip = new ImageIcon(this.getClass().getResource("/vip.png")).getImage();
		VipImg.setIcon(new ImageIcon(imgVip));
		VipImg.setBounds(140, 451, 111, 98);
		compteVipPanel.add(VipImg);

		createAccountJButton3 = new JButton("Cr\u00E9er Compte");
		createAccountJButton3.setHorizontalAlignment(SwingConstants.LEFT);
		createAccountJButton3.setIcon(new ImageIcon(imgPlus1));
		createAccountJButton3.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		createAccountJButton3.setBounds(260, 497, 205, 47);
		compteVipPanel.add(createAccountJButton3);
		createAccountJButton3.addActionListener(new createAccountButtonListener());
	}

	private class RadioButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton sourceButton = (JRadioButton) e.getSource();

			if (sourceButton == compteSalaireRadioButton) {

				compteEpargnePanel.setVisible(false);
				compteVipPanel.setVisible(false);
				compteSalarierPanel.setVisible(true);

			} else if (sourceButton == compteEpargneRadioButton) {

				compteSalarierPanel.setVisible(false);
				compteVipPanel.setVisible(false);
				compteEpargnePanel.setVisible(true);

			} else if (sourceButton == compteVipRadioButton) {

				compteSalarierPanel.setVisible(false);
				compteEpargnePanel.setVisible(false);
				compteVipPanel.setVisible(true);

			}

		}
	}

	private class createAccountButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton sourceButton = (JButton) e.getSource();

			if (sourceButton == createAccountJButton1) {
				if (ClientDb.verifClient(cinFormattedTextField1.getText()) == false) {
					if (ClientDb.insertClientNormal(nomTextField1.getText(), prenomTextField1.getText(),
							professionTextField1.getText(), telephoneFormattedTextField1.getText(),
							cinFormattedTextField1.getText()) == 1) {
						String idClient = ClientDb.getClientId(cinFormattedTextField1.getText());
						switch (agenceComboBox1.getSelectedItem().toString()) {
						case "BIAT Omran Supérieur":
							CompteDb.insertCompteSalaire(montantFormattedTextField1.getText(), "1", idClient);
							break;
						case "BIAT Manar 1":
							CompteDb.insertCompteSalaire(montantFormattedTextField1.getText(), "2", idClient);
							break;
						case "BIAT Menzah 6":
							CompteDb.insertCompteSalaire(montantFormattedTextField1.getText(), "3", idClient);
							break;
						case "BIAT Ennaser":
							CompteDb.insertCompteSalaire(montantFormattedTextField1.getText(), "4", idClient);
							break;
						}
					}
				} else {
					String idClient = ClientDb.getClientId(cinFormattedTextField1.getText());
					switch (agenceComboBox1.getSelectedItem().toString()) {
					case "BIAT Omran Supérieur":
						CompteDb.insertCompteSalaire(montantFormattedTextField1.getText(), "1", idClient);
						break;
					case "BIAT Manar 1":
						CompteDb.insertCompteSalaire(montantFormattedTextField1.getText(), "2", idClient);
						break;
					case "BIAT Menzah 6":
						CompteDb.insertCompteSalaire(montantFormattedTextField1.getText(), "3", idClient);
						break;
					case "BIAT Ennaser":
						CompteDb.insertCompteSalaire(montantFormattedTextField1.getText(), "4", idClient);
						break;
					}
				}
				// frame.dispose();
				ClientSalaireInterface ClientSalaire = new ClientSalaireInterface();
				ClientSalaire.setVisible(true);
				ClientSalaire.setLocationRelativeTo(null);

			}

			else if (sourceButton == createAccountJButton3) {
				if (ClientDb.verifClient(cinFormattedTextField3.getText()) == false) {
					ClientDb.insertClientVip(nomTextField3.getText(), prenomTextField3.getText(),
							professionTextField3.getText(), telephoneFormattedTextField3.getText(),
							cinFormattedTextField3.getText(), chiffreAffaireFormattedTextField3.getText(),
							capaciteFormattedTextField3.getText(), nomEntrepriseTextField3.getText());
					String idClient = ClientDb.getClientId(cinFormattedTextField3.getText());
					switch (agenceComboBox3.getSelectedItem().toString()) {
					case "BIAT Omran Supérieur":
						CompteDb.insertCompteVip(montantFormattedTextField3.getText(), "1", idClient);
						break;
					case "BIAT Manar 1":
						CompteDb.insertCompteVip(montantFormattedTextField3.getText(), "2", idClient);
						break;
					case "BIAT Menzah 6":
						CompteDb.insertCompteVip(montantFormattedTextField3.getText(), "3", idClient);
						break;
					case "BIAT Ennaser":
						CompteDb.insertCompteVip(montantFormattedTextField3.getText(), "4", idClient);
						break;
					}
				} else {
					String idClient = ClientDb.getClientId(cinFormattedTextField3.getText());
					switch (agenceComboBox3.getSelectedItem().toString()) {
					case "BIAT Omran Supérieur":
						CompteDb.insertCompteVip(montantFormattedTextField3.getText(), "1", idClient);
						break;
					case "BIAT Manar 1":
						CompteDb.insertCompteVip(montantFormattedTextField3.getText(), "2", idClient);
						break;
					case "BIAT Menzah 6":
						CompteDb.insertCompteVip(montantFormattedTextField3.getText(), "3", idClient);
						break;
					case "BIAT Ennaser":
						CompteDb.insertCompteVip(montantFormattedTextField3.getText(), "4", idClient);
						break;
					}
				}
				// frame.dispose();
				ClientVipInterface ClientVip = new ClientVipInterface();
				ClientVip.setVisible(true);
				ClientVip.setLocationRelativeTo(null);
			}

		}

	}
}
