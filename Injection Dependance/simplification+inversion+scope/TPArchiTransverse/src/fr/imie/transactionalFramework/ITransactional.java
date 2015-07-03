package fr.imie.transactionalFramework;

import java.sql.Connection;


public interface ITransactional {

	public abstract Connection getConnection();

	public abstract void setConnection(Connection connection);
	
	public abstract void beginTransaction(ITransactional transactional);	

	public abstract void endTransaction();	
	
}