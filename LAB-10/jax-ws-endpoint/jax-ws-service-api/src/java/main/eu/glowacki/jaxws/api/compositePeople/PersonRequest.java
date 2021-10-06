package eu.glowacki.jaxws.api.compositePeople;

import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType(
        name = "PersonRequestMessage",
        namespace = "http://glowacki.eu/composite-people"
)
public final class PersonRequest {
    public String lastName;
    public Date birthDate;

    public PersonRequest(String lastName, Date birthDate) {
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public PersonRequest() {
    }

    @Override
    public String toString() {
        return "PersonRequest: " + "lastName='" + lastName + '\'' + ", birthDate='" + birthDate + '\'';
    }
}
