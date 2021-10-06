
package eu.glowacki.jaxws.client.onewayrobust.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.glowacki.jaxws.client.onewayrobust.proxy package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServiceException_QNAME = new QName("http://glowacki.eu/one-way-robust", "ServiceException");
    private final static QName _Trigger_QNAME = new QName("http://glowacki.eu/one-way-robust", "trigger");
    private final static QName _TriggerResponse_QNAME = new QName("http://glowacki.eu/one-way-robust", "triggerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.glowacki.jaxws.client.onewayrobust.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceException }
     * 
     */
    public ServiceException createServiceException() {
        return new ServiceException();
    }

    /**
     * Create an instance of {@link Trigger }
     * 
     */
    public Trigger createTrigger() {
        return new Trigger();
    }

    /**
     * Create an instance of {@link TriggerResponse }
     * 
     */
    public TriggerResponse createTriggerResponse() {
        return new TriggerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu/one-way-robust", name = "ServiceException")
    public JAXBElement<ServiceException> createServiceException(ServiceException value) {
        return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Trigger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Trigger }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu/one-way-robust", name = "trigger")
    public JAXBElement<Trigger> createTrigger(Trigger value) {
        return new JAXBElement<Trigger>(_Trigger_QNAME, Trigger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TriggerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TriggerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu/one-way-robust", name = "triggerResponse")
    public JAXBElement<TriggerResponse> createTriggerResponse(TriggerResponse value) {
        return new JAXBElement<TriggerResponse>(_TriggerResponse_QNAME, TriggerResponse.class, null, value);
    }

}
