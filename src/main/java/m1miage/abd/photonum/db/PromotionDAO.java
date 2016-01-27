package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Promotion;

public class PromotionDAO {
	
	private Connection connection;

	 public PromotionDAO(Connection conn) {
		 this.connection = conn;
	    }


	    public List<Promotion> getAllPromotion() {
	    	List<Promotion> promotions = new ArrayList<Promotion>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from PROMOTION");
	            CommandeDAO commandeDAO = new CommandeDAO(connection);
	            while (rs.next()) {
	            	Promotion promotion = new Promotion();
	            	promotion.setCommande(commandeDAO.getCommandeById(rs.getInt("COMMANDEID")));
	                promotion.setMontant(rs.getFloat("MONTANT"));
	                promotion.setIdPromotion(rs.getInt("IDPROMOTION"));
	            	promotions.add(promotion);              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return promotions;
	    }

	    public Promotion getPromotionById(int promotionId) {
	        Promotion promotion = new Promotion();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from PROMOTION where IDPROMOTION="+promotionId);
	            ResultSet rs = preparedStatement.executeQuery();
	            CommandeDAO commandeDAO = new CommandeDAO(connection);
	            if (rs.next()) {	            	
	            	promotion.setCommande(commandeDAO.getCommandeById(rs.getInt("COMMANDEID")));
	                promotion.setMontant(rs.getFloat("MONTANT"));
	                promotion.setIdPromotion(rs.getInt("IDPROMOTION"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return promotion;
	    }

}
