import org.example.Person;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void checkEquals() {
        EqualsVerifier.simple().forClass(Person.class).verify();
    }
}
