package m1miage.abd.photonum;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import m1miage.abd.photonum.db.ClientDAO;
import m1miage.abd.photonum.db.CommandeDAO;
import m1miage.abd.photonum.db.PrestataireDAO;
import m1miage.abd.photonum.model.Client;
import m1miage.abd.photonum.model.Commande;
import m1miage.abd.photonum.model.Prestataire;
import util.ConnectDatabase;
import util.PrintableMenu;

public class Utilisateur {

	private static Connection db = ConnectDatabase.getConnection();
	private static Client currentConnectedUser = null;
	private static Scanner scan = new Scanner(System.in);
	private static ClientDAO client;

	
	public static void main(String[] args) {
			Logger logger = Logger.getLogger("defaultLog");
			logger.setUseParentHandlers(false);
			FileHandler fh;
			try {
				fh = new FileHandler("logs/MyLogFile.log");
				SimpleFormatter formatter = new SimpleFormatter();
				fh.setFormatter(formatter);
			} catch (SecurityException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   


			//ClientDAO clientDAO = new ClientDAO(db);

			String nom;
			String prenom;
			String mail;
			String adresse;
			String pass;
			System.out.println("Veillez saisir votre nom pour creer un compte");
			nom = scan.nextLine();
			System.out.println("Veillez saisir votre prenom");
			prenom = scan.nextLine();
			System.out.println("Veillez saisir votre mail");
			mail = scan.nextLine();
			System.out.println("Veillez saisir votre adresse");
			adresse = scan.nextLine();
			System.out.println("Veillez saisir votre mot de passe:");
			pass = scan.nextLine();
			currentConnectedUser = new Client(nom,prenom,mail,adresse,pass,1);
			client = new ClientDAO(db);
			client.addClient(currentConnectedUser);

			System.out.println("Bienvenue "+currentConnectedUser.getPrenom()+".");
			
			mainMenu();
			
			
			
			try {
				db.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private static void mainMenu() {
			PrintableMenu mainMenu = new PrintableMenu("Menu principal");
			mainMenu.addItem("Gestion du Profil ");
			mainMenu.addItem("Gestion des Albums");
			mainMenu.addItem("Gestion des commandes");
			int selectedItem = mainMenu.launch();
			switch (selectedItem) {
			case 1:
				utilisateurMenu();
				break;
			case 2:
				albumMenu();
				break;
			case 3:
				commandeMenu();
				break;
			case 4:
				//exit;

			default:
				System.out.println("Aucune option correspondant à votre séléction.");
				mainMenu();
				break;
			}
		}
		
		private static void utilisateurMenu() {
			PrintableMenu mainMenu = new PrintableMenu("Profil Utilisateur");
			mainMenu.addItem("Afficher les informations du profil");
			mainMenu.addItem("Afficher les codes promotion disponible");
			int selectedItem = mainMenu.launch();
			PreparedStatement preparedStatement;
			switch (selectedItem) {
			case 1:
				try {
					preparedStatement = db.prepareStatement("select * from Client where IDCLIENT=?");
					preparedStatement.setInt(1, currentConnectedUser.getIdClient());
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Nom: "+currentConnectedUser.getNom()+" Prénom: "+currentConnectedUser.getPrenom());
				System.out.println("Mail: "+currentConnectedUser.getMail()+" Adresse : "+currentConnectedUser.getAdresse());
				break;
			case 2:
				getAllPromotion()
				
				System.out.println("Nom: "+currentConnectedUser.getNom()+" Prénom: "+currentConnectedUser.getPrenom());
				System.out.println("Mail: "+currentConnectedUser.getMail()+" Adresse : "+currentConnectedUser.getAdresse());
				break;
			default:
				System.out.println("Aucune option correspondant à votre séléction.");
				mainMenu();
				break;
			}
		}
		
		public List<String> getAllPromotion() {
			List<String> promotion = new ArrayList<String>();
			try {
				Statement statement = db.createStatement();
				ResultSet rs = statement.executeQuery("select montant from Promotion join Commande on Promotion.idcommande=Commande.idcommande join Client on Commande.idclient=Client.idclient where idclient=?");
				String promo;
				while (rs.next()) {
					Client user = new Client();
					promo+=rs.getInt("MONTANT");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return promotion;
		}
		
		private static void prestatairesMenu() {
			PrintableMenu menu = new PrintableMenu("Menu prestataires");
			PrestataireDAO prestataireDAO = new PrestataireDAO(db);
			for (Prestataire prestataire : prestataireDAO.getAllPrestataire()) {
				menu.addItem(prestataire.getNom()+"("+prestataire.getIdPrestataire()+")");
			}
			menu.addItem("Nouveau prestataire");
			
			int selectedItem = menu.launch();
			
			if(menu.isLastItem(selectedItem)){
				Prestataire prestataire = new Prestataire();
				System.out.println("Entrez le nom de votre prestataire");
				prestataire.setNom(scan.nextLine());
				System.out.println("Entrez le téléphone de votre prestataire");
				prestataire.setTelephone(scan.nextLine());
				System.out.println("Entrez les informations de tirage de votre prestataire");
				prestataire.setActivite(scan.nextLine());
				System.out.println("Entrez l'adresse de votre prestataire");
				prestataire.setAdresse(scan.nextLine());
				
				PrestataireDAO prestatairePresistant = new PrestataireDAO(db);
				prestatairePresistant.addPrestataire(prestataire);
			}
		}
		private static void commandeMenu() {
			// Switch case
			PrintableMenu menu = new PrintableMenu("Menu commandes", "Séléctionnez une commande");
			CommandeDAO commandeDAO = new CommandeDAO(db);
			for (Commande commande : commandeDAO.getAllCommande()) {
				Client client = commande.getClient();
				menu.addItem("Cmd no "+commande.getIdCommande()+", "+client.getNom()+" "+client.getPrenom());
			}

			int selectedItem = menu.launch();
		}
		
		private static void utilisateursddMenu() {
			PrintableMenu menu = new PrintableMenu("Profile Utilisateur");
			//ClientDAO commandeDAO = new ClientDAO(db);client
			List<Client> clientList = commandeDAO.getAllUsers();
			for (Client client : clientList) {
				menu.addItem(client.getNom()+" "+client.getPrenom()+" ("+client.getIdClient()+")");
			}
			Client selectedClient = clientList.get(menu.launch());
			menu = new PrintableMenu("Utilisateur sélectionné: "+selectedClient.getNom()+" "+selectedClient.getPrenom()+"\n"
					+ "id: "+selectedClient.getIdClient()+"|"+selectedClient.getMail()+"|"+selectedClient.getAdresse());
			menu.addItem("Modifier prénom");
			menu.addItem("Modifier nom");
			menu.addItem("Modifier adresse");
			menu.addItem("Modifier mot de passe");
			menu.addItem("Voir les commandes");
			menu.addItem("Voir les albums");
		}
		


		private static void albumMenu() {
			PrintableMenu menu = new PrintableMenu("Profile Utilisateur, Séléctionnez un utilisateur");
			ClientDAO commandeDAO = new ClientDAO(db);
			List<Client> clientList = commandeDAO.getAllUsers();
			for (Client client : clientList) {
				menu.addItem(client.getNom()+" "+client.getPrenom()+" ("+client.getIdClient()+")");
			}
			Client selectedClient = clientList.get(menu.launch());
			menu = new PrintableMenu("Utilisateur sélectionné: "+selectedClient.getNom()+" "+selectedClient.getPrenom()+"\n"
					+ "id: "+selectedClient.getIdClient()+"|"+selectedClient.getMail()+"|"+selectedClient.getAdresse());
			menu.addItem("Modifier prénom");
			menu.addItem("Modifier nom");
			menu.addItem("Modifier adresse");
			menu.addItem("Modifier mot de passe");
			menu.addItem("Voir les commandes");
			menu.addItem("Voir les albums");
		}

		private static boolean connect(String emailAdress, String password){
			currentConnectedUser = new ClientDAO(db).getUserByMail(emailAdress);
			if(currentConnectedUser != null && password.equals(currentConnectedUser.getMdp())){
				return true;
			}
			return false;
		}
	

}
