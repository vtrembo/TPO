
package eu.glowacki.jaxws.client.addressing.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.glowacki.jaxws.client.addressing.proxy package. 
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

    private final static QName _AddressingException_QNAME = new QName("http://glowacki.eu/addressing", "AddressingException");
    private final static QName _Addressing_QNAME = new QName("http://glowacki.eu/addressing", "addressing");
    private final static QName _AddressingResponse_QNAME = new QName("http://glowacki.eu/addressing", "addressingResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.glowacki.jaxws.client.addressing.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddressingException }
     * 
     */
    public AddressingException createAddressingException() {
        return new AddressingException();
    }

    /**
     * Create an instance of {@link Addressing }
     * 
     */
    public Addressing createAddressing() {
        return new Addressing();
    }

    /**
     * Create an instance of {@link AddressingResponse }
     * 
     */
    public AddressingResponse createAddressingResponse() {
        return new AddressingResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressingException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddressingException }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu/addressing", name = "AddressingException")
    public JAXBElement<AddressingException> createAddressingException(AddressingException value) {
        return new JAXBElement<AddressingException>(_AddressingException_QNAME, AddressingException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addressing }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Addressing }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu/addressing", name = "addressing")
    public JAXBElement<Addressing> createAddressing(Addressing value) {
        return new JAXBElement<Addressing>(_Addressing_QNAME, Addressing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressingResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddressingResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu/addressing", name = "addressingResponse")
    public JAXBElement<AddressingResponse> createAddressingResponse(AddressingResponse value) {
        return new JAXBElement<AddressingResponse>(_AddressingResponse_QNAME, AddressingResponse.class, null, value);
    }

}
