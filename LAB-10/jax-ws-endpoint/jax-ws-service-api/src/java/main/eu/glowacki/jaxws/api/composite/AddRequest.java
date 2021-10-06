package eu.glowacki.jaxws.api.composite;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlType;

@XmlType( //
		name = "AddRequestMessage", // name of the XmlType should be different from the name of the class
		namespace = "http://glowacki.eu/composite" //
)
public final class AddRequest {

	public BigInteger constituent1;
	public BigInteger constituent2;

	/**
	 * empty parameterless constructor is required for unmarshalling
	 */
	public AddRequest() {
	}

	public AddRequest(BigInteger constituent1, BigInteger constituent2) {
		this.constituent1 = constituent1;
		this.constituent2 = constituent2;
	}
}