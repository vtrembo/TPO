package eu.glowacki.jaxws.implementation.compositePeople;

import eu.glowacki.jaxws.api.compositePeople.IPerson;
import eu.glowacki.jaxws.api.compositePeople.Person;
import eu.glowacki.jaxws.api.compositePeople.PersonRequest;
import eu.glowacki.jaxws.api.compositePeople.PersonResponse;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@WebService(
        name = "IPerson",
        targetNamespace = "http://glowacki.eu/composite-people"
)
public class PersonImpl implements IPerson {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private static final List<Person> people = new LinkedList<>();
    private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    static {
        try {
            populate();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Endpoint.publish(IPerson.URI, new PersonImpl());
        LOGGER.info("SERVICE STARTED");
    }

    public static void populate() throws ParseException {
        people.add(new Person("Leonardo", "Gusser", formatter.parse("1963-01-18")));
        people.add(new Person("Valerii", "Trembovetsky", formatter.parse("2002-01-24")));
        people.add(new Person("Michael", "Locasso", formatter.parse("2001-10-01")));
    }

    @Override
    public PersonResponse filter(PersonRequest req) {
        return new PersonResponse(people.stream().filter(x -> x.birthDate.equals(req.birthDate) && x.lastName.equals(req.lastName))
                .collect(Collectors.toList()));
    }
}
