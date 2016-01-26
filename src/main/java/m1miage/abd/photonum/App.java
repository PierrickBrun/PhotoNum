package m1miage.abd.photonum;

import java.sql.Connection;

import m1miage.abd.photonum.model.Album;
import m1miage.abd.photonum.model.Client;
import util.ConnectDatabase;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		Connection db = ConnectDatabase.getConnection();
		db = ConnectDatabase.getConnection();
		
		
		/*Client client = new Client("  ", "  ", "  ", "  ", "  ");

		Album album = new Album(client, "  ", "  ", 0);
		System.out.println(album);*/
	}
}
