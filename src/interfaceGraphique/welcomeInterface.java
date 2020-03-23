package interfaceGraphique;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import dataBase.CompteDb;
import javax.swing.JSeparator;

public class welcomeInterface {
	private JFrame frame;
	private JPanel logInPanel;
	private JPanel createAccoutPanel;
	private JPanel clientLoginPanel;
	private JLabel welcomeJLabel;
	private JLabel logoBanque;
	private JLabel newAccountLabel;
	private JLabel titleJLabel;
	private JLabel choiceJLabel;
	private JButton createAccountJButton;
	private JButton loginJButton;
	private JRadioButton adminRadioButton;
	private JRadioButton clientRadioButton;
	private JTextField nomTextField;
	private JTextField prenomTextField;
	private JPasswordField ribTextField;
	private JPanel adminLoginPanel;
	private JLabel nomJLabel2;
	private JLabel motDePasseJLabel;
	private JPasswordField pwdTextField;
	private JTextField nomTextField2;
	private JLabel newAccountLabel2;
	private JSeparator separator2;
	private JSeparator separatorVertical;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomeInterface window = new welcomeInterface();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcomeInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("AUTHENTIFICATION");
		frame.setBounds(100, 100, 1300, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBounds(0, 0, 1286, 702);
		frame.getContentPane().add(backgroundPanel);
		backgroundPanel.setLayout(null);

		logInPanel = new JPanel();
		logInPanel.setBackground(UIManager.getColor("Button.background"));
		logInPanel.setBounds(0, 0, 644, 712);
		backgroundPanel.add(logInPanel);
		logInPanel.setLayout(null);

		titleJLabel = new JLabel("AUTHENTIFICATION");
		titleJLabel.setFont(new Font("Georgia", Font.BOLD, 46));
		titleJLabel.setForeground(Color.BLACK);
		titleJLabel.setBackground(new Color(240, 248, 255));
		titleJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleJLabel.setBounds(51, 21, 536, 119);
		logInPanel.add(titleJLabel);

		choiceJLabel = new JLabel("S'authentifier :");
		choiceJLabel.setHorizontalAlignment(SwingConstants.LEFT);
		choiceJLabel.setForeground(new Color(0, 0, 0));
		choiceJLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		choiceJLabel.setBounds(51, 181, 170, 47);
		logInPanel.add(choiceJLabel);

		ButtonGroup choixButtonGroup = new ButtonGroup();
		adminRadioButton = new JRadioButton("ADMIN");
		adminRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		adminRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		adminRadioButton.setBounds(219, 234, 160, 47);
		logInPanel.add(adminRadioButton);
		choixButtonGroup.add(adminRadioButton);

		adminRadioButton.addActionListener(new RadioButtonActionListener());

		clientRadioButton = new JRadioButton("CLIENT");
		clientRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		clientRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		clientRadioButton.setSelected(true);
		clientRadioButton.setBounds(219, 183, 224, 47);
		logInPanel.add(clientRadioButton);
		choixButtonGroup.add(clientRadioButton);

		clientRadioButton.addActionListener(new RadioButtonActionListener());

		loginJButton = new JButton("Connecter");
		loginJButton.setHorizontalAlignment(SwingConstants.LEFT);
		Image loginIncon = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		loginJButton.setIcon(new ImageIcon(loginIncon));
		loginJButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		loginJButton.setBounds(410, 655, 224, 47);
		logInPanel.add(loginJButton);

		loginJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (adminRadioButton.isSelected()) {
					if (nomTextField2.getText().equals("Fekher")
							&& Arrays.equals("Nouioui".toCharArray(), pwdTextField.getPassword())) {

						frame.dispose();
						AdminInterface admin = new AdminInterface();
						admin.setVisible(true);
						admin.setLocationRelativeTo(null);
					} else {
						JOptionPane.showMessageDialog(null,
								"Données erronées ! Veuillez reverifiez votre Nom et Mot de Passe");
						nomTextField2.setText(null);
						pwdTextField.setText(null);

					}
				}

				else if (clientRadioButton.isSelected()) {
					String rib = String.valueOf(ribTextField.getPassword());
					if (CompteDb.verifLogin(rib)) {

						switch (CompteDb.getCompteType(rib)) {
						case "Salaire":
							frame.dispose();
							ClientSalaireInterface ClientSalaire = new ClientSalaireInterface();
							ClientSalaire.setVisible(true);
							ClientSalaire.setLocationRelativeTo(null);
							break;
						case "Epargne":
							frame.dispose();
							ClientEpargneInterface ClientEpargne = new ClientEpargneInterface();
							ClientEpargne.setVisible(true);
							ClientEpargne.setLocationRelativeTo(null);
							break;
						case "Vip":
							frame.dispose();
							ClientVipInterface ClientVip = new ClientVipInterface();
							ClientVip.setVisible(true);
							ClientVip.setLocationRelativeTo(null);
							break;
						}
					} else {
						JOptionPane.showMessageDialog(null, "Données erronées ! Veuillez reverifiez votre RIB");
						nomTextField.setText(null);
						prenomTextField.setText(null);
						ribTextField.setText(null);
					}
				}
			}
		});

		clientLoginPanel = new JPanel();
		clientLoginPanel.setBounds(10, 356, 511, 236);
		logInPanel.add(clientLoginPanel);
		clientLoginPanel.setLayout(null);

		JLabel nomJLabel = new JLabel("Nom :");
		nomJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 26));
		nomJLabel.setBounds(35, 33, 100, 36);
		clientLoginPanel.add(nomJLabel);

		JLabel prenomJLabel = new JLabel("Pr\u00E9nom :");
		prenomJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 26));
		prenomJLabel.setBounds(35, 97, 142, 51);
		clientLoginPanel.add(prenomJLabel);

		JLabel ribJLabel = new JLabel("RIB :");
		ribJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 30));
		ribJLabel.setBounds(35, 161, 77, 45);
		clientLoginPanel.add(ribJLabel);

		nomTextField = new JTextField();
		nomTextField.setBounds(201, 33, 188, 34);
		clientLoginPanel.add(nomTextField);
		nomTextField.setColumns(10);

		prenomTextField = new JTextField();
		prenomTextField.setBounds(201, 104, 188, 34);
		clientLoginPanel.add(prenomTextField);
		prenomTextField.setColumns(10);

		ribTextField = new JPasswordField();
		ribTextField.setBounds(201, 164, 188, 36);
		clientLoginPanel.add(ribTextField);

		adminLoginPanel = new JPanel();
		adminLoginPanel.setBounds(37, 356, 471, 217);
		logInPanel.add(adminLoginPanel);
		adminLoginPanel.setLayout(null);

		nomJLabel2 = new JLabel("Nom :");
		nomJLabel2.setFont(new Font("Trebuchet MS", Font.ITALIC, 26));
		nomJLabel2.setBounds(41, 47, 114, 47);
		adminLoginPanel.add(nomJLabel2);

		motDePasseJLabel = new JLabel("Mot de Passe :");
		motDePasseJLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 26));
		motDePasseJLabel.setBounds(41, 121, 171, 33);
		adminLoginPanel.add(motDePasseJLabel);

		pwdTextField = new JPasswordField();
		pwdTextField.setBounds(246, 121, 171, 36);
		adminLoginPanel.add(pwdTextField);

		nomTextField2 = new JTextField();
		nomTextField2.setBounds(185, 44, 232, 37);
		adminLoginPanel.add(nomTextField2);
		nomTextField2.setColumns(10);

		JButton resetButton = new JButton("Supprimer");
		resetButton.setHorizontalAlignment(SwingConstants.LEFT);
		resetButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		resetButton.setBounds(10, 655, 224, 47);
		logInPanel.add(resetButton);
		Image imgDelete = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		resetButton.setIcon(new ImageIcon(imgDelete));

		JSeparator separator1 = new JSeparator();
		separator1.setForeground(Color.BLACK);
		separator1.setBackground(Color.BLACK);
		separator1.setBounds(10, 126, 624, 7);
		logInPanel.add(separator1);

		separator2 = new JSeparator();
		separator2.setForeground(Color.BLACK);
		separator2.setBackground(Color.BLACK);
		separator2.setBounds(10, 612, 624, 7);
		logInPanel.add(separator2);
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (adminRadioButton.isSelected()) {
					nomTextField2.setText(null);
					pwdTextField.setText(null);
				} else if (clientRadioButton.isSelected()) {
					nomTextField.setText(null);
					prenomTextField.setText(null);
					ribTextField.setText(null);
				}

			}

		});

		createAccoutPanel = new JPanel();
		createAccoutPanel.setBounds(643, 0, 643, 702);
		backgroundPanel.add(createAccoutPanel);
		createAccoutPanel.setLayout(null);

		welcomeJLabel = new JLabel("Bienvenue dans Notre Banque !");
		welcomeJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeJLabel.setForeground(new Color(0, 0, 255));
		welcomeJLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 36));
		welcomeJLabel.setBounds(86, 10, 498, 150);
		createAccoutPanel.add(welcomeJLabel);

		logoBanque = new JLabel("");
		Image imgBanque = new ImageIcon(this.getClass().getResource("/logoBanque1.png")).getImage();
		logoBanque.setIcon(new ImageIcon(imgBanque));
		logoBanque.setBounds(188, 202, 262, 263);
		createAccoutPanel.add(logoBanque);

		newAccountLabel = new JLabel("Si vous \u00E9tes nouveau, vous devez s'inscrire en");
		newAccountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newAccountLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		newAccountLabel.setBounds(43, 475, 569, 52);
		createAccoutPanel.add(newAccountLabel);

		createAccountJButton = new JButton("Cr\u00E9er un Compte");
		createAccountJButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		createAccountJButton.setBounds(225, 622, 214, 46);
		createAccoutPanel.add(createAccountJButton);

		newAccountLabel2 = new JLabel(" cr\u00E9eant un compte dans notre banque ");
		newAccountLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		newAccountLabel2.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		newAccountLabel2.setBounds(43, 534, 569, 52);
		createAccoutPanel.add(newAccountLabel2);

		separatorVertical = new JSeparator();
		separatorVertical.setOrientation(SwingConstants.VERTICAL);
		separatorVertical.setBounds(0, 10, 5, 682);
		createAccoutPanel.add(separatorVertical);
		createAccountJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				CreateAccountInterface createAccount = new CreateAccountInterface();
				createAccount.setVisible(true);
				createAccount.setLocationRelativeTo(null);
			}

		});

	}

	private class RadioButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton sourceButton = (JRadioButton) e.getSource();

			if (sourceButton == adminRadioButton) {

				clientLoginPanel.setVisible(false);
				adminLoginPanel.setVisible(true);

			} else if (sourceButton == clientRadioButton) {

				adminLoginPanel.setVisible(false);
				clientLoginPanel.setVisible(true);

			}
		}
	}
}
