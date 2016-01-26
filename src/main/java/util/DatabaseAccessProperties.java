package util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * The BenchmarkProperties class describes the properties of
the benchmark to
 * run.
 */
public class DatabaseAccessProperties {
	private Properties prop = new Properties();
	private String jdbcDriver;
	private String dbUrl;
	private String username, password, sshHost, sshUser, sshPass;

	public DatabaseAccessProperties(String propertiesFile) {
		try {
			prop = new Properties();
			prop.load(new
					FileInputStream(propertiesFile));
		} 
		catch (FileNotFoundException e) {
			System.err.println( "FileNotFoundException: "
					+ e.getMessage()) ;
			e.printStackTrace();
			return;
		} 
		catch (IOException e) {
			System.err.println( "IOException: " +
					e.getMessage()) ;
			e.printStackTrace();
			return;
		}
		jdbcDriver = prop.getProperty("jdbc.driver");
		dbUrl = prop.getProperty("database.url");
		username = prop.getProperty("database.username");
		password = prop.getProperty("database.password");
		sshHost = prop.getProperty("ssh.host");
		sshUser = prop.getProperty("ssh.username");
		sshPass = prop.getProperty("ssh.password");
	}
	public boolean promptForCredentials(){
		if(prop.getProperty("ssh.password.prompt").equals("true")){
    		return true;
    	}else{
    		return false;
    	}
	}
	public String getJdbcDriver() {
		return jdbcDriver;
	}
	public String getDatabaseUrl() {
		return dbUrl;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getSSHHost() {
		return sshHost;
	}
	public String getSSHUsername() {
		return sshUser;
	}
	public String getSSHPassword() {
		return sshPass;
	}
	public String[] getCredentials(){
		String username = null;
		String password = null;
		JPanel panel = new JPanel();
		JLabel labelUsername = new JLabel("Username:");
		JTextField sshUsername = new JTextField(10);
		sshUsername.setText(sshUser);
		JLabel labelPassword = new JLabel("Password:");
		JPasswordField sshPass = new JPasswordField(10);
		panel.add(labelUsername);
		panel.add(sshUsername);

		panel.add(labelPassword);
		panel.add(sshPass);
		String[] options = new String[]{"OK"};
		int option = JOptionPane.showOptionDialog(null, panel, "Enter your SSH credentials:",
				JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		if(option == 0)
		{
			username = sshUsername.getText().trim();
			password = new String(sshPass.getPassword());
		}

		return new String[]{username,password};

	}
	public boolean useTunneling() {
		if(prop.getProperty("ssh.use").equals("true")){
			return true;
		}else{
			return false;
		}
	}
}
