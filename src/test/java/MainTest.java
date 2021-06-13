import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void getLexicographicOrder() {
        assertEquals("hcdk", codeWorker.getLexicographicOrder("dkhc"));
    }

    @Test
    void getLexicographicOrder1() {
        assertEquals("lmon", codeWorker.getLexicographicOrder("lmno"));
    }

    @Test
    void getNoLexicographicOrder() {
        assertEquals("no answer", codeWorker.getLexicographicOrder("bb"));
    }

    @Test
    void getStartPosition() {
        assertEquals(0, codeWorker.getStartIndex(new char[]{'d', 'k', 'h', 'c'}));
    }
}