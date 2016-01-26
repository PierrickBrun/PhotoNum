package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jcraft.jsch.JSch;
//import java.util.Scanner;
import com.jcraft.jsch.Session;

public class ConnectDatabase {

	private static final String configurationFile = "config/BD.properties";
	private static Connection connexion  = null;
	
	private ConnectDatabase(){}

	public static synchronized Connection getConnection(){
		if(connexion == null){
			System.out.println("NULL");
			Session session = null;
			try {
				String jdbcDriver, dbUrl, username, password;
				DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
				jdbcDriver = dap.getJdbcDriver();
				dbUrl = dap.getDatabaseUrl();
				username = dap.getUsername();
				password = dap.getPassword();

				//SSH TUNNEL
				if(dap.useTunneling()){
					java.util.Properties config = new java.util.Properties(); 
					config.put("StrictHostKeyChecking", "no");
					JSch jsch = new JSch();
					if(dap.promptForCredentials()){
						String[] creds = dap.getCredentials();
						session=jsch.getSession(creds[0], dap.getSSHHost(), 22);
						session.setPassword(creds[1]);
					}else{
						session=jsch.getSession(dap.getSSHUsername(), dap.getSSHHost(), 22);
						session.setPassword(dap.getSSHPassword());
					}
					session.setConfig(config);
					session.connect();
					System.out.println("SSH Tunnel connected");
					int assinged_port=session.setPortForwardingL(1521, dap.getSSHHost(), 1521);
					System.out.println("Port Forwarded");
				}


				// Load the database driver
				Class.forName(jdbcDriver);
				// Get a connection to the database
				connexion = DriverManager.getConnection(dbUrl, username, password);
				// Print information about connection warnings
				SQLWarningsExceptions.printWarnings(connexion);
				connexion.close();
			} catch (SQLException se) {
				// Print information about SQL exceptions
				SQLWarningsExceptions.printExceptions(se);
			} catch (Exception e) {
				System.err.println("Exception: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return connexion;
	}
}
