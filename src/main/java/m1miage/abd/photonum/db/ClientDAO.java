package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Client;

import  util.DatabaseAccessProperties;


public class ClientDAO {

	 private Connection connection;

	 public ClientDAO(Connection conn) {
		 this.connection = conn;
	    }

	 public void addClient(Client user) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into Client(Prenom,Nom,mail,email) values (?, ?, ?, ? )");

	            // Parameters start with 1
	            preparedStatement.setString(1, user.getPrenom());
	            preparedStatement.setString(2, user.getNom());
	            preparedStatement.setString(3, user.getMail());	            
	            preparedStatement.setString(4, user.getAdresse());
	            preparedStatement.setString(5, user.getMdp());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	    public void deleteUser(int clientId) {

	        try {

	            PreparedStatement preparedStatement = connection

	                    .prepareStatement("delete from users where userid=?");

	            // Parameters start with 1

	            preparedStatement.setInt(1, clientId);

	            preparedStatement.executeUpdate();



	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }



	    public void updateUser(Client user) {

	        try {

	            PreparedStatement preparedStatement = connection

	                    .prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?" +

	                            "where userid=?");

	            // Parameters start with 1

	            preparedStatement.setString(1, user.getPrenom());

	            preparedStatement.setString(2, user.getNom());

	            preparedStatement.setString(3, user.getMail());
	            
	            preparedStatement.setString(4, user.getAdresse());

	            preparedStatement.setString(5, user.getMdp());

	            preparedStatement.executeUpdate();



	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }




	    public List<Client> getAllUsers() {
	    	List<Client> users = new ArrayList<Client>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from Client");
	            while (rs.next()) {
	            	Client user = new Client();
	                user.setPrenom(rs.getString("prenom"));
	                user.setNom(rs.getString("nom"));
	                user.setMail(rs.getString("mail"));
	                user.setAdresse(rs.getString("adresse"));
	                user.setMdp(rs.getString("mdp"));
	                users.add(user);              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }



	    public Client getUserById(int userId) {

	        Client user = new Client();

	        try {

	            PreparedStatement preparedStatement = connection.

	                    prepareStatement("select * from users where userid=?");

	            //preparedStatement.setInt(1, userId);

	            ResultSet rs = preparedStatement.executeQuery();



	            if (rs.next()) {

	            	 user.setPrenom(rs.getString("prenom"));

		             user.setNom(rs.getString("nom"));

		             user.setMail(rs.getString("mail"));

		             user.setAdresse(rs.getString("adresse"));

		             user.setMdp(rs.getString("mdp"));

	            }

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }



	        return user;

	    }
	
}
