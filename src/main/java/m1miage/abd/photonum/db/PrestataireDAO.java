package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Prestataire;

public class PrestataireDAO {
	 private Connection connection;

	 public PrestataireDAO(Connection conn) {
		 this.connection = conn;
	    }
	 
	 public void addPrestataire(Prestataire prestataire) {
		 try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into PRESTATAIRE (NOM, ADRESSE, TELEPHONE, ACTIVITE) values (?, ?, ?, ?, ? )");
	            preparedStatement.setString(1, prestataire.getNom());
	            preparedStatement.setString(2, prestataire.getAdresse());
	            preparedStatement.setString(3, prestataire.getTelephone());	            
	            preparedStatement.setString(4, prestataire.getActivite());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }



	    public void deletePrestataire (int prestataireId) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("delete from PRESTATAIRE where IDPRESTATAIRE="+prestataireId);
	            preparedStatement.setInt(1, prestataireId);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }


	    public void updatePrestataire(Prestataire prestataire) {
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("update PRESTATAIRE set NOM=?, ADRESSE=?, TELEPHONE=?, ACTIVITE=?" +"where IDPRESTATAIRE=?");
	            preparedStatement.setString(1, prestataire.getNom());
	            preparedStatement.setString(2, prestataire.getAdresse());
	            preparedStatement.setString(3, prestataire.getTelephone());	            
	            preparedStatement.setString(4, prestataire.getActivite());
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void majID(Prestataire prestataire){
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from PRESTATAIRE where NOM=?");
	            preparedStatement.setString(1, prestataire.getNom());
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	
	            	prestataire.setIdPrestataire(rs.getInt("IDPRESTATAIRE"));
	            	prestataire.setNom(rs.getString("NOM"));
	            	prestataire.setAdresse(rs.getString("ADRESSE"));
	            	prestataire.setTelephone(rs.getString("TELEPHONE"));
	            	prestataire.setActivite(rs.getString("ACTIVITE"));
		            this.connection.commit();
		            System.out.println("Idprestataire mis à jour pour NOM:"+prestataire.getNom()+". Son id est: "+prestataire.getIdPrestataire());
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Prestataire> getAllPrestataire() {
	    	List<Prestataire> prestataires = new ArrayList<Prestataire>();
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("select * from PRESTATAIRE");
	            while (rs.next()) {
	            	Prestataire prestataire = new Prestataire();
	            	prestataire.setIdPrestataire(rs.getInt("IDPRESTATAIRE"));
	            	prestataire.setNom(rs.getString("NOM"));
	            	prestataire.setAdresse(rs.getString("ADRESSE"));
	            	prestataire.setTelephone(rs.getString("TELEPHONE"));
	            	prestataire.setActivite(rs.getString("ACTIVITE"));
	                prestataires.add(prestataire);              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return prestataires;
	    }

	    public Prestataire getPrestataireById(int prestataireId) {
	        Prestataire prestataire = new Prestataire();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement("select * from PRESTATAIRE where IDPRESTATAIRE="+prestataireId);
	            ResultSet rs = preparedStatement.executeQuery();
	            if (rs.next()) {	            	
	            	prestataire.setNom(rs.getString("NOM"));
	            	prestataire.setAdresse(rs.getString("ADRESSE"));
	            	prestataire.setTelephone(rs.getString("TELEPHONE"));
	            	prestataire.setActivite(rs.getString("ACTIVITE"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return prestataire;
	    }
}
