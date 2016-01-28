package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Format;

public class FormatDAO {
	 private Connection connection;

	 public FormatDAO(Connection conn) {
		 this.connection = conn;
	    }

	 public void addFormat(Format format) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into FORMAT (LIBELLE, PRIXUNITAIRE, RESOLUTIONMINIMALE, VITESSEIMPRESSION, STOCKPAPIER) values (?, ?, ?, ?, ? )");
	            // Parameters start with 1
	  // IDFORMAT
	            preparedStatement.setString(1, format.getLibelle());
	            preparedStatement.setFloat(2, format.getPrixUnitaire());
	            preparedStatement.setString(3, format.getResolutionMinimale());	            
	            preparedStatement.setFloat(4, format.getVitesseImpression());	            
	            preparedStatement.setInt(5, format.getStockPapier());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	    public void deleteFormat (int formatId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from FORMAT where IDFORMAT="+formatId);
	            // Parameters start with 1
	            preparedStatement.setInt(1, formatId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void updateFormat(Format format) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update FORMAT set LIBELLE=?, PRIXUNITAIRE=?, RESOLUTIONMINIMALE=?, VITESSEIMPRESSION=?, STOCKPAPIER=?" +"where IDFORMAT=?");
	            // Parameters start with 1
	            preparedStatement.setString(1, format.getLibelle());
	            preparedStatement.setFloat(2, format.getPrixUnitaire());
	            preparedStatement.setString(3, format.getResolutionMinimale());	            
	            preparedStatement.setFloat(4, format.getVitesseImpression());	            
	            preparedStatement.setInt(5, format.getStockPapier());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void majID(Format format){
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from FORMAT where LIBELLE=?");
	            preparedStatement.setString(1, format.getLibelle());
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	
	            	format.setIdFormat(rs.getInt("IDFORMAT"));
	            	format.setLibelle(rs.getString("LIBELLE"));
	            	format.setPrixUnitaire(rs.getFloat("PRIXUNITAIRE"));
	            	format.setResolutionMinimale(rs.getString("RESOLUTIONMINIMALE"));
	            	format.setVitesseImpression(rs.getFloat("VITESSEIMPRESSION"));
	                format.setStockPapier(rs.getInt("STOCKPAPIER"));
		            this.connection.commit();
		            System.out.println("Idformat mis à jour pour Libelle:"+format.getLibelle()+". Son id est: "+format.getIdFormat());
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Format> getAllFormat() {
	    	List<Format> formats = new ArrayList<Format>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from COMMANDE");
	            while (rs.next()) {
	            	Format format = new Format();
	            	format.setIdFormat(rs.getInt("IDFORMAT"));
	            	format.setLibelle(rs.getString("LIBELLE"));
	            	format.setPrixUnitaire(rs.getFloat("PRIXUNITAIRE"));
	            	format.setResolutionMinimale(rs.getString("RESOLUTIONMINIMALE"));
	            	format.setVitesseImpression(rs.getFloat("VITESSEIMPRESSION"));
	                format.setStockPapier(rs.getInt("STOCKPAPIER"));
	                formats.add(format);              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return formats;
	    }

	    public Format getFormatById(int formatId) {
	        Format format = new Format();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from FORMAT where IDFORMAT="+formatId);
	            //preparedStatement.setInt(1, userId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	            	
	            	format.setLibelle(rs.getString("LIBELLE"));
	            	format.setPrixUnitaire(rs.getFloat("PRIXUNITAIRE"));
	            	format.setResolutionMinimale(rs.getString("RESOLUTIONMINIMALE"));
	            	format.setVitesseImpression(rs.getFloat("VITESSEIMPRESSION"));
	                format.setStockPapier(rs.getInt("STOCKPAPIER"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return format;
	    }
}
