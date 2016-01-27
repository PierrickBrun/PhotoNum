package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Fichier;

public class FichierDAO {
	 private Connection connection;

	 public FichierDAO(Connection conn) {
		 this.connection = conn;
	    }

	 public void addFichier(Fichier fichier) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into FICHIER (IDCLIENT, CHEMIN, PARTAGE, PRISEDEVUE, RESOLUTION) values (?, ?, ?, ?, ? )");
	            // Parameters start with 1
	  // IDFICHIER
	            preparedStatement.setInt(2, fichier.getClient().getIdClient());
	            preparedStatement.setString(3, fichier.getChemin());
	            preparedStatement.setBoolean(4, fichier.isPartage());	            
	            preparedStatement.setString(5, fichier.getPriseDeVue());	            
	            preparedStatement.setString(6, fichier.getResolution());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	    public void deleteFichier (int fichierId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from FICHIER where IDFICHIER="+fichierId);
	            // Parameters start with 1
	            preparedStatement.setInt(1, fichierId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void updateFichier(Fichier fichier) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update FICHIER set IDCLIENT=?, CHEMIN=?, PARTAGE=?, PRISEDEVUE=?, RESOLUTION=?" +"where IDFICHIER=?");
	            // Parameters start with 1
	            preparedStatement.setInt(2, fichier.getClient().getIdClient());
	            preparedStatement.setString(3, fichier.getChemin());
	            preparedStatement.setBoolean(4, fichier.isPartage());	            
	            preparedStatement.setString(5, fichier.getPriseDeVue());	            
	            preparedStatement.setString(6, fichier.getResolution());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }




	    public List<Fichier> getAllFichier() {
	    	List<Fichier> fichiers = new ArrayList<Fichier>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from FICHIER");
	            while (rs.next()) {
	            	Fichier fichier = new Fichier();
	            	fichier.setIdFichier(rs.getInt("IDFICHIER"));
	            	fichier.getClient().setIdClient(rs.getInt("IDCLIENT"));
	            	fichier.setChemin(rs.getString("CHEMIN"));
	            	fichier.setPartage(rs.getBoolean("PARTAGE"));
	            	fichier.setPriseDeVue(rs.getString("PRISEDEVUE"));
	                fichier.setResolution(rs.getString("RESOLUTION"));
	                fichiers.add(fichier);              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return fichiers;
	    }

	    public Fichier getFichierById(int fichierId) {
	        Fichier fichier = new Fichier();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from FICHIER where IDFICHIER="+fichierId);
	            //preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	            	
	            	fichier.getClient().setIdClient(rs.getInt("IDCLIENT"));
	            	fichier.setChemin(rs.getString("CHEMIN"));
	            	fichier.setPartage(rs.getBoolean("PARTAGE"));
	            	fichier.setPriseDeVue(rs.getString("PRISEDEVUE"));
	                fichier.setResolution(rs.getString("RESOLUTION"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return fichier;
	    }
}
