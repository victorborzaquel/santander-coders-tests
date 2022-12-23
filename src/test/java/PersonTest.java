import com.victor.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) // JUnit 5
//@RunWith(MockitoJUnitRunner.class) // JUnit 4
class PersonTest {
    @Mock
    Person person;

    @Test
    void testPerson() {
        String cpf = "12345678901";
        Mockito.when(person.validCpf(Mockito.anyString())).thenReturn(true);

        assertTrue(person.validCpf(cpf));
    }
}
