package eu.glowacki.jaxws.client.composite;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.composite.AddRequest;
import eu.glowacki.jaxws.api.composite.AddResponse;
import eu.glowacki.jaxws.api.composite.IComposite;

public final class MainNoProxy {
	
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
		QName qname = new QName("http://glowacki.eu/composite", "CompositeImplService");
		Service service = Service.create(wsdl, qname);
		IComposite composite = service.getPort(IComposite.class);
		BigInteger constituent1 = new BigInteger("1");
		BigInteger constituent2 = new BigInteger("2");
		AddRequest request = new AddRequest(constituent1, constituent2);
		AddResponse response = composite.add(request);
		LOGGER.info("sum: " + response.result);
	}
}