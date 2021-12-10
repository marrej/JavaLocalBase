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
    void getMinimumRequiredConnections() {
        var allNodes = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
        var allEdges = Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(3,2),
                Arrays.asList(2,1),

                Arrays.asList(2,4),
                Arrays.asList(4,5),
                Arrays.asList(5,2),

                Arrays.asList(4,9),

                Arrays.asList(9,8),
                Arrays.asList(8,6),
                Arrays.asList(6,7),
                Arrays.asList(7,8),

                Arrays.asList(11,7),
                Arrays.asList(10,8)
                );
        assertEquals(3,codeWorker.doKosaraju(allEdges, allNodes));
    }

    @Test
    void getMinimumRequiredConnections2() {
        var allNodes = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
        var allEdges = Arrays.asList(
                Arrays.asList(1,3),
                Arrays.asList(3,2),
                Arrays.asList(2,1),

                Arrays.asList(2,4),
                Arrays.asList(4,5),
                Arrays.asList(5,2),

                Arrays.asList(4,9),

                Arrays.asList(9,8),
                Arrays.asList(8,6),
                Arrays.asList(6,7),
                Arrays.asList(7,8),

                Arrays.asList(11,7),
                Arrays.asList(10,8)
        );
        assertEquals(3,codeWorker.doKosarajuSimplified(allEdges, allNodes));
    }
}