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
    void getTheMoveSet() {
        assertEquals(6, codeWorker.findPaths(2,2,2,0,0));
    }

    @Test
    void getTheMoveSet2() {
        assertEquals(12, codeWorker.findPaths(1,3,3,0,1));
    }

    @Test
    void getTheMoveSet3() {
        // 8 sec & 36 - 806 ms
        assertEquals(102984580, codeWorker.findPaths(8,7,16,1,5));
    }
}