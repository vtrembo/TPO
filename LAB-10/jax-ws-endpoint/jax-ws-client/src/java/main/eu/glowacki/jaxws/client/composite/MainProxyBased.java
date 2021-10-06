package eu.glowacki.jaxws.client.composite;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.composite.proxy.AddRequestMessage;
import eu.glowacki.jaxws.client.composite.proxy.AddResponseMessage;
import eu.glowacki.jaxws.client.composite.proxy.CompositeImplService;
import eu.glowacki.jaxws.client.composite.proxy.IComposite;

public final class MainProxyBased {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	static {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
	}

	public static void main(String... args) throws MalformedURLException {
		URL wsdl = new URL(eu.glowacki.jaxws.api.composite.IComposite.URI + IService.WSDL_SUFFIX);
		CompositeImplService service = new CompositeImplService(wsdl);
		IComposite proxy = service.getICompositePort();
		AddRequestMessage request = new AddRequestMessage();
		request.setConstituent1(new BigInteger("1"));
		request.setConstituent2(new BigInteger("2"));
		AddResponseMessage response = proxy.add(request);
		LOGGER.info("sum: " + response.getResult());
	}
}