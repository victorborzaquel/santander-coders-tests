import com.victor.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(SpringExtension.class) // JUnit 5
@RunWith(MockitoJUnitRunner.class) // JUnit 4
public class PersonTest {
    @Mock
    Person person;

    @Test
    public void testPerson() {
        String cpf = "12345678901";
        Mockito.when(person.validCpf(Mockito.anyString())).thenReturn(true);

        assertTrue(person.validCpf(cpf));
    }
}
