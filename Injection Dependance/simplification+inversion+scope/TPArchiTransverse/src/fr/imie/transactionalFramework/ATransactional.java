package fr.imie.transactionalFramework;

import java.sql.Connection;

public abstract class ATransactional implements ITransactional {

	

	private Connection connection;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.imie.connectionFramework.IService#getConnection()
	 */
	@Override
	public Connection getConnection() {
		return connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.imie.connectionFramework.IService#setConnection(java.sql.Connection)
	 */
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	

	public void beginTransaction(ITransactional transactional){
		throw new TransactionalException("this Transactionnal Component have to be proxified by TransactionalInvocationHandler");
	}

	public void endTransaction(){
		throw new TransactionalException("this Transactionnal Component have to be proxified by TransactionalInvocationHandler");
	}

}
