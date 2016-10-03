package basic.tutorial.exception;

public class UserInfoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserInfoException() {
		super();
	}

	public UserInfoException(String message) {
		super(message);
	}

	public UserInfoException(Throwable e, String message) {
		super(message, e);
	}

}
