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
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into Client(NOM,PRENOM,MAIL,ADRESSE,MOT_DE_PASSE) values (?, ?, ?, ?, ? )");

	            // Parameters start with 1
	            
	            preparedStatement.setString(1, user.getNom());
	            preparedStatement.setString(2, user.getPrenom());	            
	            preparedStatement.setString(3, user.getMail());	            
	            preparedStatement.setString(4, user.getAdresse());
	            preparedStatement.setString(5, user.getMdp());
	            preparedStatement.executeUpdate();
	            System.out.println("Le client "+user.getNom()+" a bien été ajouté");
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	    public void deleteUser(int clientId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from users where userid=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, clientId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void updateUser(Client user) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update CLIENT set NOM=?, PRENOM=?, MAIL=?, ADRESSE=?, MOT_DE_PASSE=? where IDCLIENT=?");
	            // Parameters start with 1
	            
	            preparedStatement.setString(1, user.getNom());
	            preparedStatement.setString(2, user.getPrenom());
	            preparedStatement.setString(3, user.getMail());	            
	            preparedStatement.setString(4, user.getAdresse());
	            preparedStatement.setString(5, user.getMdp());
	            preparedStatement.setInt(6, user.getIdClient());
	            preparedStatement.executeUpdate();
	            System.out.println("Le client "+user.getNom()+" a bien été mis à jour");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void majID(Client user){
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from CLIENT where NOM=?, PRENOM=?");
	            //preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	
	            	 user.setIdClient(rs.getInt("IDCLIENT"));
		             user.setNom(rs.getString("NOM"));
		             user.setPrenom(rs.getString("PRENOM"));
		             user.setMail(rs.getString("MAIL"));
		             user.setAdresse(rs.getString("ADRESSE"));
		             user.setMdp(rs.getString("MOT_DE_PASSE"));
		             System.out.println("Client trouvé :"+user.getNom());
	            }
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
	            	user.setIdClient(rs.getInt("IDCLIENT"));
	            	user.setNom(rs.getString("NOM"));
	                user.setPrenom(rs.getString("PRENOM"));
	                user.setMail(rs.getString("MAIL"));
	                user.setAdresse(rs.getString("ADRESSE"));
	                user.setMdp(rs.getString("MOT_DE_PASSE"));
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
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from CLIENT where IDCLIENT=?");
	            preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	
	            	 user.setIdClient(rs.getInt("IDCLIENT"));
		             user.setNom(rs.getString("NOM"));
		             user.setPrenom(rs.getString("PRENOM"));
		             user.setMail(rs.getString("MAIL"));
		             user.setAdresse(rs.getString("ADRESSE"));
		             user.setMdp(rs.getString("MOT_DE_PASSE"));
		             System.out.println("Client trouvé :"+user.getNom());
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	    
	    public Client getUserByMail(String userMail) {
	        Client user = new Client();
	        try {
	        	
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from CLIENT where dbms_lob.compare(MAIL, ?) = 0");
	            preparedStatement.setString(1, userMail);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	
	            	 user.setIdClient(rs.getInt("IDCLIENT"));
		             user.setNom(rs.getString("NOM"));
		             user.setPrenom(rs.getString("PRENOM"));
		             user.setMail(rs.getString("MAIL"));
		             user.setAdresse(rs.getString("ADRESSE"));
		             user.setMdp(rs.getString("MOT_DE_PASSE"));
		             System.out.println("Client trouvé : "+user.getNom());
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	
}
