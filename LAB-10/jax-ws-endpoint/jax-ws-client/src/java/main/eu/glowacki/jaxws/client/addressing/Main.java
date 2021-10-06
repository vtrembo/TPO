package eu.glowacki.jaxws.client.addressing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.xml.ws.soap.AddressingFeature;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.addressing.proxy.AddressingException_Exception;
import eu.glowacki.jaxws.client.addressing.proxy.AddressingImplService;
import eu.glowacki.jaxws.client.addressing.proxy.IAddressing;

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

	public static void main(String... args) throws MalformedURLException, AddressingException_Exception {
		URL wsdl = new URL(eu.glowacki.jaxws.api.addressing.IAddressing.URI + IService.WSDL_SUFFIX);
		AddressingImplService service = new AddressingImplService(wsdl);
		IAddressing proxy = service.getIAddressingPort(new AddressingFeature(true, true));
		String request = "request";
		LOGGER.info("(SENT) " + request);
		String response  = proxy.addressing(request);
		LOGGER.info("(RECEIVED) " + response);
	}
}