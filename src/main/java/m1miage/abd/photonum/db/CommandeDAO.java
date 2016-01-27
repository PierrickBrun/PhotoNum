package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Commande;

public class CommandeDAO {

	 private Connection connection;

	 public CommandeDAO(Connection conn) {
		 this.connection = conn;
	    }

	 public void addCommande(Commande commande) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into COMMANDE (IDPROMOTION, IDCLIENT, DATECOMMANDE, PRIXTOTAL, STATUT) values (?, ?, ?, ?, ? )");
	            // Parameters start with 1
	  // IDCOMMANDE
	            preparedStatement.setInt(2, commande.getPromotion().getIdPromotion());
	            preparedStatement.setInt(3, commande.getClient().getIdClient());
	            preparedStatement.setDate(4, new java.sql.Date(commande.getDateCommande().getTime()));	            
	            preparedStatement.setFloat(5, commande.getPrixTotal());	            
	            preparedStatement.setString(6, commande.getStatut());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	    public void deleteCommande (int commandeId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from COMMANDE where IDCOMMANDE="+commandeId);
	            // Parameters start with 1
	            preparedStatement.setInt(1, commandeId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void updateCommande(Commande commande) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update COMMANDE set IDPROMOTION=?, IDCLIENT=?, DATECOMMANDE=?, PRIXTOTAL=?, STATUT=?" +"where IDCOMMANDE=?");
	            // Parameters start with 1
	            preparedStatement.setInt(2, commande.getPromotion().getIdPromotion());
	            preparedStatement.setInt(3, commande.getClient().getIdClient());
	            preparedStatement.setDate(4, new java.sql.Date(commande.getDateCommande().getTime()));	            
	            preparedStatement.setFloat(5, commande.getPrixTotal());	            
	            preparedStatement.setString(6, commande.getStatut());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }




	    public List<Commande> getAllCommande() {
	    	List<Commande> commandes = new ArrayList<Commande>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from COMMANDE");
	            while (rs.next()) {
	            	Commande commande = new Commande();
	            	commande.setIdCommande(rs.getInt("IDCOMMANDE"));
	            	commande.getPromotion().setIdPromotion(rs.getInt("IDPROMOTION"));
	            	commande.getClient().setIdClient(rs.getInt("IDCLIENT"));
	            	commande.setDateCommande(rs.getDate("DATECOMMANDE"));
	            	commande.setPrixTotal(rs.getInt("PRIXTOTAL"));
	                commande.setStatut(rs.getString("STATUT"));
	                commandes.add(commande);              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return commandes;
	    }

	    public Commande getAlbumById(int commandeId) {
	        Commande commande = new Commande();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from COMMANDE where IDCOMMANDE="+commandeId);
	            //preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	            	
	            	commande.getPromotion().setIdPromotion(rs.getInt("IDPROMOTION"));
	            	commande.getClient().setIdClient(rs.getInt("IDCLIENT"));
	            	commande.setDateCommande(rs.getDate("DATECOMMANDE"));
	            	commande.setPrixTotal(rs.getInt("PRIXTOTAL"));
	                commande.setStatut(rs.getString("STATUT"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return commande;
	    }
}
