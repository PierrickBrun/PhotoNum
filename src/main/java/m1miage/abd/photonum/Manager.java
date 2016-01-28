package m1miage.abd.photonum;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.omg.CORBA.Principal;

import m1miage.abd.photonum.db.ClientDAO;
import m1miage.abd.photonum.db.CommandeDAO;
import m1miage.abd.photonum.db.PrestataireDAO;
import m1miage.abd.photonum.model.Client;
import m1miage.abd.photonum.model.Commande;
import m1miage.abd.photonum.model.Prestataire;
import util.ConnectDatabase;
import util.PrintableMenu;

public class Manager {
	private static Connection db = ConnectDatabase.getConnection();
	private static Client currentConnectedUser = null;
	private static Scanner scan = new Scanner(System.in);

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


		ClientDAO clientDAO = new ClientDAO(db);


		String mail;
		String pass;
		do{
			System.out.println("Welcome on PhotoNum Manager, enter your email adress to log in:");
			mail = scan.nextLine();

			System.out.println("Enter your password:");
			pass = scan.nextLine();
		}while(!connect(mail, pass));

		System.out.println("Welcome "+currentConnectedUser.getPrenom()+".");
		
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
		mainMenu.addItem("Gestion des utilisateurs");
		mainMenu.addItem("Gestion des prestataires");
		mainMenu.addItem("Gestion des images");
		mainMenu.addItem("Gestion des commandes");
		int selectedItem = mainMenu.launch();
		switch (selectedItem) {
		case 1:
			utilisateursMenu();
			break;
		case 2:
			prestatairesMenu();
			break;
		case 3:
			imagesMenu();
			break;
		case 4:
			commandesMenu();
			break;

		default:
			System.out.println("Aucune option correspondant à votre séléction.");
			mainMenu();
			break;
		}
	}
	
	private static void commandesMenu() {
		PrintableMenu menu = new PrintableMenu("Menu commandes", "Séléctionnez une commande");
		CommandeDAO commandeDAO = new CommandeDAO(db);
		for (Commande commande : commandeDAO.getAllCommande()) {
			Client client = commande.getClient();
			menu.addItem("Cmd no "+commande.getIdCommande()+", "+client.getNom()+" "+client.getPrenom());
		}

		int selectedItem = menu.launch();
	}

	private static void imagesMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void prestatairesMenu() {
		PrintableMenu menu = new PrintableMenu("Menu prestataires");
		PrestataireDAO prestataireDAO = new PrestataireDAO(db);
		List<Prestataire> prestataires = prestataireDAO.getAllPrestataire();
		for (Prestataire prestataire : prestataires) {
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
			prestatairesMenu();
		}else{
			Prestataire prestataire = prestataires.get(selectedItem-1);
			System.out.println(prestataire);
			prestataireMenu(prestataire, prestataireDAO);
		}
	}
	
	private static void prestataireMenu(Prestataire prestataire, PrestataireDAO prestataireDAO) {
		PrintableMenu menu = new PrintableMenu("Prestataire: "+prestataire.getIdPrestataire(), "Séléctionnez une entrée pour la modifier");
		menu.addItem("Nom: "+prestataire.getNom());
		menu.addItem("Adresse: "+prestataire.getAdresse());
		menu.addItem("Tirage: "+prestataire.getActivite());
		menu.addItem("Téléphone: "+prestataire.getTelephone());
		menu.addItem("Supprimmer ce prestataire");
		switch (menu.launch()) {
		case 1:
			System.out.println("Entrez le nouveau nom de votre prestataire");
			prestataire.setNom(scan.nextLine());
			prestataireMenu(prestataire, prestataireDAO);
			break;
		case 2:
			System.out.println("Entrez la nouvelle adresse de votre prestataire");
			prestataire.setAdresse(scan.nextLine());
			prestataireMenu(prestataire, prestataireDAO);
			break;
		case 3:
			System.out.println("Entrez les nouvelles informations de tirage de votre prestataire");
			prestataire.setActivite(scan.nextLine());
			prestataireMenu(prestataire, prestataireDAO);
			break;
		case 4:
			System.out.println("Entrez le nouveau téléphone de votre prestataire");
			prestataire.setTelephone(scan.nextLine());
			prestataireMenu(prestataire, prestataireDAO);
			break;
		case 5:
			System.out.println("Suppression du prestataire");
			prestataireDAO.deletePrestataire(prestataire.getIdPrestataire());
			prestatairesMenu();
			break;

		default:
			break;
		}
	}

	private static void utilisateursMenu() {
		PrintableMenu menu = new PrintableMenu("Menu clients", "Séléctionnez un utilisateur");
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
