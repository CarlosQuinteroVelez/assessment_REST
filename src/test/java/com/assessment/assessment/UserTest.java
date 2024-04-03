package com.assessment.assessment;
import com.assessment.assessment.model.Phones;
import com.assessment.assessment.model.User;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        // Arrange
        User user = new User();
        long id = 1;
        String name = "Homer Simpson";
        String email = "homer.simpson@example.com";
        String password = "doh123";
        List<Phones> phones = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();


        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhones(phones);
        user.setCreated(now);
        user.setModified(now);
        user.setLastLogin(now);
        user.setToken("token123");
        user.setActive(true);


        assertEquals(id, user.getId());
        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(phones, user.getPhones());
        assertEquals(now, user.getCreated());
        assertEquals(now, user.getModified());
        assertEquals(now, user.getLastLogin());
        assertEquals("token123", user.getToken());
        assertEquals(true, user.isActive());
    }

    @Test
    public void testToString() {

        User user = new User();
        user.setName("Homer Simpson");
        user.setEmail("homer.simpson@example.com");
        user.setPassword("doh123");
        List<Phones> phones = new ArrayList<>();
        user.setPhones(phones);


        String result = user.toString();


        assertEquals("User{name='Homer Simpson', email='homer.simpson@example.com', passwordField=doh123, phones=[]}", result);
    }
}
