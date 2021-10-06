
package eu.glowacki.jaxws.client.compositePeople.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.glowacki.jaxws.client.compositePeople.proxy package. 
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

    private final static QName _Filter_QNAME = new QName("http://glowacki.eu/composite-people", "filter");
    private final static QName _FilterResponse_QNAME = new QName("http://glowacki.eu/composite-people", "filterResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.glowacki.jaxws.client.compositePeople.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Filter }
     * 
     */
    public Filter createFilter() {
        return new Filter();
    }

    /**
     * Create an instance of {@link FilterResponse }
     * 
     */
    public FilterResponse createFilterResponse() {
        return new FilterResponse();
    }

    /**
     * Create an instance of {@link PersonRequestMessage }
     * 
     */
    public PersonRequestMessage createPersonRequestMessage() {
        return new PersonRequestMessage();
    }

    /**
     * Create an instance of {@link PersonResponseMessage }
     * 
     */
    public PersonResponseMessage createPersonResponseMessage() {
        return new PersonResponseMessage();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Filter }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Filter }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu/composite-people", name = "filter")
    public JAXBElement<Filter> createFilter(Filter value) {
        return new JAXBElement<Filter>(_Filter_QNAME, Filter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilterResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://glowacki.eu/composite-people", name = "filterResponse")
    public JAXBElement<FilterResponse> createFilterResponse(FilterResponse value) {
        return new JAXBElement<FilterResponse>(_FilterResponse_QNAME, FilterResponse.class, null, value);
    }

}
