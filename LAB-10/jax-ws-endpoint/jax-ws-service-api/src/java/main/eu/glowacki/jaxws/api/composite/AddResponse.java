package eu.glowacki.jaxws.api.composite;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlType;

@XmlType( //
		name = "AddResponseMessage", // name of the XmlType should be different from the name of the class
		namespace = "http://glowacki.eu/composite" //
)
public final class AddResponse {

	public BigInteger result;

	/**
	 * empty parameterless constructor is required for unmarshalling
	 */
	public AddResponse() {
	}

	public AddResponse(BigInteger result) {
		this.result = result;
	}
}