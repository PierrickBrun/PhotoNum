package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Photo;

public class PhotoDAO {
	private Connection connection;

	public PhotoDAO(Connection conn) {
		 this.connection = conn;
	    }

	public void addPhoto(Photo photo) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into PHOTO (TITRE, COMMENTAIRE, PAGE, IDALBUM, IDPHOTO) values (?, ?, ?, ?, ? )");
			preparedStatement.setString(1, photo.getTitre());
			preparedStatement.setString(2, photo.getCommentaire());
			preparedStatement.setInt(3, photo.getPage());
			preparedStatement.setInt(4, photo.getAlbum().getIdAlbum());
			preparedStatement.setInt(5, photo.getFichier().getIdFichier());
			preparedStatement.executeUpdate();
			majID(photo);
			System.out.println("La photo: " + photo.getTitre()
					+ " a bien été ajouté");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletePhoto(int photoId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from PHOTO where IDPHOTO=?");
			// Parameters start with 1
			preparedStatement.setInt(1, photoId);
			preparedStatement.executeUpdate();
			this.connection.commit();
			System.out.println("La photo: " + photoId + " a bien été supprimé");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePhoto(Photo photo) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update PHOTO set IDALBUM=?, TITRE=?, COMMENTAIRE=?, IDFICHIER=?, PAGE=?"+ "where IDPHOTO=?");
			preparedStatement.setInt(1, photo.getAlbum().getIdAlbum());
			preparedStatement.setString(2, photo.getTitre());
			preparedStatement.setString(3, photo.getCommentaire());
			preparedStatement.setInt(4, photo.getFichier().getIdFichier());
			preparedStatement.setInt(5, photo.getPage());
			preparedStatement.setInt(6, photo.getIdPhoto());
			preparedStatement.executeUpdate();
			this.connection.commit();
			System.out.println("La photo: " + photo.getIdPhoto()
					+ " a bien été modifié");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void majID(Photo photo){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from PHOTO where IDALBUM=? AND IDFICHIER=? AND PAGE=?");
            preparedStatement.setInt(1, photo.getAlbum().getIdAlbum());
			preparedStatement.setInt(2, photo.getFichier().getIdFichier());
			preparedStatement.setInt(3, photo.getPage());
            ResultSet rs = preparedStatement.executeQuery();
            AlbumDAO albumDAO=new AlbumDAO(connection);
			FichierDAO fichierDAO=new FichierDAO(connection);
			if (rs.next()) {	
            	photo.setIdPhoto(rs.getInt("IDPHOTO"));
				photo.setAlbum(albumDAO.getAlbumById(rs.getInt("IDALBUM")));
				photo.setTitre(rs.getString("TITRE"));
				photo.setCommentaire(rs.getString("COMMENTAIRE"));
				photo.setFichier(fichierDAO.getFichierById(rs.getInt("IDFICHIER")));				
				photo.setPage(rs.getInt("PAGE"));
	            this.connection.commit();
	            System.out.println("Idphoto mis à jour pour IDALBUM:"+photo.getAlbum().getIdAlbum()+"et IDFICHIER:"+photo.getFichier().getIdFichier()+"et PAGE:"+photo.getPage()+". Son id est: "+photo.getIdPhoto());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<Photo> getAllPhoto() {
		List<Photo> photos = new ArrayList<Photo>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from PHOTO");
			AlbumDAO albumDAO=new AlbumDAO(connection);
			FichierDAO fichierDAO=new FichierDAO(connection);
			while (rs.next()) {
				Photo photo = new Photo();
				photo.setIdPhoto(rs.getInt("IDPHOTO"));
				photo.setAlbum(albumDAO.getAlbumById(rs.getInt("IDALBUM")));
				photo.setTitre(rs.getString("TITRE"));
				photo.setCommentaire(rs.getString("COMMENTAIRE"));
				photo.setFichier(fichierDAO.getFichierById(rs.getInt("IDFICHIER")));				
				photo.setPage(rs.getInt("PAGE"));
				photos.add(photo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photos;
	}

	public Photo getPhotoById(int photoId) {
		Photo photo = new Photo();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from PHOTO where IDPHOTO=" + photoId);
			// preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			AlbumDAO albumDAO=new AlbumDAO(connection);
			FichierDAO fichierDAO=new FichierDAO(connection);
			if (rs.next()) {
				photo.setAlbum(albumDAO.getAlbumById(rs.getInt("IDALBUM")));
				photo.setTitre(rs.getString("TITRE"));
				photo.setCommentaire(rs.getString("COMMENTAIRE"));
				photo.setFichier(fichierDAO.getFichierById(rs.getInt("IDFICHIER")));
				photo.setPage(rs.getInt("PAGE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return photo;
	}
}
