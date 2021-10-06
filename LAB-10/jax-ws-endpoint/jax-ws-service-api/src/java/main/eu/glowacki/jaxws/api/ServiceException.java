package eu.glowacki.jaxws.api;

public final class ServiceException extends Exception {

	private static final long serialVersionUID = -4871761547593519210L;
	
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}