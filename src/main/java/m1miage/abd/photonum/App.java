package m1miage.abd.photonum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		db = ConnectDatabase.getConnection();
		db = ConnectDatabase.getConnection();
		
		
		//Connection conn = ConnectDatabase.getConnection();
		ClientDAO client = new ClientDAO(db);
		Statement statement;
		try {
			statement = db.createStatement();
			ResultSet rs = statement.executeQuery("select * from Client");
			System.out.println(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//client.getAllUsers();
	
		//Client client = new Client("  ", "  ", "  ", "  ", "  ");

		//Album album = new Album(client, "  ", "  ", 0);
		//System.out.println(album);*/
	}
}
