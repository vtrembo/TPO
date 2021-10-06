package eu.glowacki.jaxws.api.onewayrobust;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import eu.glowacki.jaxws.api.ServiceException;

@WebService( //
		name = "IOneWayRobust", //
		targetNamespace = "http://glowacki.eu/one-way-robust" //
)
public interface IOneWayRobust {

	public static final String URI = "http://localhost:8080/one-way-robust";

	@Oneway
	@WebMethod(action = "http://glowacki.eu/one-way-robust")
	public void trigger(String input) throws ServiceException;

	@Oneway
	@WebMethod(action = "http://glowacki.eu/one-way-robust")
	public void triggerNotRobust(String input);
}