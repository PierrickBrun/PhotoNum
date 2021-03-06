package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Client;
import m1miage.abd.photonum.model.Commande;

public class CommandeDAO {

	 private Connection connection;

	 public CommandeDAO(Connection conn) {
		 this.connection = conn;
	    }

	 public void addCommande(Commande commande) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into COMMANDE (IDPROMOTION, IDCLIENT, DATECOMMANDE, PRIXTOTAL, STATUT) values (?, ?, ?, ?, ? )");
	            if(commande.getPromotion() == null){
	            	preparedStatement.setNull(1,java.sql.Types.INTEGER);
	            }else{	            	
	            	preparedStatement.setInt(1, commande.getPromotion().getIdPromotion());
	            }
	            preparedStatement.setInt(2, commande.getClient().getIdClient());
	            preparedStatement.setDate(3, new java.sql.Date(commande.getDateCommande().getTime()));	            
	            preparedStatement.setFloat(4, commande.getPrixTotal());	            
	            preparedStatement.setString(5, commande.getStatut());
	            preparedStatement.executeUpdate();
	            majID(commande);
				System.out.println("La commande du client: " + commande.getClient().getIdClient()
						+ " a bien été ajouté");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void majID(Commande cmd){
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from Commande where DATECOMMANDE= TO_DATE(?,'YYYY-MM-DD') AND IDCLIENT=?");
	            preparedStatement.setDate(1, new java.sql.Date(cmd.getDate().getTime()));
	            preparedStatement.setInt(2, cmd.getClient().getIdClient() );
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	
	            	 cmd.setIdCommande(rs.getInt("IDCOMMANDE"));
		             
		             this.connection.commit();
		             System.out.println("Id Commande mis à jour id: "+cmd.getIdCommande());
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void deleteCommande (int commandeId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from COMMANDE where IDCOMMANDE=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, commandeId);
	            preparedStatement.executeUpdate();
	            this.connection.commit();
				System.out.println("La commande: " + commandeId + " a bien été supprimé");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void updateCommande(Commande commande) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update COMMANDE set IDPROMOTION=?, IDCLIENT=?, DATECOMMANDE=?, PRIXTOTAL=?, STATUT=?" +"where IDCOMMANDE=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, commande.getPromotion().getIdPromotion());
	            preparedStatement.setInt(2, commande.getClient().getIdClient());
	            preparedStatement.setDate(3, new java.sql.Date(commande.getDateCommande().getTime()));	            
	            preparedStatement.setFloat(4, commande.getPrixTotal());	            
	            preparedStatement.setString(5, commande.getStatut());
	            preparedStatement.setInt(7, commande.getIdCommande());
	            preparedStatement.executeUpdate();
	            this.connection.commit();
				System.out.println("La commande: " + commande.getIdCommande()
						+ " a bien été modifié");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }




	    public List<Commande> getAllCommande() {
	    	List<Commande> commandes = new ArrayList<Commande>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from COMMANDE");
	            ClientDAO clientDAO = new ClientDAO(connection);
	            PromotionDAO promotionDAO = new PromotionDAO(connection);
	            while (rs.next()) {
	            	Commande commande = new Commande(clientDAO.getUserById(rs.getInt("IDCLIENT")));
	            	commande.setIdCommande(rs.getInt("IDCOMMANDE"));
	            	commande.setPromotion(promotionDAO.getPromotionById(rs.getInt("IDPROMOTION")));
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

	    public Commande getCommandeById(int commandeId) {
	        Commande commande = null;
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from COMMANDE where IDCOMMANDE="+commandeId);
	            //preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            ClientDAO clientDAO = new ClientDAO(connection);
	            PromotionDAO promotionDAO = new PromotionDAO(connection);
	            if (rs.next()) {	
	            	commande = new Commande(clientDAO.getUserById(rs.getInt("IDCLIENT")));
	            	commande.setPromotion(promotionDAO.getPromotionById(rs.getInt("IDPROMOTION")));	            
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
