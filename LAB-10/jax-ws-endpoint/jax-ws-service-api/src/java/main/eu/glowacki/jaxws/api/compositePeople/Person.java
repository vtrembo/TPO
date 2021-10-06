package eu.glowacki.jaxws.api.compositePeople;

import java.util.Date;

public class Person {
    public String firstName;
    public String lastName;
    public Date birthDate;

    public Person(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Person() {
    }
}
