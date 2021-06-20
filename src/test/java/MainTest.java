import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    void maxSum() {
        List<Long> l = new ArrayList<>(
                Arrays.asList(
                        3L,
                        3L,
                        9L,
                        9L,
                        5L
                )
        );
        Long modulo = 7L;
        assertEquals(6L, codeWorker.getMaximum(l, modulo));
    }

    @Test
    void binarySearchOnSet() {
        SortedSet<Long> l = new TreeSet<>(
                Arrays.asList(
                        5L
                )
        );

        Long modulo = 6L;
        assertEquals(-1L, codeWorker.binarySearchOnSet(modulo, l));
    }
}