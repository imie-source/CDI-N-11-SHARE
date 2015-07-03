package fr.imie.transactionalFramework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import fr.imie.connection.ConnectionProvider;

public class TransactionInvocationHandler implements InvocationHandler {

	private ITransactional target;
	private Connection connection;
	private Thread bookedThread;
	private Boolean slave;

	public TransactionInvocationHandler(ITransactional transactional) {
		super();
		this.target = transactional;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object retour = null;

		if (method.getName().compareTo("beginTransaction") == 0) {
			// initialisation du Caller
			beginTransaction((ITransactional) args[0]);
		} else if (method.getName().compareTo("endTransaction") == 0) {
			endTransaction();
		} else {
			// appel direct d'une methode du DAO sans caller
			if (bookedThread == null
					|| Thread.currentThread().getId() != bookedThread.getId()) {
				beginTransaction(null);
			}

			retour = method.invoke(target, args);

			endTransaction();

		}
		return retour;
	};

	public synchronized void beginTransaction(ITransactional caller)
			throws TransactionalException {
		Boolean threadBreak = false;
		while (!threadBreak)
			if (bookedThread == null) {
				bookedThread = Thread.currentThread();
				if (caller != null && caller.getConnection() != null) {
					slave = true;
					connection = caller.getConnection();
				} else {
					slave = false;
					initConnection();
				}
				target.setConnection(connection);
				threadBreak = true;
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					throw new TransactionalException(e);
				}
			}
	}

	public synchronized void endTransaction() {
		if (!slave) {
			try {
				connection.commit();
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					throw new TransactionalException(e1);
				}
				throw new TransactionalException(e);
			} finally {
				try {
					freeConnexion();
				} catch (SQLException e) {
					throw new TransactionalException(e);
				}
			}
		}
		bookedThread = null;
		notify();

	}

	private void initConnection() {
		try {
			connection = ConnectionProvider.getInstance()
			.provideConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new TransactionalException(e);
		}
//		
//		try {
//			synchronized (DriverManager.class) {
//				connection = DriverManager.getConnection(
//						"jdbc:postgresql://localhost:5432/imie", "postgres",
//						"postgres");
//				connection.setAutoCommit(false);
//
//			}
//		} catch (SQLException e) {
//			throw new TransactionalException(e);
//		}
	}

	private void freeConnexion() throws SQLException {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				target.setConnection(null);
			}
		} catch (SQLException e) {
			throw new TransactionalException(e);
		}
	}

}
