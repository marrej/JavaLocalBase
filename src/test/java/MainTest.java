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
    void reduceToNone() {
        assertEquals("", codeWorker.removeDuplicates("abcddcba"));
    }

    @Test
    void reduceToSome2() {
        assertEquals("ac", codeWorker.removeDuplicates("abbc"));
    }
    @Test
    void reduceToSome3() {
        assertEquals("ac", codeWorker.removeDuplicates("acoo"));
    }

    @Test
    void reduceToSome4() {
        assertEquals("bc", codeWorker.removeDuplicates("aabcoo"));
    }

    @Test
    void reduceToSome() {
        assertEquals("abk", codeWorker.removeDuplicates("abcddcoppok"));
    }
}