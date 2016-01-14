package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class SQLWarningsExceptions {
	public static void printWarnings(Connection conn) {
		SQLWarning warn = null;

		try {
			warn = conn.getWarnings();
		} catch (SQLException se) {
			System.err.println("SQL Exception: " + se.getMessage());
			se.printStackTrace();
			return;
		}

		// Print all warnings
		while (warn != null) {
			System.out.print("SQL Warning: ");
			System.out.print("State: " + warn.getSQLState() ) ;
			System.out.print(", Message: " + warn.getMessage());
			System.out.println( ", Error: " + warn.getErrorCode()) ;

			warn  = warn.getNextWarning();
		}
	}


	public static void printExceptions(SQLException se) {
		// Loop through SQL Exceptions
		while( se != null ) {
			System.out.println( "State: " + se.getSQLState() ) ;
			System.out.println( "Message: " + se.getMessage() ) ;
			System.out.println( "Error: " + se.getErrorCode() ) ;

			se = se.getNextException() ;
		}
	}
}
