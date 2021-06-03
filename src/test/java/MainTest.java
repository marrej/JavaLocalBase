import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

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
    void getFactorialOf0() {
        BigInteger result = new BigInteger("0");
        Integer input = 0;
        assertEquals(result, codeWorker.getFactorial(input));
    }

    @Test
    void getFactorialOf1() {
        BigInteger result = new BigInteger("1");
        Integer input = 1;
        assertEquals(result, codeWorker.getFactorial(input));
    }

    @Test
    void getFactorialOf4() {
        BigInteger result = new BigInteger("24");
        Integer input = 4;
        assertEquals(result, codeWorker.getFactorial(input));
    }

    @Test
    void getFactorialOf25() {
        BigInteger result = new BigInteger("15511210043330985984000000");
        Integer input = 25;
        assertEquals(result, codeWorker.getFactorial(input));
    }
}