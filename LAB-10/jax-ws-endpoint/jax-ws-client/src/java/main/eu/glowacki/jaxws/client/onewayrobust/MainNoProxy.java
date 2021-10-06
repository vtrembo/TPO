package eu.glowacki.jaxws.client.onewayrobust;

import eu.glowacki.jaxws.api.IService;
import eu.glowacki.jaxws.api.ServiceException;
import eu.glowacki.jaxws.api.onewayrobust.IOneWayRobust;
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

    public static void main(String... args) throws MalformedURLException, ServiceException {
        URL wsdl = new URL(IOneWayRobust.URI + IService.WSDL_SUFFIX);
        QName qname = new QName("http://glowacki.eu/one-way-robust", "OneWayRobustImplService");
        Service service = Service.create(wsdl, qname);
        IOneWayRobust proxy = service.getPort(IOneWayRobust.class);
        proxy.trigger("message");
        proxy.triggerNotRobust("message");
    }
}