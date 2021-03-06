package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Livraison;

public class LivraisonDAO {
	 private Connection connection;

	 public LivraisonDAO(Connection conn) {
		 this.connection = conn;
	    }

	 public void addLivraison(Livraison livraison) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into LIVRAISON (IDARTICLE, DATELIVRAISON, STATUT) values (?, ?, ? )");
	            // Parameters start with 1
	  // IDLIVRAISON
	            preparedStatement.setInt(1, livraison.getArticle().getIdArticle());
	            preparedStatement.setDate(2, new java.sql.Date(livraison.getDate().getTime()));
	            preparedStatement.setString(3, livraison.getStatus() );
	            preparedStatement.executeUpdate();
	            majID(livraison);
				System.out.println("La livraison de l'article: " + livraison.getArticle().getIdArticle()
						+ " a bien été ajouté");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	    public void deleteLivraison (int livraisonId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from LIVRAISON where IDLIVRAISON=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, livraisonId);
	            preparedStatement.executeUpdate();
	            this.connection.commit();
				System.out.println("La livraison: " + livraisonId + " a bien été supprimé");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void updateLivraison(Livraison livraison) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update LIVRAISON set IDARTICLE=?, DATELIVRAISON=?, STATUT=?" +"where IDLIVRAISON=?");
	            // Parameters start with 1
	            preparedStatement.setInt(1, livraison.getArticle().getIdArticle());
	            preparedStatement.setDate(2, new java.sql.Date(livraison.getDate().getTime()));
	            preparedStatement.setString(3, livraison.getStatus() );
	            preparedStatement.setInt(4, livraison.getIdLivraison());
	            preparedStatement.executeUpdate();
	            this.connection.commit();
				System.out.println("La livraison: " + livraison.getIdLivraison()
						+ " a bien été modifié");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void majID(Livraison livraison){
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from LIVRAISON where IDARTICLE=? AND DATELIVRAISON=?");
	            preparedStatement.setInt(1, livraison.getArticle().getIdArticle());
	            preparedStatement.setDate(2, new java.sql.Date(livraison.getDate().getTime()));
	            ResultSet rs = preparedStatement.executeQuery();
	            ArticleDAO articleDAO = new ArticleDAO(connection);
	            if (rs.next()) {	
	            	livraison.setIdLivraison(rs.getInt("IDLIVRAISON"));
	            	livraison.setArticle(articleDAO.getArticleById(rs.getInt("IDARTICLE")));
	            	livraison.setDate(rs.getDate("DATELIVRAISON"));
	            	livraison.setStatus(rs.getString("STATUT"));
		            this.connection.commit();
		            System.out.println("Idlivraison mis à jour pour IDARTICLE:"+livraison.getArticle().getIdArticle()+"et DATELIVRAISON:"+livraison.getDate()+". Son id est: "+livraison.getIdLivraison());
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public List<Livraison> getAllLivraison() {
	    	List<Livraison> livraisons = new ArrayList<Livraison>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from COMMANDE");
	            ArticleDAO articleDAO = new ArticleDAO(connection);
	            while (rs.next()) {
	            	Livraison livraison = new Livraison();
	            	livraison.setIdLivraison(rs.getInt("IDLIVRAISON"));
	            	livraison.setArticle(articleDAO.getArticleById(rs.getInt("IDARTICLE")));
	            	livraison.setDate(rs.getDate("DATELIVRAISON"));
	            	livraison.setStatus(rs.getString("STATUT"));
	                livraisons.add(livraison);              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return livraisons;
	    }

	    public Livraison getLivraisonById(int livraisonId) {
	        Livraison livraison = new Livraison();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from LIVRAISON where IDLIVRAISON="+livraisonId);
	            //preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            ArticleDAO articleDAO = new ArticleDAO(connection);
	            if (rs.next()) {	            	
	            	livraison.setArticle(articleDAO.getArticleById(rs.getInt("IDARTICLE")));
	            	livraison.setDate(rs.getDate("DATELIVRAISON"));
	            	livraison.setStatus(rs.getString("STATUT"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return livraison;
	    }
}
