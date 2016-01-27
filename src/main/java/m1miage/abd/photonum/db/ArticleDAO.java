package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Article;

import  util.DatabaseAccessProperties;

public class ArticleDAO {

	 private Connection connection;

	 public ArticleDAO(Connection conn) {
		 this.connection = conn;
	    }

	 public void addArticle(Article article) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into ARTICLE (IDCOMMANDE, IDALBUM, IDFORMAT, IDPRESTATAIRE, QUANTITE, PRIX) values (?, ?, ?, ?, ?, ? )");

	            // Parameters start with 1
	  // IDARTICLE
	            preparedStatement.setInt(2, article.getCommande().getIdCommande());
	            preparedStatement.setInt(3, article.getAlbum().getIdAlbum());
	            preparedStatement.setInt(4, article.getFormat().getIdFormat());	            
	            preparedStatement.setInt(5, article.getPrestataire().getIdPrestataire());	            
	            preparedStatement.setInt(6, article.getQuantite());
	            preparedStatement.setFloat(7, article.getPrix());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	    public void deleteArticle (int articleId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from ARTICLE where IDARTICLE="+articleId);
	            // Parameters start with 1
	            preparedStatement.setInt(1, articleId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void updateArticle(Article article) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update ARTICLE set IDCOMMANDE=?, IDALBUM=?, IDFORMAT=?, IDPRESTATAIRE=?, QUANTITE=?, PRIX=?" +"where IDARTICLE=?");
	            // Parameters start with 1
	            preparedStatement.setInt(2, article.getCommande().getIdCommande());
	            preparedStatement.setInt(3, article.getAlbum().getIdAlbum());
	            preparedStatement.setInt(4, article.getFormat().getIdFormat());	            
	            preparedStatement.setInt(5, article.getPrestataire().getIdPrestataire());	            
	            preparedStatement.setInt(6, article.getQuantite());
	            preparedStatement.setFloat(7, article.getPrix());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }




	    public List<Article> getAllArticle() {
	    	List<Article> articles = new ArrayList<Article>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from ARTICLE");
	            while (rs.next()) {
	            	Article article = new Article();
	            	article.setIdArticle(rs.getInt("IDARTICLE"));
	            	article.getCommande().setIdCommande(rs.getInt("IDCOMMANDE"));
	            	article.getAlbum().setIdAlbum(rs.getInt("IDALBUM"));
	            	article.getFormat().setIdFormat(rs.getInt("IDFORMAT"));
	            	article.getPrestataire().setIdPrestataire(rs.getInt("IDPRESTATAIRE"));
	            	article.setQuantite(rs.getInt("QUANTITE"));
	            	article.setPrix(rs.getFloat("PRIX"));
	            	articles.add(article);              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return articles;
	    }



	    public Article getArticleById(int articleId) {
	        Article article = new Article();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from ARTICLE where IDARTICLE="+articleId);
	            //preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	            	article.getCommande().setIdCommande(rs.getInt("IDCOMMANDE"));
	            	article.getAlbum().setIdAlbum(rs.getInt("IDALBUM"));
	            	article.getFormat().setIdFormat(rs.getInt("IDFORMAT"));
	            	article.getPrestataire().setIdPrestataire(rs.getInt("IDPRESTATAIRE"));
	            	article.setQuantite(rs.getInt("QUANTITE"));
	            	article.setPrix(rs.getFloat("PRIX"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return article;
	    }
}
