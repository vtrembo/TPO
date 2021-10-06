package eu.glowacki.jaxws.client.test.compositePeople;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.compositePeople.IPerson;
import eu.glowacki.jaxws.api.compositePeople.PersonRequest;
import eu.glowacki.jaxws.api.compositePeople.PersonResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class MainNoProxyTest {
    private static Logger LOGGER;
    @Before
    public void before() {
        LOGGER = Logger.getAnonymousLogger();
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }
    @Test
    public void test() throws ParseException, MalformedURLException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        URL wsdl = new URL(IPerson.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu/composite-people", "PersonImplService");
        Service service = Service.create(wsdl, qname);
        IPerson proxy = service.getPort(IPerson.class);
        PersonRequest req = new PersonRequest("Trembovetsky", formatter.parse("2002-01-24"));
        PersonResponse res = proxy.filter(req);
        Assert.assertEquals(1, res.people.size());
        LOGGER.info("result: " + res.people.size());
    }
}
