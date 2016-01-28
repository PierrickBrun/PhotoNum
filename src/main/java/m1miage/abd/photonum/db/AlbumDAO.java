package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Album;

public class AlbumDAO {

	private Connection connection;

	public AlbumDAO(Connection conn) {
		this.connection = conn;
	}

	public void addAlbum(Album album) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Album(IDCLIENT, PREFACE, POSTFACE, NBPAGE, TYPE, TITRE) values (?, ?, ?, ?, ?, ? )");

			// Parameters start with 1
			// IDALBUM
			preparedStatement.setInt(1, album.getClient().getIdClient());
			preparedStatement.setString(2, album.getPreface());
			preparedStatement.setString(3, album.getPostface());
			preparedStatement.setInt(4, album.getNbPage());
			preparedStatement.setString(5, album.getTypeAlbum());
			preparedStatement.setString(6, album.getTitre());
			preparedStatement.executeUpdate();
			majID(album);
			System.out.println("L'Album: " + album.getTitre()
					+ " a bien été ajouté");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAlbum(int albumId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Album where IDALBUM=?");
			// Parameters start with 1
			preparedStatement.setInt(1, albumId);
			preparedStatement.executeUpdate();
			this.connection.commit();
			System.out.println("L'Album: " + albumId + " a bien été supprimé");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAlbum(Album album) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update ALBUM set IDCLIENT=?, PREFACE=?, POSTFACE=?, NBPAGE=?, TYPE=?, TITRE=?"
							+ "where IDALBUM=?");
			// Parameters start with 1
			preparedStatement.setInt(1, album.getClient().getIdClient());
			preparedStatement.setString(2, album.getPreface());
			preparedStatement.setString(3, album.getPostface());
			preparedStatement.setInt(4, album.getNbPage());
			preparedStatement.setString(5, album.getTypeAlbum());
			preparedStatement.setString(6, album.getTitre());
			preparedStatement.setInt(7, album.getIdAlbum());
			preparedStatement.executeUpdate();
			this.connection.commit();
			System.out.println("L'Album: " + album.getIdAlbum()
					+ " a bien été modifié");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majID(Album album) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from ALBUM where IDCLIENT=? AND TITRE=?");
			preparedStatement.setInt(1, album.getClient().getIdClient());
			preparedStatement.setString(2, album.getTitre());
			ResultSet rs = preparedStatement.executeQuery();
			ClientDAO clientDAO = new ClientDAO(connection);
			if (rs.next()) {
				album.setIdAlbum(rs.getInt("IDALBUM"));
				album.setClient(clientDAO.getUserById(rs.getInt("IDCLIENT")));
				album.setTitre(rs.getString("TITRE"));
				album.setPreface(rs.getString("PREFACE"));
				album.setPostface(rs.getString("POSTFACE"));
				album.setNbPage(rs.getInt("NBPAGE"));
				album.affecterType(rs.getString("TYPE"));
				this.connection.commit();
				System.out.println("Idalbum mis à jour pour Titre:"
						+ album.getTitre() + "et IdClient:"
						+ album.getClient().getIdClient() + ". Son id est: "
						+ album.getIdAlbum());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Album> getAllAlbum() {
		List<Album> albums = new ArrayList<Album>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from ALBUM");
			ClientDAO clientDAO = new ClientDAO(connection);
			while (rs.next()) {
				Album album = new Album();
				album.setIdAlbum(rs.getInt("IDALBUM"));
				album.setClient(clientDAO.getUserById(rs.getInt("IDCLIENT")));
				album.setTitre(rs.getString("TITRE"));
				album.setPreface(rs.getString("PREFACE"));
				album.setPostface(rs.getString("POSTFACE"));
				album.setNbPage(rs.getInt("NBPAGE"));
				album.affecterType(rs.getString("TYPE"));
				albums.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return albums;
	}

	public Album getAlbumById(int albumId) {
		Album album = new Album();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from ALBUM where IDALBUM="
							+ albumId);
			// preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			ClientDAO clientDAO = new ClientDAO(connection);
			if (rs.next()) {
				album.setIdAlbum(rs.getInt("IDALBUM"));
				album.setClient(clientDAO.getUserById(rs.getInt("IDCLIENT")));
				album.setTitre(rs.getString("TITRE"));
				album.setPreface(rs.getString("PREFACE"));
				album.setPostface(rs.getString("POSTFACE"));
				album.setNbPage(rs.getInt("NBPAGE"));
				album.affecterType(rs.getString("TYPE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return album;
	}
}
