package eu.glowacki.jaxws.client.test.sample;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.sample.ICalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public final class MainNoProxyTest {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    private ICalculator _proxy;

    @Before
    public void before() throws MalformedURLException {
        URL wsdl = new URL(eu.glowacki.jaxws.api.sample.ICalculator.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu/sample", "CalculatorImplService");
        Service service = Service.create(wsdl, qname);
        _proxy = service.getPort(ICalculator.class);
    }

    @Test
    public void add()  {
        final int constituent1 = 1;
        final int constituent2 = 2;

        final int expected = constituent1 + constituent2;
        int actual = _proxy.add(constituent1, constituent2);
        Assert.assertEquals(expected, actual);
        LOGGER.info("sum: " + actual);
    }
}