package m1miage.abd.photonum.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import m1miage.abd.photonum.model.Client;

public class ClientDAO {

	private Connection connection;

	public ClientDAO(Connection conn) {
		this.connection = conn;
	}

	public void addClient(Client user) {
		try {
			String lock = "lock table CLIENT in exclusive mode";
			Statement stmt1 = connection.createStatement();
			stmt1.execute(lock);

			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into Client(NOM,PRENOM,MAIL,ADRESSE,MOT_DE_PASSE, ACTIF ) values (?, ?, ?, ?, ?, ? )");

			// Parameters start with 1

			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getPrenom());
			preparedStatement.setString(3, user.getMail());
			preparedStatement.setString(4, user.getAdresse());
			preparedStatement.setString(5, user.getMdp());
			preparedStatement.setInt(6, user.getStatut());
			preparedStatement.executeUpdate();
			majID(user);
			this.connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int clientId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CLIENT SET ACTIF = 0 WHERE IDCLIENT = ?");
			preparedStatement.setInt(1, clientId);
			preparedStatement.executeUpdate();
			this.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(Client user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update CLIENT set NOM=?, PRENOM=?, MAIL=?, ADRESSE=?, MOT_DE_PASSE=? where IDCLIENT=?");
			// Parameters start with 1

			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getPrenom());
			preparedStatement.setString(3, user.getMail());
			preparedStatement.setString(4, user.getAdresse());
			preparedStatement.setString(5, user.getMdp());
			preparedStatement.setInt(6, user.getIdClient());
			preparedStatement.executeUpdate();
			this.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majID(Client user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from CLIENT where dbms_lob.compare(MAIL, ?)= 0");
			preparedStatement.setString(1, user.getMail());
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setIdClient(rs.getInt("IDCLIENT"));
				user.setNom(rs.getString("NOM"));
				user.setPrenom(rs.getString("PRENOM"));
				user.setMail(rs.getString("MAIL"));
				user.setAdresse(rs.getString("ADRESSE"));
				user.setMdp(rs.getString("MOT_DE_PASSE"));
				user.setStatut(rs.getInt("ACTIF"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Client> getAllUsers() {
		List<Client> users = new ArrayList<Client>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Client");
			while (rs.next()) {
				Client user = new Client();
				user.setIdClient(rs.getInt("IDCLIENT"));
				user.setNom(rs.getString("NOM"));
				user.setPrenom(rs.getString("PRENOM"));
				user.setMail(rs.getString("MAIL"));
				user.setAdresse(rs.getString("ADRESSE"));
				user.setMdp(rs.getString("MOT_DE_PASSE"));
				user.setStatut(rs.getInt("ACTIF"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public Client getUserById(int userId) {
		Client user = new Client();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from CLIENT where IDCLIENT=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setIdClient(rs.getInt("IDCLIENT"));
				user.setNom(rs.getString("NOM"));
				user.setPrenom(rs.getString("PRENOM"));
				user.setMail(rs.getString("MAIL"));
				user.setAdresse(rs.getString("ADRESSE"));
				user.setMdp(rs.getString("MOT_DE_PASSE"));
				user.setStatut(rs.getInt("ACTIF"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public Client getUserByMail(String userMail) {
		Client user = new Client();
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from CLIENT where dbms_lob.compare(MAIL, ?) = 0");
			preparedStatement.setString(1, userMail);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setIdClient(rs.getInt("IDCLIENT"));
				user.setNom(rs.getString("NOM"));
				user.setPrenom(rs.getString("PRENOM"));
				user.setMail(rs.getString("MAIL"));
				user.setAdresse(rs.getString("ADRESSE"));
				user.setMdp(rs.getString("MOT_DE_PASSE"));
				user.setStatut(rs.getInt("ACTIF"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
