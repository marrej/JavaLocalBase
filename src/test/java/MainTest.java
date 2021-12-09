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
    void getLastElement() {
        assertEquals(7,codeWorker.binarySearch(Arrays.asList(1,2,3,4,5,6,7),7));
    }

    @Test
    void getSomeElement() {
        assertEquals(5,codeWorker.binarySearch(Arrays.asList(1,2,3,4,5,6,7),5));
    }

    @Test
    void getFirstElement() {
        assertEquals(1,codeWorker.binarySearch(Arrays.asList(1,2,3,4,5,6,7),1));
    }

    @Test
    void getNonExistentElement() {
        assertEquals(null,codeWorker.binarySearch(Arrays.asList(1,2,3,4,5,6,7),9));
    }

    @Test
    void getNonExistentElement2() {
        assertEquals(null,codeWorker.binarySearch(Arrays.asList(1,2,3,4,5,6,7),-2));
    }
}