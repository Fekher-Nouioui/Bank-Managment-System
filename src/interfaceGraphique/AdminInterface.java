package interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataBase.ClientDb;
import dataBase.CompteDb;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AdminInterface extends JFrame {

	private JPanel backgroundPanel;
	private JLabel transasctionLabel;
	private JPanel listeTransaction;
	private JLabel compteLabel;
	private JButton btnVoirListeCompte;
	private JLabel agenceLabel;
	private JLabel clientsLabel;
	private JButton btnNombreDesComptes;
	private JLabel nbComptesLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInterface frame = new AdminInterface();
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
	public AdminInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1423, 851);
		backgroundPanel = new JPanel();
		backgroundPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(backgroundPanel);
		backgroundPanel.setLayout(null);

		JPanel logoPanel = new JPanel();
		logoPanel.setBounds(0, 0, 1409, 66);
		backgroundPanel.add(logoPanel);
		logoPanel.setLayout(null);

		JLabel titre = new JLabel("Interface Admin");
		titre.setForeground(Color.RED);
		titre.setHorizontalAlignment(SwingConstants.CENTER);
		titre.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		titre.setBounds(10, 10, 1389, 51);
		logoPanel.add(titre);

		JPanel panel = new JPanel();
		panel.setBounds(195, 70, 1049, 66);
		backgroundPanel.add(panel);
		panel.setLayout(null);

		btnVoirListeCompte = new JButton("Voir Liste Compte");
		btnVoirListeCompte.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnVoirListeCompte.setBounds(262, 0, 251, 64);
		panel.add(btnVoirListeCompte);
		btnVoirListeCompte.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				compteLabel.setText(CompteDb.getAllComptes());

			}

		});

		JButton btnVoirListeTransaction = new JButton("Voir Liste Transaction");
		btnVoirListeTransaction.setBounds(0, 0, 251, 64);
		panel.add(btnVoirListeTransaction);
		btnVoirListeTransaction.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JButton btnVoirlisteagence = new JButton("voir Liste Agence");
		btnVoirlisteagence.setBounds(784, 0, 251, 64);
		panel.add(btnVoirlisteagence);
		btnVoirlisteagence.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnVoirlisteagence.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				agenceLabel.setText(ClientDb.getAllAgents());

			}

		});
		JButton btnVoirListeClients = new JButton("Voir Liste Clients");
		btnVoirListeClients.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clientsLabel.setText(ClientDb.getAllClients());

			}

		});
		btnVoirListeClients.setBounds(523, 0, 251, 64);
		panel.add(btnVoirListeClients);
		btnVoirListeClients.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnVoirListeTransaction.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				transasctionLabel.setText(CompteDb.getAllTransactions());

			}

		});

		listeTransaction = new JPanel();
		listeTransaction.setBorder(new LineBorder(Color.BLACK, 2, true));
		listeTransaction.setBounds(10, 142, 330, 509);
		backgroundPanel.add(listeTransaction);
		listeTransaction.setLayout(null);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(390, 10, 17, 526);
		listeTransaction.add(scrollBar);

		transasctionLabel = new JLabel("");
		transasctionLabel.setBounds(10, 60, 306, 448);
		listeTransaction.add(transasctionLabel);

		JLabel lblTransactions = new JLabel("Transactions");
		lblTransactions.setForeground(Color.RED);
		lblTransactions.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblTransactions.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactions.setBounds(0, 10, 330, 40);
		listeTransaction.add(lblTransactions);

		JPanel listeComptes = new JPanel();
		listeComptes.setBorder(new LineBorder(Color.BLACK, 2, true));
		listeComptes.setBounds(348, 142, 341, 509);
		backgroundPanel.add(listeComptes);
		listeComptes.setLayout(null);

		JLabel lblComptes = new JLabel("Comptes");
		lblComptes.setHorizontalAlignment(SwingConstants.CENTER);
		lblComptes.setForeground(Color.RED);
		lblComptes.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblComptes.setBounds(0, 10, 341, 43);
		listeComptes.add(lblComptes);

		compteLabel = new JLabel("");
		compteLabel.setBounds(10, 56, 321, 452);
		listeComptes.add(compteLabel);

		JPanel listeClients = new JPanel();
		listeClients.setBorder(new LineBorder(Color.BLACK, 2, true));
		listeClients.setLayout(null);
		listeClients.setBounds(699, 142, 349, 509);
		backgroundPanel.add(listeClients);

		JLabel lblClients = new JLabel("Clients");
		lblClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblClients.setForeground(Color.RED);
		lblClients.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblClients.setBounds(0, 10, 341, 43);
		listeClients.add(lblClients);

		clientsLabel = new JLabel("");
		clientsLabel.setBounds(10, 63, 331, 433);
		listeClients.add(clientsLabel);

		JPanel listeAgences = new JPanel();
		listeAgences.setBorder(new LineBorder(Color.BLACK, 2, true));
		listeAgences.setLayout(null);
		listeAgences.setBounds(1058, 142, 341, 509);
		backgroundPanel.add(listeAgences);

		JLabel lblAgences = new JLabel("Agences");
		lblAgences.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgences.setForeground(Color.RED);
		lblAgences.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblAgences.setBounds(0, 10, 341, 43);
		listeAgences.add(lblAgences);

		agenceLabel = new JLabel("");
		agenceLabel.setBounds(10, 56, 321, 434);
		listeAgences.add(agenceLabel);

		btnNombreDesComptes = new JButton("Nombre des Comptes");
		btnNombreDesComptes.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNombreDesComptes.setBounds(50, 661, 251, 47);
		backgroundPanel.add(btnNombreDesComptes);
		btnNombreDesComptes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nbComptesLabel.setText(CompteDb.getNbrComptes());

			}

		});

		nbComptesLabel = new JLabel("");
		nbComptesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nbComptesLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		nbComptesLabel.setBounds(10, 718, 330, 41);
		backgroundPanel.add(nbComptesLabel);

		JButton debitGlobalButton = new JButton("Debit Global de la Banque");
		debitGlobalButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		debitGlobalButton.setBounds(377, 661, 290, 47);
		backgroundPanel.add(debitGlobalButton);
		debitGlobalButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(CompteDb.getDebitGlobal());

			}

		});

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		label.setBounds(359, 718, 330, 41);
		backgroundPanel.add(label);

		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		label_1.setBounds(699, 718, 349, 41);
		backgroundPanel.add(label_1);

		JButton btnSoldeTotalDans = new JButton("Solde Total");
		btnSoldeTotalDans.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSoldeTotalDans.setBounds(1105, 661, 251, 47);
		backgroundPanel.add(btnSoldeTotalDans);
		btnSoldeTotalDans.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label_2.setText(CompteDb.getAllSolde());

			}

		});

		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		label_2.setBounds(1069, 718, 330, 41);
		backgroundPanel.add(label_2);

		JButton btnCreditGlobalDe = new JButton("Credit Global de la Banque");
		btnCreditGlobalDe.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCreditGlobalDe.setBounds(737, 661, 290, 47);
		backgroundPanel.add(btnCreditGlobalDe);
		btnCreditGlobalDe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				label_1.setText(CompteDb.getCreditGlobal());

			}

		});
	}
}
