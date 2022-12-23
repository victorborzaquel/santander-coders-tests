
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestExample {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("before");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after");
    }

    @BeforeEach
    public void beforeEach() {

    }

    @AfterEach
    public void afterEach() {

    }

    @Test
    void test() {
        String s = "Hello";
        boolean b = true;

        assertEquals("Hello", s);
        assertTrue(b);
        assertNotNull(s);
    }
}
