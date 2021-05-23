import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private CodeWorker codeWorker;

    @BeforeEach
    public void setUp() throws Exception{
        codeWorker = new CodeWorker();
    }

    @Test
    void testMethod() {
        assertEquals(codeWorker.testMethod(), "method");
    }

    @Test
    void baseTravel() {
        String adresses = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432";
        assertEquals(codeWorker.travel(adresses, "OH 43071"), "OH 43071:Main Street St. Louisville,Main Long Road St. Louisville/123,432");
        assertEquals(codeWorker.travel(adresses, "NY 56432"), "NY 56432:High Street Pollocksville/786");
    }

    @Test
    void emptyTravel() {
        String adresses = "123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432";
        assertEquals(codeWorker.travel(adresses, "NY 5643"), "NY 56432:/");
    }

    @Test
    void getBaseObject() {
        String adress = "123 Main Street St. Louisville OH 43071";
        Address address = codeWorker.breakAdress(adress);
        assertEquals(address.getZip(), "OH 43071");
        assertEquals(address.getCity(), "123");
        assertEquals(address.getStreet(), "Main Street St. Louisville");
    }
}