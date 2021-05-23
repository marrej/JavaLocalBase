import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main main;

    @BeforeEach
    public void setUp() throws Exception{
        main = new Main();
    }

    @Test
    void testMethod() {
        assertEquals(main.testMethod(), "method");
    }
}