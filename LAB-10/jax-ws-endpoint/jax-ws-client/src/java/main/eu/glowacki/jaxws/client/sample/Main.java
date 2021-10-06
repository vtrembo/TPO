package eu.glowacki.jaxws.client.sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.sample.proxy.CalculatorImplService;
import eu.glowacki.jaxws.client.sample.proxy.ICalculator;

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

	public static void main(String... args) throws MalformedURLException {
		URL wsdl = new URL(eu.glowacki.jaxws.api.sample.ICalculator.URI + IService.WSDL_SUFFIX);
		CalculatorImplService service = new CalculatorImplService(wsdl);
		ICalculator proxy = service.getICalculatorPort();
		int sum = proxy.add(1, 2);
		LOGGER.info("sum: " + sum);
	}
}