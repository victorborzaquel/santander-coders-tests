import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestExample {

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void test() {
        String s = "Hello";
        boolean b = true;

        assertEquals("Hello", s);
        assertTrue(b);
        assertNotNull(s);
    }
}
