package m1miage.abd.photonum;

import java.sql.Connection;

import m1miage.abd.photonum.model.Album;
import m1miage.abd.photonum.model.Client;
import m1miage.abd.photonum.db.*;
import util.ConnectDatabase;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		Connection db = ConnectDatabase.getConnection();
		ClientDAO client = new ClientDAO(db);
		System.out.println(client.getAllUsers().get(0).getNom());
		
		
		/*Client client = new Client("  ", "  ", "  ", "  ", "  ");

		Album album = new Album(client, "  ", "  ", 0);
		System.out.println(album);*/
	}
}
