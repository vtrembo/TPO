package eu.glowacki.jaxws.client;

public final class ClientException extends Exception {

	private static final long serialVersionUID = -5694225080654788912L;

	public ClientException(String message, Throwable cause) {
		super(message, cause);
	}
}