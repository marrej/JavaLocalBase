import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    void greySequence1() {
        assertEquals(new ArrayList<>(Arrays.asList(0,1)), codeWorker.grayCode(1));
    }

    @Test
    void greySequence2() {
        assertEquals(new ArrayList<>(Arrays.asList(0,1,3,2)), codeWorker.grayCode(2));
    }

    @Test
    void greySequence3() {
        assertEquals(new ArrayList<>(Arrays.asList(0,1,3,2,6,7,5,4)), codeWorker.grayCode(3));
    }

    @Test
    void greySequence4() {
        assertEquals(new ArrayList<>(Arrays.asList(0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8)), codeWorker.grayCode(4));
    }

    @Test
    void getUpdatedString() {
        assertEquals("0001", codeWorker.getUpdatedBinary("01", 4, 1, false));
    }

    @Test
    void getUpdatedString1() {
        assertEquals("0101", codeWorker.getUpdatedBinary("01", 4, 3, false));
    }

    @Test
    void getUpdatedString2() {
        assertEquals("101", codeWorker.getUpdatedBinary("01", 4, 3, true));
    }
}