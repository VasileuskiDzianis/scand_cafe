package by.scand.coffeeshop.domain;

public class DomainException extends Exception {
	private static final long serialVersionUID = 1L;

	public DomainException(String message, Throwable e) {
		super(message);
		initCause(e);
	}

	public DomainException(String message) {
		super(message);
	}
}
