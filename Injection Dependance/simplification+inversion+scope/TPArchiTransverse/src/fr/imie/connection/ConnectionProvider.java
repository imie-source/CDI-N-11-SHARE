package fr.imie.connection;
/**
 * 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author imie
 *
 */
public class ConnectionProvider {
	
	private static ConnectionProvider instance;
	
	private ConnectionProvider(){		
	}


	public static synchronized ConnectionProvider getInstance(){
		if (instance==null){
			instance= new ConnectionProvider();
		}
		return instance;
	}

	public Connection provideConnection() throws SQLException{
		Connection connection; 
		synchronized (DriverManager.class) {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/CDI11", "postgres",
					"postgres");	
		}
		return connection;
	}

}
