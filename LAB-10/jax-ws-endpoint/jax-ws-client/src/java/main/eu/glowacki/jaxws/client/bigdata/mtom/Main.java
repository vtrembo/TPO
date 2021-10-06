package eu.glowacki.jaxws.client.bigdata.mtom;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.bigdata.mtom.proxy.BigData;
import eu.glowacki.jaxws.client.bigdata.mtom.proxy.BigDataMTOMImplService;
import eu.glowacki.jaxws.client.bigdata.mtom.proxy.IBigDataMTOM;

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
		URL wsdl = new URL(eu.glowacki.jaxws.api.bigdata.IBigDataMTOM.URI + IService.WSDL_SUFFIX);
		BigDataMTOMImplService service = new BigDataMTOMImplService(wsdl);
		IBigDataMTOM proxy = service.getIBigDataMTOMPort();
		BigData data = proxy.get();
		LOGGER.info("data: " + data.getRawData());
	}
}