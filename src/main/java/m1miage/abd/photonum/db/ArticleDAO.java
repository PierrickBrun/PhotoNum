package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Article;

public class ArticleDAO {

	private Connection connection;

	public ArticleDAO(Connection conn) {
		this.connection = conn;
	}

	public void addArticle(Article article) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into ARTICLE (IDCOMMANDE, IDALBUM, IDFORMAT, IDPRESTATAIRE, QUANTITE, PRIX) values (?, ?, ?, ?, ?, ? )");

			// Parameters start with 1
			// IDARTICLE
			preparedStatement.setInt(1, article.getCommande().getIdCommande());
			preparedStatement.setInt(2, article.getAlbum().getIdAlbum());
			preparedStatement.setInt(3, article.getFormat().getIdFormat());
			if (article.getPrestataire() == null) {
				preparedStatement.setNull(4, java.sql.Types.INTEGER);
			} else {
				preparedStatement.setInt(4, article.getPrestataire().getIdPrestataire());
			}
			preparedStatement.setInt(5, article.getQuantite());
			preparedStatement.setFloat(6, article.getPrix());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteArticle(int articleId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from ARTICLE where IDARTICLE=" + articleId);
			// Parameters start with 1
			preparedStatement.setInt(1, articleId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateArticle(Article article) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update ARTICLE set IDCOMMANDE=?, IDALBUM=?, IDFORMAT=?, IDPRESTATAIRE=?, QUANTITE=?, PRIX=?"
							+ "where IDARTICLE=?");
			// Parameters start with 1
			preparedStatement.setInt(1, article.getCommande().getIdCommande());
			preparedStatement.setInt(2, article.getAlbum().getIdAlbum());
			preparedStatement.setInt(3, article.getFormat().getIdFormat());
			preparedStatement.setInt(4, article.getPrestataire().getIdPrestataire());
			preparedStatement.setInt(5, article.getQuantite());
			preparedStatement.setFloat(6, article.getPrix());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majID(Article article) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from ARTICLE where IDCOMMANDE=? AND IDALBUM=? AND IDFORMAT=?");
			preparedStatement.setInt(1, article.getCommande().getIdCommande());
			preparedStatement.setInt(2, article.getAlbum().getIdAlbum());
			preparedStatement.setInt(3, article.getFormat().getIdFormat());
			ResultSet rs = preparedStatement.executeQuery();
			CommandeDAO commandeDAO = new CommandeDAO(connection);
			AlbumDAO albumDAO = new AlbumDAO(connection);
			FormatDAO formatDAO = new FormatDAO(connection);
			PrestataireDAO prestataireDAO = new PrestataireDAO(connection);
			if (rs.next()) {
				article.setIdArticle(rs.getInt("IDARTICLE"));
				article.setCommande(commandeDAO.getCommandeById(rs.getInt("IDCOMMANDE")));
				article.setAlbum(albumDAO.getAlbumById(rs.getInt("IDALBUM")));
				article.setFormat(formatDAO.getFormatById(rs.getInt("IDFORMAT")));
				article.setPrestataire(prestataireDAO.getPrestataireById(rs.getInt("IDPRESTATAIRE")));
				article.setQuantite(rs.getInt("QUANTITE"));
				article.setPrix(rs.getFloat("PRIX"));
				this.connection.commit();
				System.out.println("Idarticle mis à jour pour Commande:" + article.getCommande().getIdCommande()
						+ "et Album:" + article.getAlbum().getIdAlbum() + "et Format:"
						+ article.getFormat().getIdFormat() + ". Son id est: " + article.getIdArticle());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Article> getAllArticle() {
		List<Article> articles = new ArrayList<Article>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ARTICLE");
			CommandeDAO commandeDAO = new CommandeDAO(connection);
			AlbumDAO albumDAO = new AlbumDAO(connection);
			FormatDAO formatDAO = new FormatDAO(connection);
			PrestataireDAO prestataireDAO = new PrestataireDAO(connection);
			while (rs.next()) {
				Article article = new Article();
				article.setIdArticle(rs.getInt("IDARTICLE"));
				article.setCommande(commandeDAO.getCommandeById(rs.getInt("IDCOMMANDE")));
				article.setAlbum(albumDAO.getAlbumById(rs.getInt("IDALBUM")));
				article.setFormat(formatDAO.getFormatById(rs.getInt("IDFORMAT")));
				article.setPrestataire(prestataireDAO.getPrestataireById(rs.getInt("IDPRESTATAIRE")));
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
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from ARTICLE where IDARTICLE=" + articleId);
			// preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			CommandeDAO commandeDAO = new CommandeDAO(connection);
			AlbumDAO albumDAO = new AlbumDAO(connection);
			FormatDAO formatDAO = new FormatDAO(connection);
			PrestataireDAO prestataireDAO = new PrestataireDAO(connection);
			if (rs.next()) {
				article.setCommande(commandeDAO.getCommandeById(rs.getInt("IDCOMMANDE")));
				article.setAlbum(albumDAO.getAlbumById(rs.getInt("IDALBUM")));
				article.setFormat(formatDAO.getFormatById(rs.getInt("IDFORMAT")));
				article.setPrestataire(prestataireDAO.getPrestataireById(rs.getInt("IDPRESTATAIRE")));
				article.setQuantite(rs.getInt("QUANTITE"));
				article.setPrix(rs.getFloat("PRIX"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
}
