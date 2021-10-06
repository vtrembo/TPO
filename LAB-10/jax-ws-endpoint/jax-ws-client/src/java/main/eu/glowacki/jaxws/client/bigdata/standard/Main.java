package eu.glowacki.jaxws.client.bigdata.standard;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.bigdata.standard.proxy.BigData;
import eu.glowacki.jaxws.client.bigdata.standard.proxy.BigDataStandardImplService;
import eu.glowacki.jaxws.client.bigdata.standard.proxy.IBigDataStandard;
import eu.glowacki.jaxws.client.delayed.proxy.ServiceException_Exception;

public final class Main {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	static {
		System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
		System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
		System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold",  "9999999");
	}

	public static void main(String... args) throws MalformedURLException, ServiceException_Exception {
		URL wsdl = new URL(eu.glowacki.jaxws.api.bigdata.IBigDataStandard.URI + IService.WSDL_SUFFIX);
		BigDataStandardImplService service = new BigDataStandardImplService(wsdl);
		IBigDataStandard proxy = service.getIBigDataStandardPort();
		BigData data = proxy.get();
		LOGGER.info("data: " + data.getRawData());
	}
}