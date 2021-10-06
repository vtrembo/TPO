package eu.glowacki.jaxws.client.delayed;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import javax.xml.ws.Response;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.client.ClientException;
import eu.glowacki.jaxws.client.delayed.proxy.AddResponse;
import eu.glowacki.jaxws.client.delayed.proxy.CalculatorDelayedImplService;
import eu.glowacki.jaxws.client.delayed.proxy.ICalculatorDelayed;
import eu.glowacki.jaxws.client.delayed.proxy.ServiceException_Exception;

public final class MainAsyncPolling {

	private static final Logger LOGGER = Logger.getAnonymousLogger();
	private static final int POLL_INTERVAL = 1000;
	
	static{
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "99999999");
    }

	public static void main(String... args) throws MalformedURLException, ServiceException_Exception,
			ExecutionException, InterruptedException, ClientException {

		URL wsdl = new URL(eu.glowacki.jaxws.api.delayed.ICalculatorDelayed.URI + IService.WSDL_SUFFIX);
		CalculatorDelayedImplService service = new CalculatorDelayedImplService(wsdl);
		ICalculatorDelayed proxy = service.getICalculatorDelayedPort();
		Response<AddResponse> response = proxy.addAsync(3, 1);
		while (!response.isDone()) {
			LOGGER.info("waiting...");
			sleep();
		}
		LOGGER.info("sum: " + response.get().getReturn());
	}

	private static void sleep() throws ClientException {
		try {
			Thread.sleep(POLL_INTERVAL);
		} catch (InterruptedException exception) {
			throw new ClientException("error occurred", exception);
		}
	}
}