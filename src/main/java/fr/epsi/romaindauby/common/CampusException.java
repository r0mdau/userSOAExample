package fr.epsi.romaindauby.common;

public class CampusException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor par default
	 */
	public CampusException() {
	}

	/**
	 * Constructor.
	 * 
	 * @param message : le message d'erreur
	 */
	public CampusException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param ex : l'exception
	 */
	public CampusException(Throwable ex) {
		super(ex);
	}

	/**
	 * Constructor.
	 * 
	 * @param message : le message
	 * @param ex : l'exception
	 */
	public CampusException(String message, Throwable ex) {
		super(message, ex);
	}

}
