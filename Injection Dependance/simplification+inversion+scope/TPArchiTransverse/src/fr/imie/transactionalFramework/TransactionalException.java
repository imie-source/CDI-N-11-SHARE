package fr.imie.transactionalFramework;

public class TransactionalException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5786952687391103175L;

	public TransactionalException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public TransactionalException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TransactionalException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public TransactionalException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
