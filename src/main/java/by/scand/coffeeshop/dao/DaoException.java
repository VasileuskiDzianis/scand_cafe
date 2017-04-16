package by.scand.coffeeshop.dao;

public class DaoException extends Exception {
	private static final long serialVersionUID = 1L;

	public DaoException(String message, Throwable e) {
		super(message);
		initCause(e);
	}

	public DaoException(String message) {
		super(message);
	}
}
