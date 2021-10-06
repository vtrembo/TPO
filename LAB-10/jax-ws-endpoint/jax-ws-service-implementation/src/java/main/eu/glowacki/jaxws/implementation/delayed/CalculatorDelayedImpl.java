package eu.glowacki.jaxws.implementation.delayed;

import java.util.logging.Logger;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import eu.glowacki.jaxws.api.ServiceException;
import eu.glowacki.jaxws.api.delayed.ICalculatorDelayed;

@WebService( //
		name = "ICalculatorDelayed", //
		targetNamespace = "http://glowacki.eu/delayed" //
)
public final class CalculatorDelayedImpl implements ICalculatorDelayed {

	private static final Logger LOGGER = Logger.getAnonymousLogger();
	private static final int DELAY = 10000;

	public static void main(String... args) {
		Endpoint.publish(ICalculatorDelayed.URI, new CalculatorDelayedImpl());
		LOGGER.info("SERVICE STARTED");
	}
	
	private static void sleep() throws ServiceException {
    	try {
			Thread.sleep(DELAY);
		} catch (InterruptedException exception) {
			throw new ServiceException("error occurred", exception);
		}
    }

	public int add(int component1, int component2) throws ServiceException {
		sleep();
		int sum = component1 + component2;
		return sum;
	}

	public int subtract(int minuend, int subtrahend) throws ServiceException {
		sleep();
		int difference = minuend - subtrahend;
		return difference;
	}
}