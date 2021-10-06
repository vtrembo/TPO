package eu.glowacki.jaxws.api.bigdata;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService( //
		name = "IBigDataMTOM", //
		targetNamespace = "http://glowacki.eu/big-data/mtom" //
)
public interface IBigDataMTOM {

	public static final String URI = "http://localhost:8080/big-data/mtom";

	@WebMethod(action = "http://glowacki.eu/big-data/mtom/get")
	public BigData get();
}