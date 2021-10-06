package eu.glowacki.jaxws.client.test.composite;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.composite.AddRequest;
import eu.glowacki.jaxws.api.composite.AddResponse;
import eu.glowacki.jaxws.api.composite.IComposite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public final class MainNoProxyTest {
	
	private static final Logger LOGGER = Logger.getAnonymousLogger();

	static {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
	}

	private IComposite _proxy;

	@Before
	public void before() throws MalformedURLException {
		URL wsdl = new URL(IComposite.URI + IService.WSDL_SUFFIX);
		QName qname = new QName("http://glowacki.eu/composite", "CompositeImplService");
		Service service = Service.create(wsdl, qname);
		_proxy = service.getPort(IComposite.class);
	}

	@Test
	public void add() {
		final BigInteger constituent1 = new BigInteger("2222");
		final BigInteger constituent2 = new BigInteger("3333");

		AddRequest request = new AddRequest(constituent1, constituent2);
		AddResponse response = _proxy.add(request);

		final BigInteger expected = constituent1.add(constituent2);
		Assert.assertEquals(expected, response.result);

		LOGGER.info("sum: " + response.result);
	}
}