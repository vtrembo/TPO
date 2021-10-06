package eu.glowacki.jaxws.client.onewayrobust;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.onewayrobust.proxy.IOneWayRobust;
import eu.glowacki.jaxws.client.onewayrobust.proxy.OneWayRobustImplService;
import eu.glowacki.jaxws.client.onewayrobust.proxy.ServiceException_Exception;

public final class Main {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	static {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
	}

	public static void main(String... args) throws MalformedURLException, ServiceException_Exception {
		URL wsdl = new URL(eu.glowacki.jaxws.api.onewayrobust.IOneWayRobust.URI + IService.WSDL_SUFFIX);
		OneWayRobustImplService service = new OneWayRobustImplService(wsdl);
		IOneWayRobust proxy = service.getIOneWayRobustPort();
		String message = "trigger message";
		proxy.trigger(message);
		LOGGER.info("(SENT) " + message);
	}
}