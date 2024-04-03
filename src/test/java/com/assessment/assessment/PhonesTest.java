package com.assessment.assessment;

import com.assessment.assessment.model.Phones;
import com.assessment.assessment.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhonesTest {

    @Test
    public void testGettersAndSetters() {

        Phones phone = new Phones();
        long id = 1;
        String number = "987654321";
        String citycode = "1";
        String countrycode = "57";
        User user = new User();


        phone.setId(id);
        phone.setNumber(number);
        phone.setCitycode(citycode);
        phone.setCountrycode(countrycode);
        phone.setUser(user);


        assertEquals(id, phone.getId());
        assertEquals(number, phone.getNumber());
        assertEquals(citycode, phone.getCitycode());
        assertEquals(countrycode, phone.getCountrycode());
        assertEquals(user, phone.getUser());
    }

    @Test
    public void testToString() {

        Phones phone = new Phones("987654321", "1", "57");
        phone.setId(1L);
        User user = new User();
        phone.setUser(user);


        String result = phone.toString();


        assertEquals("Phones{id=1, number='987654321', citycode='1', countrycode='57', user=" + user + "}", result);
    }
}
