package eu.glowacki.jaxws.api.delayed;

import javax.jws.WebMethod;
import javax.jws.WebService;

import eu.glowacki.jaxws.api.ServiceException;

@WebService( //
		name = "ICalculatorDelayed", //
		targetNamespace = "http://glowacki.eu/delayed" //
)
public interface ICalculatorDelayed {
	
	public static final String URI = "http://localhost:8080/delayed";

	@WebMethod(action = "http://glowacki.eu/calculator-delayed/add")
	int add(int component1, int component2) throws ServiceException;

	@WebMethod(action = "http://glowacki.eu/calculator-delayed/subtract")
	int subtract(int minuend, int subtrahend) throws ServiceException;
}