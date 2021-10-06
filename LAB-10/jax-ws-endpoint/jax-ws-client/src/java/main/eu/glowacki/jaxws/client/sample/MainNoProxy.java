package eu.glowacki.jaxws.client.sample;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.sample.ICalculator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public final class MainNoProxy {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dumpTreshold", "9999999");
    }

    public static void main(String... args) throws MalformedURLException {
        URL wsdl = new URL(eu.glowacki.jaxws.api.sample.ICalculator.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu/sample", "CalculatorImplService");
        Service service = Service.create(wsdl, qname);
        ICalculator proxy = service.getPort(ICalculator.class);
        int sum = proxy.add(1, 2);
        LOGGER.info("sum: " + sum);
    }
}