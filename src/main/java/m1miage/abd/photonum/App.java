package m1miage.abd.photonum;

import m1miage.abd.photonum.model.Album;
import m1miage.abd.photonum.model.Client;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		Client client = new Client("  ", "  ", "  ", "  ", "  ");

		Album album = new Album(client, "  ", "  ", 0);
		System.out.println(album);
	}
}
