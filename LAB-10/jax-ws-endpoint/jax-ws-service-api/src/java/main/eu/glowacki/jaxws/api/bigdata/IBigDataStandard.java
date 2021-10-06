package eu.glowacki.jaxws.api.bigdata;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService( //
		name = "IBigDataStandard", //
		targetNamespace = "http://glowacki.eu/big-data/standard" //
)
public interface IBigDataStandard {
	
	public static final String URI = "http://localhost:8080/big-data/standard";

	@WebMethod(action = "http://glowacki.eu/big-data/standard/get")
	public BigData get();
}