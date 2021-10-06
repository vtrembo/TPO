package eu.glowacki.jaxws.implementation.addressing;

import java.util.logging.Logger;

import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.Endpoint;
import javax.xml.ws.FaultAction;
import javax.xml.ws.soap.Addressing;

import eu.glowacki.jaxws.api.addressing.AddressingException;
import eu.glowacki.jaxws.api.addressing.IAddressing;

@WebService( //
		name = "IAddressing", //
		targetNamespace = "http://glowacki.eu/addressing" //
)
@Addressing( //
		enabled = true, //
		required = true //
)
public final class AddressingImpl implements IAddressing {

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	public static void main(String... args) {
		Endpoint.publish(IAddressing.URI, new AddressingImpl());
		LOGGER.info("SERVICE STARTED");
	}

	// @WebMethod(action = "http://glowacki.eu/addressing")
	/**
	 * @Action annotation enables specifying custom identification of messages
	 *         instead of relying on autogenerated names
	 */
	@Action( //
			input = "http://glowacki.eu/addressing/AddressingRequest", //
			output = "http://glowacki.eu/addressing/AddressingResponse", //
			fault = { //
					@FaultAction(className = AddressingException.class, value = "http://glowacki.eu/addressing/AddressException") //
			} //
	)
	public String addressing(String request) throws AddressingException {
		String response = String.format("(ADDRESSING) %s", request);
		LOGGER.info(response);
		return response;
	}
}